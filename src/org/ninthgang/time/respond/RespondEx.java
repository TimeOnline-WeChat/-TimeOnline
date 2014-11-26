package org.ninthgang.time.respond;

/**
 * 回复内容
 * @author lhy
 *
 */
public class RespondEx {
	
	public static String getTranslateUsage() {  
        StringBuffer buffer = new StringBuffer();  
        buffer.append("使用指南").append("\n\n");  
        buffer.append("时刻翻译支持以下翻译方向：").append("\n");  
        buffer.append("    中 -> 英").append("\n");  
        buffer.append("    英 -> 中").append("\n");  
        buffer.append("使用示例：").append("\n");  
        buffer.append("    翻译我是中国人").append("\n");  
        buffer.append("    翻译time").append("\n");  
        return buffer.toString();  
    }  
    
    public static String getFindTutor(){
    	StringBuffer buffer = new StringBuffer();
		buffer.append("找家教就找时刻教育").append("\n");
		buffer.append("可发送您的信息给我们，方式如下：我要找:姓名+年级+弱科+成绩状况+电话+地址+备注(可填对老师的要求)").append("\n");
		buffer.append("也可以拨打咨询热线18120826127，我们将竭诚为您服务。");
		return buffer.toString();
    }
    
    public static String getPrimary(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("小学生你好，可将你的问题以 小学生+问题 的方式发送给我们，我们的值班老师将为你解答。 或者你也可以拍照发送哦").append("\n");
    	buffer.append("老师的值班时间为19:00至22:00，未在值班时间发送的问题我们只能延迟回复，谢谢理解");
    	return buffer.toString();
    }
    
    public static String getJunior(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("初中生你好，可将你的问题以 初中生+问题 的方式发送给我们，我们的值班老师将为你解答。 或者你也可以拍照发送哦").append("\n");
    	buffer.append("老师的值班时间为19:00至22:00，未在值班时间发送的问题我们只能延迟回复，谢谢理解");
    	return buffer.toString();
    }
    
    public static String getSenior(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("高中生你好，可将你的问题以 高中生+问题 的方式发送给我们，我们的值班老师将为你解答。 或者你也可以拍照发送哦").append("\n");
    	buffer.append("老师的值班时间为19:00至22:00，未在值班时间发送的问题我们只能延迟回复，谢谢理解");
    	return buffer.toString();
    }
    
    public static String RespondToQuestion(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("您的问题已收到，老师将尽快为您解答并回复，请耐心等待。");
    	return buffer.toString();
    }

}
