package com.portfobio.application.mouse;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import com.portfobio.application.BasicModuleInfo;
import com.portfobio.application.core.ApplicationModuleInfo;

public class RobotMouseModule implements MouseModule {
	private static final String NAME = "Robot Mouse Module";
	private static final String DESCRIPTION = "Module to control mouse using Robot";

	private Robot robot;
	private int x = 0;
	private int y = 0;

	public RobotMouseModule() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public ApplicationModuleInfo getModuleInfo() {
		return new BasicModuleInfo(NAME, DESCRIPTION);
	}

	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
		move();
	}

	private void move() {
		robot.mouseMove(x, y);
	}

	public void moveBy(int x, int y) {
		this.x += x;
		this.y += y;

		if (this.x < 0) {
			this.x = 0;
		}

		if (this.y < 0) {
			this.y = 0;
		}
		move();
	}

	public void click(Button button) {
		int buttons = Button.LEFT_BUTTON.equals(button) ? InputEvent.BUTTON1_DOWN_MASK : InputEvent.BUTTON3_DOWN_MASK;
		robot.mousePress(buttons);
		robot.mouseRelease(buttons);
		System.out.println("Button clicked");
	}

}
