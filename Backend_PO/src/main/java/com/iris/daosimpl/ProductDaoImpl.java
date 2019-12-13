package com.iris.daosimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iris.daos.ProductDao;
import com.iris.models.Product;

@Repository("productDao")
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Product productObj) {
		try {
			Session session = sessionFactory.getCurrentSession();
			
			session.saveOrUpdate(productObj);
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteProduct(Product pObj) {
		try {
            Session session = sessionFactory.getCurrentSession();
            session.delete(pObj);
            return true;
		} 
		catch (Exception e) {
            e.printStackTrace();

}
		return false;
	}

	public Product getProductById(int productId) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Product pro=session.get (Product.class,productId);
			return pro;
		}
		catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

	public Product getProductByName(String productName) {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from com.iris.models.Product where productName=:x");
			query.setParameter("x",productName);
			List pList= query.list();
			if(pList.size()!=0){
				return (Product)pList.get(0);
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

	public List<Product> viewAllProducts() {
		try {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from com.iris.models.Product");
			return query.list();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		return null;
	}

}
