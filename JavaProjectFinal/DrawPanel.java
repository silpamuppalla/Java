import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class DrawPanel extends JPanel implements MouseMotionListener, MouseListener
{
                ArrayList<Line> linelist;
                int lastX, lastY;
                Client container;
				JLabel um;
	
	public DrawPanel()
	{
	}

	public DrawPanel(final Client container)
	{
		setBackground(Color.WHITE);
		linelist = new ArrayList<Line>();
		addMouseMotionListener(this);
		addMouseListener(this);
		this.container = container;
        um = new JLabel("WHITE BOARD");
		um.setForeground(new java.awt.Color(0,0,255));
        add(um, BorderLayout.NORTH);
		
	}

	public void mouseMoved(MouseEvent me)
	{
	}

	public void mouseDragged(MouseEvent me)
	{
		int endX = me.getX();
		int endY = me.getY();
		Line line = new Line(lastX, lastY, endX, endY);
		linelist.add(line);
		lastX = endX;
		lastY = endY;
		repaint();
	}

	public void mouseEntered(MouseEvent me)
	{
	}

	public void mouseExited(MouseEvent me)
	{
	}

	public void mousePressed(MouseEvent me)
	{
		lastX = me.getX();
		lastY = me.getY();
	}

	public void mouseReleased(MouseEvent me)
	{
	}

	public void mouseClicked(MouseEvent me)
	{
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Iterator<Line> it = linelist.iterator();
		while(it.hasNext())
			{
			Line current = it.next();
			g.drawLine(current.getStartX(), current.getStartY(),
				   current.getEndX(), current.getEndY());
			};
	}

	public Dimension getPreferredSize()
	{
		return new Dimension(300,100);
	}

	public Dimension getMinimumSize()
	{
		return new Dimension(300,100);
	}
}