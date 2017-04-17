package cn.ming.PlantGame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import GameUtil.GameUtil;

public class Plane extends GameObject{


	boolean left,right,up,down;
	private boolean live=true;

	public Plane(String imgpath, double x, double y,double speed) {
		super();
		this.img = GameUtil.getImage(imgpath);
		this.width=img.getWidth(null);
		this.height=img.getHeight(null);
		this.x = x;
		this.y = y;
		this.speed=speed;
	}
	//空构造器
	public Plane(){}
	
	//画法
	void draw(Graphics g){
//		if(x>30&&x<870){
//			if(y>30&&x<670){
//				planeMove();
//			}
//		}
		g.drawImage(img, (int)x, (int)y, null);
		if(x<10){
			left=false;
		}
		if(y<40){
			up=false;
		}
		if(x>725){
			right=false;
		}
		if(y>555){
			down=false;
		}
		planeMove();
	}
	
	//飞机移动方法
	void planeMove(){
		
		if(left){
			x -=speed;
		}
		if(right){
			x +=speed;
		}
		if(up){
			y -=speed;
		}
		if(down){
			y +=speed;
		}
	
	}
	
	//添加键盘控制的方向
	void addDirect(KeyEvent e){
		switch (e.getKeyCode()) {
		case 37:
			left=true;
			break;
		case 38:
			up=true;
			break;
		case 39:
			right=true;
			break;
		case 40:
			down=true;
			break;

		default:
			break;
		}
	}
	//键盘弹起时的处理
	void minusDirect(KeyEvent e){
		switch (e.getKeyCode()) {
		case 37:
			left=false;
			break;
		case 38:
			up=false;
			break;
		case 39:
			right=false;
			break;
		case 40:
			down=false;
			break;

		default:
			break;
		}
	}
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	
	
}
