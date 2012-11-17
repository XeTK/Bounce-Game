package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MainMenu extends JPanel
{
	private int width =0, height = 0;
	public MainMenu(int width,int height)
	{
		this.width = width;
		this.height = height;
		setSize(width, height);
	}
	public void paintComponent(Graphics g)
	{
		
	}
}
