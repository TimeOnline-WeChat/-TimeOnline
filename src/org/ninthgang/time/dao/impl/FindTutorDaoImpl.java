package org.ninthgang.time.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ninthgang.time.dao.FindTutorDao;
import org.ninthgang.time.domain.FTutor;
import org.ninthgang.time.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author lhy
 *
 */
@Repository
public class FindTutorDaoImpl implements FindTutorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveFTutor(FTutor tu) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(tu);
		session.flush();
		session.close();
	}

	@Override
	public void deleteFTutor(String sName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Query q = session.createQuery(
					" delete FTutor tu where tu.sName=:sName ").setString(
					"sName", sName);
			q.executeUpdate();
			session.flush();
		} catch (Exception e) {
		} finally {
			session.flush();
			session.close();
		}
	}

	@Override
	public FTutor getFTutorByName(String sName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery(
				" from FTutor tu where tu.sName=:sName ").setString(
				"sName", sName);
		List<FTutor> tu = (List<FTutor>) q.list();// 返回一个对象集合
		FTutor ftu = null;
		if (tu.size() > 0) {
			ftu = tu.get(0);
		}
		return ftu;
	}

}
