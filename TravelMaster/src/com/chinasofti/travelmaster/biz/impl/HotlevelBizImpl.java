package com.chinasofti.travelmaster.biz.impl;

import java.util.List;

import com.chinasofti.travelmaster.biz.IHotlevelBiz;
import com.chinasofti.travelmaster.dao.IHotlevelDao;
import com.chinasofti.travelmaster.dao.impl.HotlevelDaoImpl;
import com.chinasofti.travelmaster.po.Hotlevel;

public class HotlevelBizImpl implements IHotlevelBiz {
	
	private IHotlevelDao HotlevelDao;
	public HotlevelBizImpl() {
		super();
		
		// TODO Auto-generated constructor stub
		HotlevelDao=new HotlevelDaoImpl();
	}

	@Override
	public List<Hotlevel> selectAll(int year, int season) {
		// TODO Auto-generated method stub
		return HotlevelDao.selectAll(year, season);
		
	}

	@Override
	public Hotlevel selectById(int aid) {
		// TODO Auto-generated method stub
		return HotlevelDao.selectById(aid);
	}

	@Override
	public int findByAid(int aid) {
		// TODO Auto-generated method stub
		return HotlevelDao.selectByAid(aid);
	}

	@Override
	public boolean updateClickRate(int aid, int year, int season) {
		// TODO Auto-generated method stub
		if(HotlevelDao.isExist(aid, year, season) == null){
			Hotlevel hotlevel = new Hotlevel();
			hotlevel.setAid(aid);
			hotlevel.setYear(year);
			hotlevel.setMonth(season);
			hotlevel.setClickrate(1);
			if(HotlevelDao.insert(hotlevel)>0)
				return true;
			return false;
		}else{
			Hotlevel hotlevel = HotlevelDao.isExist(aid, year, season);
			hotlevel.setClickrate(hotlevel.getClickrate()+1);
			if(HotlevelDao.update(hotlevel)>0)
				return true;
			return false;
		}	
	}

}
