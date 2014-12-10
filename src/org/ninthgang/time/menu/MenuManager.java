package org.ninthgang.time.menu;

import org.ninthgang.time.pojo.AccessToken;
import org.ninthgang.time.pojo.Button;
import org.ninthgang.time.pojo.CommonButton;
import org.ninthgang.time.pojo.ComplexButton;
import org.ninthgang.time.pojo.Menu;
import org.ninthgang.time.pojo.ViewButton;
import org.ninthgang.time.util.WeixinUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 菜单管理器类
 * @author lhy
 *
 */
public class MenuManager {
	
	private static Logger log = LoggerFactory.getLogger(MenuManager.class);
	
	public static void main(String[] args) {
		// 第三方用户唯一凭证   
		String appId = "wx8e0ffe8761f2c036";  
		// 第三方用户唯一凭证密钥   
		String appSecret = "845136b48598c76d522b91134528f16e";  
		
		// 调用接口获取access_token   
		AccessToken at = WeixinUtil.getAccessToken(appId, appSecret);  
		
		if (null != at) {  
			// 调用接口创建菜单   
			int result = WeixinUtil.createMenu(getMenu(), at.getToken());  
				  
			// 判断菜单创建结果 
			if (0 == result)  
				log.info("菜单创建成功！");  
				else  
					log.info("菜单创建失败，错误码：" + result);  
				}  

	}
	
	/**
	 * 组装菜单数据
	 * @return
	 */
	private static Menu getMenu() {
		
		CommonButton btn11 = new CommonButton();
		btn11.setName("我是小学生");  
		btn11.setType("click");  
		btn11.setKey("11");

		CommonButton btn12 = new CommonButton();
		btn12.setName("我是初中生");  
		btn12.setType("click");  
		btn12.setKey("12");
		
		CommonButton btn13 = new CommonButton();
		btn13.setName("我是高中生");  
		btn13.setType("click");  
		btn13.setKey("13");
		
		
		CommonButton btn31 = new CommonButton();
		btn31.setName("签到送好礼");  
		btn31.setType("click");  
		btn31.setKey("31");
		
		ViewButton btn32 = new ViewButton();
		btn32.setName("时刻圆梦");  
		btn32.setType("view");  
		btn32.setUrl("http://timeonline.duapp.com/TimeOnline/");
		
//		CommonButton btn33 = new CommonButton();
//		btn33.setName("时刻答题");  
//		btn33.setType("click");  
//		btn33.setKey("33");
		
		ViewButton btn34 = new ViewButton();  
        btn34.setName("时刻社区");  
        btn34.setType("view");  
        btn34.setUrl("http://m.wsq.qq.com/263711287");  
		
		CommonButton btn35 = new CommonButton();
		btn35.setName("时刻翻译");  
		btn35.setType("click");  
		btn35.setKey("35");
		
		ComplexButton mainBtn1 = new ComplexButton();  
		mainBtn1.setName("时刻在问");  
		mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13 });
		
		ViewButton btn20 = new ViewButton();
		btn20.setName("找家教");  
		btn20.setType("view");  
		btn20.setUrl("http://timeonline.duapp.com/TimeOnline/tutor.jsp");
		
		
		ComplexButton mainBtn3 = new ComplexButton();  
		mainBtn3.setName("更多");  
		mainBtn3.setSub_button(new Button[] { btn31, btn32, btn34,btn35 });
		
		Menu menu = new Menu();  
		menu.setButton(new Button[] { mainBtn1, btn20, mainBtn3 });  
			  
		return menu;


	}

}
