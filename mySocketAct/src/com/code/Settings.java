package com.summer;

public class Settings {
	public static String SERVERIP;

	public static boolean singleTap;
	public static boolean doubleTap;
	public static boolean fling;
	public static boolean scroll;
	public static boolean keyboard;
	public static boolean shake;
	public static int scrollflexibility;//0.5-5
	public static int flingflexibility;//2-10
	public static int moveflexibility;//0.5-10
	public static int shakeflexibility;//800
	
	public static final String PREFS_IPKEY = "server_ip";
	public static final String PREFS_TAPTOCLICK = "apply_singletap";
	public static final String PREFS_MULTITOUCH_RIGHTCLICK = "apply_doubletap";
	public static final String PREFS_MOVE_FLEXIBILITY = "moveflexibility";
	public static final String PREFS_FLING = "apply_fling";
	public static final String PREFS_FLING_FLEXIBILITY = "flingflexibility";
	public static final String PREFS_SCROLL = "apply_scroll";
	public static final String PREFS_SCROLL_FLEXIBILITY = "scrollflexibility";
	public static final String PREFS_KEYBOARD="apply_keyboard";
	public static final String PREFS_SHAKE = "apply_shake";
	public static final String PREFS_SHAKE_FLEXIBILITY = "shakeflexibility";
	




	public static boolean testIPValid() throws Exception {
		try {
			String[] octets = SERVERIP.split("\\.");
			int num=0;
			for (String s : octets) {
				int i = Integer.parseInt(s);
				if (i > 255 || i < 0) {
					return false;
				}
				num++;
				
			}
			if(num!=4) return false;
		} catch (NumberFormatException e) {
			return false;
		}
		return true;

	}
}

