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
 * @author lingqiusang��lhy
 *
 */
public class CoreService {
	/** 
     * ����΢�ŷ��������� 
     *  
     * @param request 
     * @return 
     */  
    public static String processRequest(HttpServletRequest request) {  
        String respMessage = null;  
        try {  
            // Ĭ�Ϸ��ص��ı���Ϣ����  
            String respContent = "�������쳣�����Ժ��ԣ�";  
  
            // xml�������  
            Map<String, String> requestMap = MessageUtil.parseXml(request);  
  
            // ���ͷ��ʺţ�open_id��  
            String fromUserName = requestMap.get("FromUserName");  
            // �����ʺ�  
            String toUserName = requestMap.get("ToUserName");  
            // ��Ϣ����  
            String msgType = requestMap.get("MsgType");  
  
            // �ظ��ı���Ϣ  
            TextMessage textMessage = new TextMessage();  
            textMessage.setToUserName(fromUserName);  
            textMessage.setFromUserName(toUserName);  
            textMessage.setCreateTime(new Date().getTime());  
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);  
            textMessage.setFuncFlag(0);  
  
            // �ı���Ϣ  
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {  
                
                String content = requestMap.get("Content").trim();  
                if (content.startsWith("����")) {  
                    String keyWord = content.replaceAll("^����", "").trim();  
                    if ("".equals(keyWord)) {  
                    	respContent=getTranslateUsage();
                    } else {
                    	respContent=BaiduTranslateService.translate(keyWord);
                    }  
                     
                }else if(content.startsWith("��Ҫ��")){
                	String keyWord = content.replaceAll("^��Ҫ��", "").trim();
                	if ("".equals(keyWord)) {  
                    	respContent=getFindTutor();
                    } else {
                    	respContent="���ã�������Ϣ���յ������ǽ�����Ϊ���䱸�����ʵļҽ̡�";
                    }  
                } 
                else{
                respContent = "�����͵����ı���Ϣ��\n"; 
                respContent += "[΢Ц] /΢Ц /::)\n";
                respContent += "<a href='http://www.fjnu.edu.cn/'>��ӭ���ʸ���ʦ����ѧ</a> ";
                }
            }  
            // ͼƬ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {  
                respContent = "�����͵���ͼƬ��Ϣ��";  
            }  
            // ����λ����Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {  
                respContent = "�����͵��ǵ���λ����Ϣ��";  
            }  
            // ������Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {  
                respContent = "�����͵���������Ϣ��";  
            }  
            // ��Ƶ��Ϣ  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {  
                respContent = "�����͵�����Ƶ��Ϣ��";  
            }  
            // �¼�����  
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {  
                // �¼�����  
                String eventType = requestMap.get("Event");  
                // ����  
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {  
                    respContent = "��ã���ӭ��עʱ�����ߣ�����ʱС�̣����ǵĺû�顣ϣ�����ܰ��㲽��ѧϰ���µ��á�" +
                    		"No1.ʱ�����ʣ��ַ�����ɱ�ο��𰸡�No2.ʱ�̰����Ҽҽ̣�������Ҳ���õ����Ҳ�����ʦ�ˡ�" +
                    		"No3.�������๦�ܣ����и��ྪϲ��";  
                }  
                // ȡ������  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {  
                    // TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ  
                }  
                // �Զ���˵�����¼�  
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {  
                	// �¼�KEYֵ���봴���Զ���˵�ʱָ����KEYֵ��Ӧ   
                	String eventKey = requestMap.get("EventKey"); 
                	if (eventKey.equals("11")) {
                		respContent = "�������ʣ��콫������ⷢ�������������֣�����ͼƬ�ޡ�";
                	}else if (eventKey.equals("12")) {
                		respContent = "�������ʣ��콫������ⷢ�������������֣�����ͼƬ�ޡ�";
                	}else if (eventKey.equals("13")) {
                		respContent = "�������ʣ��콫������ⷢ�������������֣�����ͼƬ�ޡ�";
                	}else if (eventKey.equals("20")) {
                		respContent = getFindTutor();
                
                	}else if (eventKey.equals("31")) {
                		respContent = "ǩ����ظ�1";
                	}else if (eventKey.equals("32")) {
                		respContent = "�ù��ܼ������ţ������ڴ�";
                	}else if (eventKey.equals("33")) {
                		respContent = "�ù��ܼ������ţ������ڴ�";
                	}else if (eventKey.equals("34")) {
                		respContent = "�ù��ܼ������ţ������ڴ�";
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
        buffer.append("ʹ��ָ��").append("\n\n");  
        buffer.append("ʱ�̷���֧�����·��뷽��").append("\n");  
        buffer.append("    �� -> Ӣ").append("\n");  
        buffer.append("    Ӣ -> ��").append("\n");  
        buffer.append("ʹ��ʾ����").append("\n");  
        buffer.append("    ���������й���").append("\n");  
        buffer.append("    ����time").append("\n");  
        return buffer.toString();  
    }  
    
    public static String getFindTutor(){
    	StringBuffer buffer = new StringBuffer();
		buffer.append("�Ҽҽ̾���ʱ�̽���").append("\n");
		buffer.append("�ɷ���������Ϣ�����ǣ���ʽ���£���Ҫ��:����+�꼶+����+�ɼ�״��+�绰+��ַ+��ע(�������ʦ��Ҫ��)").append("\n");
		buffer.append("Ҳ���Բ�����ѯ����18120826127�����ǽ��߳�Ϊ������");
		return buffer.toString();
    }
}
