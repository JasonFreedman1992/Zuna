import java.io.IOException;

public class Main
{
	public static void main(String[] args) throws IOException
	{
        Window win = new Window();
        int width = 1600;
        int height = 1000;
        int density = 10;
		win.init(width, height, density);
	}
}