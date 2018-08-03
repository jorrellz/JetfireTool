package com.jetfiretool.core.lang;

import com.jetfiretool.core.text.TextSimilarity;
import org.junit.Assert;
import org.junit.Test;

/**
 * 文本相似度计算工具类单元测试
 * @author Jetfire
 *
 */
public class TextSimilarityTest {
	
	@Test
	public void similarDegreeTest() {
		String a = "我是一个文本，独一无二的文本";
		String b = "一个文本，独一无二的文本";
		
		double degree = TextSimilarity.similar(a, b);
		Assert.assertEquals(0.8571428571428571D, degree, 16);
		
		String similarPercent = TextSimilarity.similar(a, b, 2);
		Assert.assertEquals("85.71%", similarPercent);
	}
}