package com.anywell.ssh.services.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.ssh.dao.CustomerDao;
import com.anywell.ssh.domain.Customer;
import com.anywell.ssh.services.CustomerService;
import com.anywell.ssh.utils.PageBean;

public class CustomerServiceImpl implements CustomerService {
	
	private CustomerDao cd;

	public void setCd(CustomerDao cd) {
		this.cd = cd;
	}


	@Override
	public PageBean<Customer> findPageBean(DetachedCriteria dc, Integer currentPage, Integer pagesize) {
		// TODO Auto-generated method stub
		int totalCount= cd.findTotalCount(dc);
		PageBean< Customer> pageBean=new PageBean<>(currentPage, totalCount, pagesize);
		List<Customer> list= cd.findDataByPage(dc, pageBean.getStart(), pageBean.getPageSize());
		pageBean.setList(list);
		return pageBean;
	}

	
	
}
