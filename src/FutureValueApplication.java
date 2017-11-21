import java.text.NumberFormat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class FutureValueApplication extends Application{

	TextField investmentField;
	TextField interestRateField;
	TextField yearsField;
	TextField futureValueField;

	public static void main(String[] args)  {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Future Value Calcluator");
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setPadding(new Insets(25,25,25,25));
		grid.setHgap(10);
		grid.setVgap(10);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(60);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(40);
		grid.getColumnConstraints().addAll(col1,col2);
		Scene scene = new Scene(grid);
		
		investmentField = new TextField();
		interestRateField = new TextField();
		yearsField = new TextField();
		futureValueField = new TextField();
		grid.add(new Label("Monthly Investment:"), 0, 0);
		grid.add(investmentField, 1, 0);
		grid.add(new Label("Yearly Interest Rate:"), 0, 1);
		grid.add(interestRateField, 1, 1);
		grid.add(new Label("Years:"), 0, 2);
		grid.add(yearsField, 1, 2);
		grid.add(new Label("Future Value:"), 0, 3);
		futureValueField.setEditable(false);
		grid.add(futureValueField, 1, 3);
		
		Button calculateButton = new Button("Calculate");
		calculateButton.setOnAction(event-> calculateButtonClicked());
		Button exitButton = new Button("Exit");
		exitButton.setOnAction(event-> exitButtonClicked());
		
		HBox buttonBox = new HBox(10);
		buttonBox.getChildren().add(calculateButton);
		buttonBox.getChildren().add(exitButton);
		buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
		
		grid.add(buttonBox, 0, 4, 2, 1);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	private void calculateButtonClicked() {
		double investment = Double.parseDouble(investmentField.getText());
		double rate = Double.parseDouble(interestRateField.getText());
		int years = Integer.parseInt(yearsField.getText());
		
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		double futureValue = FinancialCalculations.calculateFutureValue(investment, rate, years);
		futureValueField.setText(currency.format(futureValue));
	}

	private void exitButtonClicked() {
		System.exit(0);
	}

}
