/**
 * 
 */
package org.ninthgang.time.respond;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;


/**
 * @author lingqiusang
 *
 */
public class XiaoIRobot {
	//用户申请的key
	private final static String APP_KEY = "X5RIlpiBwXrL";
	//用户申请的secret
	private final static String APP_SECRET = "laZsSH9XyTFygckgSa4z";
	
	public static String xiaoIChat(String key,String names){
			
		String realm = "xiaoi.com";
	    String method = "POST";
	    String uri = "/robot/ask.do";
	    byte[] b = new byte[20];
	    new Random().nextBytes(b);
	    String nonce = new String(Hex.encodeHex(b));
	
	    String HA1 = DigestUtils.shaHex(StringUtils.join(new String[] {
	            APP_KEY, realm, APP_SECRET }, ":"));
	
	    String HA2 = DigestUtils.shaHex(StringUtils.join(new String[] { method,
	            uri }, ":"));
	
	    String sign = DigestUtils.shaHex(StringUtils.join(new String[] { HA1,
	            nonce, HA2 }, ":"));
	
	    String str = null;
	
	    HttpClient hc = new HttpClient();
	    PostMethod pm = new PostMethod("http://nlp.xiaoi.com/robot/ask.do");
	    pm.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,
	            "utf-8");

	    pm.addRequestHeader("X-Auth", "app_key=\"X5RIlpiBwXrL\", nonce=\""
	            + nonce + "\", signature=\"" + sign + "\"");
	    pm.setParameter("platform", "weixin");
	    pm.setParameter("type", "0");
	    pm.setParameter("userId", names);
	    pm.setParameter("question", key);
	    int re_code;
	    try {
	        re_code = hc.executeMethod(pm);
	        if (re_code == 200) {
	            str = pm.getResponseBodyAsString();
	        }
	    } catch (HttpException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	
	    }
	
	    return str;
	}
}
