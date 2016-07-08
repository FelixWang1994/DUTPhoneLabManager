package first;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


//�ϴ��ļ�Action
public class UploadAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	//ʹ��File�����װ����ļ����Ӧ���ļ�����
	private File[] upload;
	//ʹ���ַ��������װ����ļ����Ӧ���ļ�����
	private String[] uploadContentType;
	//ʹ���ַ��������װ����ļ����Ӧ���ļ�����
	private String[] uploadFileName;
	//��������ע�������
	private String savePath;
	//���ظ��ͻ��˵���ʾ
	private String info;
	//ͼƬ�ı���·��
	private String srcPath;

	@SuppressWarnings("deprecation")
	public String getRealPath(String file)
	{
		return ServletActionContext.getRequest()
		.getRealPath(file);
	}
	//savePath���Ե�setter��getter����
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
		//ȡ����Ҫ�ϴ����ļ�����
		File[] files = getUpload();
		if(files==null||files.length==0)
		{
			setInfo("You Don't Choose A File");
			return SUCCESS;
		}
		//���������ļ���·��
		SimpleDateFormat f = new SimpleDateFormat("yyyy");
		SimpleDateFormat f2 = new SimpleDateFormat("MM");
		Date date = new Date();
		String filePath="/upload/files/"+f.format(date)+"/"+f2.format(date);
		File file = new File(getRealPath(filePath));
		if(!file.exists()) file.mkdirs();
		setSavePath(filePath);
		//����ÿ����Ҫ�ϴ����ļ�
		for (int i = 0 ; i < files.length ; i++)
		{
			srcPath = savePath + "/" + getUploadFileName()[i];
			srcPath = srcPath.substring(1, srcPath.length());
			//�Է��������ļ������ַ��ԭ�ļ��������ϴ��ļ������
			FileOutputStream fos = new FileOutputStream(getSavePath() + "/" + getUploadFileName()[i]);
			//��ÿ����Ҫ�ϴ����ļ������ļ�������
			FileInputStream fis = new FileInputStream(files[i]);
			//��ÿ����Ҫ�ϴ����ļ�д����������Ӧ���ļ���
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
