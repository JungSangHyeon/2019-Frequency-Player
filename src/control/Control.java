package control;

import hw.IntSoundPlayer;
import view.IntFreqControlView;

public class Control implements Runnable {
	
	// Association
	private IntFreqControlView view;
	private IntSoundPlayer player;
	
	@Override
	public void run() {
		while(true) {this.player.playSound(this.view.getFreq());}
	}

	public void associateFreqControlView(IntFreqControlView view) {this.view=view;}
	public void assembleSoundPlayer(IntSoundPlayer player) {this.player=player;}
}
