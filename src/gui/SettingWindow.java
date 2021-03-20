package gui;
import java.awt.Color;
//import process.InitMap;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import data.MapCharacteristics;

/**
 * This class represents the window for adjusting the various parameters of the simulation.
 * When the parameters have been adjusted, the main window {@link MainGui} opens.
 * 
 * @author Arthur Mimouni
 *
 */
public class SettingWindow extends JFrame{
	private static final long serialVersionUID = 1L;
	private SettingPanel settingPanel = new SettingPanel ();
	
	private JLabel selectSizeLabel = new JLabel("Select the size of the map for the Simulation:");
	private JLabel selectFoodLabel=new JLabel("Select the type of food for the Simulation:");
	private JLabel selectFrequencyFoodLabel=new JLabel("Select the frequency of appearance of food");
	private JLabel selectObstacleLabel=new JLabel("Select the type of obstacle in the Simulation:");
	private JLabel selectAntLabel=new JLabel("Select the maximum of ant in the Simulation:");
	private JLabel smallFoodLabel=new JLabel("Small food:");
	private JLabel bigFoodLabel=new JLabel("Big food:");
	private JLabel frequencyLabel = new JLabel("Frequency in secondes:");
	private JLabel blackRockLabel=new JLabel("Black rock:");
	private JLabel greenRockLabel=new JLabel("Green rock:");
	private JLabel antLabel=new JLabel("Ant:");
	
	private JRadioButton smallSizeButton = new JRadioButton(" Small ",false);
	private JRadioButton mediumSizeButton= new JRadioButton(" Medium ",false);
	private JRadioButton largeSizeButton = new JRadioButton(" Large ",false);
	private ButtonGroup selectGroup = new ButtonGroup();
	
	private SpinnerNumberModel smallFoodModel ;
	private JSpinner spinnerSmallFood; 
	private SpinnerNumberModel bigFoodModel ;
	private JSpinner spinnerBigFood; 
	private SpinnerNumberModel frequencyModel ;
	private JSpinner spinnerFrequency; 
	private SpinnerNumberModel blackRockModel ;
	private JSpinner spinnerBlackRock; 
	private SpinnerNumberModel greenRockModel ;
	private JSpinner spinnerGreenRock; 
	private SpinnerNumberModel antModel ;
	private JSpinner spinnerAnt; 
	
	private Button size = new Button ("Choice");
	private Button launch = new Button("Launch");
	

	private MapCharacteristics mapCharacteristics = MapCharacteristics.getInstance();
	
	public SettingWindow(MapCharacteristics mapCharacteristics) {
		
		this.setTitle("SettingWindow");
		this.setResizable(false);
		this.setSize(1280,829);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		settingPanel.setLayout(null);
		
		selectSizeLabel.setBounds(400, 50, 460, 30);
		selectSizeLabel.setFont(new Font("Serif", Font.BOLD, 24));
		selectSizeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				
		smallSizeButton.setBounds(260, 130, 85, 23);
		mediumSizeButton.setBounds(560,130,85,23);
		largeSizeButton.setBounds(860, 130, 85, 23);
		selectGroup.add(smallSizeButton);
		selectGroup.add(mediumSizeButton);
		selectGroup.add(largeSizeButton);
		
		selectFoodLabel.setBounds(400, 200, 450, 30);
		selectFoodLabel.setFont(new Font("Serif", Font.BOLD, 24));
		selectFoodLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		smallFoodLabel.setBounds(270, 240, 100, 100);
		smallFoodLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		
		smallFoodModel= new SpinnerNumberModel(10, 0, 50, 1);
		spinnerSmallFood = new JSpinner(smallFoodModel);
		spinnerSmallFood.setBounds(380, 280, 85, 23); 
		
		bigFoodLabel.setBounds(700, 240, 100, 100);
		bigFoodLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		
		bigFoodModel= new SpinnerNumberModel(10, 0, 50, 1);
		spinnerBigFood = new JSpinner(bigFoodModel);
		spinnerBigFood.setBounds(810, 280, 85, 23);
		
		selectFrequencyFoodLabel.setBounds(400,350,450,30);
		selectFrequencyFoodLabel.setFont(new Font("Serif", Font.BOLD, 24));
		selectFrequencyFoodLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		frequencyLabel.setBounds(370,360,300,100);
		frequencyLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		
		frequencyModel= new SpinnerNumberModel(100, 100, 500, 100);
		spinnerFrequency = new JSpinner(frequencyModel);
		spinnerFrequency.setBounds(570, 400, 85, 23);
		
		selectObstacleLabel.setBounds(380, 460, 490, 30);
		selectObstacleLabel.setFont(new Font("Serif", Font.BOLD, 24));
		selectObstacleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		blackRockLabel.setBounds(270, 490, 100, 100);
		blackRockLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		
		blackRockModel= new SpinnerNumberModel(10, 0, 50, 1);
		spinnerBlackRock = new JSpinner(blackRockModel);
		spinnerBlackRock.setBounds(380, 530, 85, 23);
		
		greenRockLabel.setBounds(700, 490, 100, 100);
		greenRockLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		
		greenRockModel= new SpinnerNumberModel(10, 0, 50, 1);
		spinnerGreenRock = new JSpinner(greenRockModel);
		spinnerGreenRock.setBounds(810, 530, 85, 23);
		
		selectAntLabel.setBounds(380, 600, 490, 30);
		selectAntLabel.setFont(new Font("Serif", Font.BOLD, 24));
		selectAntLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		antLabel.setBounds(520, 630, 100, 100);
		antLabel.setFont(new Font("Serif", Font.PLAIN, 20));
		
		antModel= new SpinnerNumberModel(20, 1, 40, 1);
		spinnerAnt = new JSpinner(antModel);
		spinnerAnt.setBounds(590, 670, 85, 23);
		
		
		settingPanel.add(selectSizeLabel);
		settingPanel.add(selectFoodLabel);
		settingPanel.add(smallSizeButton);
		settingPanel.add(mediumSizeButton);
		settingPanel.add(largeSizeButton);
		settingPanel.add(spinnerSmallFood);
		settingPanel.add(smallFoodLabel);
		settingPanel.add(bigFoodLabel);
		settingPanel.add(spinnerBigFood);
		settingPanel.add(selectFrequencyFoodLabel);
		settingPanel.add(frequencyLabel);
		settingPanel.add(spinnerFrequency);
		settingPanel.add(selectObstacleLabel);
		settingPanel.add(blackRockLabel);
		settingPanel.add(spinnerBlackRock);
		settingPanel.add(greenRockLabel);
		settingPanel.add(spinnerGreenRock);
		settingPanel.add(selectAntLabel);
		settingPanel.add(antLabel);
		settingPanel.add(spinnerAnt);


		this.getContentPane().add(settingPanel);
		
		size.addActionListener(new SizeAction());
		size.setBounds(1060, 130, 85, 23);
		launch.addActionListener(new LaunchAction());
		launch.setBounds(550, 740, 100, 30);
		settingPanel.add(size);
		settingPanel.add(launch);
		
	}
	
