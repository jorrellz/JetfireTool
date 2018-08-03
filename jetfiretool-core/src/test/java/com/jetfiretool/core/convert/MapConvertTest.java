package com.jetfiretool.core.convert;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.jetfiretool.core.map.MapBuilder;
import org.junit.Assert;
import org.junit.Test;

/**
 * Map转换单元测试
 * 
 * @author Jetfire
 *
 */
public class MapConvertTest {

	@Test
	public void beanToMapTest() {
		User user = new User();
		user.setName("AAA");
		user.setAge(45);

		HashMap<?, ?> map = Convert.convert(HashMap.class, user);
		Assert.assertEquals("AAA", map.get("name"));
		Assert.assertEquals(45, map.get("age"));
	}

	@Test
	public void mapToMapTest() {
		Map<String, Object> srcMap = MapBuilder.create(new HashMap<String, Object>()).put("name", "AAA").put("age", 45).map();

		LinkedHashMap<?, ?> map = Convert.convert(LinkedHashMap.class, srcMap);
		Assert.assertEquals("AAA", map.get("name"));
		Assert.assertEquals(45, map.get("age"));
	}

	public static class User {
		private String name;
		private int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
	}
}
