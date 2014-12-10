/**
 * update:2014年12月10日 上午10:44:39 
 */
package org.ninthgang.time.service;

import java.util.List;

import org.ninthgang.time.domain.Tutor;

/**
 * @author lingqiusang
 *
 * @update:2014年12月10日 上午10:44:39
 * 
 */
public interface FTutorService {
	public void addNewFTutor(Tutor tu);

	
	/**
	 * 删除找家教学生信息
	 * @param sName
	 */
	public void deleteFTutor(String sName);

	/**
	 * 按照名字获取找家教学生信息
	 * @param sName
	 * @return
	 */
	public Tutor getFTutor(String sName);
	
	/**
	 * 获取所有找家教学生信息
	 * @return
	 */
	public List<Tutor> getAllFTutor();
}
