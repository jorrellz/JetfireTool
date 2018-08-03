package com.jetfiretool.cache.test;

import org.junit.Assert;
import org.junit.Test;

import com.jetfiretool.cache.file.LFUFileCache;

/**
 * 文件缓存单元测试
 * @author Jetfire
 *
 */
public class FileCacheTest {
	@Test
	public void lfuFileCacheTest() {
		LFUFileCache cache = new LFUFileCache(1000, 500, 2000);
		Assert.assertNotNull(cache);
	}
}
