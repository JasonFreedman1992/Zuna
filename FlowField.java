import java.util.Random;
import java.util.Scanner;

public class FlowField
{
	double height = 1200;
	double width = 1600;
	int counter;
	int directions = 20;

	public double grid[][] = new double[12][16];
	//public static Scanner console = new Scanner(System.in);
	// 0 = 1-100
	// 1 = 101-200
	// 2 = 201-300

	// pixel 450 = 44
	// pixel 1600 = 159

	public FlowField()
	{

		//Scanner console = new Scanner(System.in);
		//System.out.println(z);
	}

	public double vx(int p_i, int p_j)
	{
		return grid[p_i][p_j];
	}

	public double vy()
	{
		return 5;
	}
	// public FlowField(int p_monsterXCenter, int p_monsterYCenter, int p_monsterXDestination, int p_monsterYDestination, int p_rockX, int p_rockY)
	// {
		
	// }
}