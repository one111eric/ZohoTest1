import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ZohoTestMain {

	public static void main(String[] args) throws InterruptedException {
		  int passes=0;
		  int fails=0;
		  List<TestCases> cases=new ArrayList<TestCases>();
		  
		  cases=TestDataReader.readData("c:\\ZohoTestData\\TestData.xls");
         //import all un-imported leads
		  for(TestCases casex:cases)
		  {
			  if(casex.getImported()==false)
			  {
				  LeadCreation lcreate=new LeadCreation(casex.getLastName(),casex.getCompany(),casex.getEmail());
				  lcreate.RunLeadCreation();
				  passes+=lcreate.passes;
				  fails+=lcreate.fails;
				  
			  }
		  }
		  //convert the first lead on lead view page
          LeadConversion lconvert=new LeadConversion();
          lconvert.ConvertFirstLead();
          passes+=lconvert.passes;
          fails+=lconvert.fails;
          System.out.println("Test finished with "+passes +" Passed and "+fails+" Failed");
	}
	
}
