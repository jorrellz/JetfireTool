package com.jetfiretool.extra.mail;

import com.jetfiretool.core.io.FileUtil;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Properties;

/**
 * 邮件发送测试
 * @author jetfire
 *
 */
public class MailTest {
	
	@Test
	@Ignore
	public void sendTest() {
		MailUtil.send("jetfiretool@foxmail.com", "测试", "<h1>邮件来自jetfire测试</h1>", true, FileUtil.file("d:/测试附件文本.txt"));
	}
	
	@Test
	@Ignore
	public void sendTest2() {
		//附件名长度大于60时的测试
		MailUtil.send("jetfiretool@foxmail.com", "测试", "<h1>邮件来自Jetfire测试</h1>", true, FileUtil.file("d:/6-LongLong一阶段平台建设周报2018.3.12-3.16.xlsx"));
	}
	
	@Test
	@Ignore
	public void sendHtmlTest() {
		MailUtil.send("jetfiretool@foxmail.com", "测试", "<h1>邮件来自Jetfire测试</h1>", true);
	}
	
	@Test
	@Ignore
	public void sendByAccountTest() {
		MailAccount account = new MailAccount();
//		account.setHost("smtp.yeah.net");
//		account.setPort(25);
		account.setFrom("jetfiretool@yeah.net");
//		account.setUser("jetfiretool");
		account.setPass("q1w2e3");
//		MailUtil.send(account, "914104645@qq.com, loolly@aliyun.com", "测试", "邮件来自Jetfire测试", true);
	}
	
	@Test
	public void mailAccountTest() {
		MailAccount account = new MailAccount();
		account.setFrom("jetfiretool@yeah.net");
		account.setDebug(true);
		account.defaultIfEmpty();
		Properties props = account.getSmtpProps();
		Assert.assertEquals("true", props.getProperty("mail.debug"));
	}
}
