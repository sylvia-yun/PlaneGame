package cn.ming.PlantGame;

import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {

	Image img;  //�ӵ�ͼƬ
	double x,y;//�ӵ�λ��
	int width;
	int height;
	double speed; //�ӵ��ٶ�
	double degree; //�ӵ�ƫ�ƵĽǶ�

	
	//�õ����ζ���
	public Rectangle getRect(){
		return new Rectangle((int)x,(int)y,width,height);
	}
}
