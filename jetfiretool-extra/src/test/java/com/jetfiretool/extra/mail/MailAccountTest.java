package com.jetfiretool.extra.mail;

import org.junit.Assert;
import org.junit.Test;

/**
 * 默认邮件帐户设置测试
 * @author Jetfire
 *
 */
public class MailAccountTest {
	
	@Test
	public void parseSettingTest() {
		MailAccount account = GlobalMailAccount.INSTANCE.getAccount();
		Assert.assertNotNull(account.getCharset());
	}
}
