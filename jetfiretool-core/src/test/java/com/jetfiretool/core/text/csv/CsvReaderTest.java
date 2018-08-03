package com.jetfiretool.core.text.csv;

import java.util.List;

import com.jetfiretool.core.io.resource.ResourceUtil;
import org.junit.Test;

import com.jetfiretool.core.lang.Console;
import com.jetfiretool.core.util.CharsetUtil;

public class CsvReaderTest {
	@Test
	public void readTest() {
		CsvReader reader = new CsvReader();
		CsvData data = reader.read(ResourceUtil.getReader("test.csv", CharsetUtil.CHARSET_UTF_8));
		List<CsvRow> rows = data.getRows();
		for (CsvRow csvRow : rows) {
			Console.log(csvRow.get(2));
		}
	}
}
