import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.AffineTransform;


public class DrawPanel extends JPanel //implements MouseMotionListener
{
	State state = new State();
	Graphics2D g2;
	int density;
	int x_count;
	int y_count;
	public DrawPanel(int p_x_count, int p_y_count, int p_density)
	{
		setDoubleBuffered(true);
		density = p_density;
		x_count = p_x_count;
		y_count = p_y_count;
		addMouseListener(new java.awt.event.MouseAdapter()
	    {
	        public void mouseClicked(java.awt.event.MouseEvent e) 
	        {

	        }
	        public void mousePressed(java.awt.event.MouseEvent e)
	        {


	        	
	        }

	        public void mouseReleased(java.awt.event.MouseEvent e)
	        {
 	
	        }
	    });

	    addMouseMotionListener(new java.awt.event.MouseAdapter()
	    {
	            public void mouseMoved(java.awt.event.MouseEvent e)
	            {
	            	int x = e.getX();
	            	int y = e.getY();
	            	state.mouseX = x;
        			state.mouseY = y;
        			//double dX = state.mouseX - 800;
 					//double dY = state.mouseY - 600;
	            }

	            public void mouseDragged(java.awt.event.MouseEvent e)
	            {

	            }
	    });
	}
	
	double imageAngleRad;
    int x;
    int y;
    
    protected void paintComponent(Graphics g)
    {
		//System.out.println(x_count);
		//System.out.println("y"+y_count);
		g.drawImage(state.bg, 0, 0, null);
		g.setColor(Color.YELLOW);
		g2 = (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));
		for(int i = 0; i < y_count; i++)
		{
			for(int j = 0; j < x_count; j++)
			{
				x = j*density;
				y = i*density;

				//g.fillOval(x-4, y-4, 8, 8);

				AffineTransform oldAT = g2.getTransform();

				double dX = state.mouseX - x;
				double dY = state.mouseY - y;
				imageAngleRad = Math.atan2(dY, dX);

				g2.rotate(imageAngleRad, x, y);

				//g2.drawImage(state.line, x, y, null);

        		g2.setTransform(oldAT);		
			}
		}

		g2.setStroke(new BasicStroke(6));
		if(!state.monsters.isEmpty())
		{
			for(int i = 0; i < state.monsters.size(); i++)
			{
				g2.setColor(state.monsters.get(i).color);
				g2.drawLine(state.monsters.get(i).X, state.monsters.get(i).Y, state.monsters.get(i).X, state.monsters.get(i).Y);
			}
		}
    }

    public void updatePaint()
    {

    }


    public void save()// throws IOException
    {

    }

}