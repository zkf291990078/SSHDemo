package com.anywell.ssh.services.impl;

import java.util.List;

import com.anywell.ssh.dao.BaseDictDao;
import com.anywell.ssh.domain.BaseDict;
import com.anywell.ssh.services.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictDao bd;
	
	
	public void setBd(BaseDictDao bd) {
		this.bd = bd;
	}


	@Override
	public List<BaseDict> getBaseDict(String type_code) {
		// TODO Auto-generated method stub
		return bd.findAllData(type_code);
	}

}
