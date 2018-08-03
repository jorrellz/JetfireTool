package com.jetfiretool.core.convert.impl;

import com.jetfiretool.core.convert.AbstractConverter;
import com.jetfiretool.core.util.ClassUtil;

/**
 * 类转换器<br>
 * 将类名转换为类
 * @author Jetfire
 *
 */
public class ClassConverter extends AbstractConverter<Class<?>> {
	
	@Override
	protected Class<?> convertInternal(Object value) {
		String valueStr = convertToStr(value);
		try {
			return ClassUtil.getClassLoader().loadClass(valueStr);
		} catch (Exception e) {
			// Ignore Exception
		}
		return null;
	}

}
