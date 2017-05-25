package SheetHandler;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class StepLogger {
	
	
	
	 static int count =0;
       
	public static void logitinfile(double iteration, int i2, String step, String step2, String step3, String stat) throws IOException, InvalidFormatException {

		
		   try {
			   
			   Row r; 
			   
			   
			    String excelFilePath = "C:\\Users\\Ashwani\\Desktop\\Datasheet.xlsm";
				   List<String>al = new ArrayList<String>() ;
				 
				   FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
			     Workbook workbook = WorkbookFactory.create(inputStream);
			     Sheet sheet = workbook.getSheet("logs");
			     
			   
				
				 
	            al.add(datelog());
	            al.add(step);
	            al.add(step2);
	            al.add(step3);
	            al.add(stat);
	            System.out.println(al);
	           
	            
	            
	            
	            r = sheet.createRow(0);
	            r.createCell(0).setCellValue("Time-Stamp");
	            r.createCell(1).setCellValue("Current Iteration");
	            r.createCell(2).setCellValue("Description");
	            r.createCell(3).setCellValue("Action ");
	            r.createCell(4).setCellValue("Expected ");
	            r.createCell(5).setCellValue("Result ");
	            
	                
	            	    r= sheet.createRow(i2+sheet.getLastRowNum());
	            	   r.createCell(0).setCellValue( al.get(0).replace("[", "") );
	            	   r.createCell(1).setCellValue( "Iteration-->"+iteration );
	            	   r.createCell(2).setCellValue( al.get(1).replace("[", "") );
	            	   r.createCell(3).setCellValue( al.get(2) );
	            	   r.createCell(4).setCellValue( al.get(3).replace("]", "") );
	            	   r.createCell(5).setCellValue( al.get(4) );
	 
	      // Iteration update
	            	   
	            	   sheet = workbook.getSheet("Scenarios");
	            	  r= sheet.getRow(3);
	            	  r.getCell(10).setCellValue(iteration);
	 
	            inputStream.close();
	 
	            FileOutputStream outputStream = new FileOutputStream("C:\\Users\\Ashwani\\Desktop\\Datasheet.xlsm");
	            workbook.write(outputStream);
	            workbook.close();
	            outputStream.close();
	             
	        } catch (IOException | EncryptedDocumentException
	                | InvalidFormatException ex) {
	            ex.printStackTrace();
	        }   
		   
	}
	
	
	
	public static String datelog(){
		
		
		 DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		   Calendar calobj = Calendar.getInstance();
		   return (df.format(calobj.getTime()).toString());
		
	}
		
}
	
		
		

