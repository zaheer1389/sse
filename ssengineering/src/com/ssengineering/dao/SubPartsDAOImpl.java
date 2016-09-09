package com.ssengineering.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssengineering.model.Part;
import com.ssengineering.model.SubPart;

@Repository
public class SubPartsDAOImpl implements SubPartsDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addSubPart(SubPart part) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(part);
	}

	@Override
	public void deleteSubPart(Long id) {
		// TODO Auto-generated method stub
		SubPart part = (SubPart)sessionFactory.getCurrentSession().load(SubPart.class, id);
		if(part != null){
			this.sessionFactory.getCurrentSession().delete(part);
		}
	}

	@Override
	public List<SubPart> getSubParts() {
		// TODO Auto-generated method stub
		return this.sessionFactory.getCurrentSession().createQuery("from SubPart").list();
	}

	@Override
	public SubPart getSubPartById(Long id) {
		// TODO Auto-generated method stub
		SubPart part = (SubPart)sessionFactory.getCurrentSession().get(SubPart.class, id);
		return part;
	}

	@Override
	public void updateSubPart(SubPart part) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().merge(part);
	}

	
}
