package com.jetfiretool.extra.ssh;

import org.junit.Ignore;
import org.junit.Test;

import com.jcraft.jsch.Session;

/**
 * Jsch工具类单元测试
 * 
 * @author Jetfire
 *
 */
public class JschUtilTest {
	
	@Test
	@Ignore
	public void bindPortTest() {
		//新建会话，此会话用于ssh连接到跳板机（堡垒机），此处为10.1.1.1:22
		Session session = JschUtil.getSession("10.1.1.1", 22, "test", "123456");
		// 将堡垒机保护的内网8080端口映射到localhost，我们就可以通过访问http://localhost:8080/访问内网服务了
		JschUtil.bindPort(session, "172.20.12.123", 8080, 8080);
	}
}
