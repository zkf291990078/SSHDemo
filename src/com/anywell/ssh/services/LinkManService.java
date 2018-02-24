package com.anywell.ssh.services;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.ssh.domain.LinkMan;
import com.anywell.ssh.utils.PageBean;

public interface LinkManService {

	void saveLinkMan(LinkMan linkMan);

	PageBean<LinkMan> findDataByPage(DetachedCriteria dc, Integer currentPage, Integer pageSize);

}
