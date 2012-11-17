package gui;

import java.util.ArrayList;

import javax.swing.JFrame;

import block.MainBlock;

public class MainFrame extends JFrame
{
	public MainFrame()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(10, 10);
		setSize(400,400);
		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setName("XeTK Bricks");
		buildLevel();
	}
//	public void playGame()
//	{
//		BallFrame bl = new BallFrame(getWidth(), getHeight());
//		bl.repaint();
//		new BallFrameAL(this, bl);
//		add(bl);
//	}
	public void playGame(ArrayList<MainBlock> aLMB)
	{
		BallFrame bl = new BallFrame(getWidth(), getHeight());
		bl.repaint();
		bl.setmBlL(aLMB);
		new BallFrameAL(this, bl);
		add(bl);
	}
	public void buildLevel()
	{
		EditFrame eF = new EditFrame(getWidth(), getHeight());
		eF.repaint();
		new EditFrameAL(this, eF);
		add(eF);
	}
}
