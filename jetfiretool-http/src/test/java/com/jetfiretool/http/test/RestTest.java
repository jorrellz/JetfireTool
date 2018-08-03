package com.jetfiretool.http.test;

import org.junit.Ignore;
import org.junit.Test;

import com.jetfiretool.core.lang.Console;
import com.jetfiretool.http.HttpRequest;
import com.jetfiretool.http.HttpUtil;
import com.jetfiretool.json.JSONUtil;

public class RestTest {
	
	@Test
	@Ignore
	public void postTest() {
		HttpRequest request = HttpRequest.post("http://localhost:8090/rest/restTest/")
				.body(JSONUtil.createObj().put("aaa", "aaaValue").put("键2", "值2"));
		Console.log(request.execute().body());
	}
	
	@Test
	@Ignore
	public void postTest2() {
		String result = HttpUtil.post("http://localhost:8090/rest/restTest/", JSONUtil.createObj().put("aaa", "aaaValue").put("键2", "值2").toString());
		Console.log(result);
	}
	
	@Test
	@Ignore
	public void postTest3() {
		HttpRequest request = HttpRequest.post("http://211.162.39.204:8181/jeesite-simple/a/open/bizGwbnService/test")
				.body(JSONUtil.createObj().put("aaa", "aaaValue").put("键2", "值2"));
		Console.log(request.execute().body());
	}
}
