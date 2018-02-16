import javax.swing.JPanel;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.geom.AffineTransform;
//import java.awt.Color;
import java.awt.*;


public class DrawPanel extends JPanel
{
	State state = new State();
	Graphics2D g2;
	//FlowField flow = new FlowField();
	int counter;
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
	        	System.out.println("mouse pressed on drawpanel");
	        	if(javax.swing.SwingUtilities.isRightMouseButton(e))
	        	{
	        		//System.out.println("right mouse clicked");
	        	}
	        	if(javax.swing.SwingUtilities.isLeftMouseButton(e))
	        	{
		        	if(state.mouseX <= state.monsterX+64  && state.mouseX >= state.monsterX && state.mouseY <= state.monsterY+64 && state.mouseY >= state.monsterY)
		        	{
		        		//state.monsterSelected = true;
		        	}
		        	else
		        	{
		        		//state.monsterSelected = false;
		        	}
		        	System.out.println(state.monsterSelected);
	        	}

	        	
	        }

	        public void mouseReleased(java.awt.event.MouseEvent e)
	        {
	        	if(javax.swing.SwingUtilities.isRightMouseButton(e))
	        	{
	        		//System.out.println("right mouse released");
	        		if(state.monsterSelected == true)
	        		{
	        			state.monsterXDestination = state.mouseX;
	        			state.monsterYDestination = state.mouseY;
	        			if(state.mouseX <= state.monsterX+64  && state.mouseX >= state.monsterX && state.mouseY <= state.monsterY+64 && state.mouseY >= state.monsterY)
			        	{
			        		//state.monsterMoving = false;
			        		//state.monsterXReached = true;
			        		//state.monsterYReached = true;
			        	}
			        	else
			        	{
			        		//state.down=false;
			        		//state.right=false;
			        		//state.up=false;
			        		//state.left=false;
			        		//state.monsterMoving = true;
			        		//state.monsterXReached = false;
			        		//state.monsterYReached = false;
			        		//determineDirection();
			        	}
	        		}
	        	}   	
	        }
	    });

	    addMouseMotionListener(new java.awt.event.MouseAdapter()
	    {
	            public void mouseMoved(java.awt.event.MouseEvent e)
	            {
	            	state.mouseX = e.getX();
        			state.mouseY = e.getY();
        			//System.out.println(state.mouseX);
        			//System.out.println(state.mouseY);
	            }

	            public void mouseDragged(java.awt.event.MouseEvent e)
	            {

	            }
	    });
	}

	void determineDirection()
    {
    	System.out.println("XDest = " + state.monsterXDestination);
    	System.out.println("YDest = " + state.monsterYDestination);
    	if(state.monsterYCenter < state.monsterYDestination)
    	{
    		state.down = true;
    		System.out.println("d");
    	}
    	if(state.monsterXCenter < state.monsterXDestination)
    	{
    		state.right = true;
    		System.out.println("r");
    	}
    	if(state.monsterYCenter > state.monsterYDestination)
    	{
    		state.up = true;
    		System.out.println("u");
    	}
    	if(state.monsterXCenter > state.monsterXDestination)
    	{
    		state.left = true;
    		System.out.println("l");
    	}
    }
    int x;
    int y;
    int count;
    protected void paintComponent(Graphics g)
    {
        g.drawImage(state.bg, 0, 0, null);
        
        //AffineTransform oldAT = g2.getTransform();
        g.setColor(Color.YELLOW);
       	g2 = (Graphics2D)g;
       	g2.setStroke(new BasicStroke(3));
       	//System.out.println("hello");
        for(int i = 0; i < 12; i++)
        {
        	for(int j  = 0; j < 16; j++)
        	{
        		x = (j*100);//+50;
        		y = (i*100);//+50;
        		//g.drawLine(x, y, x, y);
        		g.fillOval(x+43, y+43, 15, 15);
        		
        		//state.f.generateFlow();
        		switch(state.flow.grid[i][j])
        		{
        			case 1:
        			{
 						//right
 						count++;
        		//System.out.println("Count: " + count);
 						//System.out.println("hello");
        				g2.drawLine(x+50, y+50, x+75, y+50);
        				break;
        			}
        			case 2:
        			{
        				//left
        				g2.drawLine(x+50, y+50, x+25, y+50);
        				break;
        			}
        			case 3:
        			{
        				//down
        				g2.drawLine(x+50, y+50, x+50, y+75);
        				break;
        			}
        			case 4:
        			{
        				//up
        				g2.drawLine(x+50, y+50, x+50, y+25);
        				break;
        			}
        			case 5:
        			{
        				//up right
        				g2.drawLine(x+50, y+50, x+75, y+25);
        				break;
    				}
        			case 6:
        			{
        				//up left
        				g2.drawLine(x+50, y+50, x+25, y+25);
        				break;
        			}
        			case 7:
        			{
        				//down right
        				g2.drawLine(x+50, y+50, x+75, y+75);
        				break;
        			}
        			case 8:
        			{
        				//down left
        				g2.drawLine(x+50, y+50, x+25, y+75);
        				break;
        			}
        			//System.out.println("state grid ij" + state.f.grid[i][j]);
        		}
        	}
        }
        //g.drawImage(state.rock, state.rockX, state.rockY, null);
        if(state.monsterSelected == true)
        {
        	g.drawImage(state.smallselection, state.monsterX, state.monsterY, null);
        }
    	g.drawImage(state.monster, state.monsterX, state.monsterY, null);
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