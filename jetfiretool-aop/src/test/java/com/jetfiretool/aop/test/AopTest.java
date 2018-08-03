package com.jetfiretool.aop.test;

import com.jetfiretool.aop.ProxyUtil;
import com.jetfiretool.aop.aspects.TimeIntervalAspect;
import org.junit.Assert;
import org.junit.Test;

/**
 * AOP模块单元测试
 * @author Jetfire
 *
 */
public class AopTest {
	
	@Test
	public void aopTest(){
		Animal cat = ProxyUtil.proxy(new Cat(), TimeIntervalAspect.class);
		String result = cat.eat();
		Assert.assertEquals("猫吃鱼", result);
	}
	
	static interface Animal{
		String eat();
	}
	
	static class Cat implements Animal{

		@Override
		public String eat() {
			return "猫吃鱼";
		}
		
	}
}
