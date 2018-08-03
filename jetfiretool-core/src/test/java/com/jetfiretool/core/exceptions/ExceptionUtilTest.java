package com.jetfiretool.core.exceptions;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.jetfiretool.core.io.IORuntimeException;

/**
 * 异常工具单元测试
 * @author Jetfire
 *
 */
public class ExceptionUtilTest {
	
	@Test
	public void wrapTest() {
		IORuntimeException e = ExceptionUtil.wrap(new IOException(), IORuntimeException.class);
		Assert.assertNotNull(e);
	}
	
	@Test
	public void getRootTest() {
		//查找入口方法
		StackTraceElement ele = ExceptionUtil.getRootStackElement();
		Assert.assertEquals("main", ele.getMethodName());
	}
}
