package com.jetfiretool.extra.template;

import com.jetfiretool.core.lang.Dict;
import com.jetfiretool.extra.template.engine.beetl.BeetlUtil;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.StringTemplateResourceLoader;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * BeetlUtil单元测试
 * 
 * @author Jetfire
 *
 */
public class BeetlUtilTest {

	@Test
	public void renderStrTest() throws IOException {
		GroupTemplate groupTemplate = BeetlUtil.createGroupTemplate(new StringTemplateResourceLoader(), Configuration.defaultConfiguration());
		Template template = BeetlUtil.getTemplate(groupTemplate, "hello,${name}");
		String result = BeetlUtil.render(template, Dict.create().set("name", "jetfiretool"));

		Assert.assertEquals("hello,jetfiretool", result);

		String renderFromStr = BeetlUtil.renderFromStr("hello,${name}", Dict.create().set("name", "jetfiretool"));
		Assert.assertEquals("hello,jetfiretool", renderFromStr);

	}
}
