package com.jetfiretool.log.dialect.console;

import com.jetfiretool.log.Log;
import com.jetfiretool.log.LogFactory;

/**
 * 利用System.out.println()打印日志
 * @author Jetfire
 *
 */
public class ConsoleLogFactory extends LogFactory {
	
	public ConsoleLogFactory() {
		super("jetfiretool Console Logging");
	}

	@Override
	public Log createLog(String name) {
		return new ConsoleLog(name);
	}

	@Override
	public Log createLog(Class<?> clazz) {
		return new ConsoleLog(clazz);
	}

}
