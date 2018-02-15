import javax.swing.JFrame;

public class Window extends JFrame
{
	public void init(int p_width, int p_height)
	{
		setTitle("Zuna RTS");
		setSize(p_width, p_height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new java.awt.Dimension(1600, 1200));
		setVisible(true);
	}
}