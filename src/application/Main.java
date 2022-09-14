package application;

import game.game;
import game.player;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

	board board;
	game game ;
	player player1;
	player player2;


	public void start(Stage primaryStage) {

		try {


			board = new board();
			board.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(board.scene);
			primaryStage.show();
			primaryStage.setResizable(false);


			board.b1.setOnAction(e-> choose(e));
			board.b2.setOnAction(e-> choose(e));
			board.b3.setOnAction(e-> choose(e));
			board.b4.setOnAction(e-> choose(e));
			board.b5.setOnAction(e-> choose(e));
			board.b6.setOnAction(e-> choose(e));
			board.b7.setOnAction(e-> choose(e));
			board.b8.setOnAction(e-> choose(e));
			board.b9.setOnAction(e-> choose(e));


			player1 = new player("First");
			player2 = new player("Second");

			game = new game(player1,player2);
			
			//---
			game.getCoin().Flip();
			activeName();



		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private void choose(ActionEvent e) {
		if(((Button)e.getSource()).getGraphic() != null)
			((Button)e.getSource()).setGraphic(null);

		if(!(((Button)e.getSource()).getText().equals("")))
			return ;
		if(game.isXturn()) {
			((Button)e.getSource()).setText("X");
		}
		else {
			((Button)e.getSource()).setText("O");
		}

		game.insertxo((2-GridPane.getRowIndex(((Button)e.getSource()))),GridPane.getColumnIndex(((Button)e.getSource())));
		activeName();
		if(game.win()|| game.draw()) 
			newround();  

	}
	
	

	private void newround() {
		game.endround();

		for(int i=0 ;i<board.gridpane.getChildren().size();i++ ) {

			((Button)board.gridpane.getChildren().get(i)).setText("");
		}
		board.toplabel.setText(game.getPlayer1().getPoints() + "-"+game.getPlayer2().getPoints() );
	}
	
		
	private void activeName() {
		if(player1.getName().equals(game.getCoin().getCurrent().getName())) {
			board.fpl.setFill(Color.WHITE);
			board.fpl.setStroke(Color.RED);
			board.spl.setFill(Color.RED);
			board.spl.setStroke(null);
			}
		if(player2.getName().equals(game.getCoin().getCurrent().getName())) {
			board.spl.setFill(Color.WHITE);
			board.spl.setStroke(Color.RED);
			board.fpl.setFill(Color.RED);
			board.fpl.setStroke(null);
			}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
