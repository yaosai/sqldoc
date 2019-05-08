package com.yaosai.sqldoc.dao;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author YaoS
 * @date 2019-05-08 11:40
 */
@Component
public class SqlDocDao {
    /**
     * 注入的是实体管理器,执行持久化操作
     */
    @PersistenceContext
    EntityManager entityManager;

    /**
     * 功能描述: 获取所有的表名
     *
     * @param database 数据库名
     * @return 获取所有的表名
     * @author YaoS
     * @date 19/5/8 15:31
     */
    public List<String> getAllTableName(String database) {
        String sql = "select table_name from information_schema.tables where table_schema='" + database + "';";
        return entityManager.createNativeQuery(sql).getResultList();
    }

    /**
     * 功能描述: 获取表信息
     *
     * @param
     * @return
     * @author YaoS
     * @date 19/5/8 11:56
     */
    public String getTableInfo(String tableName) {
        String sql = "SELECT " + tableName + " FROM config LIMIT 1";
        Object obj = entityManager.createNativeQuery(sql).getSingleResult();
        return String.valueOf(obj);
    }

    /**
     * 功能描述: 获取字段信息
     *
     * @param database  数据库名
     * @param tableName 表名
     * @return 表详情列表
     * @author YaoS
     * @date 19/5/8 11:56
     */

    public List getColumnInfo(String database, String tableName) {
        StringBuffer sb = new StringBuffer("SELECT COLUMN_NAME columnName, COLUMN_COMMENT columnCn, COLUMN_TYPE columnType,");
        sb.append("(case COLUMN_KEY when 'MUL' then '可以重复' when 'UNI' then '唯一约束' when 'PRI' then '主键约束' ");
        sb.append("ELSE COLUMN_KEY END) columnKey,");
        sb.append("(case IS_NULLABLE when 'NO' then '否' when 'YES' then '是' END) isNullable, ");
        sb.append("COLUMN_COMMENT columnComment FROM INFORMATION_SCHEMA.COLUMNS where table_schema ='");
        sb.append(database);
        sb.append("' AND table_name = '");
        sb.append(tableName);
        sb.append("'");
        return entityManager.createNativeQuery(sb.toString()).getResultList();
    }
}
