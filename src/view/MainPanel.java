package view;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

import constant.Constants;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements IntFreqControlView {
	
	// Component
	private JSlider freqSlider;
	private JTextField freqField;
	
	// Constructor
	public MainPanel() {
		// Set Attribute
		this.setBackground(Constants.MAINPANLE_BACKGROUNDCOLOR);
		
		// Create Component
		this.freqSlider = new JSlider();
		this.freqSlider.setMinimum(Constants.MIN_FREQUENCY);
		this.freqSlider.setMaximum(Constants.MAX_FREQUENCY);
		this.freqSlider.setMajorTickSpacing(Constants.FREQSLIDER_TICK);
		this.freqSlider.setBackground(Constants.MAINPANLE_BACKGROUNDCOLOR);
		this.add(this.freqSlider);

		this.freqField = new JTextField();
		this.freqField.setEditable(false);
		this.freqField.setPreferredSize(Constants.FREQ_FIELD_SIZE);
		this.freqField.setBackground(Constants.MAINPANLE_BACKGROUNDCOLOR);
		this.add(this.freqField);
	}
	
	@ Override
	public double getFreq() {
		this.freqField.setText(Integer.toString(this.freqSlider.getValue()));
		return Double.parseDouble(this.freqField.getText());
	}
}
