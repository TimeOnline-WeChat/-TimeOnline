/**
 * 
 */
package org.ninthgang.time.message.resp;

/**
 * 文本消息
 * 
 * @author lingqiusang
 * 
 */
public class TextMessage extends BaseMessage {
	// 回复的消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
