package org.ninthgang.time.dao;

import org.ninthgang.time.domain.FTutor;

/**
 * 找家教信息数据库操作类
 * @author lhy
 *
 */
public interface FindTutorDao {

	/**
	 * 保存找家教信息
	 */
	public void saveFTutor(FTutor tu);
	/**
	 * 删除找家教信息
	 */
	public void deleteFTutor(String sName);
	/**
	 * 获取找家教信息
	 */
	public FTutor getFTutorByName(String sName);
	
	
}
