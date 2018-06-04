package Structure;

import  Path.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Grid extends Application {

    static int size =21;         //setting the size of the grid

    public static Rectangle[][] recGroup = new Rectangle[size][size];  //rectangle array

    Label lblX,lblY,lStart,lStop,lxStart,lyStart,lxEnd,lyEnd, lblCost,lblTime;  //labels used in the GUI

    TextField txStart,tyStart,txEnd,tyEnd,txtCost,txtTime;   //text fields used in the GUI

    final ToggleGroup togGroup = new ToggleGroup();  //toggle group used in the radio buttons

    Button btnStart,btnReset;    //buttons used in the GUI

    Rectangle rect;     //Rectangle object

    boolean isClick;     //check whether the button is clicked

    Image image1,image2;    //images used in pointing the start and ending point

    ImagePattern imagePattern1,imagePattern2;

    ImageView imageView1,imageView2;

    RadioButton Manhattan,Chebyshev,Euclidean;  //radio buttons used in the GUI


    @Override
    public void start(Stage primaryStage) {

        //grid pane and the GUI setup
        GridPane main = new GridPane();
        main.setAlignment(Pos.CENTER);
        main.setPadding(new Insets(10, 0, 0, 5));

        //grid pane used in drawing the map
        GridPane map = new GridPane();
        map.setAlignment(Pos.CENTER);
        isClick = map.isGridLinesVisible();

        //column and row constraints
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(15);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(200);
        col2.setMinWidth(200);

        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPrefWidth(200);
        col3.setMinWidth(200);

        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(15);

        ColumnConstraints spaces = new ColumnConstraints();
        spaces.setMinWidth(50);
        spaces.setPrefWidth(50);

        RowConstraints row1 = new RowConstraints();
        row1.setPrefHeight(120);
        row1.setMinHeight(100);

        RowConstraints row2 = new RowConstraints();
        row2.setPrefHeight(200);
        row2.setMinHeight(200);

        RowConstraints row3 = new RowConstraints();
        row3.setPrefHeight(30);
        row3.setMinHeight(30);

        RowConstraints row4 = new RowConstraints();
        row4.setPrefHeight(50);
        row4.setMinHeight(50);

        RowConstraints row5 = new RowConstraints();
        row5.setPrefHeight(60);
        row5.setMinHeight(60);

        //labels
        lStart = new Label("Starting Point");
        lStop = new Label("Ending Point");
        lxStart = new Label("X - axis");
        lyStart = new Label("Y - axis");
        lxEnd = new Label("X - axis");
        lyEnd= new Label("Y - axis");
        lblCost = new Label("Cost");
        lblTime = new Label("Time");

        lStart.setId("lStart");
        lStop.setId("lStop");
        lxStart.setId("lblX_start");
        lyStart.setId("lblY_start");
        lxEnd.setId("lblX_end");
        lyEnd.setId("lblY_end");
        lblCost.setId("lbCost");
        lblTime.setId("lbTime");


        //text fields
        txStart = new TextField();
        txEnd = new TextField();
        tyStart = new TextField();
        tyEnd = new TextField();
        txtCost = new TextField();
        txtTime = new TextField();

        //Images
        image1 = new Image("Images/start.png");
        image2 = new Image("Images/end.png");

       imagePattern1 = new ImagePattern(image1);
       imagePattern2 = new ImagePattern(image2);

       //Buttons
        btnStart = new Button("Get Path");
        btnStart.setId("btnStart");
        btnStart.setPrefWidth(200.0);

        btnReset = new Button("Reset");
        btnReset.setId("btnReset");
        btnReset.setPrefWidth(200.0);

        //Radio Buttons
        Manhattan = new RadioButton("Manhattan");
        Chebyshev = new RadioButton("Chebyshev");
        Euclidean = new RadioButton("Euclidean");

        Manhattan.setUserData("Normal");
        Chebyshev.setUserData("Picture");
        Euclidean.setUserData("Picture");

        Manhattan.setToggleGroup(togGroup);
        Chebyshev.setToggleGroup(togGroup);
        Euclidean.setToggleGroup(togGroup);
        Manhattan.setSelected(true);

        //Checkbox
        CheckBox cB1 = new CheckBox("With Heuristics");


        //vertical boxes used to store the elements in an order
        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(lStart,lxStart,txStart,lyStart,tyStart);

        VBox vBox2 = new VBox();
        vBox2.getChildren().addAll(lStop,lxEnd,txEnd,lyEnd,tyEnd);

        VBox vBox3 = new VBox();
        vBox2.getChildren().addAll(lblCost,txtCost,lblTime,txtTime);

        VBox buttons = new VBox();
        buttons.getChildren().addAll(Manhattan,Chebyshev,Euclidean);


        //adding grid lines to the map
        if (!isClick) {
            map.setGridLinesVisible(true);
            System.out.println(isClick);
        }

        //labeling the x and y axis of the map
        for (int i=1; i<size; i++){
            lblX = new Label(""+i);
            map.setHalignment(lblX,HPos.CENTER);
            map.add(lblX,0,i);
        }

        for (int j=1; j<size; j++){
            lblY = new Label(""+j);
            map.setHalignment(lblY,HPos.CENTER);
            map.add(lblY,j,0);
        }

        //method to create the rectangles in the map
        for (int i=1; i<size; i++) {

            for (int j = 1; j < size; j++) {

                rect = new Rectangle(0, 0, 30, 30);
                recGroup[i][j] = rect;

                int struc = Structure.structure[i][j];

                //checks the weight of the cells and assign the color
                switch (struc) {
                    case 1:
                        rect.setFill(Color.rgb(255, 255, 255, 0.6));
                        break;

                    case 2:

                        rect.setFill(Color.rgb(185, 185, 185, 0.6));
                        break;

                    case 3:

                         rect.setFill(Color.rgb(125, 125, 125, 0.6));
                            break;

                    case 4:

                        rect.setFill(Color.rgb(65, 65, 65, 0.6));
                        break;

                    case 5:
                        rect.setFill(Color.rgb(0, 0, 0, 0.8));
                        break;
                }
                //adding the rectangles to the map
                map.add(rect, j, i);

            }
        }
        //start button to initialize the algorithm
        btnStart.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //get the coordinates entered in the text fields
                int xStart = Integer.valueOf(txStart.getText());
                int yStart = Integer.valueOf(tyStart.getText());
                int xEnd = Integer.valueOf(txEnd.getText());
                int yEnd = Integer.valueOf(tyEnd.getText());

                //checks for the heuristics - Manhattan - Chebyshev - Eculidean
                Logic logic = new Logic();
                if (Manhattan.isSelected()) {
                    logic.setHeuristic("Manhattan");
                }
                if (Chebyshev.isSelected()) {
                    logic.setHeuristic("Chebyshev");
                }
                if (Euclidean.isSelected()) {
                    logic.setHeuristic("Euclidean");
                }

                //checking the start time of the execution of algorithm
                Long startTime = System.nanoTime();

                //pass data to run method
                PathFind.run(xStart,yStart,xEnd,yEnd);

                //checking the end time of the execution of algorithm
                Long stopTime = System.nanoTime();

                //checking the time spent of the execution of algorithm
                Long timeCost = stopTime - startTime;

                //set the time spent for the execution of algorithm
                txtTime.setText(Long.toString(timeCost)+ " Nano Seconds");

                //set the cost taken from Path find method to the cost text field
                txtCost.setText(Double.toString(PathFind.total));

                //show the image in the starting coordinate
                recGroup[yEnd][xEnd].setFill(imagePattern2);
                imageView2 = new ImageView(image2);

                //show the image in the ending coordinate
                recGroup[yStart][xStart].setFill(imagePattern1);
                imageView1 = new ImageView(image1);
            }
        });

        btnReset.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //reset the map completely
                map.getChildren().clear();

                //recreates the map in the GUI
                if (!isClick) {
                    map.setGridLinesVisible(true);
                    System.out.println(isClick);
                }

                for (int i=1; i<size; i++){
                    lblX = new Label(""+i);
                    map.setHalignment(lblX,HPos.CENTER);
                    map.add(lblX,0,i);
                }

                for (int j=1; j<size; j++){
                    lblY = new Label(""+j);
                    map.setHalignment(lblY,HPos.CENTER);
                    map.add(lblY,j,0);
                }

                for (int i=1; i<size; i++) {

                    for (int j = 1; j < size; j++) {

                        int struc = Structure.structure[i][j];

                        rect = new Rectangle(0, 0, 30, 30);
                        recGroup[i][j] = rect;

                        switch (struc) {
                            case 1:
                                rect.setFill(Color.rgb(255, 255, 255, 0.6));
                                break;

                            case 2:

                                rect.setFill(Color.rgb(185, 185, 185, 0.6));
                                break;

                            case 3:

                                rect.setFill(Color.rgb(125, 125, 125, 0.6));
                                break;

                            case 4:

                                rect.setFill(Color.rgb(65, 65, 65, 0.6));
                                break;

                            case 5:
                                rect.setFill(Color.rgb(0, 0, 0, 0.8));
                                break;
                        }
                        map.add(rect, j, i);

                    }
                }
            }
        });

        //checkbox for heuristics
        cB1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //checkbox to show path with or without heuristics
                if(!cB1.isSelected()){
                    //disables the radio buttons if heuristics is not selected
                    PathFind.setIsSelected(false);
                    Manhattan.setDisable(true);
                    Chebyshev.setDisable(true);
                    Euclidean.setDisable(true);
                }
                else{
                    PathFind.setIsSelected(true);
                    Manhattan.setDisable(false);
                    Chebyshev.setDisable(false);
                    Euclidean.setDisable(false);
                }
            }
        });


        //alligning the elements in the grid pane
        main.setHalignment(lStart,HPos.CENTER);
        main.setHalignment(lStop,HPos.CENTER);
        main.setHalignment(lxStart,HPos.CENTER);
        main.setHalignment(lyStart,HPos.CENTER);
        main.setHalignment(lxEnd,HPos.CENTER);
        main.setHalignment(lyEnd,HPos.CENTER);
        main.setHalignment(lblCost,HPos.CENTER);

        main.setHalignment(txStart,HPos.CENTER);
        main.setHalignment(txEnd,HPos.CENTER);
        main.setHalignment(tyStart,HPos.CENTER);
        main.setHalignment(tyEnd,HPos.CENTER);
        main.setHalignment(txtCost,HPos.CENTER);

        //setting the positions of the elements in the GUi
        GridPane.setConstraints(btnStart,1,8,1,1);
        GridPane.setConstraints(btnReset,1,9,1,2);
        GridPane.setConstraints(map,6,1,4,6);
        GridPane.setConstraints(vBox1,1,2);
        GridPane.setConstraints(vBox2,1,5);
        GridPane.setConstraints(buttons,1,6);
        GridPane.setConstraints(cB1,1,7);

        //adding elements to the main grid pane
        main.getChildren().addAll(map,vBox1,vBox2,vBox3, btnStart,buttons,btnReset,cB1);

        primaryStage.setTitle("Path Finder");

        //setting scene
        Scene scene = new Scene(main, 1000, 955);
        scene.getStylesheets().add("Styling/Styling.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);

    }


}
