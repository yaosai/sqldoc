package com.yaosai.sqldoc.common;

import java.awt.Color;
import java.io.IOException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;

public class FontStyle {
	public static Font getStyle(int i) throws DocumentException, IOException {
		BaseFont yh = BaseFont.createFont("/msyh.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
		Font font = new Font();
		switch(i){
		case 0:
				font = new Font(yh,  18, Font.NORMAL, new Color(0, 0, 0));
				break;
		case 1:
				font = new Font(yh,  12, Font.NORMAL, new Color(0, 0, 0));
				break;
		}
		return font;
	}
}
