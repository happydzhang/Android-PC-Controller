import java.awt.*;



import java.io.*;
import java.net.*;
import java.util.jar.*;




public class AppFrame extends Frame {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	//
	public static JarFile jar;
	public static String basePath = "";
	public static InetAddress localAddr;
	
	//
	private String[] textLines = new String[6];
	//
	private Image imLogo;
	private Image imHelp;
	private Font fontTitle;
	private Font fontText;
	//

	//
	private int height = 510;
	private int width = 540;
	
	//
	private String appName = "RemoteTouchDroid Server"; 
	//
	private Toolkit toolkit;
	private MediaTracker tracker;
	
	public AppFrame() {
		super();
		GlobalData.oFrame = this;
		this.setSize(this.width, this.height);
		//
		this.toolkit = Toolkit.getDefaultToolkit();
		this.tracker = new MediaTracker(this);
		
		String sHost = "";
		try {
			localAddr = InetAddress.getLocalHost();
			if (localAddr.isLoopbackAddress()) {
				localAddr = LinuxInetAddress.getLocalHost();
			}
			sHost = localAddr.getHostAddress();
		} catch (UnknownHostException ex) {
			sHost = "Error finding local IP.";
		}
		//
		this.textLines[0] = "The RemoteTouchDroid server application is now running.";
		this.textLines[1] = "";
		this.textLines[2] = "Your IP address is: "+sHost;
		this.textLines[3] = "";
		this.textLines[4] = "Enter this IP address on the preference of the";
		this.textLines[5] = "RemoteTouchDroid application on your phone to begin.";
		//
		try {
			URL fileURL = this.getClass().getProtectionDomain().getCodeSource().getLocation();
			String sBase = fileURL.toString();
			if ("jar".equals(sBase.substring(sBase.length()-3, sBase.length()))) {
				jar = new JarFile(new File(fileURL.toURI()));
				
			} else {
				basePath = System.getProperty("user.dir") + "\\res\\";
			}
		} catch (Exception ex) {
			this.textLines[1] = "exception: "+ex.toString();
			
		}
		
	}
	
	public Image getImage(String sImage) {
		Image imReturn = null;
		try {
			if (jar == null) {
				imReturn = this.toolkit.createImage(this.getClass().getClassLoader().getResource(sImage));
			} else {
				//
				BufferedInputStream bis = new BufferedInputStream(jar.getInputStream(jar.getEntry(sImage)));
				ByteArrayOutputStream buffer=new ByteArrayOutputStream(4096);
				int b;
				while((b=bis.read())!=-1) {
					buffer.write(b);
				}
				byte[] imageBuffer=buffer.toByteArray();
				imReturn = this.toolkit.createImage(imageBuffer);
				bis.close();
				buffer.close();
			}
		} catch (IOException ex) {
			
		}
		return imReturn;
	}
	
	public void init() {
		//
		try {
			this.imHelp = this.getImage("helpphoto.jpg");
			tracker.addImage(this.imHelp, 1);
			tracker.waitForID(0);
		} catch (InterruptedException inex) {
			
		}
		//
		try {
			this.imLogo = this.getImage("images1.jpg");
			tracker.addImage(this.imLogo, 0);
			tracker.waitForID(1);
		} catch (InterruptedException ie) {
		}
		//
		this.fontTitle = new Font("Verdana", Font.BOLD, 16);
		this.fontText = new Font("Verdana", Font.PLAIN, 11);
		this.setBackground(Color.WHITE);
		this.setForeground(Color.BLACK);
		//
		
	}
	
	public void paint(Graphics g) {
		g.setColor(this.getBackground());
		g.fillRect(0, 0, this.width, this.height);
		g.setColor(this.getForeground());
		//
		g.drawImage(this.imLogo, 300, 0, this);
		g.setFont(this.fontTitle);
		g.drawString(this.appName, 70, 55);
		//
		g.setFont(this.fontText);
		int startY = 90;
		int l = 6;
		for (int i = 0;i<l;++i) {
			g.drawString(this.textLines[i], 10, startY);
			startY += 13;
		}
		//
		g.drawImage(this.imHelp, 0, startY+10, this);
	}
	/*
	*/
}