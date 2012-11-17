package ball;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import block.*;

public class MainBall
{
	private int posX = 0, posY = 0, width = 10, height = 10, directionX = 1,
			directionY = 1, maxBoundRight = 1920, maxBoundBottom = 1080;
	private boolean alive = true;
	private Color ballColour = Color.ORANGE;

	public void movement()
	{
		if (posX > maxBoundRight)
			directionX = -(1 + (int)(Math.random() * ((5 - 1) + 1)));
		if (posX < 0)
			directionX = +(1 + (int)(Math.random() * ((5 - 1) + 1)));
		if (posY > maxBoundBottom)
			alive = false;
		if (posY < 0)
			directionY = +(1 + (int)(Math.random() * ((5 - 1) + 1)));
		posX += +directionX;
		posY += +directionY;
	}

	public void collision(MainBlock mB)
	{
		if (mB.getPosX() > posX)
			directionX = flipDir(directionX);
		if (mB.getPosX() < posX)
			directionX = flipDir(directionX);
		if (mB.getPosY() > posY)
			directionY = flipDir(directionY);
		if (mB.getPosY() < posY)
			directionY = flipDir(directionY);
		if (!(mB instanceof MainPaddle))
			mB.Collision();

	}
	public int flipDir(int in)
	{
		if (in < 0)
			return +(1 + (int)(Math.random() * ((5 - 1) + 1)));
		return -(1 + (int)(Math.random() * ((5 - 1) + 1)));
	}
	
	private void findNearestWall(int posY, int posX)
	{
		if (posX > maxBoundRight / 2)
			directionY = +1;
		else
			directionY = -1;
		if (posY > maxBoundBottom / 2)
			directionX = +1;
		else
			directionX = -1;
	}

	public MainBall(int posX, int posY,int maxBoundRight, int maxBoundBottom)
	{
		this.posX = posX;
		this.posY = posY;
		this.maxBoundRight = maxBoundRight;
		this.maxBoundBottom = maxBoundBottom;
		findNearestWall(posX, posY);
	}

	public void draw(Graphics g)
	{
		g.setColor(ballColour);
		g.fillOval(posX, posY, width, height);
		g.setColor(Color.BLACK);
		g.drawOval(posX, posY, width, height);
	}

	// get sets
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

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getDirectionX()
	{
		return directionX;
	}

	public void setDirectionX(int directionX)
	{
		this.directionX = directionX;
	}

	public int getDirectionY()
	{
		return directionY;
	}

	public void setDirectionY(int directionY)
	{
		this.directionY = directionY;
	}

	public Rectangle getBounds()
	{
		return new Rectangle(posX, posY, width, height);
	}

	public int getMaxBoundRight()
	{
		return maxBoundRight;
	}

	public void setMaxBoundRight(int maxBoundRight)
	{
		this.maxBoundRight = maxBoundRight;
	}

	public int getMaxBoundBottom()
	{
		return maxBoundBottom;
	}

	public void setMaxBoundBottom(int maxBoundBottom)
	{
		this.maxBoundBottom = maxBoundBottom;
	}

	public Color getBallColour()
	{
		return ballColour;
	}

	public void setBallColour(Color ballColour)
	{
		this.ballColour = ballColour;
	}

	public boolean isAlive()
	{
		return alive;
	}

}
