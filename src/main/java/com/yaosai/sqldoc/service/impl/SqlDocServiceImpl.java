package com.yaosai.sqldoc.service.impl;

import com.yaosai.sqldoc.dao.SqlDocDao;
import com.yaosai.sqldoc.service.SqlDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YaoS
 * @date 2019-05-08 11:39
 */
@Service
public class SqlDocServiceImpl implements SqlDocService {

    @Autowired
    private SqlDocDao sqlDocDao;

    @Override
    public List<String> getAllTableName(String database) {
        return sqlDocDao.getAllTableName(database);
    }

    @Override
    public List getTableInfo(String database) {
        return sqlDocDao.getTableInfo(database);
    }

    @Override
    public List getColumnInfo(String baseName, String tableName) {
        return sqlDocDao.getColumnInfo(baseName, tableName);
    }
}
