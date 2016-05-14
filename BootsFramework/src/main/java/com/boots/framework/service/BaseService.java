/*
 * Project Name:TCYarn
 * File Name:BaseService
 * Package Name:com.ly.dc.tcyarn.manager.service
 * Date:2015-3-9 下午7:26:30
 * Copyright (c) 2015, LY.com All Rights Reserved.
 */
package com.boots.framework.service;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import java.util.List;

/**
 * 
 * ClassName: BaseService
 * Description: 业务操作层基类
 * date: 2015-3-9 下午7:26:30
 * 
 * @author dys09435
 * @version V1.0
 * @since JDK 1.7
 */
public interface BaseService<T> {
	public List<T> getList(int start, int count, List<Criterion> conditions, List<Order> orders);

	public long getTotalCount(List<Criterion> conditions);

	public void save(T t);

	public T get(int id);

	public T update(T t);

	public void delete(T t);

	public List<T> findByProperty(String propertyName, Object value);

	public T findUniqueByProperty(String propertyName, Object value);
	
	public boolean isExist(String propertyName, Object value);
	
	public String getUUID();
}
