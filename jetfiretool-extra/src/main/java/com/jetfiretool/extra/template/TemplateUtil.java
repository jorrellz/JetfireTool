package com.jetfiretool.extra.template;

import com.jetfiretool.extra.template.engine.EngineFactory;

/**
 * 模板工具类
 * 
 * @author Jetfire
 * @since 4.1.0
 */
public class TemplateUtil {

	/**
	 * 根据用户引入的模板引擎jar，自动创建对应的模板引擎对象
	 * 
	 * @param config 模板配置，包括编码、模板文件path等信息
	 * @return {@link Engine}
	 */
	public static Engine createEngine(TemplateConfig config) {
		return EngineFactory.create(config);
	}
}
