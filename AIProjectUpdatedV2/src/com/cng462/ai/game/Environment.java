package com.cng462.ai.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Scanner;

public class Environment extends Canvas implements Runnable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 206, HEIGHT = 229;
	Scanner scr=new Scanner(System.in);
	//char w[][]=new char[5][5];
	int np;     //number of purples
	int rp,yp; // red position   yellow position
	int pos[]; // position of purples
	int pl_pos[]=new int[20];
	int rl_pos[]=new int[20];
	private Handler handler;
	private Thread thread;
	private boolean running = false;
	void accept(String space[][])
	{
		handler = new Handler();
		KeyInputs keyinputs = new KeyInputs(handler);
		this.addKeyListener(keyinputs);
		new Window(this, WIDTH, HEIGHT, "AI Project");
		handler.addObject(new Player(0, 3 * 50, ID.Player));
	for(int i=0;i<20;++i)
	{
	pl_pos[i]=-1;
	rl_pos[i]=-1;
	}

	for(int i=0;i<5;++i)
	for(int j=0;j<5;++j)
	space[i][j]="";

	int count=1;
	System.out.println("\n\n********* Space Conqueror *********\n-by Doðanay Demirten & Bahri Eker.\n");

	System.out.println("The positions are as follows.");
	for(int i=1;i<=4;++i)
	{
	System.out.println("\n-----------------------------------------------------------------");
	System.out.print("|\t");
	for(int j=1;j<=4;++j)
	System.out.print((count++)+"\t|\t");
	}
	System.out.println("\n-----------------------------------------------------------------");
	System.out.println("\nAgent start position: 13");
	space[4][1]="A";
	System.out.println("\nEnter the number of purple enemies.");
	np=scr.nextInt();
	pos=new int[np];
	System.out.println("Positions of purple, yellow and red enemies should not overlap.");
	System.out.println("Enter the position of purple enemies.");
	for(int i=0;i<np;++i)
	{
	pos[i]=scr.nextInt();
	show_sense(pos[i],1,space);
	}
	System.out.println("Enter the position of red enemy.");
	rp=scr.nextInt();
	show_sense(rp,2,space);

	System.out.println("Enter the position of the reward(yellow).");
	yp=scr.nextInt();

	insert(space);
	}

	void insert(String space[][])
	{
	int temp=0;
	int count=0;
	int flag1=0,flag2=0;
	for(int i=0;i<np;++i)
	{
	temp=pos[i];
	count=0;
	for(int j=1;j<=4;++j)
	{
	for(int k=1;k<=4;++k)
	{
	++count;
	if(count==temp)
	{
	space[j][k]+="S(*)";
	handler.addObject(new Player((k-1) * 50, (j-1) * 50, ID.Enemy2));
	}
	else
	if(count==yp && flag1==0)
	{
	space[j][k]+="~*~";
	handler.addObject(new Player((k-1) * 50, (j-1) * 50, ID.Goal));
	flag1=1;
	}
	else
	if(count==rp && flag2==0)
	{
	space[j][k]+="M(*)";
	handler.addObject(new Player((k-1) * 50, (j-1) * 50, ID.Enemy1));
	flag2=1;
	}
	}
	}
	}

	display(space);
	}

	void show_sense(int a,int b,String space[][])
	{
	int t1,t2,t3,t4;
	t1=a-1;
	t2=a+1;
	t3=a+4;
	t4=a-4;

	if(a==5 || a==9)
	t1=0;
	if(a==8 || a==12)
	t2=0;
	if(a==4)
	t2=0;
	if(a==13)
	t1=0;

	if(t3>16)
	t3=0;
	if(t4<0)
	t4=0;

	//int temp[]=new int[4];

	if(b==1)
	{pl_pos[0]=t1;pl_pos[1]=t2;pl_pos[2]=t3;pl_pos[3]=t4;}
	else
	if(b==2)
	{rl_pos[0]=t1;rl_pos[1]=t2;rl_pos[2]=t3;rl_pos[3]=t4;}

	int temp1,count;

	for(int i=0;i<4;++i)
	{
	if(b==1)
	temp1=pl_pos[i];
	else
	temp1=rl_pos[i];
	count=0;
	for(int j=1;j<=4;++j)
	{
	for(int k=1;k<=4;++k)
	{
	++count;
	if(count==temp1 && b==1 && !space[j][k].contains("PL"))
	{
	space[j][k]+="PL";
	
	}
	else
	if(count==temp1 && b==2 && !space[j][k].contains("RL"))
		space[j][k]+="RL";
	}
	}
	}
	 
	//display(w);
	}
	void display(String space[][])
	{
	System.out.println("\nThe environment for problem is as follows.\n");
	for(int i=1;i<=4;++i)
	{
	System.out.println("\n-----------------------------------------------------------------");
	System.out.print("|\t");
	for(int j=1;j<=4;++j)
	System.out.print(space[i][j]+"\t|\t");
	}
	System.out.println("\n-----------------------------------------------------------------");
	}

	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop()
	{
		try
		{
			thread.join();
			running = false;
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void run() // Game Loop
	{
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1)
			{
				tick();
				--delta;
			}
			
			if(running)
			{
				render();
			}
			++frames;
			
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				//System.out.println("FPS: "+frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick()
	{
		handler.tick();
	}
	
	private void render()
	{
		BufferStrategy bS = this.getBufferStrategy();
		
		if(bS == null)
		{
			this.createBufferStrategy(3); //Recommended
			return;
		}
		
		Graphics g = bS.getDrawGraphics();
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		for(int i=0; i<=500; i+=100)
		{
			for(int j=0; j<=500; j+=100)
			{
				g.clearRect(i, j, 50, 50);
			}
		}
		
		for(int i=50; i<=550; i+=100)
		{
			for(int j=50; j<=650; j+=100)
			{
				g.clearRect(i, j, 50, 50);
			}
		}
		
		handler.render(g);
		g.dispose();
		bS.show();
	}
	
	public static int clamp(int val, int min, int max)
	{
		if(val >= max)
			return val = max;
		
		else if(val <= min)
			return val = min;
		
		else
			return val;
	}

}
