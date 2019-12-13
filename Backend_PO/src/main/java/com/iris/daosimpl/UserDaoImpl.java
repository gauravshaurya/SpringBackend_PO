package com.iris.daosimpl;


import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.iris.daos.UserDao;
import com.iris.models.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
		@Autowired
		SessionFactory sessionFactory;

		public boolean registerUser(User uObj) {
			try {
				Session session = sessionFactory.getCurrentSession();
				session.saveOrUpdate(uObj);
				return true;
			} catch (Exception e) {
					e.printStackTrace();
			
			}
			return false;
		}

		public User loginUser(String email, String password) {
			try {
				Session session = sessionFactory.getCurrentSession();
				Query query=session.createQuery("from com.iris.models.User where email=:email and password=:upass");
				query.setParameter("email",email);
				query.setParameter("upass",password);
				
				List list=query.list();
				if(list.size()!=0) {
					return (User)list.get(0);
			}
			} catch (Exception e) {
				e.printStackTrace();	
			}
		return null;
	}
		
		public User getSeller() {
			try {

				Session session=sessionFactory.getCurrentSession();
				Query query=session.createQuery("from com.iris.models.User where role='Seller'");
				
					List<User>list=query.list();	
				if(list.size()!=0) {
					return list.get(0);
				}
				else session.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public User getBuyer(int id) {
			try {

				Session session=sessionFactory.getCurrentSession();
				Query query=session.createQuery("from com.iris.models.User where role='Buyer' and userId="+id);
				
					List<User>list=query.list();	
				if(list.size()!=0) {
					return list.get(0);
				}
				else session.close();
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		public List<User> getAllBuyers() {
			try {

				Session session=sessionFactory.getCurrentSession();
				Query query=session.createQuery("from com.iris.models.User where role='Buyer'");
				
					List<User>list=query.list();	
		
					return list;
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
}
