package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

import block.MainBlock;

public class EditFrame extends JPanel
{
	private ArrayList<MainBlock> mBlL = new ArrayList<MainBlock>();
	private int width =0, height = 0;
	public EditFrame(int width,int height)
	{
		this.width = width;
		this.height = height;
		setSize(width, height);
	}
	public void paintComponent(Graphics g)
	{
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, width, height);
		drawGrid(g);
		for (int i = 0; i< mBlL.size();i++)
			mBlL.get(i).draw(g);
		repaint();
	}
	public MainBlock findBrick(int posX, int posY)
	{
		for (int i = 0; i < mBlL.size();i++)
		{
			if (mBlL.get(i).getBounds().intersects((new Rectangle(posX,posY,10,10).getBounds())))
				return mBlL.get(i);
		}
		return null;
	}
	public void addBrick(int posX, int posY)
	{
		MainBlock tempBlock = brickGrid(new MainBlock(posX,posY));
			for (int i = 0; i < mBlL.size();i++)
				if (tempBlock != null)
					if(tempBlock.getBounds().intersects(mBlL.get(i).getBounds()))
						tempBlock = null;
		
		if (tempBlock != null)
			mBlL.add(tempBlock);
		repaint();
	}
	public void removeBlock(MainBlock mB)
	{
		if (mB != null)
			mBlL.remove(mB);
		repaint();
	}
	public MainBlock brickGrid(MainBlock mB)
	{
		int maxBricksX = (width - 20) / 50;
		int maxBricksY = (height / 4 * 3) / 25;
		for (int i = 0; i <= maxBricksX;i++)
		{
			if ((i * 50) + 10 > mB.getPosX())
			{
				mB.setPosX(((i - 1) * 50) + 10);
				break;
			}
		}
		for (int i = 0; i <= maxBricksY;i++)
		{
			if ((i * 25) + 10 > mB.getPosY())
			{
				mB.setPosY(((i - 1) * 25) + 10);
				break;
			}
		}
		if (mB.getPosX() > (maxBricksX) * 50 + 10)
			return null;
		if (mB.getPosY() > (maxBricksY) * 25 + 10)
			return null;
		return mB;
	}
	public void drawGrid(Graphics g)
	{
		int maxBricksX = (width - 20) / 50;
		int maxBricksY = (height / 4 * 3) / 25;
		g.setColor(Color.white);
		for (int i = 0; i <= maxBricksX;i++)
			g.drawLine((i * 50) + 10, 10, (i * 50) + 10, (maxBricksY * 25) + 10);
		for (int i = 0; i <= maxBricksY;i++)
			g.drawLine(10, (i * 25) + 10, (maxBricksX * 50) + 10, (i * 25) + 10);
	}
	protected ArrayList<MainBlock> getmBlL()
	{
		return mBlL;
	}
	protected void setmBlL(ArrayList<MainBlock> mBlL)
	{
		this.mBlL = mBlL;
	}
	public void shiftRight(MainBlock mB)
	{
		if (findBrick(mB.getPosX() + 50 ,mB.getPosY()) == null);
			mB.setPosX(mB.getPosX() + 50);
		repaint();
	}
	public void shiftLeft(MainBlock mB)
	{
		if (findBrick(mB.getPosX() - 50 ,mB.getPosY()) == null);
			mB.setPosX(mB.getPosX() - 50);
		repaint();
	}
	public void shiftUp(MainBlock mB)
	{
		if (findBrick(mB.getPosX(),mB.getPosY() - 25) == null);
			mB.setPosY(mB.getPosY() - 25);
		repaint();
	}
	public void shiftDown(MainBlock mB)
	{
		if (findBrick(mB.getPosX(),mB.getPosY() + 25) == null);
			mB.setPosY(mB.getPosY() + 25);
		repaint();
	}
}
