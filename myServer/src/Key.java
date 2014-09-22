import java.awt.*;  
import java.awt.event.*;  
import java.awt.MouseInfo;    
public class Key {
	public void Press(int keycode){
		
		try {  
				
			Robot robot = new Robot(); 

		robot.keyPress( keycode);
	 
	        
		
			
		
		 
		} catch (AWTException e) {  
			e.printStackTrace();  
		}  
	}
	public void Release(int keycode){
		
		try {  
				
			Robot robot = new Robot(); 

	
	 
       robot.keyRelease(keycode);
	        
		
			
		
		 
		} catch (AWTException e) {  
			e.printStackTrace();  
		}  
	}

}