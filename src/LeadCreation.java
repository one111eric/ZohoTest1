import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LeadCreation extends ZohoTest{
    //constructor
	
	public LeadCreation(String ln,String company,String email)
	{
		
		this.LastName=ln;
		this.Company=company;
		this.Email=email;
	}
	     
	//Test Script Method
	public void RunLeadCreation() throws InterruptedException
	{
		System.out.println("Testing Lead Creation...");
		login();
		goto_leadpage_create();
		save_newlead();
		wd.close();
    }
	    
	
	private void goto_leadpage_create()
	    {
	    	try{
	    		wd.findElement(By.id("tab_Leads")).click();
	    		Thread.sleep(1000);
	    		wd.findElement(By.cssSelector(".btn.createNewBtn")).click();
	    		Thread.sleep(1000);
	    		System.out.println("LeadPage Passed");
	    		passes++;
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("LeadPage Failed");
	    		fails++;
	    	}
	    }
	    //save a new lead and check result
	    private void save_newlead()
	    {
	    	try{
	    		WebElement company=wd.findElement(By.id("property(Company)"));
	    		company.sendKeys(Company);
	    		WebElement lastname=wd.findElement(By.id("property(Last Name)"));
	    		lastname.sendKeys(LastName);
	    		WebElement email=wd.findElement(By.id("property(Email)"));
	    		email.sendKeys(Email);
	    		WebElement savebtn=wd.findElement(By.xpath(".//*[@id='rwb']/form/table[2]/tbody/tr/td/input[1]"));
	    		savebtn.click();
	    		Thread.sleep(2000);
	    		WebElement resultlastname=wd.findElement(By.id("headervalue_Last Name"));
	    		WebElement resultcompany=wd.findElement(By.id("headervalue_Company"));
	    		WebElement resultemail=wd.findElement(By.id("subvalue1_Email"));
	    		//Check if saved lead info match the info we provide		
	    		if(resultlastname.getText().equals(LastName)&&resultcompany.getText().equals(Company)&&resultemail.getText().equals(Email))
	    		{
	    			System.out.println("Save Lead Passed");
	    		}
	    		passes++;
	    	}
	    	catch(Exception e)
	    	{
	    		System.out.println("Save Lead Failed");
	    		fails++;
	    	}
	    }
        
        private String LastName;
        private String Company;
        private String Email;
        
	

}
