package org.nabokos.game;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.Raster;

import org.nabokos.resources.Tileset;
import org.nabokos.resources.Tileset.TILE;

public class World {
	private static final int MAX_WIDTH = 640;
	private static final int MAX_HEIGHT = 480;
	private PressedKeys keys;
	private int[] brick;
	private int[] ground;
	private int[] cross;
	private int[] box;
	private int[] fire1;
	private int[] fire2;
	private int[] fire3;
	private int[] door;
	
	private BufferedImage world = new BufferedImage(MAX_WIDTH, MAX_HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	public World() {
		brick = Tileset.getTile(TILE.BRICK);
		ground = Tileset.getTile(TILE.GROUND);
		cross =  Tileset.getTile(TILE.CROSS);
		box =  Tileset.getTile(TILE.BOX);
		fire1 =  Tileset.getTile(TILE.FIRE_1);
		fire2 =  Tileset.getTile(TILE.FIRE_2);
		fire3 =  Tileset.getTile(TILE.FIRE_3);
		door =  Tileset.getTile(TILE.DOOR);
	}
	
	public void setPressedKeys(PressedKeys pk) {
		keys = pk;
	}
	
	//15*15
	private static int[][] level = {{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 2, 3, 4, 5, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, },
									{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, },
								};
	
	public BufferedImage render() {
		int x = 0;
		int y = 0;
		
		for (int[] line : level) {
			for (int tileType : line) {
				writeTile(x, y, tileType);
				x += 32;
			}
			x = 0;
			y += 32;
			
		}
		return world;
	}
	
	private void writeTile(int x, int y, int tileType) {

		switch (tileType) {
		case 0:
			world.setRGB(x, y, 32, 32, brick, 0, 32);
			break;
		case 1:
			world.setRGB(x, y, 32, 32, ground, 0, 32);
			break;
		case 2:
			world.setRGB(x, y, 32, 32, cross, 0, 32);
			break;
		case 3:
			world.setRGB(x, y, 32, 32, box, 0, 32);
			break;
		case 4:
			world.setRGB(x, y, 32, 32, getFire(), 0, 32);
			break;
		case 5:
			world.setRGB(x, y, 32, 32, door, 0, 32);
			break;
		default:
			world.setRGB(x, y, 32, 32, brick, 0, 32);
		}
		
	}
	
	private int[] getFire() {
		int rand = (int) (Math.random() * 10) % 3;
		System.out.println("rand = " + rand);
		if (rand == 0) {
			return fire1;
		} else if (rand == 1) {
			return fire2;
		}
		return fire3;
	}
}
