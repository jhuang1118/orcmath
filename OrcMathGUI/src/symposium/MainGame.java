package symposium;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import guiTeacher.GUIApplication;

public class MainGame extends GUIApplication {
	public static MainGame game;
	public static MainScreen main;
	public static BlackjackScreen bj;
	public static MenuScreen menu;
	public static DiceScreen dice;
	private static Clip g;

	public MainGame(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	public static void main(String[] args) {
		game = new MainGame(1280, 1040);
		Thread runner = new Thread(game);
		runner.start();
		playMusic("resources/open.wav");		
	}

	@Override
	public void initScreen() {
		createCards();
		createDice();
		bj = new BlackjackScreen(getWidth(), getHeight());
		dice = new DiceScreen(getWidth(), getHeight());
		menu = new MenuScreen(getWidth(), getHeight());
		main = new MainScreen(getWidth(), getHeight());
		
		setScreen(menu);
	}

	private void createDice() {
		// TODO Auto-generated method stub
		
	}

	private void createCards() {
		
		
	}
	
	public static void playMusic(String musicPos) {
		if (g!= null) {
			g.stop();
		}
		try {
	          File soundFile = new File(musicPos);
	          AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
	          g = AudioSystem.getClip();
	         g.open(audioIn);
	         g.start();
	      } catch (UnsupportedAudioFileException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (LineUnavailableException e) {
	         e.printStackTrace();
	      }
	}

}
