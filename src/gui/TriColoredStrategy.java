package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import data.MapCharacteristics;

/**
 * Displays the components on the map according to the type of the element requested by {@link ManageComponent}
 * 
 * @author Arthur Mimouni, Paul Gasquet
 *
 */

public class TriColoredStrategy {
		
	public static void setColor(Graphics graphics,MapCharacteristics mapCharacteristics,int x, int y,String couleur) {
		if(couleur.equals("SPIDER")) {
			Image spiderImg;
			try {
			spiderImg = ImageIO.read(new File("src\\Images\\spider.png"));
			  graphics.drawImage(spiderImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
			} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		if(couleur.equals("BLACKROCK")) {
			Image bombImg;
			try {
			bombImg = ImageIO.read(new File("src\\Images\\blackRock.png"));
			  graphics.drawImage(bombImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
		
		if(couleur.equals("GREENROCK")) {	
				Image rockImg;
				try {
				rockImg = ImageIO.read(new File("src\\Images\\greenRock.png"));
				  graphics.drawImage(rockImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		if(couleur.equals("APPLE")) {
			Image foodImg;
			 
			try {
				
				foodImg = ImageIO.read(new File("src\\Images\\apple.png"));
				  graphics.drawImage(foodImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		if(couleur.equals("DONUT")) {		
			Image bigFoodImg;
			 
			try {
				
				bigFoodImg = ImageIO.read(new File("src\\Images\\donut.png"));
				graphics.drawImage(bigFoodImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		if(couleur.equals("NID")) {
			Image nidImg;
			try {
				
				nidImg = ImageIO.read(new File("src\\Images\\nest.png"));
	     	    graphics.drawImage(nidImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(couleur.equals("PHEROMONES1")) {
			graphics.setColor(Color.decode("#72fd72"));
			graphics.fillOval(x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare()-12,mapCharacteristics.getHeightSquare()-14);

		}
		
		if(couleur.equals("PHEROMONES2")) {
			graphics.setColor(Color.decode("#8efd8e"));
			graphics.fillOval(x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare()-10,mapCharacteristics.getHeightSquare()-12);	
		}
		
		if(couleur.equals("PHEROMONES3")) {
			graphics.setColor(Color.decode("#abfcab"));
			graphics.fillOval(x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare()-8,mapCharacteristics.getHeightSquare()-10);
		}
		
		if(couleur.equals("PHEROMONES4")) {
			graphics.setColor(Color.decode("#cffdcf"));
			graphics.fillOval(x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare()-6,mapCharacteristics.getHeightSquare()-8);	
		}
		
		if(couleur.equals("PHEROMONES5")) {
			graphics.setColor(Color.decode("#adffad"));
			graphics.fillOval(x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare()-4,mapCharacteristics.getHeightSquare()-8);	
		}
	}
	
	public static void setColorAnt(Graphics graphics,MapCharacteristics mapCharacteristics,int x, int y,String couleur,String direction) {
		
		
		if(couleur.equals("ANT")) {
			Image AntImg;
			
			try {
				
				if(direction.equals("TOP")) {
					AntImg = ImageIO.read(new File("src\\Images\\ant\\top.png"));
					graphics.drawImage(AntImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
				}
				
				else if(direction.equals("BOTTOM")) {
					AntImg = ImageIO.read(new File("src\\Images\\ant\\bottom.png"));
					graphics.drawImage(AntImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
				}
				
				else if(direction.equals("LEFT")) {
					AntImg = ImageIO.read(new File("src\\Images\\ant\\left.png"));
					graphics.drawImage(AntImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
				}
				
				else if(direction.equals("RIGHT")) {
					AntImg = ImageIO.read(new File("src\\Images\\ant\\right.png"));
					graphics.drawImage(AntImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
				}
				
				else if(direction.equals("LEFT-TOP")) {
					AntImg = ImageIO.read(new File("src\\Images\\ant\\topLeft.png"));
					graphics.drawImage(AntImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
				}
				
				else if(direction.equals("RIGHT-TOP")) {
					AntImg = ImageIO.read(new File("src\\Images\\ant\\topRight.png"));
					graphics.drawImage(AntImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
				}
				
				else if(direction.equals("RIGHT-BOTTOM")) {
					AntImg = ImageIO.read(new File("src\\Images\\ant\\bottomRight.png"));
					graphics.drawImage(AntImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
				}
				
				else if(direction.equals("LEFT-BOTTOM")) {
					AntImg = ImageIO.read(new File("src\\Images\\ant\\BottomLeft.png"));
					graphics.drawImage(AntImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
				}
				
				else {
					AntImg = ImageIO.read(new File("src\\Images\\ant\\top.png"));
					graphics.drawImage(AntImg,x*mapCharacteristics.getScale(),y*mapCharacteristics.getScale(),mapCharacteristics.getWidthSquare(),mapCharacteristics.getHeightSquare(),null);
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
		





	