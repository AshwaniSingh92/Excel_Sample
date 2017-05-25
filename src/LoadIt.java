import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import org.apache.poi.util.StringUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import SheetHandler.ActionKeys;
import SheetHandler.ElementsOperations;
import SheetHandler.StepLogger;
import SheetHandler.TestDataHandler;

public class LoadIt {
	
	static ArrayList<String>TSTEPS;
	static int count ;
	static String[] tdat ;
	static String[] tdat2;
	static String[]tdata3;
	static HashMap<String,ArrayList<String>> testdat = new HashMap<String,ArrayList<String>>() ;
	
		
	public static void main(String args[]) throws IOException, EncryptedDocumentException, InvalidFormatException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		StepDef.loader("TC_001");
		
		
		
		ElementsOperations ob = new ElementsOperations();
		StepLogger sl = new StepLogger();
		TSTEPS = StepDef.tcid;	
		String browser = StepDef.browser;
		double currentiteration= StepDef.iteration+1;
		int i =1;
		String stat = null;
		String status;
		//ActionKeys.openBrowser(browser);
		
		System.out.println(browser);
		System.out.println("Current Iteration"+currentiteration);
		String step[] = null ;
		
		//System.out.println(TSTEPS);
		
		//collects the row data 
	
		
		
		//TestDataHandler.loadtestdata("TC_001Data = ToCity");
		
		/*for (String st:TSTEPS) {
			
			step= StepDef.loader("TC_001").get(st).split(",");	
			
			//System.out.println(st);
			
			if(step[4].contains("Data")){
				
				String built = step[4].replace("]", "").trim();
				//System.out.println(built);
				//System.out.println("Fetching data");
			System.out.println(TestDataHandler.loadtestdata(st,step[4]));
				
				
			}else if(step[4].contains("DATAACT")){
				
				System.out.println("Action to be performed");
				
			}
			
		}
	}*/
		
		
		HashMap<String, String> td1 = null;		
		ArrayList<String> inner =new ArrayList<String>();		
		
		
		for(String st:TSTEPS){	
			
			step= StepDef.loader("TC_001").get(st).split(",");
			
			if(step[4].contains("Data")){				
				
		 td1 = TestDataHandler.loadtestdata(st,step[4]);			 
			 
			 //System.out.println(td1);
			tdat = td1.get(st).split(":");			
			inner.add(tdat[1].replace("[","").replace("]",""));
			
			System.out.println(st);
		   System.out.println(inner);
		   
		  testdat.put(st, inner);
		  
		 // System.out.println(testdat);
		  
		  inner.clear();
	
			
// I need to come up with some logic here			
			
			
			
			
	}else if(step[4].contains("DATAACT")){
		
				System.out.println("Action to be performed");
				
			}
			
		
			
			System.out.println(testdat);
			
	
		
			
			
			
			
		
		
		
/*	 try {			 
			 status =ob.perform(step[2],step[1]+step[3].toLowerCase().replace("]","").trim(),step[4].replace("]","").trim());
			if(status!=null){
				System.out.println("Current Step"+step[1]+step[3]);
				 sl.logitinfile(currentiteration,i,step[0],step[3],step[4],status);
				 status=null;
				 }
			
			 
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}	
	}
		
		ActionKeys.closeBrowser();
	*/	
		
	    		
		}
		
		

	}
	
	
	public static void recur(String step, String x2){
		
			
			System.out.println(step+"Calling with:"+x2);
			return;
			
		
		
		
		
		
		
		
		
		
	}
	
}
	


	

	

