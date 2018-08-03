package com.jetfiretool.extra.template.engine;

import com.jetfiretool.extra.template.Engine;
import com.jetfiretool.extra.template.TemplateConfig;
import com.jetfiretool.extra.template.TemplateException;
import com.jetfiretool.extra.template.engine.beetl.BeetlEngine;
import com.jetfiretool.extra.template.engine.freemarker.FreemarkerEngine;
import com.jetfiretool.extra.template.engine.rythm.RythmEngine;
import com.jetfiretool.extra.template.engine.velocity.VelocityEngine;
import com.jetfiretool.log.StaticLog;


/**
 * 简单模板工厂，用于根据用户引入的模板引擎jar，自动创建对应的模板引擎对象
 * 
 * @author Jetfire
 *
 */
public class EngineFactory {
	/**
	 * 根据用户引入的模板引擎jar，自动创建对应的模板引擎对象
	 * 
	 * @param config 模板配置，包括编码、模板文件path等信息
	 * @return {@link Engine}
	 */
	public static Engine create(TemplateConfig config) {
		final Engine engine = doCreate(config);
		StaticLog.debug("Use [{}] Engine As Default.", engine.getName());
		return engine;
	}

	/**
	 * 根据用户引入的模板引擎jar，自动创建对应的模板引擎对象
	 * 
	 * @param config 模板配置，包括编码、模板文件path等信息
	 * @return {@link Engine}
	 */
	private static Engine doCreate(TemplateConfig config) {
		try {
			return new BeetlEngine(config);
		} catch (NoClassDefFoundError e) {
			// ignore
		}
		try {
			return new FreemarkerEngine(config);
		} catch (NoClassDefFoundError e) {
			// ignore
		}
		try {
			return new VelocityEngine(config);
		} catch (NoClassDefFoundError e) {
			// ignore
		}
		try {
			return new RythmEngine(config);
		} catch (NoClassDefFoundError e) {
			// ignore
		}
		throw new TemplateException("No template found ! Please add one of [Beetl,Freemarker,Velocity,Rythm] jar to your project !");
	}
}
