package com.chinasofti.travelmaster.biz.impl;

import com.chinasofti.travelmaster.biz.IRelationsBiz;
import com.chinasofti.travelmaster.dao.IRelationsDao;
import com.chinasofti.travelmaster.dao.impl.RelationsDaoImpl;
import com.chinasofti.travelmaster.po.Relations;

public class RelationsBizImpl implements IRelationsBiz {

	private IRelationsDao relationsDao;
	
	public RelationsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		relationsDao=new RelationsDaoImpl();
	}

	@Override
	public boolean insert(Relations relation) {
		// TODO Auto-generated method stub
		return relationsDao.insert(relation)>0?true:false;
	}

	@Override
	public boolean isAdded(Relations relation) {
		// TODO Auto-generated method stub
		return relationsDao.isAdded(relation);
	}

	@Override
	public boolean removeById(int reid) {
		// TODO Auto-generated method stub
		return relationsDao.deleteById(reid)>0?true:false;
	}

}
