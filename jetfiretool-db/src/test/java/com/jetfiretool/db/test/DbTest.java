package com.jetfiretool.db.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.jetfiretool.core.lang.Console;
import com.jetfiretool.db.Db;
import com.jetfiretool.db.Entity;
import com.jetfiretool.db.transaction.TxFunc;

/**
 * Db对象单元测试
 * @author Jetfire
 *
 */
public class DbTest {
	
	@Test
	@Ignore
	public void txTest() throws SQLException {
		List<Entity> find = Db.use().find(Entity.create("user").set("age", 18));
		Console.log(find);
		
		Db.use().tx(new TxFunc() {
			
			@Override
			public void call(Db db) throws SQLException {
				db.insert(Entity.create("user").set("name", "unitTestUser"));
				db.update(Entity.create().set("age", 79), Entity.create("user").set("name", "unitTestUser"));
			}
		});
	}
}
