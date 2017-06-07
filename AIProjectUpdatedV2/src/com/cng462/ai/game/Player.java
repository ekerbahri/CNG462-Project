package com.cng462.ai.game;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject
{
	public Player(int x, int y, ID id) 
	{
		super(x, y, id);	
	}

	public void tick() 
	{
		x = Environment.clamp(this.x, 0, Environment.WIDTH - 55);
		y = Environment.clamp(this.y, 0, Environment.HEIGHT - 77);
	}

	public void render(Graphics g) 
	{
		if(id == ID.Player)
		{
			g.setColor(Color.GREEN);
		}
		
		else if(id == ID.Goal)
		{
			g.setColor(Color.YELLOW);
		}
		
		else if(id == ID.Enemy1)
		{
			g.setColor(Color.RED);
		}
		
		else if(id == ID.Enemy2)
		{
			g.setColor(Color.MAGENTA);
		}
		g.fillRect(x, y, 50, 50);
	}

}
