package com.jetfiretool.db.test;

import com.jetfiretool.db.Page;
import com.jetfiretool.db.sql.Query;
import com.jetfiretool.db.sql.SqlBuilder;
import com.jetfiretool.db.sql.SqlUtil;
import org.junit.Test;

import com.jetfiretool.core.lang.Console;
import com.jetfiretool.db.Entity;

/**
 * SQL单元测试
 * 
 * @author Jetfire
 *
 */
public class SqlTest {
	
	@Test
	public void oraclePageSqlTest() {
		Page page = new Page(1, 10);
		Entity where = Entity.create("PMCPERFORMANCEINFO").set("yearPI", "2017");
		final Query query = new Query(SqlUtil.buildConditions(where), where.getTableName());
		query.setPage(page);
		
		
		
		SqlBuilder find = SqlBuilder.create(null).query(query).orderBy(page.getOrders());
		final int[] startEnd = page.getStartEnd();
		SqlBuilder builder =  SqlBuilder.create(null)
			.append("SELECT * FROM ( SELECT row_.*, rownum rownum_ from ( ")//
			.append(find)//
			.append(" ) row_ where rownum <= ").append(startEnd[1])//
			.append(") table_alias")//
			.append(" where table_alias.rownum_ >= ").append(startEnd[0]);//
		
		Console.log(builder);
	}
}
