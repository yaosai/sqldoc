package com.yaosai.sqldoc.config;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.lowagie.text.rtf.RtfWriter2;
import com.yaosai.sqldoc.service.SqlDocService;
import com.yaosai.sqldoc.utils.WordUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.awt.*;
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
//            String baseName = "jd_platform_chen";
            List<String> tableNames = sqlDocService.getAllTableName(baseName);
            Document document = new Document(PageSize.A4);
            RtfWriter2.getInstance(document, new FileOutputStream(path));
            document.open();
            try {
                //设置全局文档名称
                Paragraph paragraph = new Paragraph();
                Font f = new Font();
                Paragraph p = new Paragraph("数据库表结构说明", new Font(Font.NORMAL, 18, Font.BOLD, new Color(0, 0, 0)));
                p.setAlignment(1);
                document.add(p);
                paragraph.setFont(f);
                for (String tableName : tableNames) {
                    List list = sqlDocService.getColumnInfo(baseName, tableName);
                    Table table = wordUtils.createTable(list);
                    document.add(new Paragraph(""));
                    document.add(new Paragraph(tableName + "表结构说明"));
                    document.add(table);
                }
                document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
    }
}
