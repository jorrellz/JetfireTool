package com.jetfiretool.core.convert.impl;

import com.jetfiretool.core.convert.AbstractConverter;
import com.jetfiretool.core.convert.ConverterRegistry;
import com.jetfiretool.core.util.ArrayUtil;

/**
 * byte 类型数组转换器
 * @author Jetfire
 *
 */
public class ByteArrayConverter extends AbstractConverter<byte[]>{
	
	@Override
	protected byte[] convertInternal(Object value) {
		final Byte[] result = ConverterRegistry.getInstance().convert(Byte[].class, value);
		return ArrayUtil.unWrap(result);
	}

}
