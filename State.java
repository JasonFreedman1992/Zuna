import java.awt.Image;
import java.awt.Color;
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

	public static ArrayList<Monster> monsters = new ArrayList<Monster>();

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

	public static boolean Moving = false;

	public static Image building;
	public static Image bg;
	public static Image cube;
	public static Image smallselection;
	public static Image rock;
	public static Image line;

	public static boolean createMonster = false;

	public double imageAngleRad;

	double premonsterAcceleration;

	private double multiplier = .8;

	public void update()
	{
		if(Moving)
		{
			try{
				if(!monsters.isEmpty())
				{
					for(int i = 0; i < monsters.size(); i++)
					{
						//double friction = r.nextDouble();
						//flow.generateFlow();
						int x = monsters.get(i).X/100;
						int y = monsters.get(i).Y/100;
						double angle = flow.angle(y, x);
						if((angle*Math.PI) < 0)
						{
							monsters.get(i).vx = (10 - (-20 * angle)) * monsters.get(i).multiplier;
							if(angle < 0 && angle >= -.5)
							{
								monsters.get(i).vy = (0 + (20 * angle)) * monsters.get(i).multiplier;
							}
							else if(angle < -.5 && angle >= - 1)
							{
								monsters.get(i).vy = (20 * (-1 - angle)) * monsters.get(i).multiplier;
							}
						}
						else if((angle*Math.PI) > 0)
						{
							monsters.get(i).vx = (10 + (-20 * angle)) * monsters.get(i).multiplier;
							if(angle > 0 && angle <= .5)
							{
								monsters.get(i).vy = (0 + (20 * angle)) * monsters.get(i).multiplier;
							}
							else if(angle > .5 && angle < 1)
							{
								monsters.get(i).vy = (-20 * (-1 + angle)) * monsters.get(i).multiplier;
							}
						}
						monsters.get(i).X += monsters.get(i).vx;
						monsters.get(i).Y += monsters.get(i).vy;
					}
				}
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
			
		if(createMonster)
		{
			System.out.println("in create");
			int red = r.nextInt(255);
			int g = r.nextInt(255);
			int b = r.nextInt(255);

			Color c = new Color(red, g, b);

			Monster mon = new Monster();
			mon.color = c;
			mon.multiplier = r.nextDouble();
			mon.X = r.nextInt(1050)+25;
			mon.Y = r.nextInt(750)+25;
			monsters.add(mon);
		}

		// if(!monsters.isEmpty())
		// {
		// 	for(int i = 0; i < monsters.size(); i++)
		// 	{
		// 		monsters.get(i).X += monsters.get(i).vx;
		// 		monsters.get(i).Y += monsters.get(i).vy;
		// 	}
		// }
            //System.out.println("monster vx =" + monster.vx);
            //System.out.println("monster vy =" + monster.vy);

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