package com.yaosai.sqldoc.service;

import java.util.List;

/**
 * @author YaoS
 * @date 2019-05-08 11:38
 */
public interface SqlDocService {

    List<String> getAllTableName(String database);

    String getTableInfo(String tableName);

    List getColumnInfo(String baseName, String tableName);
}
