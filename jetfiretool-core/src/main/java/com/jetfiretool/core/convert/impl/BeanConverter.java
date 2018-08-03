package com.jetfiretool.core.convert.impl;

import java.util.Map;

import com.jetfiretool.core.bean.BeanUtil;
import com.jetfiretool.core.bean.copier.BeanCopier;
import com.jetfiretool.core.bean.copier.CopyOptions;
import com.jetfiretool.core.bean.copier.ValueProvider;
import com.jetfiretool.core.convert.AbstractConverter;
import com.jetfiretool.core.util.ReflectUtil;

/**
 * Bean转换器，支持：
 * <pre>
 * Map =》 Bean
 * Bean =》 Bean
 * ValueProvider =》 Bean
 * </pre>
 * 
 * @param <T> Bean类型
 * @author Jetfire
 * @since 4.0.2
 */
public class BeanConverter<T> extends AbstractConverter<T> {

	private Class<T> beanClass;
	private CopyOptions copyOptions;

	/**
	 * 构造，默认转换选项，注入失败的字段忽略
	 * 
	 * @param beanClass 转换成的目标Bean类
	 */
	public BeanConverter(Class<T> beanClass) {
		this(beanClass, CopyOptions.create().setIgnoreError(true));
		this.beanClass = beanClass;
	}
	
	/**
	 * 构造
	 * 
	 * @param beanClass 转换成的目标Bean类
	 * @param copyOptions Bean转换选项参数
	 */
	public BeanConverter(Class<T> beanClass, CopyOptions copyOptions) {
		this.beanClass = beanClass;
		this.copyOptions = copyOptions;
	}

	@Override
	protected T convertInternal(Object value) {
		if(value instanceof Map || value instanceof ValueProvider || BeanUtil.isBean(value.getClass())) {
			//限定被转换对象类型
			return BeanCopier.create(value, ReflectUtil.newInstanceIfPossible(this.beanClass), copyOptions).copy();
		}
		return null;
	}

	@Override
	public Class<T> getTargetType() {
		return this.beanClass;
	}
}
