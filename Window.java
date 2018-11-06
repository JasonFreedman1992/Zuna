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

	Timer timer = new Timer(30, new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			panel.setSize(state.width, state.height);
			panel.repaint();
			state.update();				
		}
	});

    public void init(int p_width, int p_height, int p_density) throws IOException
    {
		setTitle("Zuna RTS");
		setSize(p_width, p_height);
		state.width = p_width;
		state.height = p_height;
		state.density = p_density;
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(p_width, p_height));
		//setMinimumSize(new java.awt.Dimension(1600, 1200));
		setMaximumSize(new java.awt.Dimension(p_width, p_height));
		setVisible(true);
		addKeyListener(control);

		//
		// load images
		//
		state.line = ImageIO.read(new File("Line.png"));
		state.bg = ImageIO.read(new File("Background.jpg"));

		int x_count = p_width/p_density;
		int y_count = p_height/p_density;
		state.x_count = x_count;
		state.y_count = y_count;
		CostField field = new CostField();
		
		field.density = p_density;

		state.cost = field;
		panel = new DrawPanel(x_count, y_count, p_density);
		add(panel);
		state.started = true;
		//state.update();
		panel.setSize(state.width, state.height);
		panel.repaint();

		try{
			Thread.sleep(1000);
		}
		catch(Exception e)
		{

		}

		timer.start();
		
    }
}