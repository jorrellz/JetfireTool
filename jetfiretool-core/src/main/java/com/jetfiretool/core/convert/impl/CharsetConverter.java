package com.jetfiretool.core.convert.impl;

import java.nio.charset.Charset;

import com.jetfiretool.core.convert.AbstractConverter;
import com.jetfiretool.core.util.CharsetUtil;

/**
 * 编码对象转换器
 * @author Jetfire
 *
 */
public class CharsetConverter extends AbstractConverter<Charset>{

	@Override
	protected Charset convertInternal(Object value) {
		return CharsetUtil.charset(convertToStr(value));
	}

}
