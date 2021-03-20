package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

/**
 * 
 * @author Paul Gasquet
 *
 */

public class Button extends JButton implements MouseListener {
		
	private static final long serialVersionUID = 1L;
		
	public Button(String title) {
			super(title);
			this.addMouseListener(this);
			this.setBackground(Color.white);
	}
	
	public void mouseClicked(MouseEvent event) {}
		
	public void mouseEntered(MouseEvent event) {
		 this.setBackground(Color.orange);
	}
	
	public void mousePressed(MouseEvent event) {
		 this.setBackground(Color.blue);
	}
	 
	public void mouseReleased(MouseEvent event) {
		 this.setBackground(Color.white);
	}
	
	public void mouseExited(MouseEvent e) {
		this.setBackground(Color.white);
	} 
}
