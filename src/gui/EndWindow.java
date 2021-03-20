package gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import instrument.ChartManager;
import process.Map;

/**
 *This class is the end of simulation window and contains the global graph of the simulation
 *
 *@author Arthur Mimouni
 */

public class EndWindow extends JFrame {
	

	private static final long serialVersionUID = 1L;
	private JPanel endPanel = new JPanel();
	private ChartManager chartManager = new ChartManager();
	private ChartPanel graphBar;
	
	public EndWindow(Map map) {
		this.setTitle("EndWindow");
		this.setResizable(false);
		this.setSize(1280,829);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.getContentPane().add(endPanel);
		endPanel.setBackground(Color.orange);
		this.graphBar=new ChartPanel(chartManager.getGraphBar(map.getMapCharacteristics()));
		endPanel.add(graphBar);
	}
}
