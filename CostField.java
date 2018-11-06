import java.util.ArrayList;

public class CostField
{
    public int density = 0;

    public static ArrayList<coord> coords = new ArrayList<coord>();
    public CostField()
    {
        for(int i = 0; i < 20; i++)
        {
            coord coord1 = new coord();
            coord1.x = 20;
            coord1.y = 20 + i;
            coords.add(coord1);
        }
        
    }

    // field.line_x = 200;
    // field.line_x1 = 200;
    // field.line_y = 200;
    // field.line_y1 = 400;

    public int num_of_blocks(int p_y_count, int p_x_count)
    {
        return 0;
    }

    public boolean is_wall()
    {
        return false;
    }

    class coord
    {
        int x = 0;
        int y = 0;
        coord()
        {

        }
    }

}