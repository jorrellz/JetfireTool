package com.jetfiretool.core.io;

/**
 * Stream进度条
 * @author Jetfire
 *
 */
public interface StreamProgress {
	
	/**
	 * 开始
	 */
	public void start();
	
	/**
	 * 进行中
	 * @param progressSize 已经进行的大小
	 */
	public void progress(long progressSize);
	
	/**
	 * 结束
	 */
	public void finish();
}
