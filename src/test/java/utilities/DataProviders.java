package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws Exception{
		String path=".\\TestData\\OpenCart_LoginData.xlsx";
		ExcelUtility excelUtils = new ExcelUtility(path);
		
		int rowCount = excelUtils.getRowCount("Login");
		int columnCount = excelUtils.getCellCount("Login", 1);
		
		String[][] loginData = new String[rowCount][columnCount];
		
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j <columnCount; j++) {
				loginData[i-1][j] = excelUtils.getCellData("Login", i, j);
			}
		}
		
		return loginData;
	}
}