	private class SizeAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
				if(smallSizeButton.isSelected()) {
					
					mapCharacteristics.setxNid(17);
					mapCharacteristics.setyNid(12);
					
					mapCharacteristics.setXmax(35);
					mapCharacteristics.setYmax(25);
					
					smallFoodModel.setMaximum(45);
					smallFoodModel.setValue(45);
					smallFoodModel.setStepSize(1);
					
					bigFoodModel.setMaximum(25);
					bigFoodModel.setValue(25);
					bigFoodModel.setStepSize(1);
					
					blackRockModel.setMaximum(30);
					blackRockModel.setValue(30);
					blackRockModel.setStepSize(1);
					
					greenRockModel.setMaximum(30);
					greenRockModel.setValue(30);
					greenRockModel.setStepSize(1);
					
					antModel.setMaximum(10);
					antModel.setValue(10);
					antModel.setStepSize(1);
				}
				
				else if (mediumSizeButton.isSelected()) {
					
					mapCharacteristics.setXmax(50);
					mapCharacteristics.setYmax(40);
					
					mapCharacteristics.setxNid(25);
					mapCharacteristics.setyNid(19);
					
					smallFoodModel.setMaximum(60);
					smallFoodModel.setValue(60);
					smallFoodModel.setStepSize(1);
					
					bigFoodModel.setMaximum(45);
					bigFoodModel.setValue(45);
					bigFoodModel.setStepSize(1);
					
					blackRockModel.setMaximum(50);
					blackRockModel.setValue(50);
					blackRockModel.setStepSize(1);
					
					greenRockModel.setMaximum(50);
					greenRockModel.setValue(50);
					greenRockModel.setStepSize(1);
					
					antModel.setMaximum(20);
					antModel.setValue(20);
					antModel.setStepSize(1);
				}
				
				else {
					
					mapCharacteristics.setXmax(61);
					mapCharacteristics.setYmax(48);
					
					mapCharacteristics.setxNid(30);
					mapCharacteristics.setyNid(24);
					
					smallFoodModel.setMaximum(80);
					smallFoodModel.setValue(70);
					smallFoodModel.setStepSize(1);
					
					bigFoodModel.setMaximum(60);
					bigFoodModel.setValue(60);
					bigFoodModel.setStepSize(1);
					
					blackRockModel.setMaximum(80);
					blackRockModel.setValue(60);
					blackRockModel.setStepSize(1);
					
					greenRockModel.setMaximum(80);
					greenRockModel.setValue(70);
					greenRockModel.setStepSize(1);
					
					antModel.setMaximum(30);
					antModel.setValue(30);
					antModel.setStepSize(1);
					
				}
		}
	}
			

	private class LaunchAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int value;
			try {
				value = (Integer) spinnerSmallFood.getValue();
				mapCharacteristics.setNbrMAXSmallFood(value);
				
				value = (Integer) spinnerBigFood.getValue();
				mapCharacteristics.setNbrMAXBigFood(value);
				
				value = (Integer) spinnerBigFood.getValue();
				mapCharacteristics.setNbrMAXBigFood(value);
				
				value = (Integer) spinnerFrequency.getValue();
				mapCharacteristics.setFrequencyFood(value);
				
				value = (Integer) spinnerBlackRock.getValue();
				mapCharacteristics.setNbrBlackRock(value);
				
				value = (Integer) spinnerGreenRock.getValue();
				mapCharacteristics.setNbrGreenRock(value);
				
				value = (Integer) spinnerAnt.getValue();
				mapCharacteristics.setNbrMaxAnts(value);
				
				mapCharacteristics.setNbrMAXTotalFood();
				
				new MainGui (mapCharacteristics);
			} catch (IOException | URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
			
		}
	}

}