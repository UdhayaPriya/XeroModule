package XeroModule;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {

	public static WebDriver driver;
	public static int reportflag = 0;

	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub

		String dataPath = "C:/Priya/Selenium Training/Testing/TestSuite/TestSuiteXeroModule.xls";
		String[][] recData = ReusableMethods.readSheet(dataPath,"Sheet1");
		String testScript;

		for (int i=1; i<recData.length; i++)
		{
			if (recData[i][1].equalsIgnoreCase("Y"))
			{
				/*Firefox*/
				if (recData[i][3].equalsIgnoreCase("Y"))
				{
					driver = new FirefoxDriver();
				
					reportflag = 0;  // Reset
					testScript = recData[i][2];
					ReusableMethods.startReport(testScript,"C:\\Priya\\Selenium Training\\Report");
					
					//java reflection or reflexive API
					Method ts = AutomationScripts.class.getMethod(testScript);
					ts.invoke(ts);
					driver.quit();
					
					if(reportflag == 0)
					{
						ReusableMethods.writeExcel(dataPath, "Sheet1", i, 3, "Pass");
					}
					else
					{
						ReusableMethods.writeExcel(dataPath, "Sheet1", i, 3, "Fail");
					}
				}
				// Chrome..
				if(recData[i][4].equalsIgnoreCase("Y"))
				{
					System.setProperty("webdriver.chrome.driver", "C:\\Users\\UdhayaPriya\\Downloads\\chromedriver.exe");
					driver = new ChromeDriver();

					reportflag = 0;  // Reset
					testScript = recData[i][2];
					ReusableMethods.startReport(testScript, "C:\\Priya\\Selenium Training\\Report");

					//Java Reflection or Reflexive API
					Method ts = AutomationScripts.class.getMethod(testScript);
					ts.invoke(ts);
					driver.quit();
					
					if(reportflag == 0)
					{
						ReusableMethods.writeExcel(dataPath, "Sheet1", i, 4, "Pass");
					}
					else
					{
						ReusableMethods.writeExcel(dataPath, "Sheet1", i, 4, "Fail");
					}
				}
			}
			else
			{
				System.out.println("Row number :" +i+ " script is not executed..");
				System.out.println();
				ReusableMethods.writeExcel(dataPath, "Sheet1", i, 3, "NA");
			}
			ReusableMethods.bw.close();
		}
		
	}
}



