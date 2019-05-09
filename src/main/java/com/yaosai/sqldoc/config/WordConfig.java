package com.yaosai.sqldoc.config;

import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;
import com.yaosai.sqldoc.common.FontStyle;
import com.yaosai.sqldoc.service.SqlDocService;
import com.yaosai.sqldoc.utils.WordUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileOutputStream;
import java.util.List;

/**
 * @author YaoS
 * @date 2019-05-08 17:23
 */
@Configuration
public class WordConfig {
    @Value("${word.path}")
    private String path;
    @Value("${database.name}")
    private String baseName;

    @Bean
    public CommandLineRunner demo(SqlDocService sqlDocService) {
        return (args) -> {
            WordUtils wordUtils = new WordUtils();
            List<String> tableNames = sqlDocService.getAllTableName(baseName);
            Document document = new Document(PageSize.A4);
            RtfWriter2.getInstance(document, new FileOutputStream(path));
            document.open();
            try {
                Font titleStyle = FontStyle.getStyle(0);
                // 设置全局文档名称
                Paragraph paragraph = new Paragraph();
                Font f = new Font();
                f.setSize(14);
                Paragraph p = new Paragraph(baseName + "数据库设计文档",titleStyle);
                p.setAlignment(1);
                document.add(p);
                paragraph.setFont(f);
                List databaseList = sqlDocService.getTableInfo(baseName);
                String[] titleStr = {"表名","注释"};
                Table database = wordUtils.createTable(databaseList,titleStr);
                document.add(new Paragraph(""));
                Paragraph databaseTitle = new Paragraph("全表说明",titleStyle);
                databaseTitle.setFirstLineIndent(40f);
                document.add(databaseTitle);

                document.add(database);
                Paragraph pl = new Paragraph("数据库表结构说明",titleStyle);
                document.add(new Paragraph(""));
                document.add(pl);

                for (String tableName : tableNames) {

                    List list = sqlDocService.getColumnInfo(baseName, tableName);
                    String[] titleStr2 = {"字段名","数据类型","是否为键 ","默认为空","注释"};
                    Table table = wordUtils.createTable(list,titleStr2);

                    document.add(new Paragraph(""));
                    Paragraph tableTitle = new Paragraph(tableName + "表结构说明",
                            titleStyle);
                    tableTitle.setFirstLineIndent(40f);
                    document.add(tableTitle);
                    document.add(table);
                }
                document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
    }
}
