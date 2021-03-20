package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 
 * @author Paul Gasquet
 *
 */
public class LaunchPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public LaunchPanel() {
		
	}
	
	protected void paintComponent (Graphics g) {
		
		super.paintComponent(g);
		
		Image bgimg;
		try {
			bgimg = ImageIO.read(new File("src/Images/BackgroundLaunch.jpg"));
     	    g.drawImage(bgimg,0, 0, this.getWidth(), this.getHeight(), this);
     	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
