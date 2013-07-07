package com.zist.Utils;

import com.zist.model.Style;
import com.zist.util.ResponseMap;

public class styleValidation {

	public static Style validateStyleAndGetStyle(ResponseMap response, String styleCode, String knitPattern){

		Style style = new Style();
		
		style.setStyleCode(styleCode);
		style.setKnitPattern(knitPattern);
		return style;
	}
}
