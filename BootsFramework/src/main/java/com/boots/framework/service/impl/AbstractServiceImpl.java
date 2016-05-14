/*
 * Project Name:TCYarn
 * File Name:AbstractServiceImpl
 * Package Name:com.ly.dc.tcyarn.manager.service.impl
 * Date:2015-3-9 下午7:29:30
 * Copyright (c) 2015, LY.com All Rights Reserved.
 */
package com.boots.framework.service.impl;

import com.boots.framework.dao.BaseDao;
import com.boots.framework.service.BaseService;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

/**
 * 
 * ClassName: AbstractServiceImpl
 * Description: 业务操作层基类
 * date: 2015-3-9 下午7:29:30
 * 
 * @author dys09435
 * @version V1.0
 * @since JDK 1.7
 */
@Service
public abstract class AbstractServiceImpl<T> implements BaseService<T> {
	protected abstract BaseDao<T> getDAO();

	@Override
	public List<T> getList(int start, int count, List<Criterion> conditions, List<Order> orders) {
		return getDAO().getList(start, count, conditions, orders);
	}

	@Override
	public long getTotalCount(List<Criterion> conditions) {
		return getDAO().getTotalCount(conditions);
	}

	@Override
	@Transactional
	public void save(T t) {
		getDAO().save(t);
	}

	@Override
	public T get(int id) {
		return getDAO().get(id);
	}

	@Override
	@Transactional
	public T update(T t) {
		return getDAO().update(t);
	}

	@Override
	@Transactional
	public void delete(T t) {
		getDAO().delete(t);
	}

	@Override
	public List<T> findByProperty(String propertyName, Object value) {
		return getDAO().findByProperty(propertyName, value);
	}

	@Override
	public T findUniqueByProperty(String propertyName, Object value) {
		return getDAO().findUniqueByProperty(propertyName, value);
	}

	@Override
	public boolean isExist(String propertyName,Object value) {
		return getDAO().findUniqueByProperty(propertyName, value) != null;
	}
	
	@Override
	public String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
