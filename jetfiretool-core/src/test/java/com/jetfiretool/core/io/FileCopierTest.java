package com.jetfiretool.core.io;

import org.junit.Ignore;
import org.junit.Test;

import com.jetfiretool.core.io.file.FileCopier;

/**
 * 文件拷贝单元测试
 * @author Jetfire
 *
 */
public class FileCopierTest {
	
	@Test
	@Ignore
	public void dirCopyTest() {
		FileCopier copier = FileCopier.create("D:\\Java", "e:/eclipse/eclipse2.zip");
		copier.copy();
	}
	
	@Test
	@Ignore
	public void dirCopyTest2() {
		//测试带.的文件夹复制
		FileCopier copier = FileCopier.create("D:\\workspace\\java\\.metadata", "D:\\workspace\\java\\temp");
		copier.copy();
		
		FileUtil.copy("D:\\workspace\\java\\Jetfire\\jetfiretool\\.git", "D:\\workspace\\java\\temp", true);
	}
	
	@Test
	@Ignore
	public void copyFileToDirTest() {
		FileCopier copier = FileCopier.create("d:/GReen_Soft/XshellXftpPortable.zip", "c:/hp/");
		copier.copy();
	}
}
