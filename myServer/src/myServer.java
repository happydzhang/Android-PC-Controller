
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPort;
import com.illposed.osc.OSCPortIn;



public class myServer {
	private OSCPortIn receiver;
	private static String cmd[][]=new String[10000][];
	private static int cmd_idx=0;
	//private static Socket client;
	int count=0;
	public void run() {
		InetAddress local;
		try {
			local = InetAddress.getLocalHost();
		
		if (local.isLoopbackAddress()) {
			this.receiver = new OSCPortIn(OSCPort.defaultSCOSCPort());
		} else {
			this.receiver = new OSCPortIn(OSCPort.defaultSCOSCPort());
		}
		OSCListener listener = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				Object[] args = message.getArguments();
				String str=(String)args[0];
				System.out.println(str);
/*				cmd[cmd_idx]=str.split(" ");
				
				if(cmd[cmd_idx][0].toString().equals("DOWN")){
				  Float x=Float.parseFloat(cmd[cmd_idx][1].toString());
				  Float y=Float.parseFloat(cmd[cmd_idx][2].toString());
					MoveMouse controlledMouse=new MoveMouse();
					controlledMouse.run(0, 0);
				}
				if(cmd[cmd_idx][0].toString().equals("MOVE")){
					Float prex=Float.parseFloat(cmd[cmd_idx-1][1].toString());
					Float prey=Float.parseFloat(cmd[cmd_idx-1][2].toString());
					Float prex2=Float.parseFloat(cmd[cmd_idx-2][1].toString());
					Float prey2=Float.parseFloat(cmd[cmd_idx-2][2].toString());
					Float x=Float.parseFloat(cmd[cmd_idx][1].toString())-prex;
					Float y=Float.parseFloat(cmd[cmd_idx][2].toString())-prey;
					Float x2=Float.parseFloat(cmd[cmd_idx][1].toString())-prex2;
					Float y2=Float.parseFloat(cmd[cmd_idx][2].toString())-prey2;
					MoveMouse controlledMouse=new MoveMouse();
					controlledMouse.run(x, y);
					if (cmd[cmd_idx-1][0].toString().equals("MOVE")&&cmd[cmd_idx-2][0].toString().equals("DOWN")&&Math.abs(x)<=0.01&&Math.abs(y)<=0.01 &&Math.abs(x2)<=0.01&&Math.abs(y2)<=0.01 )
						{ClickMouse drag=new ClickMouse();
					    drag.run('T',0);}
					count++;
				}
				if(cmd[cmd_idx][0].toString().equals("UP")){
					Float prex=Float.parseFloat(cmd[cmd_idx-1][1].toString());
					Float prey=Float.parseFloat(cmd[cmd_idx-1][2].toString());
					Float prex2=Float.parseFloat(cmd[cmd_idx-2][1].toString());
					Float prey2=Float.parseFloat(cmd[cmd_idx-2][2].toString());
					Float x=Float.parseFloat(cmd[cmd_idx][1].toString())-prex;
					Float y=Float.parseFloat(cmd[cmd_idx][2].toString())-prey;
					Float x2=Float.parseFloat(cmd[cmd_idx][1].toString())-prex2;
					Float y2=Float.parseFloat(cmd[cmd_idx][2].toString())-prey2;
					MoveMouse controlledMouse=new MoveMouse();
					controlledMouse.run(x, y);
					//System.out.println(count);
					if (count<=1&&Math.abs(x2)<=0.02&&Math.abs(y2)<=0.02)
					{
						ClickMouse leftclick=new ClickMouse();
						if(cmd_idx >=5 && cmd[cmd_idx-5][0].toString().equals("DOWN")||cmd_idx >=5 && cmd[cmd_idx-4][0].toString().equals("DOWN"))
						leftclick.run('D',0);
						else
						leftclick.run('L',0);
							
				
				}
					count=0;
				}
		       
				cmd_idx++;*/
				//向服务器发送消息
				//PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())),true);
				//out.println("Server Message："+str);
				
			}
		};
		this.receiver.addListener("/touch", listener);
		this.receiver.startListening();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			ServerSocket serverSocket=new ServerSocket(54321);
			while(true)
			{   //float prex=0;
				//float prey=0;
				//System.out.println("接收用户连接：");
				//接受客户端请求
				Socket client=serverSocket.accept();
				//System.out.println("accept:");
			
				
				try
				{
					//接受客户端信息	
					
					//  prex=Float.parseFloat(cmd[cmd_idx][1].toString());
					  //prey=Float.parseFloat(cmd[cmd_idx][2].toString());
					BufferedReader in=new BufferedReader(new InputStreamReader(client.getInputStream()));
					String str=in.readLine();
					//System.out.println("read:"+str);
			        
					cmd[cmd_idx]=str.split(" ");
					
					if(cmd[cmd_idx][0].toString().equals("DOWN")){
					  Float x=Float.parseFloat(cmd[cmd_idx][1].toString());
					  Float y=Float.parseFloat(cmd[cmd_idx][2].toString());
						MoveMouse controlledMouse=new MoveMouse();
						controlledMouse.run(0, 0);
					}
					if(cmd[cmd_idx][0].toString().equals("MOVE")){
						Float prex=Float.parseFloat(cmd[cmd_idx-1][1].toString());
						Float prey=Float.parseFloat(cmd[cmd_idx-1][2].toString());
						Float prex2=Float.parseFloat(cmd[cmd_idx-2][1].toString());
						Float prey2=Float.parseFloat(cmd[cmd_idx-2][2].toString());
						Float x=Float.parseFloat(cmd[cmd_idx][1].toString())-prex;
						Float y=Float.parseFloat(cmd[cmd_idx][2].toString())-prey;
						Float x2=Float.parseFloat(cmd[cmd_idx][1].toString())-prex2;
						Float y2=Float.parseFloat(cmd[cmd_idx][2].toString())-prey2;
						MoveMouse controlledMouse=new MoveMouse();
						controlledMouse.run(x, y);
						if (cmd[cmd_idx-1][0].toString().equals("MOVE")&&cmd[cmd_idx-2][0].toString().equals("DOWN")&&Math.abs(x)<=0.01&&Math.abs(y)<=0.01 &&Math.abs(x2)<=0.01&&Math.abs(y2)<=0.01 )
							{ClickMouse drag=new ClickMouse();
						    drag.run('T',0);}
						count++;
					}
					if(cmd[cmd_idx][0].toString().equals("UP")){
						Float prex=Float.parseFloat(cmd[cmd_idx-1][1].toString());
						Float prey=Float.parseFloat(cmd[cmd_idx-1][2].toString());
						Float prex2=Float.parseFloat(cmd[cmd_idx-2][1].toString());
						Float prey2=Float.parseFloat(cmd[cmd_idx-2][2].toString());
						Float x=Float.parseFloat(cmd[cmd_idx][1].toString())-prex;
						Float y=Float.parseFloat(cmd[cmd_idx][2].toString())-prey;
						Float x2=Float.parseFloat(cmd[cmd_idx][1].toString())-prex2;
						Float y2=Float.parseFloat(cmd[cmd_idx][2].toString())-prey2;
						MoveMouse controlledMouse=new MoveMouse();
						controlledMouse.run(x, y);
						//System.out.println(count);
						if (count<=1&&Math.abs(x2)<=0.02&&Math.abs(y2)<=0.02)
						{
							ClickMouse leftclick=new ClickMouse();
							if(cmd_idx >=5 && cmd[cmd_idx-5][0].toString().equals("DOWN")||cmd_idx >=5 && cmd[cmd_idx-4][0].toString().equals("DOWN"))
							leftclick.run('D',0);
							else
							leftclick.run('L',0);
								
					
					}
						count=0;
					}
			       
					cmd_idx++;
					//向服务器发送消息
					//PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())),true);
					//out.println("Server Message："+str);
					
					in.close();
					//out.close();
					
				}catch(Exception ex)
				{
					//System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
				
				
				finally
				{
					client.close();
					//System.out.println("close");
				}
				
			}
		} catch (IOException e) {
			//System.out.println(e.getMessage());
		}
		*/

 }

 

}
