/**
 * 
 */
package org.ninthgang.time.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.ninthgang.time.message.resp.Music;
import org.ninthgang.time.message.resp.MusicMessage;
import org.ninthgang.time.message.resp.TextMessage;
import org.ninthgang.time.respond.RespondEx;
import org.ninthgang.time.respond.XiaoIRobot;
import org.ninthgang.time.util.MessageUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public static String processRequest(HttpServletRequest request) {
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    	UserService userService = (UserService) ctx.getBean("userService");
        String respMessage = null; 
        // 返回给微信服务器的xml消息  
        String respXml = null;
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
  
            String datetime=formatTime(requestMap.get("CreateTime"));
            String hour = datetime.substring(datetime.indexOf(" ")+1, datetime.indexOf(":"));
            
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
                    	respContent=RespondEx.getTranslateUsage();
                    } else {
                    	respContent=BaiduTranslateService.translate(keyWord);
                    }  
                     
                }else if(content.startsWith("我要找")){
                	String keyWord = content.replaceAll("^我要找", "").trim();
                	if ("".equals(keyWord)) {  
                    	respContent=RespondEx.getFindTutor();
                    } else {
                    	respContent="您好，您的信息已收到，我们将尽快为您配备最优质的家教。";
                    }  
                }else if(content.startsWith("小学生")||content.startsWith("初中生")||content.startsWith("高中生")){
                	if(hour.equals("19")||hour.equals("20")||hour.equals("21")){
                		respContent=RespondEx.RespondToQuestion();
                	}else{
                		respContent=RespondEx.outOfTime();
                	}
                }else if(content.equals("听歌")){
                	respContent=RespondEx.getMusic();
                }else if(content.startsWith("歌曲")){
                	// 将歌曲2个字及歌曲后面的+、空格、-等特殊符号去掉  
                    String keyWord = content.replaceAll("^歌曲[\\+ ~!@#%^-_=]?", "");  
                    // 如果歌曲名称为空  
                    if ("".equals(keyWord)) {  
                        respContent = RespondEx.getMusic();  
                    } else {  
                        String[] kwArr = keyWord.split("@");  
                        // 歌曲名称  
                        String musicTitle = kwArr[0];  
                        // 演唱者默认为空  
                        String musicAuthor = "";  
                        if (2 == kwArr.length)  
                            musicAuthor = kwArr[1];  
  
                        // 搜索音乐  
                        Music music = BaiduMusicService.searchMusic(musicTitle, musicAuthor);  
                        // 未搜索到音乐  
                        if (null == music) {  
                            respContent = "对不起，没有找到你想听的歌曲<" + musicTitle + ">。";  
                        } else {  
                            // 音乐消息  
                            MusicMessage musicMessage = new MusicMessage();  
                            musicMessage.setToUserName(fromUserName);  
                            musicMessage.setFromUserName(toUserName);  
                            musicMessage.setCreateTime(new Date().getTime());  
                            musicMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_MUSIC);  
                            musicMessage.setMusic(music);  
                            respXml = MessageUtil.musicMessageToXml(musicMessage);
                            return respXml;
                        }  
                    }  
                }  
                else{
                	respContent = XiaoIRobot.xiaoIChat(content, "dijiubang").trim();
                }
            }  
            // 图片消息  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
            	if(hour.equals("19")||hour.equals("20")||hour.equals("21")){
            		respContent=RespondEx.RespondToQuestion();
            	}else{
            		respContent=RespondEx.outOfTime();
            	}  
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
            	if(hour.equals("19")||hour.equals("20")||hour.equals("21")){
            		respContent=RespondEx.RespondToQuestion();
            	}else{
            		respContent=RespondEx.outOfTime();
            	}  
            }  
            // 事件推送  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // 事件类型  
                String eventType = requestMap.get("Event");  
                // 订阅  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                	userService.addNewUser(fromUserName);
                    respContent = "你好，欢迎关注时刻在线，我是时小刻，你们的好伙伴。希望我能帮你步入学习的新殿堂。" +
                    		"No1.时刻在问，分分钟秒杀参考答案。No2.时刻帮你找家教，妈妈再也不用担心找不到老师了。" +
                    		"No3.开启更多功能，会有更多惊喜噢！\n目前连续签到天数:"+userService.getSignInCount(fromUserName)+"天。";      
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
                		respContent = RespondEx.getPrimary();
                	}else if (eventKey.equals("12")) {
                		respContent = RespondEx.getJunior();
                	}else if (eventKey.equals("13")) {
                		respContent = RespondEx.getSenior();
                	}else if (eventKey.equals("20")) {
                		respContent = RespondEx.getFindTutor();                
                	}else if (eventKey.equals("31")) {
                		//签到
                		respContent = userService.signIn(fromUserName);          		
                	}else if (eventKey.equals("32")) {
                		respContent = "该功能即将开放，敬请期待";
                	}else if (eventKey.equals("33")) {
                		respContent = "该功能即将开放，敬请期待";
                	}else if (eventKey.equals("34")) {
                		respContent = "该功能即将开放，敬请期待";
                	}else if(eventKey.equals("35")){
                		respContent=RespondEx.getTranslateUsage();
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
    
    /** 
     * 将微信消息中的CreateTime转换成标准格式的时间（yyyy-MM-dd HH:mm:ss） 
     *  
     * @param createTime 消息创建时间 
     * @return 
     */  
    public static String formatTime(String createTime) {  
        // 将微信传入的CreateTime转换成long类型，再乘以1000  
        long msgCreateTime = Long.parseLong(createTime) * 1000L;  
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        return format.format(new Date(msgCreateTime));  
    }  
    
}
