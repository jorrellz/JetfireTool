package com.jetfiretool.http.test;

import java.util.List;
import java.util.Map;

import com.jetfiretool.http.HttpResponse;
import org.junit.Ignore;
import org.junit.Test;

import com.jetfiretool.core.date.DateUtil;
import com.jetfiretool.core.date.TimeInterval;
import com.jetfiretool.core.lang.Console;
import com.jetfiretool.core.util.CharsetUtil;
import com.jetfiretool.http.HttpRequest;
import com.jetfiretool.http.ssl.SSLSocketFactoryBuilder;

/**
 * {@link HttpRequest}单元测试
 * 
 * @author Jetfire
 *
 */
public class HttpRequestTest {
	final String url = "http://photo.qzone.qq.com/fcgi-bin/fcg_list_album?uin=88888&outstyle=2";

	@Test
	@Ignore
	public void getHttpsTest() {
		String body = HttpRequest.get("https://www.gjifa.com/pc/").execute().body();
		Console.log(body);
	}
	
	@Test
	@Ignore
	public void getWithParamsTest() {
		String url = "http://gc.ditu.aliyun.com/geocoding?ccc=你好";
		
		HttpRequest request = HttpRequest.get(url).setEncodeUrl(true).body("a=乌海");
		String body = request.execute().body();
		Console.log(body);
		
//		String body2 = HttpUtil.get(url);
//		Console.log(body2);
	}

	@Test
	@Ignore
	public void asyncHeadTest() {
		HttpResponse response = HttpRequest.head(url).execute();
		Map<String, List<String>> headers = response.headers();
		Console.log(headers);
		Console.log(response.body());
	}

	@Test
	@Ignore
	public void asyncGetTest() {
		TimeInterval timer = DateUtil.timer();
		HttpResponse body = HttpRequest.get(url).charset("GBK").executeAsync();
		long interval = timer.interval();
		timer.restart();
		Console.log(body.body());
		long interval2 = timer.interval();
		Console.log("Async response spend {}ms, body spend {}ms", interval, interval2);
	}

	@Test
	@Ignore
	public void syncGetTest() {
		TimeInterval timer = DateUtil.timer();
		HttpResponse body = HttpRequest.get(url).charset("GBK").execute();
		long interval = timer.interval();
		timer.restart();
		Console.log(body.body());
		long interval2 = timer.interval();
		Console.log("Async response spend {}ms, body spend {}ms", interval, interval2);
	}

	@Test
	@Ignore
	public void customGetTest() {
		// 自定义构建HTTP GET请求，发送Http GET请求，针对HTTPS安全加密，可以自定义SSL
		HttpRequest request = HttpRequest.get(url)
				// 自定义返回编码
				.charset(CharsetUtil.CHARSET_GBK)
				// 禁用缓存
				.disableCache()
				// 自定义SSL版本
				.setSSLProtocol(SSLSocketFactoryBuilder.TLSv12);
		Console.log(request.execute().body());
	}
}
