package com.jetfiretool.crypto.test;

import com.jetfiretool.crypto.Padding;
import com.jetfiretool.crypto.SecureUtil;
import com.jetfiretool.crypto.symmetric.SymmetricAlgorithm;
import com.jetfiretool.crypto.symmetric.SymmetricCrypto;
import org.junit.Assert;
import org.junit.Test;

import com.jetfiretool.core.util.CharsetUtil;
import com.jetfiretool.core.util.StrUtil;
import com.jetfiretool.crypto.Mode;
import com.jetfiretool.crypto.symmetric.AES;
import com.jetfiretool.crypto.symmetric.DES;
import com.jetfiretool.crypto.symmetric.DESede;

/**
 * 对称加密算法单元测试
 * 
 * @author Jetfire
 *
 */
public class SymmetricTest {

	@Test
	public void aesTest() {
		String content = "test中文";

		// 随机生成密钥
		byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

		// 构建
		SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

		// 加密
		byte[] encrypt = aes.encrypt(content);
		// 解密
		byte[] decrypt = aes.decrypt(encrypt);

		Assert.assertEquals(content, StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));

		// 加密为16进制表示
		String encryptHex = aes.encryptHex(content);
		// 解密为字符串
		String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

		Assert.assertEquals(content, decryptStr);
	}

	@Test
	public void aesTest2() {
		String content = "test中文";

		// 随机生成密钥
		byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();

		// 构建
		AES aes = SecureUtil.aes(key);

		// 加密
		byte[] encrypt = aes.encrypt(content);
		// 解密
		byte[] decrypt = aes.decrypt(encrypt);

		Assert.assertEquals(content, StrUtil.utf8Str(decrypt));

		// 加密为16进制表示
		String encryptHex = aes.encryptHex(content);
		// 解密为字符串
		String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

		Assert.assertEquals(content, decryptStr);
	}

	@Test
	public void aesTest3() {
		String content = "test中文aaaaaaaaaaaaaaaaaaaaa";

		AES aes = new AES(Mode.CTS, Padding.PKCS5Padding, "0CoJUm6Qyw8W8jud".getBytes(), "0102030405060708".getBytes());
		
		// 加密
		byte[] encrypt = aes.encrypt(content);
		// 解密
		byte[] decrypt = aes.decrypt(encrypt);

		Assert.assertEquals(content, StrUtil.utf8Str(decrypt));

		// 加密为16进制表示
		String encryptHex = aes.encryptHex(content);
		// 解密为字符串
		String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);

		Assert.assertEquals(content, decryptStr);
	}

	@Test
	public void desTest() {
		String content = "test中文";

		byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();

		SymmetricCrypto des = new SymmetricCrypto(SymmetricAlgorithm.DES, key);
		byte[] encrypt = des.encrypt(content);
		byte[] decrypt = des.decrypt(encrypt);

		Assert.assertEquals(content, StrUtil.utf8Str(decrypt));

		String encryptHex = des.encryptHex(content);
		String decryptStr = des.decryptStr(encryptHex);

		Assert.assertEquals(content, decryptStr);
	}

	@Test
	public void desTest2() {
		String content = "test中文";

		byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DES.getValue()).getEncoded();

		DES des = SecureUtil.des(key);
		byte[] encrypt = des.encrypt(content);
		byte[] decrypt = des.decrypt(encrypt);

		Assert.assertEquals(content, StrUtil.utf8Str(decrypt));

		String encryptHex = des.encryptHex(content);
		String decryptStr = des.decryptStr(encryptHex);

		Assert.assertEquals(content, decryptStr);
	}
	
	@Test
	public void desTest3() {
		String content = "test中文";
		
		DES des = new DES(Mode.CTS, Padding.PKCS5Padding, "0CoJUm6Qyw8W8jud".getBytes(), "01020304".getBytes());
		
		byte[] encrypt = des.encrypt(content);
		byte[] decrypt = des.decrypt(encrypt);
		
		Assert.assertEquals(content, StrUtil.utf8Str(decrypt));
		
		String encryptHex = des.encryptHex(content);
		String decryptStr = des.decryptStr(encryptHex);
		
		Assert.assertEquals(content, decryptStr);
	}

	@Test
	public void desdeTest() {
		String content = "test中文";

		byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();

		DESede des = SecureUtil.desede(key);
		
		byte[] encrypt = des.encrypt(content);
		byte[] decrypt = des.decrypt(encrypt);

		Assert.assertEquals(content, StrUtil.utf8Str(decrypt));

		String encryptHex = des.encryptHex(content);
		String decryptStr = des.decryptStr(encryptHex);

		Assert.assertEquals(content, decryptStr);
	}
	
	@Test
	public void desdeTest2() {
		String content = "test中文";
		
		byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.DESede.getValue()).getEncoded();
		
		DESede des = new DESede(Mode.CBC, Padding.PKCS5Padding, key, "12345678".getBytes());
		
		byte[] encrypt = des.encrypt(content);
		byte[] decrypt = des.decrypt(encrypt);
		
		Assert.assertEquals(content, StrUtil.utf8Str(decrypt));
		
		String encryptHex = des.encryptHex(content);
		String decryptStr = des.decryptStr(encryptHex);
		
		Assert.assertEquals(content, decryptStr);
	}
}
