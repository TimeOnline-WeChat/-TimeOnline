package org.ninthgang.time.menu;

import org.ninthgang.time.pojo.AccessToken;
import org.ninthgang.time.pojo.Button;
import org.ninthgang.time.pojo.CommonButton;
import org.ninthgang.time.pojo.ComplexButton;
import org.ninthgang.time.pojo.Menu;
import org.ninthgang.time.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * �˵���������
 * @author lhy
 *
 */
public class MenuManager {
	
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);
	
	public static void main(String[] args) {
		// �������û�Ψһƾ֤   
		String appId = "wx8e0ffe8761f2c036";  
		// �������û�Ψһƾ֤��Կ   
		String appSecret = "845136b48598c76d522b91134528f16e";  
		
		// ���ýӿڻ�ȡaccess_token   
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);  
		
		if (null != at) {  
			// ���ýӿڴ����˵�   
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());  
				  
			// �жϲ˵�������� 
			if (0 == result)  
				log.info("�˵������ɹ���");  
				else  
					log.info("�˵�����ʧ�ܣ������룺" + result);  
				}  

	}
	
	/**
	 * ��װ�˵�����
	 * @return
	 */
	private static Menu getMenu() {
		
		CommonButton btn11 = new CommonButton();
		btn11.setName("����Сѧ��");  
		btn11.setType("click");  
		btn11.setKey("11");

		CommonButton btn12 = new CommonButton();
		btn12.setName("���ǳ�����");  
		btn12.setType("click");  
		btn12.setKey("12");
		
		CommonButton btn13 = new CommonButton();
		btn13.setName("���Ǹ�����");  
		btn13.setType("click");  
		btn13.setKey("13");
		
		
		CommonButton btn31 = new CommonButton();
		btn31.setName("ǩ���ͺ���");  
		btn31.setType("click");  
		btn31.setKey("31");
		
		CommonButton btn32 = new CommonButton();
		btn32.setName("��������");  
		btn32.setType("click");  
		btn32.setKey("32");
		
		CommonButton btn33 = new CommonButton();
		btn33.setName("ʱ��ѧϰ��");  
		btn33.setType("click");  
		btn33.setKey("33");
		
		CommonButton btn34 = new CommonButton();
		btn34.setName("ѧ���ؼ�");  
		btn34.setType("click");  
		btn34.setKey("34");
		
		CommonButton btn35 = new CommonButton();
		btn35.setName("ʱ�̷���");  
		btn35.setType("click");  
		btn35.setKey("35");
		
		ComplexButton mainBtn1 = new ComplexButton();  
		mainBtn1.setName("ʱ������");  
		mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13 });
		
		CommonButton btn20 = new CommonButton();
		btn20.setName("ʱ������");  
		btn20.setType("click");  
		btn20.setKey("20");
		
		
		ComplexButton mainBtn3 = new ComplexButton();  
		mainBtn3.setName("����");  
		mainBtn3.setSub_button(new CommonButton[] { btn31, btn32, btn33, btn34,btn35 });
		
		Menu menu = new Menu();  
		menu.setButton(new Button[] { mainBtn1, btn20, mainBtn3 });  
			  
		return menu;


	}

}
