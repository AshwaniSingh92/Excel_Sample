package SheetHandler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

 public class ElementsOperations {
	 	 
	
	 ActionKeys act = new ActionKeys();
	 Method  method [] = act.getClass().getMethods(); 
	 
	 public List<String> setobj = new ArrayList<String>() ;
	 
	 public void browserload(String browser) {		 
		 act.openBrowser(browser);		 
	 }
	 
	 String status ;
	 //path, locAction keys
	 public  String perform(String path ,String LocAction, String keys) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException  {
		 
		 for (int i = 0; i < method.length; i++) {		
			 setobj.add(method[i].getName());		 
		}
		  
		 if(!setobj.contains(LocAction.trim())){			 
			return "Undefined Method" ;			 
		 }
		 
		 
		
		
		for(int i =0 ; i <method.length;i++){			
			
			if(LocAction.trim().equals(method[i].getName())){					
				
				status =null;
				try {
					Thread.sleep(4000l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Invoking:"+LocAction.trim()+LocAction.trim().equals(method[i].getName()));
				status= (String) method[i].invoke(act,path,LocAction,keys);
				
				break;					
				}else{
					status = null;
				}
			
			
			}
			
		return status;
		}
		
	 }
	
   	
		
		

	
	
	

