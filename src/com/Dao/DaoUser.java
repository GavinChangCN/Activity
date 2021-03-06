package com.Dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.Factory.HibernateSessionFactory;
import com.Vo.User;

public class DaoUser extends DaoAbstract{
	@SuppressWarnings("unchecked")
	public List<User> UserLogin(String m_userPhone){
		Session session = HibernateSessionFactory.getSession();
		String sql = "from User where m_userPhone=?";
		try{
			session.beginTransaction();
			session.clear();
			Query query = session.createQuery(sql).setString(0, m_userPhone);
			List<User> userLogin = query.list();
			session.getTransaction().commit();
			return userLogin;
		} catch(Exception e){
			return null;
		}
	}
	//查询用户，返回所属层
	@SuppressWarnings("unchecked")
	public int CheckSecIdByUserId(int m_userId) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		String sql = "from User where m_userId=?";
		try{

			session.clear();
			session.beginTransaction();
			Query query = session.createQuery(sql).setInteger(0, m_userId);
			List<User> user = query.list();
			session.getTransaction().commit();
			return user.get(0).getM_secId();
		}catch(Exception e){
			e.printStackTrace();
			return -1;	
		}
	}
	//根据用户Id返回用户Name
	@SuppressWarnings("unchecked")
	public String QueryUserNameByUserId(int m_userId){
		Session s = HibernateSessionFactory.getSession();
		String sql = "from User where m_userId=?";
		try{
			s.clear();
			s.beginTransaction();
			Query query = s.createQuery(sql).setInteger(0, m_userId);
			List<User> user = query.list();
			return user.get(0).getM_userName(); 
		}catch(Exception e){
			e.printStackTrace();
			return "查无此人";
		}
	}
	//根据用户SecId查询用户userId
	@SuppressWarnings("unchecked")
	public int QueryUserIdBySecId(int m_secId){
		Session s = HibernateSessionFactory.getSession();
		String sql = "from User where m_secId=?";
		try{
			s.clear();
			s.beginTransaction();
			Query query = s.createQuery(sql).setInteger(0, m_secId);
			List<User> user = query.list();
			return user.get(0).getM_userId();
		}catch(Exception e){
			e.printStackTrace();
			return -1;
		}
	}
	//根据用户SecId查询用户信息
	@SuppressWarnings("unchecked")
	public List<User> QueryUserBySecId(int m_secId){
		Session s = HibernateSessionFactory.getSession();
		String sql = "from User where m_secId=?";
		try{
			s.clear();
			s.beginTransaction();
			Query query = s.createQuery(sql).setInteger(0, m_secId);
			List<User> user = query.list();
			return user;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
