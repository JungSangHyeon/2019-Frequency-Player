package view;

import javax.swing.JFrame;

import constant.Constants;

@SuppressWarnings("serial")
public class View extends JFrame{

	// Component
	private MainPanel mainPanel;
	
	// Constructor
	public View() {
		// Set Attribute
		this.setTitle(Constants.MAINFRAME_TITLE);
		this.setResizable(Constants.MAINFRAME_RESIZEABLE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(Constants.MAINFRAME_SIZE);
		this.setLocationRelativeTo(null);
		
		// Create Components
		this.mainPanel = new MainPanel();
		this.add(this.mainPanel);
	}
	
	public void init() {this.setVisible(true);}
	public IntFreqControlView getFreqControlView() {return this.mainPanel;}
}
