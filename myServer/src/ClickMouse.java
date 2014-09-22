import java.awt.*;  
import java.awt.event.*;  
import java.awt.MouseInfo;    
public class ClickMouse {
	public void run(char left_or_right,int wheelAmt){
		try {  
			

	
			
			Robot robot = new Robot(); 
			switch (left_or_right)
			{
			case 'L'    :  robot.mousePress(InputEvent.BUTTON1_MASK);
			               robot.mouseRelease(InputEvent.BUTTON1_MASK);
			
			break;
			case 'R'	: robot.mousePress(InputEvent.BUTTON3_MASK);
						  robot.mouseRelease(InputEvent.BUTTON3_MASK);
			break;
						  
			case 'D'	: robot.mousePress(InputEvent.BUTTON1_MASK);
			  			  robot.mouseRelease(InputEvent.BUTTON1_MASK);
						  robot.mousePress(InputEvent.BUTTON1_MASK);
			              robot.mouseRelease(InputEvent.BUTTON1_MASK);
			  			  
			break;
			case 'W'	: robot.mouseWheel(wheelAmt);
        

			break;
			case 'T'	: robot.mousePress(InputEvent.BUTTON1_MASK);

			break;
			
			default:
				
			break;
			}
			
			
		
		 
		} catch (AWTException e) {  
			e.printStackTrace();  
		}  
	}
	 

}