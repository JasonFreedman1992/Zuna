public class FlowField
{

    public CostField cost = new CostField();

    public double angle(int p_i, int p_j)
    {
        return grid[p_i][p_j];
    }

    public FlowField(int p_x_counter, int p_y_counter, CostField p_field)
    {
        grid = new double[p_y_counter][p_x_counter];
        cost = p_field;
    }

    double height;
    double width;
    public double grid[][]; // = new double[8][11];

}