package cn.ming.PlantGame;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {

	Image img;  //子弹图片
	double x,y;//子弹位置
	int width;
	int height;
	double speed; //子弹速度
	double degree; //子弹偏移的角度

	
	//得到矩形对象
	public Rectangle getRect(){
		return new Rectangle((int)x,(int)y,width,height);
	}
}
