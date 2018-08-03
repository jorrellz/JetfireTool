package com.jetfiretool.db.test;

import java.util.Map;

import com.jetfiretool.db.sql.NamedSql;
import org.junit.Assert;
import org.junit.Test;

import com.jetfiretool.core.map.MapBuilder;
import com.jetfiretool.core.map.MapUtil;

public class NamedSqlTest {

	@Test
	public void parseTest() {
		String sql = "select * from table where id=@id and name = @name1 and nickName = :subName";

		MapBuilder<String, Object> builder = MapUtil.builder();
		Map<String, Object> paramMap = builder.put("name1", "张三").put("age", 12).put("subName", "小豆豆").build();

		NamedSql namedSql = new NamedSql(sql, paramMap);
		Assert.assertEquals("select * from table where id=@id and name = ? and nickName = ?", namedSql.getSql());
		Assert.assertEquals("张三", namedSql.getParams()[0]);
		Assert.assertEquals("小豆豆", namedSql.getParams()[1]);
	}
}
