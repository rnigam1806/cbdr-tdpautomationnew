# cbdr-tdpautomationnew
This is a repository for the new framework based on Selenium TestNg Java for TDP Homepage Automation
This is a Selenium Hybrid Framework.

Written in JAVA
Implemented using TestNG
Build Toold - Maven
Implemented Page Object Model Design Pattern
Excel TestNG @DataProvider
Video Recording - Monte Repack
WebDriver Manager - Auto Download of required drivers.
AShot - Captures Entire Webpage Screenshot
Browsers Supported
Mozilla Firefox
Google Chrome
Internet Explorer
Opera
Microsoft Edge
Headerless Support
HTMLUnit
Chrome Headless
Phantom JS
Platform Support
Windows
Linux
Macintosh
Reporting
Allure Reporting
Usage
$ git clone https://github.com/GladsonAntony/WebAutomation_AllureWDM.git
$ mvn clean test
Browser Setup
Navigate to WebAutomation\src\main\resources change BrowserType in the ApplicationConfig.properties or use Maven to invoke different browsers
$ mvn clean test -DBrowserType=Chrome			#Chrome
$ mvn clean test -DBrowserType=Chrome_Headless		#Chrome Headless
$ mvn clean test -DBrowserType=Firefox			#Mozilla Firefox
$ mvn clean test -DBrowserType=IE			#Internet Explorer
$ mvn clean test -DBrowserType=Opera			#Opera Blink
$ mvn clean test -DBrowserType=Edge			#Microsoft Edge
$ mvn clean test -DBrowserType=Unit			#HTML Unit Headerless Browser
Report Generation
$ mvn site
Navigate to /target/site/allure-maven-plugin.html

Supported Only on Mozilla Firefox
To Open Results in other Browsers do

$ mvn jetty:run -Djetty.http.port=9988
@DataProviders
Method 1:

Use TestData.xlsx file as your dataproviders. The Sheet Name should be the name of your Method Name.
To use different xlsx file, Create a new @DataProvider method and change the workbook name.
@DataProvider(name="multiSheetExcelRead", parallel=true)
public static Object[][] multiSheetExcelRead(Method method) throws Exception
{
	File file = new File("./src/test/resources/Excel Files/TestData.xlsx");
	String SheetName = method.getName();
	System.out.println(SheetName);
	Object testObjArray[][] = ExcelUtils.getTableArray(file.getAbsolutePath(), SheetName);
	return testObjArray;
}
Method 2:

Create Excel Workbook with the same name as your method Name.
@DataProvider(name="excelSheetNameAsMethodName",parallel=true)
public static Object[][] excelSheetNameAsMethodName(Method method) throws Exception
{
	File file = new File("./src/test/resources/Excel Files/"+method.getName()+".xlsx");
	Object testObjArray[][] = ExcelUtils.getTableArray(file.getAbsolutePath());
	return testObjArray;
}
@DataProvider Usuage
To Use Method Name as Excel Workbook Name, Use the following:

@Test(dataProvider="excelSheetNameAsMethodName", dataProviderClass=ExcelDataProvider.class)
To use a Single Workbook with multiple @DataProvidersheets, Use:

NOTE:SheetName should be same name as Method Name

@Test(dataProvider="multiSheetExcelRead", dataProviderClass=ExcelDataProvider.class)
