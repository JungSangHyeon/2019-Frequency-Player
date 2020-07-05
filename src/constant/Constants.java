package constant;

import java.awt.Color;
import java.awt.Dimension;

import javax.sound.sampled.AudioFormat;

public class Constants {
	
	// Main Frame
	public static final boolean MAINFRAME_RESIZEABLE = false;
	public static final String MAINFRAME_TITLE = "Frequency Player";
	public static final Dimension MAINFRAME_SIZE = new Dimension(300, 70);
	
	// Main Panel
	public static final Color MAINPANLE_BACKGROUNDCOLOR = Color.WHITE;
	public static final Dimension FREQ_FIELD_SIZE = new Dimension(40, 20);
	public static final int FREQSLIDER_TICK = 50;
	public static final int MIN_FREQUENCY = 0;
	public static final int MAX_FREQUENCY = 40000;
	
	// SoundPlayer
	public static final String LINE_UNAVAILABLE_EXCEPTION_ERR_MSG = "Line not available";
	public static final double BUFFER_DURATION = 0.100;
	public static final int SAMPLING_RATE = 48000; // 44100, 48000, 96000, 176400, 352800
	public static final int SAMPLE_SIZE_IN_BYTES = 2;
	public static final int CHANEL_NUM = 1; // 1 for mono, 2 for stereo
	public static final boolean SIGNED = true;
	public static final boolean BIG_ENDIAN = true;
	public static final int SINE_PACKET_SIZE = (int) (Constants.BUFFER_DURATION * Constants.SAMPLING_RATE * Constants.SAMPLE_SIZE_IN_BYTES);
	public static final AudioFormat AUDIO_FORMAT = new AudioFormat(
			Constants.SAMPLING_RATE,
			Constants.SAMPLE_SIZE_IN_BYTES * 8,//Bits
			Constants.CHANEL_NUM,
			Constants.SIGNED,
			Constants.BIG_ENDIAN
	);
}
