package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.JFrame;
import data.MapCharacteristics;

public class LaunchWindow extends JFrame{
	/**
	 * This class represents the first window of the simulation
	 * 
	 * @author Paul Gasquet
	 */
	private static final long serialVersionUID = 1L;
	private LaunchPanel launchPanel = new LaunchPanel();
	private Button setting= new Button ("Setting");
	private Button quickLaunch = new Button("Quik Launch");
	private MapCharacteristics mapCharacteristics=MapCharacteristics.getInstance();
	
	public LaunchWindow() {
		this.setTitle("LaunchWindow");
		this.setResizable(false);
		this.setSize(1280,829);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		setting.addActionListener(new SelectAction());
		quickLaunch.addActionListener(new QuickLaunchAction());
		launchPanel.add(setting);
		launchPanel.add(quickLaunch);
		launchPanel.setLayout(null);
		setting.setBounds(500,714, 105, 30);
		quickLaunch.setBounds(650, 714, 105, 30);
		this.getContentPane().add(launchPanel);
		

	}
	
	private class SelectAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new SettingWindow(mapCharacteristics);
			dispose();
		}
	}
	
	private class QuickLaunchAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				new MainGui(mapCharacteristics);
				setVisible(false);
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
