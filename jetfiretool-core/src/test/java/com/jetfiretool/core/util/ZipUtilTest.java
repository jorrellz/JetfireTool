package com.jetfiretool.core.util;

import java.io.File;

import com.jetfiretool.core.lang.Console;
import org.junit.Ignore;
import org.junit.Test;

/**
 * {@link ZipUtil}单元测试
 * @author Jetfire
 *
 */
public class ZipUtilTest {
	
	@Test
	@Ignore
	public void zipDirTest() {
		ZipUtil.zip("d:/aaa");
	}
	
	@Test
	@Ignore
	public void unzipTest() {
		File unzip = ZipUtil.unzip("E:\\aaa\\RongGenetor V1.0.0.zip", "e:\\aaa");
		Console.log(unzip);
		File unzip2 = ZipUtil.unzip("E:\\aaa\\RongGenetor V1.0.0.zip", "e:\\aaa");
		Console.log(unzip2);
	}
	
	@Test
	@Ignore
	public void unzipChineseTest() {
		ZipUtil.unzip("d:/测试.zip");
	}
}
