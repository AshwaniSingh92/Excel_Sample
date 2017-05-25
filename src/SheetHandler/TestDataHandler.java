package SheetHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestDataHandler {
	
	
	
	public static HashMap<String, String> loadtestdata(String step,String TestStepKey) throws EncryptedDocumentException, InvalidFormatException, IOException{
	
		String data[] = TestStepKey.split("=");	
		
		String type = data[1].replace("]","").trim();
	String excelfilepath = "C:\\workspace\\ExcelReaderInTestNg\\TestData\\TestData.xlsx";		
	 FileInputStream fis = new FileInputStream(new File(excelfilepath));		 
	
	 
	 HashMap<String, HashMap<String,String>> depl = new HashMap<String,HashMap<String,String>>();
	  
	 HashMap<String,String> hal = new  HashMap<String,String> ();
	 
	 List<String>al = new ArrayList<String>();	 
	 
	 Workbook wb=WorkbookFactory.create(fis);
   		Sheet firstsheet = wb.getSheet(data[0].trim().toString());
   		Iterator<Row> ritr = firstsheet.iterator();
   		
   		while(ritr.hasNext()){
   			Row nextRow = ritr.next(); 
   			
   			   			
   			if(nextRow.getCell(0).getStringCellValue().equals(type)){  				
   			 			
   			Iterator<Cell> citr = nextRow.cellIterator();
   			while(citr.hasNext()){     				
   				
   				   				
   				Cell cell  = citr.next(); 
   				
   				if(cell.getColumnIndex()==0){
   					 continue;
   				}
   				
   				DataFormatter formatter = new DataFormatter();	    				
   				al.add(formatter.formatCellValue(cell));
   				
   				
   				
   			}	
   				
   		}
   	}
   		
   		//System.out.println(type+al);
   		
   		hal.put(step, type+":"+al);
   		//System.out.println(hal);
   		return hal;
}

}
