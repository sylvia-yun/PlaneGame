package cn.ming.PlantGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.print.attribute.standard.PrinterInfo;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.text.StyledEditorKit.ForegroundAction;

import GameUtil.Constent;
import GameUtil.GameFrame;
import GameUtil.GameUtil;

public class PlaneGameFrame extends GameFrame{

	Image bg=GameUtil.getImage("images/bg.jpg");
	Plane p=new Plane("images/plane.png",50,50,10);
	PlaneExplod explod;
	
	Date starTime,endTime;
	//Bullet bu=new Bullet(400,300,20,20,10,0.14,0.14);
	
	ArrayList bulletlist=new ArrayList();//以后再用 泛型
	
	
	//重载launch函数
	public void  launchFrame(){
		super.launchFrame();
		//设置键盘监听
		addKeyListener(new KeyMonitor());
		
		//从数组里面拿出子弹
		for(int i=0;i<50;i++){
			Bullet bu=new Bullet(Constent.WIDTH/2+100,Constent.HEIGHT/2+100,20,20,5);
			bulletlist.add(bu);
		}
		starTime=new Date();
	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	//画出图片
	public void paint(Graphics g){
		g.drawImage(bg, 0,0, null);

		
		//把子弹画出来
		for(int i=0;i<20;i++){
			Bullet bu=(Bullet) bulletlist.get(i);
			bu.draw(g);
			//设置碰撞时发生的事件
			boolean peng=bu.getRect().intersects(p.getRect());
			if(peng){
				p.setLive(false);
				
				if(explod==null){
					endTime=new Date();
					explod=new PlaneExplod(p.x, p.y);
				}
				explod.draw(g);
			}
		}
		

		if(!p.isLive()){
			int peride=(int)((endTime.getTime()-starTime.getTime())/1000);
			switch (peride/10) {
			case 0:
				printInfo(g,50,"菜鸟青铜",Color.white,250,300);
				printInfo(g, 30, "用时："+peride+"秒", Color.white, 250, 350);
				break;

			case 1:
				printInfo(g,50,"不屈白银",Color.white,250,300);
				printInfo(g, 30, "用时："+peride+"秒", Color.white, 250, 350);
				break;
			case 2:
				printInfo(g,50,"荣耀黄金",Color.white,250,300);
				printInfo(g, 30, "用时："+peride+"秒", Color.white, 250, 350);
				break;
			case 3:
				printInfo(g,50,"闪耀钻石",Color.white,250,300);
				printInfo(g, 30, "用时："+peride+"秒", Color.white, 250, 350);
				break;
			default:
				printInfo(g,50,"最强王者",Color.white,250,300);
				printInfo(g, 30, "用时："+peride+"秒", Color.white, 250, 350);
				break;
			}
			
		}
		else{
			p.draw(g);
		}
	}
	
	/*
	 * 实现双缓冲技术，让画面停止闪动
	 */
	private Image offScreenImage=null;
	public void update(Graphics g){
		if(offScreenImage==null){
			offScreenImage=this.createImage(Constent.WIDTH*2,Constent.HEIGHT*2);
		}
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}

	
	/*
	 * 打印飞机死去显示出来的信息
	 */
	public void printInfo(Graphics g,int size,String str,Color color,int x,int y){
		Color c=g.getColor();
		g.setColor(color);
		Font f=new Font("宋体", Font.BOLD, size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	
	//新建一个内部类，用来设置键盘移动
	class KeyMonitor extends KeyAdapter{

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("按下："+e.getKeyCode());
				p.addDirect(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				p.minusDirect(e);
			}
		}
	
}
