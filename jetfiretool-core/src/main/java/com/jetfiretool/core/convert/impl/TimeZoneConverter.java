package com.jetfiretool.core.convert.impl;

import java.util.TimeZone;

import com.jetfiretool.core.convert.AbstractConverter;

/**
 * TimeZone转换器
 * @author Jetfire
 *
 */
public class TimeZoneConverter extends AbstractConverter<TimeZone>{

	@Override
	protected TimeZone convertInternal(Object value) {
		return TimeZone.getTimeZone(convertToStr(value));
	}

}
