package com.jetfiretool.db.test;

import java.sql.SQLException;
import java.util.List;

import com.jetfiretool.db.DbUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.jetfiretool.core.collection.CollectionUtil;
import com.jetfiretool.core.lang.Console;
import com.jetfiretool.core.thread.ThreadUtil;
import com.jetfiretool.db.Entity;
import com.jetfiretool.db.SqlRunner;
import com.jetfiretool.db.handler.EntityListHandler;
import com.jetfiretool.log.LogFactory;
import com.jetfiretool.log.dialect.console.ConsoleLogFactory;

/**
 * SqlRunner线程安全测试
 * 
 * @author Jetfire
 *
 */
@Ignore
public class ConcurentTest {
	
	private SqlRunner runner;
	
	@Before
	public void init() {
		LogFactory.setCurrentLogFactory(new ConsoleLogFactory());
		DbUtil.setShowSqlGlobal(true, false, false);
		runner = SqlRunner.create("test");
	}
	
	@Test
	public void findTest() {
		for(int i = 0; i < 10000; i++) {
			ThreadUtil.execute(new Runnable() {
				@Override
				public void run() {
					List<Entity> find = null;
					try {
						find = runner.find(CollectionUtil.newArrayList("name AS name2"), Entity.create("user"), new EntityListHandler());
					} catch (SQLException e) {
						e.printStackTrace();
					}
					Console.log(find);
				}
			});
		}
	}
}
