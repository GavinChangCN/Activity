package com.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Factory.HibernateSessionFactory;
import com.Vo.Formation;

public class DaoFormation extends DaoAbstract{
	
	public void Save(Formation formation){
		Session s = HibernateSessionFactory.getSession();
		s.clear();
		try{
			s.beginTransaction();
			s.save(formation);
			s.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public static int QueryParentIdByChildId(int m_secId) {
		// TODO Auto-generated method stub
		Session s = HibernateSessionFactory.getSession();
		try{
			int parentId = 0;
			String sql = "from Formation where m_secId"+m_secId;
			
			s.clear();
			s.beginTransaction();
			
			Query query = s.createQuery(sql);
			List<Formation> formation = query.list();
			parentId = formation.get(0).getM_parentId();
			return parentId;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
}
