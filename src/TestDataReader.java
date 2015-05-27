import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
//Data reader class to read from excel test cases
public class TestDataReader {
      public static List<TestCases> readData(String FileLocation)
      {
    	  List<TestCases> cases=new ArrayList<TestCases>();
      	try {
  			FileInputStream in=new FileInputStream(new File(FileLocation));
  			HSSFWorkbook workbook=new HSSFWorkbook(in);
  			HSSFSheet sheet=workbook.getSheetAt(0);
  			Iterator<Row> rowIterator = sheet.iterator();
  			rowIterator.next();
  			while(rowIterator.hasNext()) {
                  Row row = rowIterator.next();
                               
                      double id=row.getCell(0).getNumericCellValue();
                      String lastname=row.getCell(1).getStringCellValue(); 
                      String company=row.getCell(2).getStringCellValue();
                      String email=row.getCell(3).getStringCellValue();
                      String imported=row.getCell(4).getStringCellValue();
                      TestCases casex=new TestCases(id,lastname,company,email,imported);
                      cases.add(casex);                  
               }    
  			workbook.close();
      	}			
         
      	catch (IOException e) {
  			e.printStackTrace();
  		}
      	return cases;
      }
	
}
