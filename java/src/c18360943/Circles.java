package c18360943;

import java.util.LinkedList;

import processing.core.PImage;

public class Circles extends Visuals {
	int screenWidth = 1668; //screenWidth and screenHeight are set to the dimensions  of the photo that I am using for my background
	int screenHeight = 924;
	private PImage backgroundImage;
	private String bGround = "BG1.jpeg";
	protected float hue;
	LinkedList<Float> ampHistory = new LinkedList();
	LinkedList<Float> bandsHist = new LinkedList();
	LinkedList<Float> freqHist = new LinkedList();
	boolean top=false;
	boolean circlesOn = false;
	boolean visualiserOn = true;
	boolean freqCircle = true;
	boolean cubeVisual = false;
	boolean freqWave = false;
	CircleVisuals cv;
	AmplitudeWaves aw;
	FreqCircle fc;
	SquareVisuals sv;
	FrequencyWave fw;
	
	public void settings() {
		size(screenWidth, screenHeight);
	}
	
	public void setup() {
		cv = new CircleVisuals(this);
		aw = new AmplitudeWaves(this);
		fc = new FreqCircle(this);
		sv = new SquareVisuals(this);
		fw = new FrequencyWave(this);
		startMinim();
		backgroundImage = loadImage(bGround);
		loadAudio("ThinkAboutThings.mp3");
		getAudioPlayer().play();
	}
	
	public void draw() {
		background(backgroundImage);
		colorMode(HSB, 360 ,100, 100);
		try {
			calculateFFT();
		}
		catch(VisualException e){
			e.printStackTrace();
		}
		stroke(hue, 255,255); //set stroke to react to songs amplitude
		noFill();
		translate(screenWidth/2, screenHeight/2);
		calculateAverageAmplitude();
		calculateFrequencyBands();
		hue = map(getAmplitude() * 1000, -400, 300, 0 ,255); //General hue set to respond to songs current amplitude
		
		ampHistory.add(getSmoothenedAmplitude());
		if(ampHistory.size()== screenWidth/2) {
			ampHistory.clear();       //Re-calibrate the history so visuals can re-start from center of the screen
		}
		for(int i = 0 ; i< getBands().length ; i++) {
			bandsHist.add(getSmoothenedBands()[i]);
			if(bandsHist.size() == screenWidth/2) {
				bandsHist.clear();    //same as loop above except for frequency visualiser
			}
		}
		
		//all visuals are user controlled.
		if(visualiserOn == true) {
			aw.render();
		}
		if(circlesOn == true) {
			cv.render();
		}
		if(freqCircle == true) {
			fc.render();
		}
		if(cubeVisual == true) {
			sv.render();
		}
		if(freqWave == true) {
			fw.render();
		}
	}
	
	
	public void keyPressed() //Functional keys set to allow the user to control visuals / audio.
    {
        if (key == ' ')
        {
            if(getAudioPlayer().isPlaying()) {
            	getAudioPlayer().pause();
            }
            else {
            	getAudioPlayer().play();
            }
        }
        if(key == 't') {
        	if(top==false) {
        		top=true;
        	}
        	else {
        		top=false;
        	}
        }
        if(key == 'c') {
        	if(circlesOn == true) {
        		circlesOn = false;
        	}
        	else {
        		circlesOn = true;
        	}
        }
        
        if(key == 'v') {
        	if(visualiserOn == true) {
        		visualiserOn = false;
        	}
        	else {
        		visualiserOn = true;
        	}
        }
        if(key == 'f') {
        	if(freqCircle == true) {
        		freqCircle = false;
        	}
        	else {
        		freqCircle = true;
        	}
        }
        if(key == 'g') {
        	if(cubeVisual == false) {
        		cubeVisual = true;
        	}
        	else {
        		cubeVisual= false;
        	}
        }
        if(key == 'w') {
        	if(freqWave == false) {
        		freqWave = true;
        	}
        	else {
        		freqWave = false;
        	}
        }
        if(key == 'x') {
        	stop();
        }
    }
	
	public void stop()  //Close the AudioPlayer and Minim after use.
	{
		getAudioPlayer().close();
		getMinim().stop();
		return;
	}

}
