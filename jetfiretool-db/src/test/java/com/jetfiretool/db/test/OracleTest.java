package com.jetfiretool.db.test;

import java.sql.SQLException;

import com.jetfiretool.db.Entity;
import com.jetfiretool.db.Page;
import com.jetfiretool.db.PageResult;
import org.junit.Ignore;
import org.junit.Test;

import com.jetfiretool.core.lang.Console;
import com.jetfiretool.db.Db;

/**
 * Oracle操作单元测试
 * 
 * @author Jetfire
 *
 */
public class OracleTest {

	@Test
	@Ignore
	public void pageTest() throws SQLException {
		PageResult<Entity> result = Db.use("orcl").page(Entity.create("T_USER").set("name", "张三"), new Page(1, 10));
		Console.log(result);
	}

}
