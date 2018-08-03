package com.jetfiretool.extra.template.engine.rythm;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.Map;

import com.jetfiretool.extra.template.AbstractTemplate;
import com.jetfiretool.extra.template.engine.beetl.BeetlTemplate;

/**
 * Rythm模板包装
 * 
 * @author Jetfire
 *
 */
public class RythmTemplate extends AbstractTemplate implements Serializable {
	private static final long serialVersionUID = -132774960373894911L;

	private org.rythmengine.template.ITemplate rawTemplate;
	
	/**
	 * 包装Rythm模板
	 * 
	 * @param template Rythm的模板对象 {@link org.rythmengine.template.ITemplate}
	 * @return {@link BeetlTemplate}
	 */
	public static RythmTemplate wrap(org.rythmengine.template.ITemplate template) {
		return (null == template) ? null : new RythmTemplate(template);
	}
	
	/**
	 * 构造
	 * 
	 * @param rawTemplate Velocity模板对象
	 */
	public RythmTemplate(org.rythmengine.template.ITemplate rawTemplate) {
		this.rawTemplate = rawTemplate;
	}

	@Override
	public void render(Map<String, Object> bindingMap, Writer writer) {
		rawTemplate.__setRenderArgs(bindingMap);
		rawTemplate.render(writer);
	}

	@Override
	public void render(Map<String, Object> bindingMap, OutputStream out) {
		rawTemplate.__setRenderArgs(bindingMap);
		rawTemplate.render(out);
	}
}
