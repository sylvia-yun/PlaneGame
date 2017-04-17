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
	
	ArrayList bulletlist=new ArrayList();//�Ժ����� ����
	
	
	//����launch����
	public void  launchFrame(){
		super.launchFrame();
		//���ü��̼���
		addKeyListener(new KeyMonitor());
		
		//�����������ó��ӵ�
		for(int i=0;i<50;i++){
			Bullet bu=new Bullet(Constent.WIDTH/2+100,Constent.HEIGHT/2+100,20,20,5);
			bulletlist.add(bu);
		}
		starTime=new Date();
	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	
	//����ͼƬ
	public void paint(Graphics g){
		g.drawImage(bg, 0,0, null);

		
		//���ӵ�������
		for(int i=0;i<20;i++){
			Bullet bu=(Bullet) bulletlist.get(i);
			bu.draw(g);
			//������ײʱ�������¼�
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
				printInfo(g,50,"������ͭ",Color.white,250,300);
				printInfo(g, 30, "��ʱ��"+peride+"��", Color.white, 250, 350);
				break;

			case 1:
				printInfo(g,50,"��������",Color.white,250,300);
				printInfo(g, 30, "��ʱ��"+peride+"��", Color.white, 250, 350);
				break;
			case 2:
				printInfo(g,50,"��ҫ�ƽ�",Color.white,250,300);
				printInfo(g, 30, "��ʱ��"+peride+"��", Color.white, 250, 350);
				break;
			case 3:
				printInfo(g,50,"��ҫ��ʯ",Color.white,250,300);
				printInfo(g, 30, "��ʱ��"+peride+"��", Color.white, 250, 350);
				break;
			default:
				printInfo(g,50,"��ǿ����",Color.white,250,300);
				printInfo(g, 30, "��ʱ��"+peride+"��", Color.white, 250, 350);
				break;
			}
			
		}
		else{
			p.draw(g);
		}
	}
	
	/*
	 * ʵ��˫���弼�����û���ֹͣ����
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
	 * ��ӡ�ɻ���ȥ��ʾ��������Ϣ
	 */
	public void printInfo(Graphics g,int size,String str,Color color,int x,int y){
		Color c=g.getColor();
		g.setColor(color);
		Font f=new Font("����", Font.BOLD, size);
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);
	}
	
	//�½�һ���ڲ��࣬�������ü����ƶ�
	class KeyMonitor extends KeyAdapter{

			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("���£�"+e.getKeyCode());
				p.addDirect(e);
			}
			@Override
			public void keyReleased(KeyEvent e) {
				p.minusDirect(e);
			}
		}
	
}
