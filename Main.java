package main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

public class Main {
	
	final static int buttonx = 1115;
	final static int buttony = 700;
	final static int delay = 10000;
	
	
	final static Color color = new Color(0, 245, 147);
	final static Color colorHover = new Color(0, 173, 150);
	
	final static Rectangle captureArea = new Rectangle (buttonx, buttony, 1, 1);
	
	public static int mouseButton = InputEvent.BUTTON1_MASK;

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		
		Robot robot = new Robot(); // create robot instance
		
		BufferedImage storedData;
		
		while (true) {

			Thread.sleep(delay);
			
			storedData = robot.createScreenCapture(captureArea);
			
			if (equalTo(storedData.getRGB(0, 0), color.getRGB()) || equalTo(storedData.getRGB(0, 0), colorHover.getRGB())) {
				robot.mouseMove(buttonx, buttony);
				robot.mousePress(mouseButton);
				robot.mouseRelease(mouseButton);
			}
		}

	}
	
	public static boolean equalTo(int one, int two) {
		if (one == two) {
			return true;
		}
		return false;
	}

}
