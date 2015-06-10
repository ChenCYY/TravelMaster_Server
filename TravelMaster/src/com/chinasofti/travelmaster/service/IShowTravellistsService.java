package com.chinasofti.travelmaster.service;

import java.util.List;

import com.chinasofti.travelmaster.po.Travellists;

public interface IShowTravellistsService {
	public abstract List<Travellists> showTravellistsByUid(final int uid);
	public abstract Travellists showTravellistsByTid(final int tid);
}
