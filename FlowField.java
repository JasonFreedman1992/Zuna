import java.util.Random;
import java.util.Scanner;

public class FlowField
{
	double height = 1200;
	double width = 1600;
	int counter;
	int directions = 20;

	public int grid[][] = new int[12][16];
	//public static Scanner console = new Scanner(System.in);
	// 0 = 1-10
	// 1 = 11-20
	// 2 = 21-30

	// pixel 450 = 44
	// pixel 1600 = 159

	public FlowField()
	{
		//Scanner console = new Scanner(System.in);
		//System.out.println(z);
	}

	public void generateFlow()
	{
		int z;
		for(int i = 0; i < 12; i++)
		{
			for(int j = 0; j < 16; j++)
			{
				counter++;
				System.out.println("Count:" + counter);
				z = 0;
				Random r = new Random();
				z = r.nextInt(8)+1;
				grid[i][j]=z;
				//System.out.print(i + "," + j + " = " + grid[i][j] + "\n");
			}
		}
	}
	// public FlowField(int p_monsterXCenter, int p_monsterYCenter, int p_monsterXDestination, int p_monsterYDestination, int p_rockX, int p_rockY)
	// {
		
	// }
}