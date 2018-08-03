package com.jetfiretool.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.jetfiretool.core.lang.test.bean.ExamInfoDict;
import org.junit.Assert;
import org.junit.Test;

/**
 * 反射工具类单元测试
 * 
 * @author Jetfire
 *
 */
public class ReflectUtilTest {

	@Test
	public void getMethodsTest() {
		Method[] methods = ReflectUtil.getMethods(ExamInfoDict.class);
		Assert.assertTrue(ArrayUtil.isNotEmpty(methods));
	}

	@Test
	public void getMethodTest() {
		Method method = ReflectUtil.getMethod(ExamInfoDict.class, "getId");
		Assert.assertEquals("getId", method.getName());
	}

	@Test
	public void getFieldTest() {
		// 能够获取到父类字段
		Field privateField = ReflectUtil.getField(ClassUtilTest.TestSubClass.class, "privateField");
		Assert.assertNotNull(privateField);
	}

	@Test
	public void invokeTest() {
		TestClass testClass = new TestClass();
		ReflectUtil.invoke(testClass, "setA", 10);
		Assert.assertEquals(10, testClass.getA());
	}

	static class TestClass {
		private int a;

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}
	}
}
