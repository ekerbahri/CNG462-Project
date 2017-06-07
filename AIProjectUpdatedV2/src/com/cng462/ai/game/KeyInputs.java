package com.cng462.ai.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInputs extends KeyAdapter
{
	private Handler handler;
	private int counter = 0;
	int result[][];
	int matrix[][];
	Environment2 environment[][];
	int x = 0;
	int y = 0;
	
	public KeyInputs(Handler handler)
	{
		this.handler = handler;	
	}
	
	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int matrix[][]) {
		this.matrix = matrix;
	}

	public Environment2[][] getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment2 environment[][]) {
		this.environment = environment;
	}

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
				
		for(int i=0; i < handler.objects.size(); ++i)
		{
			GameObject temp = handler.objects.get(i);
			
			if(temp.getID() == ID.Player)
			{
				if(key == KeyEvent.VK_SPACE)
				{
					//System.out.println(temp.getX() + ", " + temp.getY());
					int pos2 = SpaceConqueror.pos;
					//temp.setY(temp.getY() - 50);
					if(pos2 == 1){
						temp.setX(0);
						temp.setY(0);
					}
					else if(pos2 == 2){
						temp.setX(50);
						temp.setY(0);
					}
					
					else if(pos2 == 3){
						temp.setX(100);
						temp.setY(0);
					}
					else if(pos2 == 4){
						temp.setX(150);
						temp.setY(0);
					}
					else if(pos2 == 5){
						temp.setX(0);
						temp.setY(50);
					}
					else if(pos2 == 6){
						temp.setX(50);
						temp.setY(50);
					}
					else if(pos2 == 7){
						temp.setX(100);
						temp.setY(50);
					}
					else if(pos2 == 8){
						temp.setX(150);
						temp.setY(50);
					}
					else if(pos2 == 9){
						temp.setX(0);
						temp.setY(100);
					}
					else if(pos2 == 10){
						temp.setX(50);
						temp.setY(100);
					}
					else if(pos2 == 11){
						temp.setX(100);
						temp.setY(100);
					}
					else if(pos2 == 12){
						temp.setX(150);
						temp.setY(100);
					}
					else if(pos2 == 13){
						temp.setX(0);
						temp.setY(150);
					}
					else if(pos2 == 14){
						temp.setX(50);
						temp.setY(150);
					}
					else if(pos2 == 15){
						temp.setX(100);
						temp.setY(150);
					}
					else if(pos2 == 16){
						temp.setX(150);
						temp.setY(150);
					}
					
				}
			}
		}
	}
}
