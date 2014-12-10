package org.ninthgang.time.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.ninthgang.time.dao.FindTutorDao;
import org.ninthgang.time.domain.Tutor;
import org.ninthgang.time.domain.Student;
import org.ninthgang.time.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author lhy
 * @author lingqiusang
 *
 */
@Repository
public class FindTutorDaoImpl implements FindTutorDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void saveFTutor(Tutor tu) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.save(tu);
		session.flush();
		session.close();
	}

	@Override
	public void deleteFTutorByName(String sName) {
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
	public Tutor getFTutorByName(String sName) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Query q = session.createQuery(
				" from FTutor tu where tu.sName=:sName ").setString(
				"sName", sName);
		List<Tutor> tu = (List<Tutor>) q.list();// 返回一个对象集合
		Tutor ftu = null;
		if (tu.size() > 0) {
			ftu = tu.get(0);
		}
		return ftu;
	}

	@Override
	public List<Tutor> findAllFTutor() {
		
		Session session = sessionFactory.openSession();
		Query q = session.createQuery(" from FTutor ");
		List<Tutor> fTutors = new ArrayList<Tutor>();
		fTutors = (List<Tutor>) q.list();
		return fTutors;
		
	}

}
