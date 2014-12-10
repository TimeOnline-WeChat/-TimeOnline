/**
 * 
 */
package org.ninthgang.time.service;

import java.util.List;

import org.ninthgang.time.dao.FindTutorDao;
import org.ninthgang.time.domain.Tutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *找家教学生信息服务类
 *
 * @author lingqiusang
 *
 */
@Service
public class FTutorServiceImpl implements FTutorService{
	@Autowired
	private FindTutorDao findTutorDao;
	
	/**
	 * 添加找家教学生信息
	 * @param tu
	 */
	public void addNewFTutor(Tutor tu){
		findTutorDao.saveFTutor(tu);
	}
	
	/**
	 * 删除找家教学生信息
	 * @param sName
	 */
	public void deleteFTutor(String sName){
		findTutorDao.deleteFTutorByName(sName);
	}
	/**
	 * 按照名字获取找家教学生信息
	 * @param sName
	 * @return
	 */
	public Tutor getFTutor(String sName){
		Tutor fTutor = null;
		fTutor = findTutorDao.getFTutorByName(sName);
		return fTutor;
	}
	
	/**
	 * 获取所有找家教学生信息
	 * @return
	 */
	public List<Tutor> getAllFTutor(){
		List<Tutor> fTutors = findTutorDao.findAllFTutor();
		return fTutors;
	}
}
