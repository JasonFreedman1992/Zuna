import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.util.Scanner;


public class Window extends JFrame
{
	State state = new State();
	Controller control = new Controller();

	JPanel panel;
	Graphics g;
	Graphics2D g2;
	//Scanner console = new Scanner(System.in);
	Timer timer = new Timer(30, new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			
			panel.setSize(state.width, state.height);
			panel.repaint();
			state.update();
			
							
			//String s = console.next();
			//chew();
		}
	});

	public void init(int p_width, int p_height)
	{
		setTitle("Zuna RTS");
		setSize(p_width, p_height);
		state.width = p_width;
		state.height = p_height;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(p_width, p_height));
		//setMinimumSize(new java.awt.Dimension(1600, 1200));
		setMaximumSize(new java.awt.Dimension(p_width, p_height));
		setVisible(true);
		addKeyListener(control);
		loadImages();
		initPanel();
		add(panel);
		//state.f.generateFlow();
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 11; j++)
			{		
				//System.out.print(i + "," + j + " = " + state.f.grid[i][j] + "\n");
			}
		}
		timer.start();
	}

	void loadImages()
	{
        try
        {
            state.rock = ImageIO.read(new File("Rock.png"));
            state.smallselection = ImageIO.read(new File("smallselection.png"));
            state.bg = ImageIO.read(new File("Background.jpg"));
            state.building = ImageIO.read(new File("Building2.png"));
            state.cube = ImageIO.read(new File("Blue Alien.png"));
            state.line = ImageIO.read(new File("Line.png"));
        }
        catch(IOException ex)
        {

        }
	}

    void initPanel()
    {
        panel = new DrawPanel();
    }



}