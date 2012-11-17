package gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import block.MainBlock;

public class EditFrameAL implements MouseListener, KeyListener, MouseMotionListener
{
	private EditFrame eF;
	private MainFrame jP;
	private boolean delMode = false,
					editMode = false;
	private MainBlock selectedBlock = null;
	public EditFrameAL(MainFrame jp, EditFrame eF)
	{
		this.jP = jp;
		this.eF = eF;
		jp.addMouseListener(this);
		jp.addMouseMotionListener(this);
		jp.addKeyListener(this);
	}
	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub
		if (!editMode)
		{
			if (!delMode)
			{
				eF.addBrick(e.getX() - 10, e.getY() - 15);
			}
			else
			{
				eF.removeBlock(eF.findBrick(e.getX() - 10, e.getY() - 15));
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		//P
		if (arg0.getKeyCode() == 80)
		{
			if (selectedBlock != null)
				selectedBlock.setSelected(false);
			selectedBlock = null;
			delMode = false;
			editMode = false;
			jP.remove(eF);
			jP.removeKeyListener(this);
			jP.removeMouseListener(this);
			jP.removeMouseMotionListener(this);
			jP.playGame(eF.getmBlL());
			jP.repaint();
		}
		//A
		if (arg0.getKeyCode() == 65)
		{
			if (selectedBlock != null)
				selectedBlock.setSelected(false);
			selectedBlock = null;
			delMode = false;
			editMode = false;
		}
		//D
		if (arg0.getKeyCode() == 68)
		{
			if (selectedBlock != null)
				selectedBlock.setSelected(false);
			selectedBlock = null;
			delMode = !delMode;
			editMode = false;
		}
		//E
		if (arg0.getKeyCode() == 69)
		{
			editMode = !editMode;
			delMode = false;
		}
		//UP
		if (editMode&& arg0.getKeyCode() == 38)
		{
			eF.shiftUp(selectedBlock);
		}
		//DOWN
		if (editMode&& arg0.getKeyCode() == 40)
		{
			eF.shiftDown(selectedBlock);
		}
		//LEFT
		if (editMode&& arg0.getKeyCode() == 37)
		{
			eF.shiftLeft(selectedBlock);
		}
		//RIGHT
		if (editMode&& arg0.getKeyCode() == 39)
		{
			eF.shiftRight(selectedBlock);
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		//LeftClick
		if (e.getButton() == MouseEvent.BUTTON1&&!delMode)
		{
			if (delMode)
				eF.removeBlock(eF.findBrick(e.getX() - 10, e.getY() - 15));
			else if (editMode)
				selectedBlock(eF.findBrick(e.getX() - 10, e.getY() - 15));
			else
				eF.addBrick(e.getX() - 10, e.getY() - 15);
		}
		//RightClick
		else if (e.getButton() == MouseEvent.BUTTON3)
		{
			//eF.removeBlock(eF.findBrick(e.getX() - 10, e.getY() - 15));
		}
	}
	public void selectedBlock(MainBlock mB)
	{
		if (mB != null)
		{
			if (selectedBlock != null)
				selectedBlock.setSelected(false);
			selectedBlock = mB;
			selectedBlock.setSelected(true);
		}
	}
}
