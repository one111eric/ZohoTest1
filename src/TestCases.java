//Test case class for easier access data
public class TestCases {
	private double CaseId;
	private String LastName;
	private String Company;
	private String Email;
	private boolean Imported;
	public TestCases(double caseid, String lastname,String company,String email,String imported)
	{
		this.CaseId=caseid;
		this.LastName=lastname;
		this.Company=company;
		this.Email=email;
		if(imported.contains("Yes"))
		{
			this.Imported=true;
			}
		else 
		{
			this.Imported=false;
		}
		
	}
	public double getCaseId()
	{
		return this.CaseId;
	}
	public String getLastName()
	{
		return this.LastName;
	}
	public String getCompany()
	{
		return this.Company;
	}
	public String getEmail()
	{
		return this.Email;
	}
	public boolean getImported()
	{
		return this.Imported;
	}
}
