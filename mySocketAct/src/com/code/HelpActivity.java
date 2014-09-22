package com.summer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

public class HelpActivity extends Activity implements View.OnClickListener{
	private Button btnclose;
	 @Override
	  	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.help);
		  btnclose=(Button)findViewById(R.id.btnCloseHelp);
		  btnclose.setOnClickListener(this);
	 }

		
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		this.finish();
		startActivity(new Intent(HelpActivity.this, mySocketAct.class));
	}


	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) { //按下的如果是BACK，同时没有重复
			this.finish();
			startActivity(new Intent(HelpActivity.this, mySocketAct.class));
		    return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	 
	 


}
