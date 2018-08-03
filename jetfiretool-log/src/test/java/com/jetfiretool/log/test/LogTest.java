package com.jetfiretool.log.test;

import com.jetfiretool.log.level.Level;
import org.junit.Test;

import com.jetfiretool.log.Log;
import com.jetfiretool.log.LogFactory;

/**
 * 日志门面单元测试
 * @author Jetfire
 *
 */
public class LogTest {
	
	@Test
	public void logTest(){
		Log log = LogFactory.get();
		// 自动选择日志实现
		log.debug("This is {} log", Level.DEBUG);
		log.info("This is {} log", Level.INFO);
		log.warn("This is {} log", Level.WARN);
		
//		Exception e = new Exception("test Exception");
//		log.error(e, "This is {} log", Level.ERROR);
	}
}
