package com.anywell.ssh.services;

import org.hibernate.criterion.DetachedCriteria;

import com.anywell.ssh.domain.Customer;
import com.anywell.ssh.utils.PageBean;

public interface CustomerService {
 
	public PageBean<Customer> findPageBean(DetachedCriteria dc, Integer currentPage,Integer pagesize);
}
