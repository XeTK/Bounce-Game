package functions;

import java.awt.Color;

public class RandomNess
{
	public static Color RandomColour()
	{
		int r = 1 + (int)(Math.random() * ((10 - 1) + 1));
		if (r ==1)
		{
			return Color.blue;
		}
		else if (r ==2)
		{
			return Color.cyan;
		}
		else if (r ==3)
		{
			return Color.green;
		}
		else if (r == 4)
		{
			return Color.magenta;
		}
		else if (r == 5)
		{
			return Color.orange;
		}
		else if (r == 6)
		{
			return Color.pink;
		}
		else if (r == 7)
		{
			return Color.red;
		}
		else if (r == 8)
		{
			return Color.white;
		}
		else if (r == 9)
		{
			return Color.yellow;
		}
		else
		{
			return Color.cyan;
		}
	}
}
