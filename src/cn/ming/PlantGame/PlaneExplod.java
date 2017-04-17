package cn.ming.PlantGame;

import java.awt.Graphics;
import java.awt.Image;

import GameUtil.GameUtil;

public class PlaneExplod {

	double x,y;
	int count;
	static Image imgs[]=new Image[16];
	static {
		for(int i=0;i<16;i++){
			imgs[i]=GameUtil.getImage("ExplodImages/e"+(i+1)+".gif");
		}
	}
	
	public PlaneExplod(double x,double y){
		this.x=x;
		this.y=y;
	}
	
	void draw(Graphics g){
		if(count<15){
		g.drawImage(imgs[count], (int)x, (int)y, null);
		count++;
		}
	}
	public PlaneExplod(){}
	
}
