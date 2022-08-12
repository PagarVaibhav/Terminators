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
	
	public PetientInfo updatedata(PetientInfo petientInfo) {
		Session session = sf.openSession();
		session.beginTransaction();
	   session.update(petientInfo);
	   session.getTransaction().commit();
	   session.close();
	   
	   Session session2 = sf.openSession();
	   PetientInfo info = session2.get(PetientInfo.class, petientInfo.getPid());
	   session2.close();
		return info;
		
	}
	
	public PetientInfo logincheck(PetientInfo petientInfo) {
		Session session = sf.openSession();
		session.beginTransaction();
		String hql="from PetientInfo";
		Query query = session.createQuery(hql);
		List <PetientInfo>list = query.getResultList();
		
		for(PetientInfo pi:list) {
			if(petientInfo.getPname().equals(pi.getPname()) && petientInfo.getPbloodgrp().equals(pi.getPbloodgrp()));
		return pi;
		}
		return null;
		
		
	}
	
	public PetientInfo deleteById (int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		PetientInfo petientInfo = session.get(PetientInfo.class,id);
		if (petientInfo!=null) {
			session.delete(petientInfo);
			session.getTransaction().commit();
			session.close();
		}
		return petientInfo;
	}
	
	public void deleteall (){
		Session session = sf.openSession();
		session.beginTransaction();
		String hql="delete From PetientInfo";
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.getTransaction().commit();
	}
	
}
