package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import instrument.ChartManager;
import log.LoggerUtility;
import process.CyclicCounter;
import process.Chronometer;
import process.Ant;
import process.Map;
import data.MapCharacteristics;
import process.Core;
import data.NumericStat;

/**
 * This class represents the main window of the simulation. It contains the main thread and call the core
 * 
 * @author Arthur Mimouni, Paul Gasquet
 *
 */

public class MainGui extends JFrame implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private MainGui instance = this;
	
	private Chronometer chronometer = new Chronometer();
	private int speed = 160;
	private boolean stop = true;
	private String superiorSymbol=">";
	private String inferiorSymbol="<";
	private int decrementeObstacle=50;
	
	private Map map; 
	private MapCharacteristics mapCharacteristics;
	private Core core;
	private ChartManager chartManager = new ChartManager();
	
	private DashBoard dashBoard;
	private JPanel buttonPanel = new JPanel();
	private LegendPanel legendPanel = new LegendPanel(); 
	private JPanel statPanel = new JPanel();
	private JPanel timePanel = new JPanel();
	
	private Button pausePlay = new Button("Start");
	private Button EndButton = new Button("End");
	private Button accelerate = new Button(superiorSymbol);
	private Button decelerate = new Button(inferiorSymbol);
	private Button normalSpeed= new Button("Default");
	private Button predatorButton = new Button("predator");
	private Button obstacleButton = new Button("obstacle 50");
	private Button diaryButton = new Button("Ant diary");
	
	private JLabel hourLabel = new JLabel("Hour:");
	private JLabel minuteLabel = new JLabel("Minute:");
	private JLabel secondLabel = new JLabel("Second:");
	private JLabel hourValue = new JLabel("");
	private JLabel minuteValue = new JLabel("");
	private JLabel secondValue = new JLabel("");
	private JLabel pieLabel=new JLabel();
	private JLabel numericStatLabel = new JLabel();
	private static Logger logger = LoggerUtility.getLogger(MainGui.class, "html");
	
	public MainGui(MapCharacteristics mapCharacteristics) throws IOException, URISyntaxException {
		this.map=new Map(mapCharacteristics);
		this.mapCharacteristics=map.getMapCharacteristics();
		dashBoard = new DashBoard(map);
		core = new Core();	
		init();
		run();
	}
	
	
	public void init() {
		logger.info("Simulation initializing");
		updateValueChrono();
		this.setTitle("MainGui");
		this.setResizable(false);
		this.setSize(mapCharacteristics.getWindowWidth(),mapCharacteristics.getWindowHeight());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		getContentPane().setLayout(new BorderLayout());
		
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
		statPanel.setLayout(new BorderLayout());
	
		numericStatLabel.setBounds(0, 700, 300, 100);
		numericStatLabel.setFont(new Font("Serif", Font.PLAIN, 18));
		
		statPanel.add(numericStatLabel);
		
		timePanel.add(hourLabel);
		timePanel.add(hourValue);

		timePanel.add(minuteLabel);
		timePanel.add(minuteValue);

		timePanel.add(secondLabel);
		timePanel.add(secondValue);
		timePanel.setBackground(Color.lightGray);
		
		statPanel.add(timePanel,BorderLayout.SOUTH);
		statPanel.add(legendPanel,BorderLayout.NORTH);
		
		pausePlay.addActionListener(new StartStopAction());
		pausePlay.setMaximumSize(new Dimension(100,30));
		buttonPanel.add(pausePlay);
		buttonPanel.add(Box.createRigidArea(new Dimension(50,0)));

		normalSpeed.addActionListener(new normalSpeedAction());
		normalSpeed.setMaximumSize(new Dimension(100,30));
		buttonPanel.add(normalSpeed);
		buttonPanel.add(Box.createRigidArea(new Dimension(50,0)));
				
		accelerate.addActionListener(new accelerationAction());
		accelerate.setMaximumSize(new Dimension(100,30));
		buttonPanel.add(accelerate);
		buttonPanel.add(Box.createRigidArea(new Dimension(50,0)));

		decelerate.addActionListener(new decelerationAction());
		decelerate.setMaximumSize(new Dimension(100,30));
		buttonPanel.add(decelerate);
		buttonPanel.add(Box.createRigidArea(new Dimension(50,0)));
		
		EndButton.addActionListener(new EndAction());
		EndButton.setMaximumSize(new Dimension(100,30));
		buttonPanel.add(EndButton);
		//Fin normalSpeed
		buttonPanel.add(Box.createRigidArea(new Dimension(50,0)));
		
		predatorButton.addActionListener(new PredatorAction());
		predatorButton.setMaximumSize(new Dimension(100,30));
		buttonPanel.add(predatorButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(50,0)));

		obstacleButton.addActionListener(new ObstacleAction());
		obstacleButton.setMaximumSize(new Dimension(110,30));
		buttonPanel.add(obstacleButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(50,0)));

		diaryButton.addActionListener(new DiaryAction());
		diaryButton.setMaximumSize(new Dimension(110,30));
		buttonPanel.add(diaryButton);
		buttonPanel.add(Box.createRigidArea(new Dimension(50,0)));
	
		legendPanel.setBackground(Color.orange);
		buttonPanel.setBackground(Color.orange);
		statPanel.setBackground(Color.orange);
		
		getContentPane().add(buttonPanel,BorderLayout.SOUTH);
		getContentPane().add(dashBoard,BorderLayout.CENTER);
		getContentPane().add(statPanel,BorderLayout.WEST);
		
		ImageIcon ii= chartManager.getPie(mapCharacteristics);
		pieLabel.setIcon(ii);
		statPanel.add(pieLabel);
	}
	
	@Override
	public void run() {
		while(!stop) {
			
			try {
				ImageIcon ii= chartManager.getPie(mapCharacteristics);
				pieLabel.setIcon(ii);
				String stat=NumericStat.getNumericStat(mapCharacteristics);
				numericStatLabel.setText(stat);
				core.process(map);
						
			} catch (IOException | URISyntaxException e1) {
				e1.printStackTrace();
			}
			
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				logger.error("exception in run()", e);
				System.out.println(e.getMessage());
			}
			chronometer.increment();
			if (!stop) {
				update();
				updateValueChrono();
			}
		}
	}
	
	private void update() {
		dashBoard.setAnts(map.getAnts());
		dashBoard.setMap(map);
		dashBoard.repaint();
	}
	
	private void updateValueChrono() {
		CyclicCounter hour = chronometer.getHour();
		hourValue.setText(hour.toString() + " ");

		CyclicCounter minute = chronometer.getMinute();
		minuteValue.setText(minute.toString() + " ");

		CyclicCounter second = chronometer.getSecond();
		secondValue.setText(second.toString() + " ");
	}
	
	private class StartStopAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (!stop) {
				stop = true;
				pausePlay.setText(" Start ");
				
			} 
			else {
				stop = false;
				pausePlay.setText(" Pause ");
				Thread simulation = new Thread(instance);
				simulation.start();
			}
		}
	}
	
	private class EndAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			instance.dispose();
			stop=true;
			new EndWindow(map);
		}
	}
	
	private class accelerationAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(speed>20) {
				superiorSymbol+=">";
				accelerate.setText(superiorSymbol);
				speed=speed/2;
				}
			if(!inferiorSymbol.equals("<")) {
				inferiorSymbol=inferiorSymbol.substring(0, inferiorSymbol.length()-1);
				decelerate.setText(inferiorSymbol);

			}
		}
	}
	
	private class decelerationAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(speed<1279) {
				inferiorSymbol+="<";
				decelerate.setText(inferiorSymbol);
				speed=speed*2;
				if(!superiorSymbol.equals(">")) {
					superiorSymbol=superiorSymbol.substring(0, superiorSymbol.length()-1);
					accelerate.setText(superiorSymbol);
				}
			}
		}
	}
	
	private class normalSpeedAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			speed=150;
			superiorSymbol=">";
			accelerate.setText(superiorSymbol);
			inferiorSymbol="<";
			decelerate.setText(inferiorSymbol);
		}
	}
	
	private class PredatorAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			map.addPredator();
		}		
	}

	private class ObstacleAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			map.addObstacle();
			decrementeObstacle--;
			if(decrementeObstacle>=0) {
				String decremente= String.valueOf(decrementeObstacle);
				obstacleButton.setText("Obstacle"+" "+decremente);
			}
		}
	}
	
	private class DiaryAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new DiaryWindow();
			instance.setVisible(false);
			if (!stop) {
				stop = true;
				pausePlay.setText(" Start ");
			} 
		}
	}
	
	private class DiaryWindow extends JFrame{

		private static final long serialVersionUID = 1L;
		private DiaryWindow instanceDiary=this;
		private DiaryPanel diaryPanel = new DiaryPanel();
		
		private Button backButton=new Button("Back");
		private Button liveAntsButton = new Button("Choose");
		private Button deadAntsButton = new Button("Choose");
		
		private JLabel liveAnts=new JLabel("Lives ants");
		private JLabel deadAnts = new JLabel("Dead ants");
		private JLabel chooseLiveAnts = new JLabel ("Choose ant N°: ");
		private JLabel chooseDeadAnts = new JLabel ("Choose ant N°: ");
		private JLabel descriptionLiveAnt=new JLabel("");
		private JLabel descriptionDeadAnt=new JLabel("");
		
		private JComboBox<Integer> listLiveAnts=new JComboBox<Integer>();
		private JComboBox<Integer> listDeadAnts=new JComboBox<Integer>();
		
		private DiaryWindow() {
			
			this.setTitle("DiaryWindow");
			this.setResizable(false);
			this.setSize(1289,829);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			this.getContentPane().add(diaryPanel);
			
			diaryPanel.setLayout(null);
			this.getContentPane().add(diaryPanel);
			
			liveAnts.setBounds(550, 30, 110, 30);
			liveAnts.setFont(new Font("Serif", Font.BOLD, 24));
			liveAnts.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			
			chooseLiveAnts.setBounds(50, 180, 490, 30);
			chooseLiveAnts.setFont(new Font("Serif", Font.BOLD, 24));
			
			listLiveAnts.setBounds(230, 180, 80, 30);
			
			for(int i=0;i<map.getAnts().size();i++) {
				listLiveAnts.addItem(map.getAnts().get(i).getIdentity().getIdNumber());
			}
			
			liveAntsButton.setBounds(330,180,80,30);
			liveAntsButton.addActionListener(new LiveAntsButton());	
			
			deadAnts.setBounds(550, 380, 110, 30);
			deadAnts.setFont(new Font("Serif", Font.BOLD, 24));
			deadAnts.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			
			chooseDeadAnts.setBounds(50, 520, 490, 30);
			chooseDeadAnts.setFont(new Font("Serif", Font.BOLD, 24));
			
			listDeadAnts.setBounds(230, 520, 80, 30);
			
			deadAntsButton.setBounds(330,520,80,30);
			deadAntsButton.addActionListener(new DeadAntsButton());	
			
			
			Iterator<Ant> it = map.getCimiteryAnt().values().iterator();
			
			while(it.hasNext()) {
				Ant ant = it.next();
				listDeadAnts.addItem(ant.getIdentity().getIdNumber());
			}
					
			backButton.setBounds(560,750, 85, 23);
			backButton.addActionListener(new BackButtonAction());	
			
			descriptionLiveAnt.setBounds(800, 100, 900, 300);
			descriptionLiveAnt.setFont(new Font("Serif", Font.BOLD, 24));
			
			descriptionDeadAnt.setBounds(800, 520, 900, 300);
			descriptionDeadAnt.setFont(new Font("Serif", Font.BOLD, 24));
			
			diaryPanel.add(backButton);
			diaryPanel.add(liveAnts);
			diaryPanel.add(deadAnts);
			diaryPanel.add(backButton);
			diaryPanel.add(chooseLiveAnts);
			diaryPanel.add(listLiveAnts);
			diaryPanel.add(deadAnts);
			diaryPanel.add(chooseDeadAnts);
			diaryPanel.add(listDeadAnts);
			diaryPanel.add(liveAntsButton);
			diaryPanel.add(deadAntsButton);
			diaryPanel.add(descriptionLiveAnt); 
			diaryPanel.add(descriptionDeadAnt);
		}
		
		private class BackButtonAction implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				instanceDiary.setVisible(false);
				instance.setVisible(true);
				stop = false;
				pausePlay.setText(" Pause ");
				Thread simulation = new Thread(instance);
				simulation.start();
				dispose();
			}
		}
		
		private class LiveAntsButton implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				
				String s;
				int value=listLiveAnts.getSelectedIndex();
				s=map.getAnts().get(value).whoAmI();
				descriptionLiveAnt.setText(s);
			}
		}
		
		private class DeadAntsButton implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				String s="";
				int value=(int) listDeadAnts.getSelectedItem();	
				System.out.println(value);
				Iterator<Ant> it=map.getCimiteryAnt().values().iterator();
				while(it.hasNext()) {
					Ant ant=it.next();
					if(ant.getIdentity().getIdNumber()==value) {
						s=ant.whoAmI();
						break;
					}
				}
				descriptionDeadAnt.setText(s);
			}
		}
	}
}
	
	
	





