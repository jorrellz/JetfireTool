package com.jetfiretool.core.clone;

import java.lang.*;

/**
 * 克隆支持类，提供默认的克隆方法
 * @author Jetfire
 *
 * @param <T> 继承类的类型
 */
public class CloneSupport<T> implements Cloneable<T> {
	
	@SuppressWarnings("unchecked")
	@Override
	public T clone() {
		try {
			return (T) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new CloneRuntimeException(e);
		}
	}
	
}
