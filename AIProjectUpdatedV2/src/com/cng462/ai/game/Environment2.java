package com.cng462.ai.game;

public class Environment2 
{
	private boolean redLight;
	private boolean magentaLight;
	private boolean glitter;
	private boolean wall;
	private boolean isDead;
	
	public Environment2()
	{
		this.redLight = false;
		this.magentaLight = false;
		this.glitter = false;
		this.wall = false;
		this.isDead = false;
	}

	public boolean getRedLight() {
		return redLight;
	}

	public void setRedLight(boolean redLight) {
		this.redLight = redLight;
	}

	public boolean getMagentaLight() {
		return magentaLight;
	}

	public void setMagentaLight(boolean magentaLight) {
		this.magentaLight = magentaLight;
	}

	public boolean getGlitter() {
		return glitter;
	}

	public void setGlitter(boolean glitter) {
		this.glitter = glitter;
	}

	public boolean getWall() {
		return wall;
	}

	public void setWall(boolean wall) {
		this.wall = wall;
	}

	public boolean getIsDead() {
		return isDead;
	}

	public void setIsDead(boolean isDead) {
		this.isDead = isDead;
	}
	
}
