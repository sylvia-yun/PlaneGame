package GameUtil;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
/*
 * @ming
 */
import java.awt.event.WindowEvent;

/*
 * 启动界面
 */
public class GameFrame extends Frame{
	
//	Image image=GameUtil.getImage("images/img.jpg"); //利用定义好的工具类，加载图片进来
	
	/*
	 * 加载窗口
	 */
	
	
	public void launchFrame(){ //设置启动窗口界面
		setSize(800,600); //设置上下大小
		setLocation(200,100);//设置窗口位置
		setVisible(true); //设置窗口可见
		
		
		new PaintThread().start(); //启动重画
		//添加窗口监听事件，可以关闭窗口
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
	
	//定义两个坐标值
	//private double x=100,y=100;
	
	
/*
 * 绘图
 * @see java.awt.Window#paint(java.awt.Graphics)
 */
//	@Override
//	public void paint(Graphics g) {
//
//		Font f=new Font("宋体", Font.BOLD,100);
//		g.setFont(f);
//		g.drawRect(100, 100, 200, 200);
//		g.drawString("师兄好", 200, 200);
//		//g.drawImage(image, (int)x,(int)y,null);
//		x+=3;
//		
//	}
	/*
	 * 抓取抛出的异常，延迟40s启动
	 */
	class PaintThread extends Thread{
		public void run(){
			while(true){
				repaint();
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
