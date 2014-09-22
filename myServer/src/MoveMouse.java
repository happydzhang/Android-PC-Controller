import java.awt.*;  
import java.awt.event.*;  
import java.awt.MouseInfo;    
public class MoveMouse {
	public void run(float x,float y){
		try {  
			
			Point mousepoint = MouseInfo.getPointerInfo().getLocation();  
			int cx = mousepoint.x;  
			int cy = mousepoint.y;
			int f=600;
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();  
			Robot robot = new Robot(); 
			//robot.mouseMove(cx,cy);
			int ScreenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;  
			int ScreenWidth  = Toolkit.getDefaultToolkit().getScreenSize().width;
			if(x!=0&&y!=0)
			//robot.mouseMove((int)(cx+f*x*Math.abs(x)*Math.abs(x)),(int)(cy+f*y*Math.abs(y)*Math.abs(y)));  
			robot.mouseMove((int)(cx+f*x),(int)(cy+f*y));  
		 
		} catch (AWTException e) {  
			e.printStackTrace();  
		}  
	}
	 

}