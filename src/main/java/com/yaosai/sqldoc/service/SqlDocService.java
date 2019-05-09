package com.yaosai.sqldoc.service;

import java.util.List;

/**
 * @author YaoS
 * @date 2019-05-08 11:38
 */
public interface SqlDocService {

    List<String> getAllTableName(String database);

    List getTableInfo(String database);

    List getColumnInfo(String baseName, String tableName);
}
