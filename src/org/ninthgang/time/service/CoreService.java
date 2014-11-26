/**
 * 
 */
package org.ninthgang.time.service;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ninthgang.time.message.resp.TextMessage;
import org.ninthgang.time.util.MessageUtil;

/**
 * @author lingqiusang、lhy
 *
 */
public class CoreService {
	/** 
     * 处理微信发来的请求 
     *  
     * @param request 
     * @return 
     */  
	private static UserService userService = new UserService(); 
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";  
  
            // xml请求解析  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
  
            // 回复文本消息  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
  
            // 文本消息  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                
                String content = requestMap.get("Content").trim();  
                if (content.startsWith("翻译")) {  
                    String keyWord = content.replaceAll("^翻译", "").trim();  
                    if ("".equals(keyWord)) {  
                    	respContent=getTranslateUsage();
                    } else {
                    	respContent=BaiduTranslateService.translate(keyWord);
                    }  
                     
                }else if(content.startsWith("我要找")){
                	String keyWord = content.replaceAll("^我要找", "").trim();
                	if ("".equals(keyWord)) {  
                    	respContent=getFindTutor();
                    } else {
                    	respContent="您好，您的信息已收到，我们将尽快为您配备最优质的家教。";
                    }  
                } 
                else{
                respContent = "您发送的是文本消息！\n"; 
                respContent += "[微笑] /微笑 /::)\n";
                respContent += "<a href='http://www.fjnu.edu.cn/'>欢迎访问福建师范大学</a> ";
                }
            }  
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "您发送的是图片消息！";  
            }  
            // 地理位置消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "您发送的是地理位置消息！";  
            }  
            // 链接消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "您发送的是链接消息！";  
            }  
            // 音频消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "您发送的是音频消息！";  
            }  
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respContent = "你好，欢迎关注时刻在线，我是时小刻，你们的好伙伴。希望我能帮你步入学习的新殿堂。" +
                    		"No1.时刻在问，分分钟秒杀参考答案。No2.时刻帮你找家教，妈妈再也不用担心找不到老师了。" +
                    		"No3.开启更多功能，会有更多惊喜噢";  
                    userService.addNewUser(fromUserName);
                }  
                // 取消订阅  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息  
                }  
                // 自定义菜单点击事件  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                	// 事件KEY值，与创建自定义菜单时指定的KEY值对应   
                	String eventKey = requestMap.get("EventKey"); 
                	if (eventKey.equals("11")) {
                		respContent = "请问请问，快将你的问题发过来，可以文字，可以图片噢。";
                	}else if (eventKey.equals("12")) {
                		respContent = "请问请问，快将你的问题发过来，可以文字，可以图片噢。";
                	}else if (eventKey.equals("13")) {
                		respContent = "请问请问，快将你的问题发过来，可以文字，可以图片噢。";
                	}else if (eventKey.equals("20")) {
                		respContent = getFindTutor();
                
                	}else if (eventKey.equals("31")) {
                		respContent = "签到请回复1";
                	}else if (eventKey.equals("32")) {
                		respContent = "该功能即将开放，敬请期待";
                	}else if (eventKey.equals("33")) {
                		respContent = "该功能即将开放，敬请期待";
                	}else if (eventKey.equals("34")) {
                		respContent = "该功能即将开放，敬请期待";
                	}else if(eventKey.equals("35")){
                		respContent=getTranslateUsage();
                	}      
                }  
            }  
  
            textMessage.setContent(respContent);  
            respMessage = MessageUtil.textMessageToXml(textMessage);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return respMessage;  
    }  
    
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
}
