import java.awt.Image;
import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;

public class State 
{
    public State()
    {

    }

    public static Image bg;
    public static Image line;

    public static FlowField flow;// = new FlowField();
    public static CostField cost = new CostField();

    public static ArrayList<Monster> monsters = new ArrayList<Monster>();

    public static int width;
    public static int height;

	public static int density;
	public static int x_count;
    public static int y_count;
    
    public static int mouseX = 0;
    public static int mouseY = 0;

    public static boolean started = false;
    public static boolean moving = false;
    public static boolean create_monster = false;

    static Random r = new Random();

    public static void update()
    {
        flow = new FlowField(x_count, y_count, cost);
        for(int i = 0; i < y_count; i++) // 8
        {
            for(int j = 0; j < x_count; j++) // 11
            {
                int x = j*density;
                int y = i*density;

                double dX = mouseX - x;
                double dY = mouseY - y;
                double imageAngleRad = Math.atan2(dY, dX);

                // if(flow.cost.coords.x == j && flow.cost.coords.y == i)
                // {
                //     flow.grid[i][j] = 0;
                // }
                // else
                // {
                //     flow.grid[i][j] = imageAngleRad/Math.PI;
                // }

                flow.grid[i][j] = imageAngleRad/Math.PI;
            }
        }
        if(moving)
        {
            try
            {
                if(!monsters.isEmpty())
                {
                    for(int i = 0; i < monsters.size(); i++)
                    {
                        //System.out.println(monsters.size());
                       //System.out.println("moving" + i);
						int x = monsters.get(i).X/density;
						int y = monsters.get(i).Y/density;
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
                System.out.println(e.getStackTrace().toString());
            }
        }
        if(create_monster)
        {
            System.out.println(monsters.size());
            for(int i = 0; i < 10; i++)
            {
                int red = r.nextInt(255);
                int g = r.nextInt(255);
                int b = r.nextInt(255);
                
                Color c = new Color(red, g, b);
    
                Monster mon = new Monster();
                mon.color = c;
                mon.multiplier = r.nextDouble() * 2;
                if(mon.multiplier < .2)
                {
                    mon.multiplier = mon.multiplier + .2;
                }
                mon.X = r.nextInt(width - 50) + 25;
                mon.Y = r.nextInt(height - 50) + 25;
                monsters.add(mon);
            }
            // int red = r.nextInt(255);
			// int g = r.nextInt(255);
            // int b = r.nextInt(255);
            
            // Color c = new Color(red, g, b);

            // Monster mon = new Monster();
            // mon.color = c;
            // mon.multiplier = r.nextDouble() * 2;
            // if(mon.multiplier < .2)
            // {
            //     mon.multiplier = mon.multiplier + .2;
            // }
            // mon.X = r.nextInt(width - 50) + 25;
            // mon.Y = r.nextInt(height - 50) + 25;
            // monsters.add(mon);
        }
    }
}