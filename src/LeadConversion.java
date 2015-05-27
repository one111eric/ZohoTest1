import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LeadConversion extends ZohoTest{

	public void ConvertFirstLead()
	{
		System.out.println("Testing Lead Conversion...");
		login();
		goto_leadpage();
		enter_firstlead();
		convert_lead();
		wd.close();
	}
	//get into first lead on lead table
	private void enter_firstlead()
	{
		try{
		WebElement leadtable=wd.findElement(By.id("lvTred"));
		List<WebElement> leadrows=leadtable.findElements(By.tagName("tr"));
		WebElement firstrow=leadrows.get(0);
		firstrow.click();
		Thread.sleep(1000);
		System.out.println("Enter First Lead Passed");
		passes++;
		}
		catch(Exception e)
		{
			System.out.println("Enter First Lead Failed");
			fails++;
		}
	}
	//convert lead into account&contacts
	private void convert_lead()
	{
		try{
			List<WebElement> btns=wd.findElement(By.id("detailViewButtonLayerDiv")).findElements(By.tagName("input"));
			WebElement convert=btns.get(5);
			convert.click();
			Thread.sleep(1000);
			WebElement save=wd.findElement(By.id("save"));
			save.click();
			Thread.sleep(1500);
			//situation 1:neither contact nor company exist
			if(wd.findElement(By.cssSelector(".msgInfo.green")).getText().endsWith("successfully converted."))
			{
			    System.out.println("Convert Passed");
			    passes++;
			}
			//situation 2:contact doesn't exist, company does
			else if(wd.findElement(By.cssSelector(".msgInfo.green")).getText().startsWith("The Account"))
			{
				{
					wd.findElement(By.id("cna_ex")).click();
				}
				Thread.sleep(500);
				save.click();
				Thread.sleep(1500);
				if(wd.findElement(By.cssSelector(".msgInfo.green")).getText().endsWith("successfully converted."))
				{
					System.out.println("Convert Passed");
					passes++;
				}
		    }
			//situation 3:contact exist
			else if(wd.findElement(By.id("cnc_new")).isDisplayed())
			{
				wd.findElement(By.id("cnc_new")).click();
				Thread.sleep(500);
				if(wd.findElement(By.id("cna_ex")).isDisplayed())
				{
					wd.findElement(By.id("cna_ex")).click();
				}
				save.click();
				Thread.sleep(1500);
				if(wd.findElement(By.cssSelector(".msgInfo.green")).getText().endsWith("successfully converted."))
				{
					System.out.println("Convert Passed");
					passes++;
				}
				
			}
			//if fail
			else
			{
				System.out.println("Convert Failed");
				fails++;
			}
			
		}
		catch(Exception e){
			System.out.println("Convert Failed");
		    fails++;
		}
	}
	
}
