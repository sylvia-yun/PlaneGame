package cn.ming.PlantGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.management.remote.SubjectDelegationPermission;

import GameUtil.GameUtil;

public class Bullet extends GameObject{
	

	public Bullet(double x, double y,int width,int height,double speed) 
	{
		super();
		//this.img = GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
		this.width=width;
		this.height=height;
		this.speed = speed;
		this.degree = Math.random()*Math.PI*2;
	}
	public Bullet(){}  //定义空的构造器，防止出错
	
	void draw(Graphics g){
		Color c=g.getColor();
		
		g.setColor(Color.yellow);
		g.fillOval((int)x,(int)y, (int)width, (int)height);
		g.setColor(c);
		

//		if(speed>0){
//			speed-=0.1;
//			}
//		else{
//			speed=0;
//		}
		
		x+=speed*Math.cos(degree);
		y+=speed*Math.sin(degree);
		
		if(x>770||x<0){
			degree=Math.PI-degree;
		}
		if(y>580||y<30){
			degree=-degree;
		}
		
	}
	
	

}
