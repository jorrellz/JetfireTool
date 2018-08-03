package com.jetfiretool.core.lang;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class ClassScanerTest {
	
	@Test
	public void scanTest() {
		Set<Class<?>> result = ClassScaner.scanPackage("com.jetfiretool.core");
//		for (Class<?> clazz : result) {
//			Console.log(clazz.getName());
//		}
		Assert.assertFalse(result.isEmpty());
	}
}
