import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//parent class of testing zoho CRM
public class ZohoTest {
    public ZohoTest()
    {
    	this.wd=new FirefoxDriver();
    	
    }
    //generic login method
	public void login()
	{
		try{
			wd.manage().window().setPosition(new Point(0,0));
	   		wd.manage().window().setSize(new Dimension(1024,768));
			WebDriverWait wait=new WebDriverWait(wd,10);
	        wd.get("https://www.zoho.com/crm/lp/login.html");
	 		Thread.sleep(3000);
	 		wd.switchTo().frame(wd.findElement(By.name("zohoiam")));
	 		WebElement login=wd.findElement(By.id("lid"));
	 		login.sendKeys("one111eric@hotmail.com");
	 		WebElement password=wd.findElement(By.id("pwd"));
	 		password.sendKeys("miaotest123");
	 		WebElement submit=wd.findElement(By.id("submit_but"));
	 		submit.click();
	 		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab_Leads")));
	 		System.out.println("Login Passed");
	 		passes++;
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Login Failed");
	    		fails++;
	    	}
	}
	//generic goto lead page method
	public void goto_leadpage()
    {
    	try{
    		wd.findElement(By.id("tab_Leads")).click();
    		Thread.sleep(1000);
    		passes++;
    	}
    	catch(Exception e)
    	{
    		System.out.println("LeadPage Failed");
    		fails++;
    	}
    }
	protected WebDriver wd;
	protected int passes=0;
    protected int fails=0;        
	public int getpasses(){
		return passes;
	}
	public int getfails()
	{
		return fails;
	}
}
