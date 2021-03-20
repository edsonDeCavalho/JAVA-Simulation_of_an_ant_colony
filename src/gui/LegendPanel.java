package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class contains the legend of the different elements of the simulation
 * 
 * @author Paul Gasquet
 *
 */
public class LegendPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel smallFoodLabel = new JLabel("Small food:");
	private JLabel bigFoodLabel = new JLabel("Big food:");
	private JLabel greenRockLabel = new JLabel("Green rock:");
	private JLabel blackRockLabel = new JLabel("Black rock:");
	private JLabel antLabel = new JLabel("Ant:");
	private JLabel predatorLabel = new JLabel("Predator:");
	private JLabel nestLabel = new JLabel("Nest:");
	private JLabel pheromoneLabel= new JLabel("Pheromone:");
	
	public LegendPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(smallFoodLabel);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(bigFoodLabel);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(greenRockLabel);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(blackRockLabel );
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(antLabel);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(predatorLabel);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(nestLabel);
		this.add(Box.createRigidArea(new Dimension(0,20)));
		this.add(pheromoneLabel);
	} 
	
	protected void paintComponent (Graphics g) {
	
		super.paintComponent(g);
		Image smallFoodImg;
		Image bigFoodImg;
		Image greenRockImg;
		Image blackRockImg;
		Image antImg;
		Image predatorImg;
		Image nestImg;
		Image pheroImg;
		
		try {
			smallFoodImg = ImageIO.read(new File("src\\Images\\apple.png"));
			bigFoodImg = ImageIO.read(new File("src\\Images\\donut.png"));
			greenRockImg = ImageIO.read(new File("src\\Images\\greenRock.png"));
			blackRockImg = ImageIO.read(new File("src\\Images\\blackRock.png"));
			antImg = ImageIO.read(new File("src\\Images\\ant\\top.png"));
			predatorImg = ImageIO.read(new File("src\\Images\\spider.png"));
			nestImg = ImageIO.read(new File("src\\Images\\nest.png"));
			pheroImg = ImageIO.read(new File("src\\Images\\phero.jpg"));
			
     	    g.drawImage(smallFoodImg,70, 0, 20, 20, this);
			g.drawImage(bigFoodImg,70, 33, 20, 20, this);
			g.drawImage(greenRockImg,70, 66, 20, 20, this);
			g.drawImage(blackRockImg,70, 99, 20, 20, this);
			g.drawImage(antImg,70, 139, 20, 20, this);
			g.drawImage(predatorImg,70, 178, 20, 20, this);
			g.drawImage(nestImg,70, 212, 20, 20, this);
			g.drawImage(pheroImg,70, 250, 20, 20, this);
			
     	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
