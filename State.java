import java.awt.Image;
import java.util.Random;
import java.util.ArrayList;

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

	public ArrayList<Monster> monsters = new ArrayList<Monster>();

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

			mouseClicked = false;
		}
		if(monster.Moving)
		{
			//double friction = r.nextDouble();
			//flow.generateFlow();
			int x = monster.X/100;
			int y = monster.Y/100;
			double angle = flow.angle(y, x);
            if((angle*Math.PI) < 0)
            {
                monster.vx = 10 - (-20 * angle);
                if(angle < 0 && angle >= -.5)
                {
                    monster.vy = 0 + (20 * angle);
                }
                else if(angle < -.5 && angle >= - 1)
                {
                    monster.vy = 20 * (-1 - angle);
                }
            }
            else if((angle*Math.PI) > 0)
            {
                monster.vx = 10 + (-20 * angle);
                if(angle > 0 && angle <= .5)
                {
                    monster.vy = 0 + (20 * angle);
                }
                else if(angle > .5 && angle < 1)
                {
                    monster.vy = -20 * (-1 + angle);
                }
            }

            monster.X += monster.vx;
            monster.Y += monster.vy;
            System.out.println("monster vx =" + monster.vx);
            System.out.println("monster vy =" + monster.vy);

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