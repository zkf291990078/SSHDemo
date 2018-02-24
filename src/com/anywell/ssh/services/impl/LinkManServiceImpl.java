package com.anywell.ssh.services.impl;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.ssh.dao.LinkManDao;
import com.anywell.ssh.domain.LinkMan;
import com.anywell.ssh.services.LinkManService;
import com.anywell.ssh.utils.PageBean;

public class LinkManServiceImpl implements LinkManService {

	private LinkManDao ld;

	public void setLd(LinkManDao ld) {
		this.ld = ld;
	}

	@Override
	public void saveLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		ld.save(linkMan);
	}

	@Override
	public PageBean<LinkMan> findDataByPage(DetachedCriteria dc, Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		return (PageBean<LinkMan>) ld.findDataByPage(dc, currentPage, pageSize);
	}

}
