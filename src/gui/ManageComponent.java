package gui;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import data.Element;
import process.Ant;
import data.Cell;
import process.Map;
import data.MapCharacteristics;
import process.Predator;

public class ManageComponent extends JPanel{
	/**
	 *This class manages the display of components on the map. It sorts the elements according to their type as well as the different pheromone levels of the cells of the grid.
	 *She uses the class {@link TriColoredStrategy} to display the elements on the map
	 * 
	 * @author Arthur Mimouni
	 */
	private static final long serialVersionUID = 1L;


	protected static void moveComponent(Graphics g, Map map,ArrayList<Ant> ants) throws InterruptedException  {
	
	
		MapCharacteristics mapCharacteristics=map.getMapCharacteristics();
		ArrayList<Element>obstacles =map.getObstacles();
		ArrayList<Element>foods=map.getFoods();
		ArrayList<Predator>predators=map.getPredators();
		Cell[][]grid= map.getGrid();

		TriColoredStrategy.setColor( g,mapCharacteristics,mapCharacteristics.getxNid(),mapCharacteristics.getyNid(), "NID");
		
		for(int i=0;i<obstacles.size();i++) {
			if(obstacles.get(i).getType()==3) {
				TriColoredStrategy.setColor(g, mapCharacteristics,obstacles.get(i).getPosition().getX(), obstacles.get(i).getPosition().getY(), "BLACKROCK");
			}
			else {
				TriColoredStrategy.setColor(g,mapCharacteristics,obstacles.get(i).getPosition().getX(), obstacles.get(i).getPosition().getY(), "GREENROCK");
			}
		}
	
		for(int i=0;i<foods.size();i++) {
			if(foods.get(i).getType()==5) {
				TriColoredStrategy.setColor(g,mapCharacteristics,foods.get(i).getPosition().getX(), foods.get(i).getPosition().getY(), "APPLE");
			}
			else {
				TriColoredStrategy.setColor(g,mapCharacteristics,foods.get(i).getPosition().getX(), foods.get(i).getPosition().getY(), "DONUT");
			}
		}
		
		for(int i=0; i<map.getXmax(); i++) {
			for(int j=0; j<map.getYmax(); j++) {
				if (grid[i][j].getQuantitePheromones()>0) {
					int quantite = grid[i][j].getQuantitePheromones();
					
					if(quantite<=15) {
						TriColoredStrategy.setColor(g,mapCharacteristics,grid[i][j].getPosition().getX(),grid[i][j].getPosition().getY(),"PHEROMONES1");
					}
					
					else if(quantite<=20) {
						TriColoredStrategy.setColor(g,mapCharacteristics,grid[i][j].getPosition().getX(),grid[i][j].getPosition().getY(),"PHEROMONES2");
					}
					
					else if(quantite<=30) {
						TriColoredStrategy.setColor(g,mapCharacteristics,grid[i][j].getPosition().getX(),grid[i][j].getPosition().getY(),"PHEROMONES3");
					}
					
					else if(quantite<=35) {
						TriColoredStrategy.setColor(g,mapCharacteristics,grid[i][j].getPosition().getX(),grid[i][j].getPosition().getY(),"PHEROMONES4");
					}
					
					else {
						TriColoredStrategy.setColor(g,mapCharacteristics,grid[i][j].getPosition().getX(),grid[i][j].getPosition().getY(),"PHEROMONES5");
					}
					grid[i][j].setQuantitePheromones("less");
				}
			}
		}
		
		for(int i=0;i<ants.size();i++) {
			TriColoredStrategy.setColorAnt(g,mapCharacteristics,ants.get(i).getPosition().getX(),ants.get(i).getPosition().getY(),"ANT",ants.get(i).getDirection());
		}
		
		for(int i=0;i<predators.size();i++) {
			TriColoredStrategy.setColor(g,mapCharacteristics,predators.get(i).getPosition().getX(),predators.get(i).getPosition().getY(),"SPIDER");
		}
	}
}
						
		
		
