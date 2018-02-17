import java.awt.Image;
import java.util.Random;

public class State
{
	public State()
	{
		//f.generateFlow();
	}
	public static int mouseX;
	public static int mouseY;

	public static int width;
	public static int height;

	public Random r = new Random();

	public static boolean monsterSelected;
	public static boolean monsterMoving;
	public static boolean monsterXReached = true;
	public static boolean monsterYReached = true;

	Monster monster = new Monster();

	//
	// 1 = up
	// 2 = up right
	// 3 = right
	// 4 = down right
	// 5 = down
	// 6 = down left
	// 7 = left
	// 8 = up left
	//

	public static FlowField flow = new FlowField();

	public static int rockX = 800;
	public static int rockY = 800;

	public static boolean mouseClicked = false;

	public static Image building;
	public static Image bg;
	public static Image cube;
	public static Image smallselection;
	public static Image rock;
	public static Image line;

	public double imageAngleRad;

	double premonsterAcceleration;

	public void update()
	{
		if(mouseClicked)
		{
			System.out.println("mouseX = " + mouseX);
			System.out.println("mouseY = " + mouseY);
			monster.X = mouseX-32;
			monster.Y = mouseY-32;
			System.out.println(mouseX + "," + mouseY);
			monster.XCenter = mouseX;
			monster.YCenter = monster.Y;
			mouseClicked = false;
		}
		if(monsterMoving)
		{
			double friction = r.nextDouble();
			flow.generateFlow();

    // 		if(down)
    // 		{
			 // 	monsterY=monsterY+(int)premonsterAcceleration;
			 // 	monsterYCenter=monsterYCenter+(int)premonsterAcceleration;
    // 		}
    // 		if(right)
    // 		{
				// monsterX=monsterX+(int)premonsterAcceleration;
				// monsterXCenter=monsterXCenter+(int)premonsterAcceleration;
    // 		}
    // 		if(up)
    // 		{
				// monsterY=monsterY-(int)premonsterAcceleration;
				// monsterYCenter=monsterYCenter-(int)premonsterAcceleration;
    // 		}
    // 		if(left)
    // 		{
				// monsterX=monsterX-(int)premonsterAcceleration;
				// monsterXCenter=monsterXCenter-(int)premonsterAcceleration;
    // 		}

		}
	}
}