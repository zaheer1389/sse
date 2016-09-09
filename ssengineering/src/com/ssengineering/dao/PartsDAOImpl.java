package com.ssengineering.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssengineering.model.Part;

@Repository
public class PartsDAOImpl implements PartsDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addPart(Part part) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(part);
	}

	@Override
	public void deletePart(Long id) {
		// TODO Auto-generated method stub
		Part part = (Part)sessionFactory.getCurrentSession().load(Part.class, id);
		if(part != null){
			this.sessionFactory.getCurrentSession().delete(part);
		}
	}

	@Override
	public List<Part> getParts() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from Part").list();
	}

	@Override
	public Part getPartById(Long id) {
		// TODO Auto-generated method stub
		Part part = (Part)sessionFactory.getCurrentSession().get(Part.class, id);
		return part;
	}

	@Override
	public void updatePart(Part part) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(part);
	}

	
}
