package org.nabokos.resources;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Tileset {
	private static BufferedImage image;
	private static int HEIGHT = 32;
	private static int WIDTH = 32;
	
	public enum TILE {BRICK, GROUND, CROSS, BOX, FIRE_1, FIRE_2, FIRE_3, DOOR, OPEN_DOOR, PLAYER};

	
	static {
		try {
			URL url = Tileset.class.getResource("/tileset_32x32.png");
			if (url != null) {
				image = ImageIO.read(url);
				
			} else {
				System.out.println("resources not find");
				System.exit(1);
			}
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
			System.exit(1);
		}	
	}
	
	public static int[] getTile(TILE tile) { 
		int[] rgb = new int[32*32];
		
		switch(tile) {
			case BRICK:
				image.getRGB(getStartX(1), getStartY(1), WIDTH, HEIGHT, rgb, 0, WIDTH);
				break;
			case GROUND:
				image.getRGB(getStartX(2), getStartY(1), WIDTH, HEIGHT, rgb, 0, WIDTH);
				break;
			case CROSS:
				image.getRGB(getStartX(3), getStartY(1), WIDTH, HEIGHT, rgb, 0, WIDTH);
				break;
			case BOX:
				image.getRGB(getStartX(4), getStartY(1), WIDTH, HEIGHT, rgb, 0, WIDTH);
				break;
			case FIRE_1:
				image.getRGB(getStartX(5), getStartY(1), WIDTH, HEIGHT, rgb, 0, WIDTH);
				break;
			case FIRE_2:
				image.getRGB(getStartX(6), getStartY(1), WIDTH, HEIGHT, rgb, 0, WIDTH);
				break;
			case FIRE_3:
				image.getRGB(getStartX(7), getStartY(1), WIDTH, HEIGHT, rgb, 0, WIDTH);
				break;
			case DOOR:
				image.getRGB(getStartX(1), getStartY(2), WIDTH, HEIGHT, rgb, 0, WIDTH);
				break;
			case OPEN_DOOR:
				image.getRGB(getStartX(2), getStartY(2), WIDTH, HEIGHT, rgb, 0, WIDTH);
				break;
			case PLAYER:
				image.getRGB(getStartX(3), getStartY(2), WIDTH, HEIGHT, rgb, 0, WIDTH);
				break;
		}
		
		return rgb;
	}

	private static int getStartX(int column) {
		return (column + 32*(column-1));
	}
	
	private static int getStartY(int line) {
		return (line + 32*(line-1));
	}

	
	private static int getAlpha(int pixel) {
		return (pixel >> 24) & 0xff;		
	}
	
	private static int getRedColor(int pixel) {
		return (pixel >> 16) & 0xff;
	}
	
	private static int getGreenColor(int pixel) {
		return (pixel >> 8) & 0xff;
	}

	private static int getBlueColor(int pixel) {
		return pixel & 0xff;
	}

}
