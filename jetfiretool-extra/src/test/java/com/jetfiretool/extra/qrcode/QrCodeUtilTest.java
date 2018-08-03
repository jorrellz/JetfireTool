package com.jetfiretool.extra.qrcode;

import com.jetfiretool.core.io.FileUtil;
import com.jetfiretool.core.lang.Console;
import org.junit.Ignore;
import org.junit.Test;

import java.awt.*;



/**
 * 二维码工具类单元测试
 * 
 * @author Jetfire
 *
 */
public class QrCodeUtilTest {

	@Test
	@Ignore
	public void generateTest() {
		QrCodeUtil.generate("http://jetfiretool.cn/", 300, 300, FileUtil.file("e:/qrcode.jpg"));
	}
	
	@Test
	@Ignore
	public void generateTest2() {
		QrConfig config = new QrConfig();
		config.setMargin(3);
		config.setForeColor(Color.CYAN.getRGB());
		config.setBackColor(Color.GRAY.getRGB());
		QrCodeUtil.generate("http://jetfiretool.cn/", config, FileUtil.file("e:/qrcode.jpg"));
	}

	@Test
	@Ignore
	public void decodeTest() {
		String decode = QrCodeUtil.decode(FileUtil.file("e:/test.png"));
		Console.log(decode);
	}
}
