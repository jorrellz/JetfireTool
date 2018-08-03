package com.jetfiretool.log;

import com.jetfiretool.log.level.DebugLog;
import com.jetfiretool.log.level.ErrorLog;
import com.jetfiretool.log.level.InfoLog;
import com.jetfiretool.log.level.Level;
import com.jetfiretool.log.level.TraceLog;
import com.jetfiretool.log.level.WarnLog;

/**
 * 日志统一接口
 * 
 * @author Jetfire
 *
 */
public interface Log extends TraceLog, DebugLog, InfoLog, WarnLog, ErrorLog {

	/**
	 * @return 日志对象的Name
	 */
	public String getName();

	/**
	 * 是否开启指定日志
	 * @param level 日志级别
	 * @return 是否开启指定级别
	 */
	boolean isEnabled(Level level);

	/**
	 * 打印指定级别的日志
	 * @param level 级别
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void log(Level level, String format, Object... arguments);

	/**
	 * 打印 指定级别的日志
	 * 
	 * @param level 级别
	 * @param t 错误对象
	 * @param format 消息模板
	 * @param arguments 参数
	 */
	void log(Level level, Throwable t, String format, Object... arguments);
}
