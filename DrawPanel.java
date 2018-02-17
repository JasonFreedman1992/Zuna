import javax.swing.JPanel;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.geom.AffineTransform;
//import java.awt.Color;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.AffineTransform;


public class DrawPanel extends JPanel //implements MouseMotionListener
{
	State state = new State();
	Graphics2D g2;
	//FlowField flow = new FlowField();
	int counter;
	boolean suh = false;
	public DrawPanel()
	{
		//state.flow.generateFlow();
		addMouseListener(new java.awt.event.MouseAdapter()
	    {
	        public void mouseClicked(java.awt.event.MouseEvent e) 
	        {

	        }
	        public void mousePressed(java.awt.event.MouseEvent e)
	        {
	        	// if(javax.swing.SwingUtilities.isRightMouseButton(e))
	        	// {

	        	// }
	        	// if(javax.swing.SwingUtilities.isLeftMouseButton(e))
	        	// {
	        	 	state.mouseClicked = true;
		        // 	if(state.mouseX <= state.monsterX+64  && state.mouseX >= state.monsterX && state.mouseY <= state.monsterY+64 && state.mouseY >= state.monsterY)
		        // 	{
		        // 		//state.monsterSelected = true;
		        // 	}
		        // 	else
		        // 	{
		        // 		//state.monsterSelected = false;
		        // 	}
	        	// }

	        	
	        }

	        public void mouseReleased(java.awt.event.MouseEvent e)
	        {
	        	// if(javax.swing.SwingUtilities.isRightMouseButton(e))
	        	// {
	        	// 	if(state.monsterSelected == true)
	        	// 	{
	        	// 		state.monsterXDestination = state.mouseX;
	        	// 		state.monsterYDestination = state.mouseY;
	        	// 		if(state.mouseX <= state.monsterX+64  && state.mouseX >= state.monsterX && state.mouseY <= state.monsterY+64 && state.mouseY >= state.monsterY)
			       //  	{

			       //  	}
			       //  	else
			       //  	{

			       //  	}
	        	// 	}
	        	// }   	
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
        			double dX = state.mouseX-50 - 800;
 					double dY = state.mouseY-50 - 600;
 					System.out.println((Math.atan2(dY, dX))/Math.PI);
	            }

	            public void mouseDragged(java.awt.event.MouseEvent e)
	            {

	            }
	    });
	}
	double imageAngleRad;
    int x;
    int y;
    int count;
    protected void paintComponent(Graphics g)
    {
    	if(!suh)
    	{
        	g.drawImage(state.bg, 0, 0, null);
        	suh=true;
        }
        g.drawImage(state.bg, 0, 0, null);
        g.setColor(Color.YELLOW);
       	g2 = (Graphics2D)g;
       	g2.setStroke(new BasicStroke(3));
        for(int i = 0; i < 12; i++)
        {
        	for(int j  = 0; j < 16; j++)
        	{
        		x = (j*100);//+50;
        		y = (i*100);//+50;
        		
        		//
        		// use center of image
        		// 
        		g.fillOval(x+43, y+43, 15, 15);
        		AffineTransform oldAT = g2.getTransform();
 				double dX = state.mouseX-50 - x;
 				double dY = state.mouseY-50 - y;
 				imageAngleRad = Math.atan2(dY, dX);
 				state.flow.grid[i][j] = imageAngleRad/Math.PI;
 				//state.imageAngleRad = imageAngleRad; //;
 				//System.out.println(imageAngleRad);
 				g2.rotate(imageAngleRad, x+50, y+50);
        		g2.drawImage(state.line, x+50, y+50, null);
        		g2.setTransform(oldAT);		
        	}
        }
        if(state.monsterSelected == true)
        {
        	g.drawImage(state.smallselection, state.monster.X, state.monster.Y, null);
        }
    	g.drawImage(state.cube, state.monster.X, state.monster.Y, null);
    	g2.setStroke(new BasicStroke(4));
    	g2.setColor(Color.RED);
    	g2.drawLine(800, 600, 800, 600);
    	g2.drawLine(state.monster.XCenter, state.monster.YCenter, state.monster.XCenter, state.monster.YCenter);
    	//g.drawImage(state.smallselection, state.monsterX, state.monsterY, null);

    }

    public void updatePaint()
    {

    }


    public void save()// throws IOException
    {
        //ImageIO.write(paintImage, "PNG", new File("Board.png"));
    }

}