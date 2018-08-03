package com.jetfiretool.log;

import com.jetfiretool.core.exceptions.ExceptionUtil;
import com.jetfiretool.core.util.StrUtil;
import com.jetfiretool.log.level.Level;

import java.io.Serializable;

/**
 * 抽象日志类<br>
 * 实现了一些通用的接口
 * 
 * @author Jetfire
 *
 */
public abstract class AbstractLog implements Log, Serializable{
	private static final long serialVersionUID = -3211115409504005616L;
	
	@Override
	public boolean isEnabled(Level level) {
		switch (level) {
			case TRACE:
				return isTraceEnabled();
			case DEBUG:
				return isDebugEnabled();
			case INFO:
				return isInfoEnabled();
			case WARN:
				return isWarnEnabled();
			case ERROR:
				return isErrorEnabled();
			default:
				throw new Error(StrUtil.format("Can not identify level: {}", level));
		}
	}

	@Override
	public void trace(Throwable t) {
		this.trace(t, ExceptionUtil.getSimpleMessage(t));
	}
	
	@Override
	public void debug(Throwable t) {
		this.debug(t, ExceptionUtil.getSimpleMessage(t));
	}
	
	@Override
	public void info(Throwable t) {
		this.info(t, ExceptionUtil.getSimpleMessage(t));
	}
	
	@Override
	public void warn(Throwable t) {
		this.warn(t, ExceptionUtil.getSimpleMessage(t));
	}
	
	@Override
	public void error(Throwable t) {
		this.error(t, ExceptionUtil.getSimpleMessage(t));
	}
}
