package com.zist.utils;

import com.zist.model.Style;

public class styleValidation {

	public static Style validateStyleAndGetStyle(ResponseMap response, String styleCode, String knitPattern){

		Style style = new Style();
		
		style.setStyleCode(styleCode);
		style.setKnitPattern(knitPattern);
		return style;
	}
}
