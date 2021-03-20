package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import process.Ant;
import process.Map;
import data.MapCharacteristics;

/**
 *This class is the Jpanel of the simulation map.
 * It displays the grid and colors it green, then calls the {@linkManageComponent} class to display the componants
 * 
 * 0author Arthur Mimouni
 */

public class DashBoard extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Map map;
	private ArrayList<Ant> ants;
	private MapCharacteristics mapCharacteristics;

	public DashBoard(Map map) {
		this.map=map;
		ants=map.getAnts();
		setBackground(Color.decode("#006400"));
		this.mapCharacteristics=map.getMapCharacteristics();	
	}
	
	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		
		g.setColor(new Color(0,0,0,0));
		for(int i =0;i<map.getXmax();i++) {
			for(int j=0; j<map.getYmax();j++) {
				g.drawRect(i*mapCharacteristics.getScale(),j*mapCharacteristics.getScale(), mapCharacteristics.getWidthSquare(), mapCharacteristics.getHeightSquare());
				g.setColor(Color.decode("#99b11d"));
				g.fillRect(i*mapCharacteristics.getScale(),j*mapCharacteristics.getScale(), mapCharacteristics.getWidthSquare(), mapCharacteristics.getHeightSquare());
			}
		}
		
		try {
			ManageComponent.moveComponent(g,map,ants);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public ArrayList<Ant> getAnts() {
		return ants;
	}

	public void setAnts(ArrayList<Ant> ants) {
		this.ants = ants;
	}

}
	


