import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

class StepDef {
	
	static ArrayList<String> tcid ;
	static String browser;
	static double iteration;
		
 static HashMap<String, String> loader(String TS) throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		
		String excelfilepath = "./Repository/Test_Case_Sheet_Automation";		
		 FileInputStream fis = new FileInputStream(new File(excelfilepath));		 
		 HashMap<String,String> hal = new  HashMap<String,String> ();		 
		 List<String>al = new ArrayList<String>();	
		 
		 tcid = new ArrayList<String>();		 
		 Workbook wb=WorkbookFactory.create(fis);		 
		 browser = wb.getSheet("Scenarios").getRow(3).getCell(2).getStringCellValue().toLowerCase(); 
		
		 iteration = wb.getSheet("Scenarios").getRow(3).getCell(10).getNumericCellValue(); 
			
		 
		// System.out.println(cell1);
		 
	    		Sheet firstsheet = wb.getSheet(TS);
	    		Iterator<Row> ritr = firstsheet.iterator();
	    		
	    		while(ritr.hasNext()){
	    			Row nextRow = ritr.next();
	    			if(nextRow.getRowNum() == 0){
	    				continue;
	    			}
	    			
	    			Iterator<Cell> citr = nextRow.cellIterator();
	    			String id = nextRow.getCell(0).toString();
	    			tcid.add(id);
	    			
	    			while(citr.hasNext()){  
	    				
	    				Cell cell  = citr.next();
	    				if(cell.getColumnIndex()==0){
	    					continue;
	    				}
	    				
	    				DataFormatter formatter = new DataFormatter();	    				
	    				al.add(formatter.formatCellValue(cell));
	    				
	    			}	
	    			
	    			hal.put(id, al.toString());	    			
	    			al.clear();	    			
	    			
	    		}
	    		
	    		
	    		return hal;
	    		
		
		
		
	}

}
