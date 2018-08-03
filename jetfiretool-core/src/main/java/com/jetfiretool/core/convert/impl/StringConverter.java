package com.jetfiretool.core.convert.impl;

import com.jetfiretool.core.convert.AbstractConverter;

/**
 * 字符串转换器
 * @author Jetfire
 *
 */
public class StringConverter extends AbstractConverter<String>{

	@Override
	protected String convertInternal(Object value) {
		return convertToStr(value);
	}

}
