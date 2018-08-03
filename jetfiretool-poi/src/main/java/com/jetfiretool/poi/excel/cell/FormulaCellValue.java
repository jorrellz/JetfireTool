package com.jetfiretool.poi.excel.cell;

/**
 * 公式类型的值
 * 
 * @author Jetfire
 * @since 4.0.11
 */
public class FormulaCellValue implements CellValue<String> {

	/** 公式 */
	String formula;

	public FormulaCellValue(String formula) {
		this.formula = formula;
	}

	@Override
	public String getValue() {
		return this.formula;
	}

}
