package Structure;

public class Structure {

    //20x20 grid structural array
    public static int[][] structure = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1},
            {1, 4, 4, 1, 4, 1, 1, 1, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1},
            {1, 4, 4, 4, 4, 4, 4, 1, 1, 2, 3, 3, 3, 2, 1, 1, 1, 1, 1, 1, 1},
            {1, 4, 4, 4, 4, 4, 4, 1, 1, 2, 3, 3, 3, 3, 2, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 4, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 2, 1, 1, 2, 2, 1, 1},
            {1, 1, 4, 4, 1, 2, 2, 1, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 1},
            {1, 4, 2, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1},
            {1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4},
            {1, 1, 1, 2, 3, 3, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 4},
            {1, 1, 2, 3, 3, 3, 3, 2, 2, 1, 1, 1, 1, 4, 4, 4, 4, 4, 4, 4, 1},
            {1, 1, 2, 3, 2, 2, 2, 3, 2, 4, 1, 1, 1, 4, 4, 4, 4, 2, 1, 1, 1},
            {1, 1, 2, 2, 1, 1, 1, 4, 4, 4, 4, 1, 1, 4, 4, 4, 1, 1, 1, 1, 1},
            {1, 1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 5},
            {1, 1, 1, 4, 4, 4, 4, 1, 1, 1, 2, 2, 5, 5, 1, 1, 1, 1, 1, 1, 5},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 5, 5, 5, 1, 1, 5, 5, 5},
            {1, 1, 2, 2, 2, 2, 2, 1, 1, 1, 2, 1, 1, 1, 5, 5, 5, 5, 5, 5, 5},
            {1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 5},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5, 5, 5, 5, 5, 5, 5, 5},

    };

    //40x40 grid structural array
    public static int[][] forty = {
            { 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 1 , 1 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 1 , 1 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 4 , 4 , 4 , 4 , 1 , 1 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 4 , 4 , 4 , 4 , 1 , 1 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 1 , 1 , 1 , 1 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 },
            { 1 , 1 , 1 , 1 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 },

            { 1 , 1 , 4 , 4 , 4 , 4 , 1 , 1 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 },
            { 1 , 1 , 4 , 4 , 4 , 4 , 1 , 1 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 },
            { 4 , 4 , 2 , 2 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 4 , 4 , 2 , 2 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 1 , 1 , 2 , 2 , 1 , 1 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 },
            { 1 , 1 , 2 , 2 , 1 , 1 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 },
            { 1 , 1 , 1 , 1 , 2 , 2 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 },
            { 1 , 1 , 1 , 1 , 2 , 2 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 },
            { 1 , 1 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 },
            { 1 , 1 , 2 , 2 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 3 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 },

            { 1 , 1 , 2 , 2 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 2 , 2 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 1 , 1 , 2 , 2 , 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 3 , 3 , 2 , 2 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 1 , 1 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 1 , 1 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 },
            { 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 5 , 5 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 },
            { 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 5 , 5 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 },
            { 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 5 , 5 , 5 , 5 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 },
            { 1 , 1 , 1 , 1 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 4 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 2 , 2 , 5 , 5 , 5 , 5 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 },

            { 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 , 1 , 1 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 },
            { 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 , 1 , 1 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 },
            { 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 },
            { 1 , 1 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 },
            { 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 },
            { 2 , 2 , 2 , 2 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 },
            { 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 },
            { 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 },
            { 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 },
            { 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 , 5 }
    };
}
