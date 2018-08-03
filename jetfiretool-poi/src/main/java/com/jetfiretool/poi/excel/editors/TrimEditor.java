package com.jetfiretool.poi.excel.editors;

import org.apache.poi.ss.usermodel.Cell;

import com.jetfiretool.core.util.StrUtil;
import com.jetfiretool.poi.excel.cell.CellEditor;

/**
 * 去除String类型的单元格值两边的空格
 * @author Jetfire
 *
 */
public class TrimEditor implements CellEditor{

	@Override
	public Object edit(Cell cell, Object value) {
		if(value instanceof String) {
			return StrUtil.trim((String)value);
		}
		return value;
	}

}
