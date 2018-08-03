package com.jetfiretool.core.convert.impl;

import com.jetfiretool.core.convert.AbstractConverter;
import com.jetfiretool.core.util.StrUtil;

/**
 * 字符转换器
 * @author Jetfire
 *
 */
public class CharacterConverter extends AbstractConverter<Character>{

	@Override
	protected Character convertInternal(Object value) {
		if(char.class == value.getClass()){
			return Character.valueOf((char)value);
		}else{
			final String valueStr = convertToStr(value);
			if (StrUtil.isNotBlank(valueStr)) {
				return Character.valueOf(valueStr.charAt(0));
			}
		}
		return null;
	}

}
