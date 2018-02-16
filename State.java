import java.awt.Image;

public class State
{
	public State()
	{
		//f.generateFlow();
	}
	public int mouseX;
	public int mouseY;

	public static int width;
	public static int height;

	public static boolean up;
	public static boolean right;
	public static boolean left;
	public static boolean down;

	public static boolean monsterSelected;
	public static boolean monsterMoving;
	public static boolean monsterXReached = true;
	public static boolean monsterYReached = true;

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

	public static byte monsterDirection;

	public static FlowField flow = new FlowField();

	public static int rockX = 800;
	public static int rockY = 800;

	public static int monsterX = 500;
	public static int monsterY = 500;
	public static int monsterXCenter = 532;
	public static int monsterYCenter = 532;
	public static int monsterAcceleration = 10;

	public static int monsterXDestination = 0;
	public static int monsterYDestination = 0;

	public static Image building;
	public static Image bg;
	public static Image monster;
	public static Image smallselection;
	public static Image rock;

	public void update()
	{
		if(monsterMoving)
		{
			int i = monsterYCenter / 100;
			int j = monsterXCenter / 100;
			System.out.println("i cord = " + i + "\n");
			System.out.println("j cord = " + i + "\n");

			// System.out.println("moving = true");
   // //  		System.out.println("XDest = " + monsterXDestination);
   // //  		System.out.println("YDest = " + monsterYDestination);
			// if(down && !monsterYReached)
			// {
			// 	monsterY=monsterY+monsterAcceleration;
			// 	monsterYCenter=monsterYCenter+monsterAcceleration;
			// 	if(monsterYCenter >= monsterYDestination)
			// 	{
			// 		monsterYReached = true;
			// 		System.out.println("Y Reached!");
			// 	}
			// }
			// if(right && !monsterXReached)
			// {

			// 	monsterX=monsterX+monsterAcceleration;
			// 	monsterXCenter=monsterXCenter+monsterAcceleration;
			// 	if(monsterXCenter >= monsterXDestination)
			// 	{
			// 		monsterXReached = true;
			// 		System.out.println("X Reached!");
			// 	}
			// }
			// if(up && !monsterYReached)
			// {

			// 	monsterY=monsterY-monsterAcceleration;
			// 	monsterYCenter=monsterYCenter-monsterAcceleration;
			// 	if(monsterYCenter <= monsterYDestination)
			// 	{
			// 		monsterYReached = true;
			// 		System.out.println("Y Reached!");
			// 	}
			// }
			// if(left && !monsterXReached)
			// {

			// 	monsterX=monsterX-monsterAcceleration;
			// 	monsterXCenter=monsterXCenter-monsterAcceleration;
			// 	if(monsterXCenter <= monsterXDestination)
			// 	{
			// 		monsterXReached = true;
			// 		System.out.println("X Reached!");
			// 	}
			// }
		}
	}


	// void determineDirection()
 //    {
 //    	System.out.println("XDest = " + monsterXDestination);
 //    	System.out.println("YDest = " + monsterYDestination);
 //    	if(monsterY < monsterYDestination)
 //    	{
 //    		down = true;
 //    		//if(monsterY+monsterAcceleration => rockY && )
 //    		{
 //    			down = false;
 //    		}
 //    		System.out.println("d");
 //    	}
 //    	if(monsterX < monsterXDestination)
 //    	{
 //    		right = true;
 //    		//if(monsterX+monsterAcceleration => rockX)
 //    		{

 //    		}
 //    		System.out.println("r");
 //    	}
 //    	if(monsterY > monsterYDestination)
 //    	{
 //    		up = true;
 //    		//if(monsterY-monsterAcceleration <= m)
 //    		System.out.println("u");
 //    	}
 //    	if(monsterX > monsterXDestination)
 //    	{
 //    		left = true;
 //    		System.out.println("l");
 //    	}
 //    }
}