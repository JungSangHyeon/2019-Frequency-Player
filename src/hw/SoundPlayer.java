package hw;

import java.nio.ByteBuffer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

import constant.Constants;

public class SoundPlayer implements IntSoundPlayer {

	// Attribute
	private double freqCyclePosition = 0; // Position through the sine wave as a percentage (0-1 <=> 0-2*PI)
	
	// Component?
	private SourceDataLine line;
	private ByteBuffer buff;
	
	public void init() {
		try {
			DataLine.Info info = new DataLine.Info(SourceDataLine.class, Constants.AUDIO_FORMAT, Constants.SINE_PACKET_SIZE * 2);
			if (!AudioSystem.isLineSupported(info)) {throw new LineUnavailableException();}
			this.line = (SourceDataLine) AudioSystem.getLine(info);
			this.line.open(Constants.AUDIO_FORMAT);
			this.line.start();
		} catch (LineUnavailableException e) {System.out.println(Constants.LINE_UNAVAILABLE_EXCEPTION_ERR_MSG); System.exit(-1);}
		this.buff = ByteBuffer.allocate(Constants.SINE_PACKET_SIZE);
	}
	
	@Override
	public void playSound(double freq) {
	    double freqCycleInc = freq / Constants.SAMPLING_RATE;
		this.buff.clear();
		for (int i = 0; i < Constants.SINE_PACKET_SIZE / Constants.SAMPLE_SIZE_IN_BYTES; i++) {
			this.buff.putShort((short) (Short.MAX_VALUE * Math.sin(2 * Math.PI * this.freqCyclePosition)));
			this.freqCyclePosition += freqCycleInc;
			if (this.freqCyclePosition > 1) {this.freqCyclePosition -= 1;}
		}
		this.line.write(this.buff.array(), 0, this.buff.position());
		try {while (this.line.getBufferSize() - this.line.available() > Constants.SINE_PACKET_SIZE) {Thread.sleep(1);}} 
		catch (InterruptedException e) {} // While Using Buffer Size > Sine Packet Size
	}
}
