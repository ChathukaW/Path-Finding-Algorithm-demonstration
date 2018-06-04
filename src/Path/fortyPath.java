package Path;

import Structure.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class fortyPath {


    static int size=40;

    static Square[][] grid = new Square[size][size]; //grid node array

    public static ArrayList<Integer[]> path = new ArrayList<Integer[]>();

    static PriorityQueue<Square> open; //open list is made as a priority que

    static boolean closed[][]; //closed list made as a boolean array

    static boolean isSelected;

    static int xStart, yStart;
    static int xEnd, yEnd;

    public static double total;




    public static void setStartCell(int x, int y) {
        xStart = x;
        yStart = y;
    }

    public static void setEndCell(int x, int y) {
        xEnd = x;
        yEnd = y;
    }

    public static void calculateCost(Square current, Square temp){


        if (temp != null) {
            if (!closed[temp.x][temp.y]) {
                if (open.contains(temp)) {
                    int tempgCost = current.gCost + Structure.forty[temp.x][temp.y];
                    if (temp.gCost > tempgCost) {
                        temp.gCost = tempgCost;
                        temp.fCost = temp.gCost;
                        temp.parent = current;
                    }
                } else {
                    temp.parent = current;
                    temp.gCost = current.gCost + Structure.forty[temp.x][temp.y];
                    temp.fCost = temp.gCost;
                }
                open.add(temp);

            }
        }
    }

    public static void checking(){
        open.add(grid[xStart][yStart]);
        Square current;

        while (true) {
            current = open.poll();
            if (current == null) {
                break;
            }
            if(closed[current.x][current.y]){
                continue;
            }else {
                closed[current.x][current.y] = true;
            }
            if (current.equals(grid[xEnd][yEnd])) {
                return;
            }

            Square t;
            if(current.x-1>=0){
                t = grid[current.x-1][current.y];
                calculateCost(current, t);
                if(current.y-1>=0){
                    t = grid[current.x-1][current.y-1];
                    calculateCost(current, t);
                }
                if(current.y+1<grid[0].length){
                    t = grid[current.x-1][current.y+1];
                    calculateCost(current, t);
                }
            }

            if(current.y-1>=0){
                t = grid[current.x][current.y-1];
                calculateCost(current, t);
            }

            if(current.y+1<grid[0].length){
                t = grid[current.x][current.y+1];
                calculateCost(current, t);
            }

            if(current.x+1<grid.length){
                t = grid[current.x+1][current.y];
                calculateCost(current, t);
                if(current.y-1>=0){
                    t = grid[current.x+1][current.y-1];
                    calculateCost(current, t);
                }
                if(current.y+1<grid[0].length){
                    t = grid[current.x+1][current.y+1];
                    calculateCost(current, t);
                }
            }
        }

    }

    public static void run( int sx, int sy, int ex, int ey) {

        // nxn grid
        grid = new Square[size][size];

        // to be blocked at end
        //matrix = new boolean[n][n];
        // no cells are visited at beginning
        closed = new boolean[size][size];

        // priority queue to contain open cells
        // cell with least finalCost to be chosen as head
        open = new PriorityQueue<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {

                Square c1 = (Square) o1;
                Square c2 = (Square) o2;

                int cost1 = c1.fCost + c1.hCost;
                int cost2 = c2.fCost + c2.hCost;

                if (cost1 < cost2) {
                    return -1; // this matters for priority
                } else if (cost1 > cost2) {
                    return 1;
                } else {
                    return 0; // equal fCosts : then first in first out
                }
            }
        });

        // calculate path - time start


        // set start position x,y static variables
        setStartCell(sy, sx);

        // set end position x,y static variables
        setEndCell(ey, ex);

        // calculate & assign heuristic costs

        for (int x = 1; x < Structure.forty.length; x++) { // x
            for (int y = 1; y < Structure.forty[x].length; y++) { // y

                // create a cell object in the grid with coordinates


                grid[x][y] = new Square(x, y);

                if(isSelected) {

                    // calculate & assign heuristic cost for cell object

                    // manhattan
                    Logic logic = new Logic();
                    if (logic.getHeuristic().equals("Manhattan")) {
                        grid[x][y].hCost = (int) logic.calManhattan(x, xEnd, y, yEnd);

                    }
                    if (logic.getHeuristic().equals("Chebyshev")) {
                        grid[x][y].hCost = (int) logic.calChebyshev(x, xEnd, y, yEnd);
                    }
                    if (logic.getHeuristic().equals("Euclidean")) {
                        grid[x][y].hCost = (int) logic.calEuclidean(x, xEnd, y, yEnd);

                    }
                }else{
                    grid[x][y].hCost = 0;
                }
            }
        }


        checking();

        // trace path ///////////////////////////////////////////////////////////

        if (closed[xEnd][yEnd]) {

            // start from end point
            Square current = grid[xEnd][yEnd];
            total = current.gCost;
            path.add(new Integer[]{(current.x), (current.y)});

            // iterate until the super parent (starting cell) is found
            while (current.parent != null) {
                // add parent of the current node
                path.add(new Integer[]{(current.parent.x), (current.parent.y)});

                // ready for next parent finding
                current = current.parent;


                fortyGrid.recGroup[current.x][current.y].setFill(Color.rgb(40,70,60));

            }

            // calculate path - time end


            System.out.println("Path found!");

        } else {

            // end point has not reached
            // path stopped in middle
            // calculate path - time end

            System.out.println("No possible path!");

        }


            }

    public static void main(String args[]){
        run(2,2,5,5);


    }
}

