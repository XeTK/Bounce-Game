package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import player.PlayerObject;

import levels.Level;
import levels.Level1;

import ball.MainBall;
import block.MainBlock;
import block.MainPaddle;

public class BallFrame extends JPanel
{
	private ArrayList<MainBall> mBaL = new ArrayList<MainBall>();
	private ArrayList<MainBlock> mBlL = new ArrayList<MainBlock>();
	private PlayerObject currentPlayer = new PlayerObject("Tom");
	private MainPaddle mP;
	private int width = 0, height = 0;

	public BallFrame(int width, int height)
	{
		this.width = width;
		this.height = height;
		setSize(width, height);
		mP = new MainPaddle(width /2 + 50, height - 110);
		//buildLevel();
		//buildAutoLevel();
	}

	public void paintComponent(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(0, 0, width, height);
		ballLife();
		super.paintComponents(g);
		for (int i = 0; i < mBaL.size(); i++)
			mBaL.get(i).draw(g);
		for (int i = 0; i < mBlL.size(); i++)
			mBlL.get(i).draw(g);
		g.setColor(Color.BLACK);
		g.fill3DRect(5, height - 110, 175, 70, true);
		g.setColor(Color.WHITE);
		g.drawRect(5, height - 110, 175, 70);
		g.drawString("Players Score: " + currentPlayer.getScore(), 10, height - 50);
		g.drawString("Balls Lost : " + currentPlayer.getBallsLost(), 10, height - 70);
		g.drawString("Players Name : " + currentPlayer.getName(), 10, height - 90);
		mP.draw(g);
		repaint();
	}

	public void addBall(ArrayList<MainBall> aLMB)
	{
		for (int i = 0; i < aLMB.size(); i++)
			mBaL.add(aLMB.get(i));
		repaint();
	}

	public void addBall(MainBall mB)
	{
		mBaL.add(mB);
		repaint();
	}

	public void ballLife()
	{
		// speed of game
		try{Thread.sleep(currentPlayer.getPlayLevel());} catch (Exception ex){}
		// movement and death of ball
		for (int i = 0; i < mBaL.size(); i++)
		{
			mBaL.get(i).movement();
			if (!mBaL.get(i).isAlive())
			{
				mBaL.remove(i);
				currentPlayer.setBallsLost(currentPlayer.getBallsLost() + 1);
			}
		}
		// collision detection with bricks
		for (int i = 0; i < mBaL.size(); i++)
		{
			if (mBaL.get(i).getBounds().intersects(mP.getBounds()))
				mBaL.get(i).collision((MainBlock)mP);
		
			for (int j = 0; j < mBlL.size(); j++)
				if (mBaL.get(i).getBounds().intersects(mBlL.get(j).getBounds()))
				{
					mBaL.get(i).collision(mBlL.get(j));
					currentPlayer.setScore(currentPlayer.getScore() + 1);
					if (mBlL.get(j).isDead() == true)
					{
						mBlL.remove(j);
						currentPlayer.setScore(currentPlayer.getScore() + 4);
					}
				}
		}
		repaint();

	}

	public void buildLevel()
	{
		Level[] le = Level1.values();
		for (int i = 0; i < le.length; i++)
			mBlL.add(new MainBlock(le[i].getPosX(), le[i].getPosY()));
		repaint();
	}
	public void buildAutoLevel()
	{
		int blockSizeWidth = 50,
				blockSizeHeight = 25,
				curPosX = 10,
				curPosY = 10,
				lines = 20,
				width = this.width / blockSizeWidth;
		for (int i = 0; i < lines; i++)
		{
			for (int j = 0; j < width;j++)
			{
				mBlL.add(new MainBlock(curPosX,curPosY));
				curPosX += +blockSizeWidth;
			}
			curPosX = 10;
			curPosY += + blockSizeHeight;
		}
	}

	public MainPaddle getmP()
	{
		return mP;
	}

	public void setmP(MainPaddle mP)
	{
		this.mP = mP;
	}

	protected void setmBlL(ArrayList<MainBlock> mBlL)
	{
		this.mBlL = mBlL;
		repaint();
	}
	
}
