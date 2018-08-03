package com.jetfiretool.core.convert.impl;

import java.util.UUID;

import com.jetfiretool.core.convert.AbstractConverter;

/**
 * UUID对象转换器转换器
 * 
 * @author Jetfire
 * @since 4.0.10
 *
 */
public class UUIDConverter extends AbstractConverter<UUID> {

	@Override
	protected UUID convertInternal(Object value) {
		return UUID.fromString(convertToStr(value));
	}

}
