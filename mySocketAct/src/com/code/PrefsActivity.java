package com.summer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen;
import android.view.KeyEvent;
import android.widget.Toast;

public class PrefsActivity extends PreferenceActivity implements OnSharedPreferenceChangeListener{
	 @Override
	  	public void onCreate(Bundle savedInstanceState) {
		  super.onCreate(savedInstanceState);
		  getPreferenceManager().setSharedPreferencesName("settings");
		  
		  addPreferencesFromResource(R.xml.preference);
		  
		  getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);

	 }

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		// TODO Auto-generated method stub
		SharedPreferences preferences = getSharedPreferences(
				"settings", MODE_PRIVATE);
		Settings.SERVERIP = preferences.getString(Settings.PREFS_IPKEY, "127.0.0.1");
		try {
			if(!Settings.testIPValid()) Toast.makeText(this, "Invalid IP!", Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Settings.singleTap = preferences.getBoolean(Settings.PREFS_TAPTOCLICK, false);
		Settings.doubleTap = preferences.getBoolean(Settings.PREFS_MULTITOUCH_RIGHTCLICK,false);
		Settings.fling = preferences.getBoolean(Settings.PREFS_FLING, false);
		Settings.scroll = preferences.getBoolean(Settings.PREFS_SCROLL, false);
		Settings.keyboard = preferences.getBoolean(Settings.PREFS_KEYBOARD, false);
		Settings.shake = preferences.getBoolean(Settings.PREFS_SHAKE, false);
		Settings.moveflexibility = Integer.parseInt(preferences.getString(Settings.PREFS_MOVE_FLEXIBILITY, "1"));
		Settings.flingflexibility = Integer.parseInt(preferences.getString(Settings.PREFS_FLING_FLEXIBILITY, "10"));
		Settings.scrollflexibility =Integer.parseInt(preferences.getString(Settings.PREFS_SCROLL_FLEXIBILITY, "1"));
		Settings.shakeflexibility =Integer.parseInt(preferences.getString(Settings.PREFS_SHAKE_FLEXIBILITY, "800"));
	}
	
	@Override
	public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
			Preference preference) {
		// TODO Auto-generated method stub
		String key = preference.getKey();  
        if( key != null ){  
        	if(key.equals("close")){
            	this.finish();
            	startActivity(new Intent(PrefsActivity.this, mySocketAct.class));
            }
        } 
		return super.onPreferenceTreeClick(preferenceScreen, preference);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) { //按下的如果是BACK，同时没有重复
			this.finish();
			startActivity(new Intent(PrefsActivity.this, mySocketAct.class));
		    return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	
}
