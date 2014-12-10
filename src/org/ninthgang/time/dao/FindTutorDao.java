package org.ninthgang.time.dao;

import java.util.List;

import org.ninthgang.time.domain.Tutor;

/**
 * 找家教信息数据库操作类
 * 
 * @author lhy
 * @author lingqiusang
 * 
 */
public interface FindTutorDao {

	/**
	 * 保存找家教信息
	 */
	public void saveFTutor(Tutor tu);

	/**
	 * 删除找家教信息
	 */
	public void deleteFTutorByName(String sName);

	/**
	 * 获取找家教信息
	 */
	public Tutor getFTutorByName(String sName);

	/** 获取所有家教信息 */
	public List<Tutor> findAllFTutor();

}
