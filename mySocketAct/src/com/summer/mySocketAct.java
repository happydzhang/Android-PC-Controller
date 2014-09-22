package com.summer;
import java.io.*;

import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Vector;

import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPort;
import com.illposed.osc.OSCPortOut;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.WindowManager;
import android.view.GestureDetector.OnGestureListener;
import android.view.SurfaceHolder.Callback;
import android.view.View.OnTouchListener;
import android.widget.*;
import android.*;
//客户端的实现

public class mySocketAct extends Activity implements Callback,
Runnable, OnGestureListener, OnTouchListener{
 private TextView text1;
 private TextView text2;
 private Button but1;
 private EditText edit2;
 private Vector<String> str;
 private final String DEBUG_TAG="mySocketAct";
 private static String touchAction=null;
 private OSCPortOut sender;
 private GestureDetector gd;	
 	public mySocketAct(Context context){
 		super();
 		str=new Vector<String>();
 		gd=new GestureDetector(this);
 		gd.setIsLongpressEnabled(true);
 		
 		
 	}
            
 	  
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		//获得触摸的坐标
		try{
		int ANDROID_WIDTH;
		int ANDROID_HEIGHT;
		WindowManager windowManager = getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		ANDROID_WIDTH = display.getWidth();
		ANDROID_HEIGHT = display.getHeight();
		float x = event.getX()/ANDROID_WIDTH;
		float y = event.getY()/ANDROID_HEIGHT; 
        edit2=(EditText)findViewById(R.id.ip_address);
		switch (event.getAction()) 
		{
		//触摸屏幕时刻
		case MotionEvent.ACTION_DOWN:
		
			touchAction="DOWN" + " "+x + " "+ y;
			
			Log.d("test",touchAction );
			break;
		//触摸并移动时刻
		case MotionEvent.ACTION_MOVE:
		
			touchAction="MOVE" + " "+x + " "+ y;
			Log.d("test",touchAction );
			break;
		//终止触摸时刻
		case MotionEvent.ACTION_UP:
			
			touchAction="UP" + " "+x + " "+ y;
			Log.d("test",touchAction );
			break;
		}
		}catch(Exception e){
			
		}
		//Socket socket=null;
		String mesg=touchAction;
		try {
			sender=new OSCPortOut(InetAddress.getByName(edit2.getText().toString()),OSCPort.defaultSCOSCPort());
		    Object[] args=new Object[1];
		    args[0]=mesg;
		    Log.d("abs",mesg);
			OSCMessage msg=new OSCMessage("/touch",args);
			sender.send(msg);
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
		return super.onTouchEvent(event);
		
	}


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean onDown(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub
		str.add("longpress");
		text1.setText(str.toString());
		Log.d("long","longpress");
	}


	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		str.add("tap");
		text1.setText(str.toString());
		return true;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		
	}

}
