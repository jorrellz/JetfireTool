package com.jetfiretool.core.io;

import com.jetfiretool.core.lang.Console;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

/**
 * 文件类型判断单元测试
 * @author Jetfire
 *
 */
public class FileTypeUtilTest {
	
	@Test
	public void fileTypeUtilTest() {
		File file = FileUtil.file("jetfiretool.jpg");
		String type = FileTypeUtil.getType(file);
		Assert.assertEquals("jpg", type);
		
		FileTypeUtil.putFileType("ffd8ffe000104a464946", "new_jpg");
		String newType = FileTypeUtil.getType(file);
		Assert.assertEquals("jpg", newType);
	}
	
	@Test
	@Ignore
	public void emptyTest() {
		File file = FileUtil.file("d:/empty.txt");
		String type = FileTypeUtil.getType(file);
		Console.log(type);
	}
}
