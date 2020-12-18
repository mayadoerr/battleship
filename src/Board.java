import java.util.ArrayList;
import java.util.Arrays;

public class Board
{
    private String[][] grid;
    static int BOARD_SIZE = 10;

    public Board()
    {
        // Initialize grid for game
        grid = new String[BOARD_SIZE][BOARD_SIZE];

        // Iterate through each element and set to "0"
        for (String[] r : grid)
        {
            for (int i = 0; i < r.length; i++)
            {
                r[i] = "0";
            }
        }
    }


    public String toString()
    {
        String result = "";

        // Iterate through each row
        for (String[] r : grid)
        {
            // Iterate through each element of row and add to string
            for (String s : r)
            {
                result += s + "  ";
            }

            // Add new line to string
            result += "\n";
        }
        return result;
    }


    public int shoot(int row, int col)
    {
        // If shot out of bounds, return -1
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return -1;

        // If ship hit, replace with "x" and return 1
        if(grid[row][col].equals("S"))
        {
            grid[row][col] = "x";
            return 1;
        }

        // If square already shot, return 2
        if(grid[row][col].equals("x") || grid[row][col].equals("m"))
            return 2;

        // Otherwise mark as miss, return 0
        grid[row][col] = "m";
        return 0;
    }


    public boolean addShip(int row, int col, int len, boolean horizontal)
    {
        // If start of ship is off grid return false
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length)
            return false;

        if(horizontal)
        {
            // If end of ship is off grid return false
            if(col + len > grid.length)
                return false;

            /* This code iterates through elements of the 2-d array squares by
             * incrementing the column index by 1, beginning with a value of col and
             * exiting at col + length, while the row index is kept the same. This
             * is done twice: the first time checks each element to see if there is
             * already a "b" present, and returns false if so. The second loop
             * replaces each element with "b" to place the ship.
             */
            for (int i = col; i < col + len; i++)
            {
                if(!grid[row][i].equals("0"))
                {
                    return false;
                }
            }

            for (int i = col; i < col + len; i++)
            {
                grid[row][i] = "S";
            }
        }

        else
        {
            // If end of ship is off grid return false
            if(row + len > grid.length)
                return false;

            /* This code works in the same way as the horizontal section above but
             * iterates through the rows and keeps the column the same.
             */
            for (int i = row; i < row + len; i++)
            {
                if(!grid[i][col].equals("0"))
                {
                    return false;
                }
            }

            for (int i = row; i < row + len; i++)
            {
                grid[i][col] = "S";
            }
        }

        // If this point is reached, ship has been added so return true
        return true;
    }


    public boolean gameOver()
    {
        // Iterate through each element, return false if "b" found
        for (String[] r : grid)
        {
            for (String s : r)
            {
                if(s.equals("S"))
                    return false;
            }
        }

        // If no "b"s, return true
        return true;
    }

    public boolean foundShip(int len)
    {
        // Iterates through all rows of array
        for (int r = 0; r < grid.length; r++)
        {
            /* Iterates through each element in the row, looking for
             * consecutive runs of the Stringacter "b". This is done by using
             * an interior while loop which is entered when a "b" is found
             * and increments both c the variable foundLen as long as "b"
             * appears. If foundLen is equal to len at the end of this
             * interior loop, the value true is returned.
             */
            int c = 0;
            while(c < grid[r].length)
            {
                int foundLen = 0;
                while (c < grid[r].length && grid[r][c].equals("S"))
                {
                    foundLen++;
                    c++;
                }
                if(foundLen == len)
                    return true;
                foundLen = 0;
                c++;
            }
        }

        // Works as above, but checks each column for vertical runs
        for (int c = 0; c < grid[0].length; c++)
        {
            int r = 0;
            while(r < grid.length)
            {
                int foundLen = 0;
                while (r < grid.length && grid[r][c].equals("S"))
                {
                    foundLen++;
                    r++;
                }
                if(foundLen == len)
                    return true;
                foundLen = 0;
                r++;
            }
        }

        return false;
    }

}
