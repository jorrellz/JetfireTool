package com.jetfiretool.db.test;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;

import com.jetfiretool.core.collection.CollectionUtil;
import com.jetfiretool.db.ds.DSFactory;
import com.jetfiretool.db.meta.MetaUtil;
import com.jetfiretool.db.meta.Table;

/**
 * 元数据信息单元测试
 * 
 * @author Jetfire
 *
 */
public class MetaTest {
	DataSource ds = DSFactory.get("test");

	@Test
	public void getTablesTest() {
		List<String> tables = MetaUtil.getTables(ds);
		Assert.assertEquals("user", tables.get(0));
	}

	@Test
	public void getTableMetaTest() {

		Table table = MetaUtil.getTableMeta(ds, "user");
		Assert.assertEquals(CollectionUtil.newHashSet("id"), table.getPkNames());
	}
}
