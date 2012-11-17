package block;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MainPaddle extends MainBlock
{
	public MainPaddle(int posX, int posY)
	{
		super(posX, posY);
		this.setHeight(25);
		this.setWidth(100);
		this.setColour(Color.red);
		// TODO Auto-generated constructor stub
	}
}

