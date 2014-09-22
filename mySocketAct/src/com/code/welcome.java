package com.summer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

public class welcome extends Activity{
	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.welcome);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		if(event.getAction()==MotionEvent.ACTION_UP){
			Intent intent = new Intent();  
	         intent.setClass(this, mySocketAct.class);  
	         this.startActivity(intent);  
	         this.finish();
			
		}
			
		return super.onTouchEvent(event);
		
	}
	
	
}
