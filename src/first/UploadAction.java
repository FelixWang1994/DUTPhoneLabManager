package first;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


//上传文件Action
public class UploadAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	//使用File数组封装多个文件域对应的文件内容
	private File[] upload;
	//使用字符串数组封装多个文件域对应的文件类型
	private String[] uploadContentType;
	//使用字符串数组封装多个文件域对应的文件名字
	private String[] uploadFileName;
	//接受依赖注入的属性
	private String savePath;
	//返回给客户端的提示
	private String info;
	//图片的保存路径
	private String srcPath;

	@SuppressWarnings("deprecation")
	public String getRealPath(String file)
	{
		return ServletActionContext.getRequest()
		.getRealPath(file);
	}
	//savePath属性的setter和getter方法
	public void setSavePath(String savePath)
	{
		this.savePath = savePath;
	}
	public String getSavePath()
	{
		return getRealPath(savePath);
	}

	@Override
	public String execute() throws Exception
	{
		//取得需要上传的文件数组
		File[] files = getUpload();
		if(files==null||files.length==0)
		{
			setInfo("You Don't Choose A File");
			return SUCCESS;
		}
		//创建保存文件的路径
		SimpleDateFormat f = new SimpleDateFormat("yyyy");
		SimpleDateFormat f2 = new SimpleDateFormat("MM");
		Date date = new Date();
		String filePath="/upload/files/"+f.format(date)+"/"+f2.format(date);
		File file = new File(getRealPath(filePath));
		if(!file.exists()) file.mkdirs();
		setSavePath(filePath);
		//遍历每个需要上传的文件
		for (int i = 0 ; i < files.length ; i++)
		{
			srcPath = savePath + "/" + getUploadFileName()[i];
			srcPath = srcPath.substring(1, srcPath.length());
			//以服务器的文件保存地址和原文件名建立上传文件输出流
			FileOutputStream fos = new FileOutputStream(getSavePath() + "/" + getUploadFileName()[i]);
			//以每个需要上传的文件建立文件输入流
			FileInputStream fis = new FileInputStream(files[i]);
			//将每个需要上传的文件写到服务器对应的文件中
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0)
			{
				fos.write(buffer , 0 , len);
			}
			fos.close();
		}
		setInfo("Uploaded Successfully");
		return SUCCESS;
	}
	public File[] getUpload() {
		return upload;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
	}
	public String[] getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String[] getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSrcPath() {
		return srcPath;
	}
	public void setSrcPath(String srcPath) {
		this.srcPath = srcPath;
	}
}
