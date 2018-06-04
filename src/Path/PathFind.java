package Path;

import Structure.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PathFind {


    static int size=21;  //size of the grid

    static Square[][] grid = new Square[size][size]; //square array created from the Square class

    public static ArrayList<Integer[]> path = new ArrayList<Integer[]>();  //array declared for getting the path

    static boolean isSelected;  //boolean to check whether the checkbox is selected to check with or without heuristics

    static int xStart, yStart;
    static int xStop, yStop;

    static PriorityQueue<Square> checked; //priority que - open list - to arrange the elements in ascending order

    static boolean unChecked[][]; //closed boolean array - closed list

    public static double total;  //total cost

    //boolean to check whether heuristics are selected or not
    public static void setIsSelected(boolean isSelected) {
        PathFind.isSelected = isSelected;
    }


        public static void checkPath(){
        checked.add(grid[xStart][yStart]);
        Square current;

        while (true) {
            current = checked.poll();
            if (current == null) {
                break;
            }
            if(unChecked[current.x][current.y]){
                continue;
            }else {
                unChecked[current.x][current.y] = true;
            }
            if (current.equals(grid[xStop][yStop])) {
                return;
            }

            Square t;
            if(current.x-1>=0){
                t = grid[current.x-1][current.y];
                gCost(current, t);
                if(current.y-1>=0){
                    t = grid[current.x-1][current.y-1];
                    gCost(current, t);
                }
                if(current.y+1<grid[0].length){
                    t = grid[current.x-1][current.y+1];
                    gCost(current, t);
                }
            }

            if(current.y-1>=0){
                t = grid[current.x][current.y-1];
                gCost(current, t);
            }

            if(current.y+1<grid[0].length){
                t = grid[current.x][current.y+1];
                gCost(current, t);
            }

            if(current.x+1<grid.length){
                t = grid[current.x+1][current.y];
                gCost(current, t);
                if(current.y-1>=0){
                    t = grid[current.x+1][current.y-1];
                    gCost(current, t);
                }
                if(current.y+1<grid[0].length){
                    t = grid[current.x+1][current.y+1];
                    gCost(current, t);
                }
            }
        }

    }

        //setter methods of startCell and endCell to set the cell value
        public static void setStartCell(int x, int y) {
        xStart = x;
        yStart = y;
    }

        public static void setEndCell(int x, int y) {
        xStop = x;
        yStop = y;
    }

        public static void run( int sx, int sy, int ex, int ey) {

            //creating new Square object
            grid = new Square[size][size];

            // unChecked list is empty at the start
            unChecked = new boolean[size][size];


            //the squares with least cost are choosen at top in the priority que
            checked = new PriorityQueue<>(new Comparator<Object>() {
                @Override
                public int compare(Object obj1, Object obj2) {

                    //creating Square objects
                    Square sqr1 = (Square) obj1;
                    Square sqr2 = (Square) obj2;

                    int cost1 = sqr1.fCost + sqr1.hCost;
                    int cost2 = sqr2.fCost + sqr2.hCost;

                    if (cost1 < cost2) {
                        return -1; // this matters for priority
                    } else if (cost1 > cost2) {
                        return 1;
                    } else {
                        return 0; // equal fCosts : then first in first out
                    }
                }
            });

            hCost();

            // set start position x,y static variables
            setStartCell(sy, sx);

            // set end position x,y static variables
            setEndCell(ey, ex);

            //method to check the path
            checkPath();

            //method to track the path
            tracePath();

        }

        public static void tracePath(){

            if (unChecked[xStop][yStop]) {

                // start from end point
                Square current = grid[xStop][yStop ];
                total = current.gCost;
                path.add(new Integer[]{(current.x), (current.y)});

                // iterate until the super parent (starting cell) is found
                while (current.parent != null) {
                    // add parent of the current node
                    path.add(new Integer[]{(current.parent.x), (current.parent.y)});

                    // ready for next parent finding

                    current = current.parent;

                    //path is drawn here
                    Grid.recGroup[current.x][current.y].setFill(Color.rgb(40,70,60));

                }

                System.out.println("Path found!");


            } else {
                System.out.println("No possible path!");

            }
        }

        public static void hCost(){

            //calculate the heuristic value and assign to the array
            for (int x = 1; x < Structure.structure.length; x++) { // x
                for (int y = 1; y < Structure.structure[x].length; y++) { // y

                    //create a new square in the grid
                    grid[x][y] = new Square(x, y);

                    //checking the checkbox
                    if(isSelected) {

                        // manhattan
                        Logic logic = new Logic();
                        if (logic.getHeuristic().equals("Manhattan")) {
                            grid[x][y].hCost = (int) logic.calManhattan(x, xStop, y, yStop);
                        }
                        // Chebyshev
                        if (logic.getHeuristic().equals("Chebyshev")) {
                            grid[x][y].hCost = (int) logic.calChebyshev(x, xStop, y, yStop);
                        }
                        //Euclidean
                        if (logic.getHeuristic().equals("Euclidean")) {
                            grid[x][y].hCost = (int) logic.calEuclidean(x, xStop, y, yStop);

                        }
                    }else{
                        //if not checked the h cost will be zero
                        grid[x][y].hCost = 0;
                    }
                }
            }
        }

        public static void gCost(Square currSquare, Square newSquare){

        //check whether the new square is empty or not
        if (newSquare != null) {
            //checking for the new square whether it is in un checked list or not
            if (!unChecked[newSquare.x][newSquare.y]) {
                //if the new square is in checked priotity que
                if (checked.contains(newSquare)) {
                    //calculate the new g cost (current square g cost + new square g cost)
                    int newgCost = currSquare.gCost + Structure.structure[newSquare.x][newSquare.y];
                    //if the current square's g cost is higher than new g cost
                    //assign the current square's g cost to the parent node's g cost
                    if (newSquare.gCost > newgCost) {
                        newSquare.gCost = newgCost;
                        newSquare.fCost = newSquare.gCost;
                        newSquare.parent = currSquare;
                    }
                } else {
                    //if not in the priority que,
                    newSquare.parent = currSquare;
                    newSquare.gCost = currSquare.gCost + Structure.structure[newSquare.x][newSquare.y];
                    newSquare.fCost = newSquare.gCost;
                }
                //add the new square to the open list
                checked.add(newSquare);

            }
        }
    }

        public static void main(String args[]){
            run(2,2,5,5);


        }
}
