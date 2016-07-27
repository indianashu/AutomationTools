/*
   @author ashutosh
   Jun 17, 2014
 */

package com.ilabs.afv.excelUtility;

import java.util.Hashtable;

public class TestUtil {

	public static boolean isTestCaseExecutable(String testcase, Excel runmode) {

		for (int rnum = 2; rnum <= runmode.getRowCount("Test Cases"); rnum++) {

			if (testcase.equals(runmode.getCellData("Test Cases",
					"Test Case ID", rnum))) {

				if (runmode.getCellData("Test Cases", "Run mode", rnum).equals(
						"Y")) {

					return true;
				} else {
					return false;
				}
			}
		}

		return false;

	}

	public static String getData(String testcasename, String testDataType,
			Excel data) {
		int testCaseStartRowNum = 0;
		int colstartrownum = 0;
		int rowNumOfData = 0;
		String value;

		for (int rnum = 1; rnum <= data.getRowCount("Test Data"); rnum++) {

			if (testcasename.equals(data.getCellData("Test Data", 0, rnum))) {
				testCaseStartRowNum = rnum;
				break;
			}

		}
		colstartrownum = testCaseStartRowNum + 1;
		rowNumOfData = testCaseStartRowNum + 2;

		value = data.getCellData("Test Data", testDataType, rowNumOfData,
				colstartrownum);

		return value;
	}

	
	
	public static Object[][] getdata(String testcasename,Excel c){
		//find the test in excel
		//find the no of columns in test
		//find the no of rows in test
		//put the data in hashtable and put the hastable in object array
		//return the object array
		//rows always start from one and columns start from 0..for zeroeth row blank value is returned in Xls_Reader.java
		//hence row no for loop will be less than or equal to
		//where as column no for loop will be less than(equal to not present) since it starts at zero
		
		int testCaseStartRowNum=0;
		int cols=0;
		int colstartrownum=0;
		int rowstartnum=0;
		int rows=0;
		//System.out.println("no of rows are-------------"+c.getRowCount("Test Data"));
		for(int rnum=1;rnum<=c.getRowCount("Test Data");rnum++){
			
			if(testcasename.equals(c.getCellData("Test Data", 0, rnum))){
				testCaseStartRowNum=rnum;
				//System.out.println("------------"+testCaseStartRowNum);
				break;
				
			}
			
		
		}
		colstartrownum=testCaseStartRowNum+1;
		while(!c.getCellData("Test Data", cols, colstartrownum).equals("")){
			cols++;
		}
		//System.out.println("no of columns are --"+cols);
		
		rowstartnum=testCaseStartRowNum+2;
		while(!c.getCellData("Test Data", 0, (rowstartnum+rows)).equals("")){
			rows++;
		}
		
		//System.out.println("no of rows are"+rows);
		
		Object data[][]=new Object[rows][1];
		Hashtable<String, String> table=null;
		
		
		for(int i=rowstartnum;i<(rowstartnum+rows);i++){
			//here row no is less than cos(equal to not present) last row is empty after each test's data
			//System.out.println("no of rows inside for row loop"+rows);
			table=new Hashtable<String,String>();
			for(int j=0;j<cols;j++){
				//System.out.println("no of cols inside for col loop"+cols);
				table.put(c.getCellData("Test Data", j, colstartrownum), c.getCellData("Test Data", j,i));
				//System.out.println("this is the key "+c.getCellData("Test Data", j, colstartrownum));
				//System.out.println("this is the value "+c.getCellData("Test Data", j,i));
				//System.out.println(c.getCellData("Test Data", j,i));
			
				
			}
			//System.out.println("value of i is---------"+i);
			//System.out.println("value of rowstartnum is---------"+rowstartnum);
			data[i-rowstartnum][0]=table;
			
		}
		return data;
		
		
	}
}
