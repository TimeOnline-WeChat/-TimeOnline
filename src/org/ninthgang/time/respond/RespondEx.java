package org.ninthgang.time.respond;

/**
 * �ظ�����
 * @author lhy
 *
 */
public class RespondEx {
	
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
    
    public static String getPrimary(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("Сѧ����ã��ɽ���������� Сѧ��+���� �ķ�ʽ���͸����ǣ����ǵ�ֵ����ʦ��Ϊ���� ������Ҳ�������շ���Ŷ").append("\n");
    	buffer.append("��ʦ��ֵ��ʱ��Ϊ19:00��22:00��δ��ֵ��ʱ�䷢�͵���������ֻ���ӳٻظ���лл���");
    	return buffer.toString();
    }
    
    public static String getJunior(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("��������ã��ɽ���������� ������+���� �ķ�ʽ���͸����ǣ����ǵ�ֵ����ʦ��Ϊ���� ������Ҳ�������շ���Ŷ").append("\n");
    	buffer.append("��ʦ��ֵ��ʱ��Ϊ19:00��22:00��δ��ֵ��ʱ�䷢�͵���������ֻ���ӳٻظ���лл���");
    	return buffer.toString();
    }
    
    public static String getSenior(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("��������ã��ɽ���������� ������+���� �ķ�ʽ���͸����ǣ����ǵ�ֵ����ʦ��Ϊ���� ������Ҳ�������շ���Ŷ").append("\n");
    	buffer.append("��ʦ��ֵ��ʱ��Ϊ19:00��22:00��δ��ֵ��ʱ�䷢�͵���������ֻ���ӳٻظ���лл���");
    	return buffer.toString();
    }
    
    public static String RespondToQuestion(){
    	StringBuffer buffer = new StringBuffer();
    	buffer.append("�����������յ�����ʦ������Ϊ����𲢻ظ��������ĵȴ���");
    	return buffer.toString();
    }

}
