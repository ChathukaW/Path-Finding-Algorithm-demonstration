package Path;

public class Square {
    int x;   // x coordinates
    int y;   // y coordinates
    int gCost = 0; // calculate gcost - the weight from starting from to the end
    int hCost = 0; // calculate hcost - distance from start point to end point
    int fCost = 0; // F = G + H
    Square parent; // the cell which is visited before the current cell

    //constructor
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

