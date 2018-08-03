package com.jetfiretool.db.test;

import com.jetfiretool.core.collection.CollUtil;
import com.jetfiretool.db.Entity;
import com.jetfiretool.db.SqlRunner;
import com.jetfiretool.db.ds.DSFactory;
import com.jetfiretool.db.ds.c3p0.C3p0DSFactory;
import com.jetfiretool.db.ds.dbcp.DbcpDSFactory;
import com.jetfiretool.db.ds.druid.DruidDSFactory;
import com.jetfiretool.db.ds.hikari.HikariDSFactory;
import com.jetfiretool.db.ds.pooled.PooledDSFactory;
import com.jetfiretool.db.ds.tomcat.TomcatDSFactory;
import org.junit.Assert;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

/**
 * 数据源单元测试
 * @author Jetfire
 *
 */
public class DsTest {
	
	@Test
	public void defaultDsTest() throws SQLException{
		DataSource ds = DSFactory.get("test");
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void hikariDsTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new HikariDSFactory());
		DataSource ds = DSFactory.get("test");
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void druidDsTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new DruidDSFactory());
		DataSource ds = DSFactory.get("test");
		
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void tomcatDsTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new TomcatDSFactory());
		DataSource ds = DSFactory.get("test");
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void dbcpDsTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new DbcpDSFactory());
		DataSource ds = DSFactory.get("test");
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void c3p0DsTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new C3p0DSFactory());
		DataSource ds = DSFactory.get("test");
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
	
	@Test
	public void JetfirePoolTest() throws SQLException{
		DSFactory.setCurrentDSFactory(new PooledDSFactory());
		DataSource ds = DSFactory.get("test");
		SqlRunner runner = SqlRunner.create(ds);
		List<Entity> all = runner.findAll("user");
		Assert.assertTrue(CollUtil.isNotEmpty(all));
	}
}
