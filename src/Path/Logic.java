package Path;

public class Logic {

    //variable declared to send the logic to the GUI for the radio buttons
    static String heuristic;

    //getter and setters
    public  void setHeuristic(String heuristic) {
        Logic.heuristic = heuristic;
    }

    public  String getHeuristic() {

        return heuristic;
    }


    //calculating manhattan heuristic
    public double calManhattan(int x1, int x2 ,int y1, int y2){

        //the distance between two points
        double manhattan = Math.abs(x1-x2) + Math.abs(y1-y2);

        return manhattan;
    }

    //calculating Euclidean heuristic
    public double calEuclidean(int x1, int x2 ,int y1, int y2){
        //the distance in the hypotenuse (straight line)(like pythegorous theorm)
        double euclidean = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));

        return euclidean;

    }

    //calculating Chebyshev heuristic
    public double calChebyshev(int x1,int x2, int y1, int y2){
        //the maximum distance for all the sides around a point
        double chebyshev = Math.max(Math.abs(x1-x2),Math.abs(y1-y2));

        return chebyshev;
    }
}
