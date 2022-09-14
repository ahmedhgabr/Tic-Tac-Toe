package application;



import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class board {

	GridPane gridpane;

	BorderPane borderpane;

	Text fpl;
	Text spl;

	Text toplabel;


	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	Button b6;
	Button b7;
	Button b8;
	Button b9;

	VBox vbox1;
	VBox vbox2;

	HBox hbox;

	Scene scene;

	public board() {

		borderpane= new BorderPane();

		vbox1 = new VBox(100);
		vbox2 = new VBox(100);
		hbox = new HBox(100);

		vbox1.setPadding(new Insets(25,25, 25, 25));
		vbox2.setPadding(new Insets(25,25, 25, 25));
		hbox.setPadding(new Insets(25,25,25,25));



		//		fpl = new Label("First Player Points");
		//		spl = new Label("Second Player Points");
		//		toplabel = new Label("Round 1");
		//
		//		vbox1.getChildren().add(fpl);
		//		vbox2.getChildren().add(spl);
		//		hbox.getChildren().add(toplabel);

		String [] names  = {"Dracula", "Golem", "Goblin", "Minotaur ","Centaur", "Griffin", "Werewolf",
				"Phoenix" , "Hydra ", "Medusa " ,"Dr.Rami"};
		Font font = Font.loadFont("file:src\\Creep.ttf", 45);

		int r= (int) (Math.random()*10) ;
		fpl = new Text(30.0, 75.0,names[r]);
		spl = new Text(30.0, 75.0,names[r+1]);
		toplabel = new Text(30.0, 75.0,"Round 1");

		fpl.setFont(font);
		fpl.setFill(Color.RED);
		spl.setFont(font);
		spl.setFill(Color.RED);
		toplabel.setFont(font);
		toplabel.setFill(Color.RED);
		hbox.getChildren().addAll(fpl,toplabel,spl);

		gridpane = new GridPane();

		b1 = new Button();
		b2 = new Button();
		b3 = new Button();
		b4 = new Button();
		b5 = new Button();
		b6 = new Button();
		b7 = new Button();
		b8 = new Button();
		b9 = new Button();


		b1.setMinSize(150, 150);
		b2.setMinSize(150, 150);
		b3.setMinSize(150, 150);
		b4.setMinSize(150, 150);
		b5.setMinSize(150, 150);
		b6.setMinSize(150, 150);
		b7.setMinSize(150, 150);
		b8.setMinSize(150, 150);
		b9.setMinSize(150, 150);

		gridpane.getChildren().addAll(b1,b2,b3,b4,b5,b6,b7,b8,b9);
		gridpane.setVgap(5);
		gridpane.setHgap(5);

		
		//----------------
		
		for(Node b : gridpane.getChildren()) {
			((Button)b).setFont(font);
			((Button)b).setTextFill(Color.WHITE);
		}
		
		BackgroundFill bgBlack = new BackgroundFill(Color.rgb(10, 10, 10), CornerRadii.EMPTY,
				Insets.EMPTY);
		Background background = new Background(bgBlack);
		borderpane.setBackground(background);

		BackgroundFill bgRed = new BackgroundFill(Color.rgb(70, 17, 17), CornerRadii.EMPTY,
				Insets.EMPTY);
		Background backgroundButtons = new Background(bgRed);

		BackgroundFill bgFine = new BackgroundFill(Color.rgb(17, 15, 12), CornerRadii.EMPTY,
				Insets.EMPTY);
		Background backgroundFine = new Background(bgFine);
		try {
			FileInputStream inputstream = new FileInputStream("src\\itsfine.gif");
			Image fine = new Image(inputstream); 
			ImageView fineView = new ImageView(fine);
			fineView.setFitHeight(80);
			fineView.setFitWidth(90);


			int ran = (int) (Math.random()*9) ;
			for (int i = 0 ; i < 9 ; i ++) {
				if (i == ran) {
					((Button) gridpane.getChildren().get(i)).setGraphic(fineView);
					((Button) gridpane.getChildren().get(i)).setBackground(backgroundFine);
				}
				else
					((Button) gridpane.getChildren().get(i)).setBackground(backgroundButtons);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} 
		
		//-----------
		GridPane.setConstraints(b1, 0, 2);
		GridPane.setConstraints(b2, 1, 2);
		GridPane.setConstraints(b3, 2, 2);

		GridPane.setConstraints(b4, 0, 1);
		GridPane.setConstraints(b5, 1, 1);
		GridPane.setConstraints(b6, 2, 1);		

		GridPane.setConstraints(b7, 0, 0);
		GridPane.setConstraints(b8, 1, 0);
		GridPane.setConstraints(b9, 2, 0);


		gridpane.setAlignment(Pos.CENTER);

		borderpane.setCenter(gridpane);
		borderpane.setLeft(vbox1);
		borderpane.setRight(vbox2);
		borderpane.setTop(hbox);

		hbox.setAlignment(Pos.BASELINE_CENTER);
		vbox1.setAlignment(Pos.TOP_CENTER);
		vbox2.setAlignment(Pos.TOP_CENTER);

		scene = new Scene(borderpane, 800 ,600);

		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());



	}






}
