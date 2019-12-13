package com.iris.daosimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.iris.daos.VendorProductDao;
import com.iris.models.Product;
import com.iris.models.VendorProduct;

@Repository("vendorProductDao")
public class VendorProductDaoImpl implements VendorProductDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public Product getProductById(int pId) {
		try {

			Session session=sessionFactory.getCurrentSession();

			Product pObj=session.get(Product.class,pId);

			return pObj;

			}

			catch(Exception e){

				e.printStackTrace();

			}

			return null;
	}

	public List<Product> viewAllVendorProducts(int id) {
		try {

			Session session=sessionFactory.getCurrentSession();

			Query query=session.createQuery("from com.iris.models.VendorProduct where vendorId="+id);

			return query.list();

			}

			catch(Exception e){

				e.printStackTrace();

			}

		return null;
	}

	public boolean add(VendorProduct vpObj) {
		
		try {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(vpObj);
			System.out.println(vpObj+" ");
			return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return false;
	}

	public VendorProduct checkProductForVendor(int vendorId, int productId) {
		try {

			Session session=sessionFactory.getCurrentSession();

			Query query=session.createQuery("from com.iris.models.VendorProduct where vendorId=:x and productId=:y");
			query.setParameter("x",vendorId);
			query.setParameter("y",productId);
			List list=query.list();
			if(list.size()!=0) {
				return (VendorProduct) list.get(0);
			}
			}

			catch(Exception e){

				e.printStackTrace();

			}
		return null;
	}
}
