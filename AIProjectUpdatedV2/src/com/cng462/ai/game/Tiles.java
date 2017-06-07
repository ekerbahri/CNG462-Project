package com.cng462.ai.game;

public class Tiles {
	int safe=0;
	int unsafe=0;
	int red=0;
	int purple=0;
	int yellow=0;
	int doubt_purple=0;
	int doubt_red=0;
	String env;
	int num=0;
	int br=0;
	int bl=0;
	int bu=0;
	int bd=0;
	int visited=0;
	int l,r,u,d;
	String back="";
	Tiles(String s,int n)
	{
	env=s;
	num=n;
	l=r=u=d=0;
	if(n==9 || n==5)
	bl=1;

	if(n==8 || n==12)
	br=1;

	if(n==1)
	{
	bu=1;bl=1;
	}
	if(n==13)
	{
	bd=1;bl=1;
	}
	if(n==4)
	{
	bu=1;br=1;
	}
	if(n==16)
	{
	bd=1;br=1;
	}

	}

	int sense()
	{
	if(env.contains("PL"))
	return 1;
	else
	if(env.contains("RL"))
	return 2;
	else
	if(env.contains("YL"))
	return 3;
	if(env.contains("M(*)"))
	return 4;
	else
	return 0;
	}

}
