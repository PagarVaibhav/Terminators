package com.BikkadIT.Service;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.Model.PetientInfo;
@Service
public class ServiceImpl {

	@Autowired
	private SessionFactory sf;
	
	public int savedata(PetientInfo petientInfo) {
		Session session = sf.openSession();
		session.beginTransaction();
		  int id = (int) session.save(petientInfo);
		  session.getTransaction().commit();
		return id;
		
	}
	
	public List<PetientInfo> saveMultiple(List<PetientInfo> petientInfos){
		Session session = sf.openSession();
		session.beginTransaction();
		for(PetientInfo pi:petientInfos) {
			session.save(pi);
		}
		session.getTransaction().commit();
		return petientInfos;
	}
	
	public List<PetientInfo> getall (){
		
		Session session = sf.openSession();
		session.beginTransaction();
		String hql="From PetientInfo";
		Query query = session.createQuery(hql);
		List list = query.getResultList();
		return list;	
	}
	
	public PetientInfo getparticulardata(int id){
		
		Session session = sf.openSession();
		session.beginTransaction();
		String hql="From PetientInfo where id=:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Object result = query.getSingleResult();
		session.getTransaction().commit();
		
		return (PetientInfo) result;
	}

	
	
}
