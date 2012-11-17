package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import ball.MainBall;

public class BallFrameAL implements MouseListener, KeyListener, MouseMotionListener
{
	private BallFrame bl;
	public BallFrameAL(JFrame jp, BallFrame bl)
	{
		this.bl = bl;
		jp.addMouseListener(this);
		jp.addKeyListener(this);
		jp.addMouseMotionListener(this);
	}
	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		bl.addBall(new MainBall(arg0.getX(), arg0.getY(), bl.getWidth(), bl.getHeight()));
		bl.repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		//left
		if (arg0.getKeyCode() == 37)
				bl.getmP().setPosX(bl.getmP().getPosX() -25);
		//right
		if (arg0.getKeyCode() == 39)
				bl.getmP().setPosX(bl.getmP().getPosX() +25);
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		bl.getmP().setPosX(arg0.getX() - 50);
	}
	
	//Not Used
	@Override
	public void mouseClicked(MouseEvent arg0){}

	@Override
	public void mouseEntered(MouseEvent arg0){}

	@Override
	public void mouseExited(MouseEvent arg0){}

	@Override
	public void mousePressed(MouseEvent arg0){}

	@Override
	public void keyReleased(KeyEvent arg0){}

	@Override
	public void keyTyped(KeyEvent arg0){}

	@Override
	public void mouseDragged(MouseEvent arg0){}
}
