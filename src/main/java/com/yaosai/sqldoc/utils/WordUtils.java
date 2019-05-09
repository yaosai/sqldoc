package com.yaosai.sqldoc.utils;

import com.lowagie.text.Font;
import com.lowagie.text.*;
import com.yaosai.sqldoc.common.FontStyle;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 创建word文档 步骤: 1,建立文档 2,创建一个书写器 3,打开文档 4,向文档中写入数据 5,关闭文档
 *
 * @author YaoS
 * @date 2019-05-08 14:08
 */
@Component
public class WordUtils {
    private static final String color = "CCFFFF";

    public Table createTable(List<Map<String, Object>> list,String[] titleStr) throws DocumentException, IOException {
        Table table = new Table(titleStr.length);
        table.setBorderWidth(1);
        table.setBorderColor(Color.BLACK);
        table.setPadding(0);
        table.setSpacing(0);
        Font font = FontStyle.getStyle(1);
        Cell[] cell = new Cell[titleStr.length];
        Paragraph title = new Paragraph();
        for (int i = 0; i< titleStr.length ;i++) {
            title = new Paragraph(titleStr[i],font);
            cell[i] = new Cell(title);
            cell[i].setBackgroundColor(new Color(Integer.parseInt(color, 16)));
            cell[i].setHorizontalAlignment(1);
            table.addCell(cell[i]);
        }
        for (Object obj : list) {
            Object[] cells = (Object[]) obj;
            addRowCell(table, cells);
        }
        return table;
    }

    public static void addRowCell(Table table, Object[] cells) throws DocumentException, IOException {
        Font font = FontStyle.getStyle(1);
        for (Object object : cells) {
            Paragraph cell = new Paragraph((String) object);
            cell.setFont(font);
            table.addCell(cell);
        }
    }
}