package main;

import control.Control;
import hw.SoundPlayer;
import view.View;

public class Main {

	public static void main(String[] args) {
		// Create 
		View view = new View();
		Control control = new Control();
		SoundPlayer player = new SoundPlayer();
		
		// Initialize
		view.init();
		player.init();
		
		// Associate
		control.associateFreqControlView(view.getFreqControlView());
		control.assembleSoundPlayer(player);
		
		// Run
		control.run();
	}
}
