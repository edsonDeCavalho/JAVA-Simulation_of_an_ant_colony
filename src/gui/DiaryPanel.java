package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Arthur Mimouni
 */
public class DiaryPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Image liveAntImg;
	Image deadAntImg;
	Graphics g;
	
	public DiaryPanel(){
		try {
			liveAntImg = ImageIO.read(new File("src\\Images\\liveAntImg.png"));
			deadAntImg = ImageIO.read(new File("src\\Images\\deadAntImg.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void paintComponent (Graphics g) {
		this.setBackground(Color.orange);
		super.paintComponent(g);
		g.drawImage(liveAntImg,850, 30, 200, 200, this);
		g.drawImage(deadAntImg,850, 400, 200, 200, this);	
	}
}
