package block;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MainBlock
{
	private int posX = 0, posY = 0, width = 50, height = 25, stength = 2;
	private Boolean dead = false, dieing = false, selected = false, flash = false;
	private Color colour = functions.RandomNess.RandomColour();
	public MainBlock(int posX, int posY)
	{
		this.posX = posX;
		this.posY = posY;
	}

	//reg collision
//	public void Collision()
//	{
//		colour = functions.RandomNess.RandomColour();
//		stength = stength - 1;
//		if (stength == 0)
//			dead = true;
//	}
	//Falling blocks
	public void Collision()
	{
		colour = functions.RandomNess.RandomColour();
		stength = stength - 1;
		if (stength == 0)
			dieing = true;
	}
	public void draw(Graphics g)
	{
		if (selected)
		{
			flash = !flash;
			if (flash)
				g.setColor(Color.red);
			else
				g.setColor(Color.white);
		}
		else
		{
			g.setColor(colour);
		}
		g.fill3DRect(posX, posY, width, height, true);
		//g.fillRect(posX, posY, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(posX, posY, width, height);
		if (dieing)
		{
			posY += + 10;
			if (posY >= 1000)
				dead = true;
		}
	}

	public int getPosX()
	{
		return posX;
	}

	public void setPosX(int posX)
	{
		this.posX = posX;
	}

	public int getPosY()
	{
		return posY;
	}

	public void setPosY(int posY)
	{
		this.posY = posY;
	}

	public Color getColour()
	{
		return colour;
	}

	public void setColour(Color colour)
	{
		this.colour = colour;
	}

	public Boolean isDead()
	{
		return dead;
	}
	
	protected int getWidth()
	{
		return width;
	}

	protected void setWidth(int width)
	{
		this.width = width;
	}

	protected int getHeight()
	{
		return height;
	}

	protected void setHeight(int height)
	{
		this.height = height;
	}

	public Rectangle getBounds()
	{
		return new Rectangle(posX, posY, width, height);
	}

	public Boolean getSelected()
	{
		return selected;
	}

	public void setSelected(Boolean selected)
	{
		this.selected = selected;
	}
}
