package com.boots.framework.service.impl;

import com.boots.framework.dao.BaseDao;
import com.boots.framework.entity.LogEntity;
import com.boots.framework.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: LogServiceImpl
 * Description:
 * Date: 2016/5/13 23:12
 *
 * @author SAM SHO
 * @version V1.0
 */
@Service(value = "logService")
public class LogServiceImpl extends AbstractServiceImpl<LogEntity> implements LogService {


    @Resource
    private BaseDao<LogEntity> baseDao;

    @Override
    public BaseDao<LogEntity> getDAO() {
        return baseDao;
    }
}
