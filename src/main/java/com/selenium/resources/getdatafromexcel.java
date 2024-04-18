package com.selenium.resources;

import java.util.Hashtable;

public  class getdatafromexcel {
	public static Object[][] readdatafromexcel(String sheet,String test) {
		readexcel_own readdata = new readexcel_own(System.getProperty("user.dir")+"\\Hackathondata\\exceldata.xlsx");
		String sheetname = sheet;
		String testname = test;

		int startrownum = 1;

		while (!readdata.getcelldata(sheetname, 0, startrownum).equalsIgnoreCase(testname)) {
			startrownum++;
		}
		// System.out.println("the test starts from" + " " + startrownum);

		int starttestcol = startrownum + 1;
		int starttestdata = startrownum + 2;
		int row = 0;

		while (!readdata.getcelldata(sheetname, 0, (starttestdata + row)).equals("")) {
			row++;
		}
		// System.out.println("the testdata has" + "-" + row + " " + "number of rows");
		int col = 0;
		while (!readdata.getcelldata(sheetname, col, starttestcol).equals("")) {
			col++;
		}
		// System.out.println("the test has" + "-" + col + " " + "number of columns");
		Object[][] dataset = new Object[row][1];
		Hashtable<String, String> data = null;
		int datarownumber = 0;
		for (int r = starttestdata; r < (starttestdata + row); r++) {
			data = new Hashtable<String, String>();
			for (int c = 0; c < col; c++) {
				// System.out.println(readdata.getcelldata(sheetname, c, r));
				String key = readdata.getcelldata(sheetname, c, starttestcol);
				String value = readdata.getcelldata(sheetname, c, r);
				data.put(key, value);

			}
			dataset[datarownumber][0] = data;
			datarownumber++;
		}
		return dataset;

	}

}
