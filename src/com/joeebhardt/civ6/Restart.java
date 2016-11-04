package com.joeebhardt.civ6;

import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Restart {

	private Robot robot;
	private int x;
	private int y;

	public Restart() {

		try {
			robot = new Robot();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Match.init();
		exitGame();
		setup();
		selectLeader();
		selectDifficulty();
		selectSpeed();
		selectMap();
		start();
		Match.save();
	}
	

	public void exitGame() {
		move(1, 1); // gives game focus
		click();
		pause(Info.Pause.UI);
		menu();
		move(Match.find(Match.exitGame));
		click();
		pause(Info.Pause.UI);
		move(Match.find(Match.exitConfirmation));
		click();
		pause(Info.Pause.exitGame);
	}

	public void setup() {

		move(Match.find(Match.singlePlayer));
		click();
		pause(Info.Pause.UI);
		move(Match.find(Match.createGame));
		click();
		pause(Info.Pause.UI);

	}

	public void selectLeader() {

		int leaderOffset = 50;
		move(Match.find(Match.civilization));
		click();
		
		move(x, y + leaderOffset);
		int scroll = Math.round((float) (Info.civ.ordinal() * 2.1));
		scroll(scroll);

		if (Info.civ.ordinal() > Civ.Spain.ordinal()) {
			move(x, y + (Info.civ.ordinal() - Civ.Spain.ordinal())
					* leaderOffset);
		} else {
			activatePointer();
		}
		
		click();
	}

	public void selectDifficulty() {

		move(Match.find(Match.difficulty));
		click();

		int offset = 25 * (Info.difficulty.ordinal() + 1);
		move(x, y + offset);
		click();

	}

	public void selectSpeed() {
		
		move(Match.find(Match.speed));
		click();

		int offset = 25 * (Info.speed.ordinal() + 1);
		move(x, y + offset);
		click();
	}

	public void selectMap() {

		move(Match.find(Match.mapType));
		click();

		int offset = 25 * (Info.mapType.ordinal() + 1);
		move(x, y + offset);
		click();

		move(Match.find(Match.mapSize));
		click();

		offset = 25 * (Info.mapSize.ordinal() + 1);
		move(x, y + offset);
		click();
		pause(Info.Pause.UI);

	}

	public void start() {
		move(Match.find(Match.startGame));
		click();
	}

	public void menu() {
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
		pause(Info.Pause.UI);
	}

	public void click() {
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		pause(Info.Pause.button);
	}

	public void move(Point p) {
		move(p.x, p.y);
	}

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
		robot.mouseMove(x-1, y);
		robot.mouseMove(x, y);
		pause(Info.Pause.button);
	}

	public void activatePointer() {
		move(x + 1, y);
		move(x - 1, y);
	}

	public void pause(int ms) {
		try {
			Thread.sleep(ms);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void scroll(int notches) {

		for (int i = 0; i < notches; i++) {
			robot.mouseWheel(1);
			pause(25);
		}

	}

}
