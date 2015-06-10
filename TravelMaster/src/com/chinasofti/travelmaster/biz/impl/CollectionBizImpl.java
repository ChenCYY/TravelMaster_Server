package com.chinasofti.travelmaster.biz.impl;

import com.chinasofti.travelmaster.biz.ICollectionBiz;
import com.chinasofti.travelmaster.dao.ICollectionsDao;
import com.chinasofti.travelmaster.dao.impl.CollectionsDaoImpl;
import com.chinasofti.travelmaster.po.Collections;

public class CollectionBizImpl implements ICollectionBiz {

	private ICollectionsDao collectionsDao;
	
	public CollectionBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		collectionsDao=new CollectionsDaoImpl();
		
	}

	@Override
	public boolean add(Collections collection) {
		// TODO Auto-generated method stub
		return collectionsDao.insert(collection)>0 ?true:false;
	}

	@Override
	public boolean removeById(int colid) {
		// TODO Auto-generated method stub
		return collectionsDao.deleteById(colid)>0 ?true:false;
	}

	@Override
	public boolean isCollected(int aid, int uid) {
		// TODO Auto-generated method stub
		return collectionsDao.selectByAidAndUid(aid, uid) == null?false:true;
	}

}
