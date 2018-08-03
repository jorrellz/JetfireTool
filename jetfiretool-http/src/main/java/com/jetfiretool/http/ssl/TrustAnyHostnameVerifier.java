package com.jetfiretool.http.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/**
 * https 域名校验
 * 
 * @author Jetfire
 */
public class TrustAnyHostnameVerifier implements HostnameVerifier {
	
	@Override
	public boolean verify(String hostname, SSLSession session) {
		return true;// 直接返回true
	}
}
