/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.language = 'zh-cn';
	config.uiColor = '#8A2BE2';
	config.font_names = '����;����;������;����;����;��Բ;΢���ź�;Arial;Comic Sans MS;Courier New;Tahoma;Times New Roman;Verdana';
	config.toolbar='Basic';
	config.toolbar_Basic =		
    [
        {name: 'styles', items: ['Font', 'FontSize'] }, //��ʽ�������塢��С
        {name: 'paragraph', items: ['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'] }, //������������롢���Ķ��롢�Ҷ��롢���˶���
        {name: 'colors', items: ['TextColor', 'BGColor'] }, //��ɫ�����ı���ɫ��������ɫ
        {name: 'basicstyles', items: ['Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat'] }, //������ʽ�����Ӵ֡���б���»��ߡ�ɾ���ߡ��±ꡢ�ϱꡢ�Ƴ���ʽ
        {name: 'insert', items: ['Image', 'Flash', 'Table', 'HorizontalRule'] }, //��������ͼ��flash�����ˮƽ��
        {name: 'links', items: ['Link', 'Unlink'] }, //�������������ӳ����ӡ�ȡ��������
        {name: 'document', items: ['Source']}//Դ���������鿴Դ����
    ];
    //�������Ƿ���Ա��������������Ͻǵ����Ƿ����Ƿ���ʾ��
    config.toolbarCanCollapse = true;
    //������Ĭ���Ƿ�չ��
    config.toolbarStartupExpanded = true;
    // �Ƿ�������ק�ı�ߴ硱���ܣ��������½ǵ����Ƿ����Ƿ���ʾ��
    config.resize_enabled = true;
    //�����룺shift+Enterʱ����ı�ǩ
    config.shiftEnterMode = CKEDITOR.ENTER_P; //��ѡ��CKEDITOR.ENTER_BR��CKEDITOR.ENTER_DIV
    //�س���Enter��ʱ�����ı�ǩ
    config.enterMode = CKEDITOR.ENTER_BR; //���x��CKEDITOR.ENTER_BR��CKEDITOR.ENTER_DIV
    //���
    config.width = "100%";
    //�߶�
    config.height = "500px";
    //Ĭ����ʽ
    //config.skin ��'kama'��Ĭ�ϣ���'office2003'��'v2'
    //config.skin = "kama";
    //��������λ��
    //config.toolbarLocation = 'top'; //��ѡ��bottom
    //�ı��С�����߶�
    //config.resize_maxHeight = 3000;
    //�ı��С�������
    //config.resize_maxWidth = 3000;
    //�ı��С����С�߶�
    //config.resize_minHeight = 250;
    //�ı��С����С���
    //config.resize_minWidth = 750;
    //���ύ�����д˱༭���ı�ʱ���Ƿ��Զ�����Ԫ�؃ȵ�����
    config.autoUpdateElement = true;
    //����Ŀ¼�������Ŀ¼��Ϊ��Ϊ���Ŀ¼
    //config.baseHref = ''
    //�༭����z-indexֵ
    //config.baseFloatZIndex = 10000;
//����Ϊ�ϴ�������������ã������ckfinder�ؼ�ʹ��
    //    var ckfinderPath = "/Scripts";
    //    config.filebrowserUrl = ckfinderPath + '/ckfinder/ckfinder.html';//�ϴ��ļ�ʱ��������ļ���
    //    config.filebrowserImageBrowseUrl = ckfinderPath + '/ckfinder/ckfinder.html?Type=Images';//�ϴ�ͼƬʱ��������ļ���
    //    config.filebrowserFlashBrowserUrl = ckfinderPath + '/ckfinder/ckfinder.html?Type=Flash'; //�ϴ�Flashʱ��������ļ���
    //    config.filebrowserUploadUrl = ckfinderPath + '/ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Files'; //�ϴ��ļ���ť(��ǩ)
    //    config.filebrowserImageUploadUrl = ckfinderPath + '/ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Images';//�ϴ�ͼƬ��ť(��ǩ)
    //    config.filebrowserFlashUploadUrl = ckfinderPath + '/ckfinder/core/connector/aspx/connector.aspx?command=QuickUpload&type=Flash';//�ϴ�Flash��ť(��ǩ)


	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';
};
