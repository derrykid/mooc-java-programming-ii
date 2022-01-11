package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

	@Override
	public void start(Stage window) {

		VBox vBox = new VBox();

		// saving borderpane
		BorderPane savingPane = new BorderPane();
		Label savingLabel = new Label("Monthly savings");
		Slider savingSlider = new Slider(25, 250, 25);
		Label showSavingNow = new Label("");
		savingSlider.setShowTickMarks(true);
		savingSlider.setShowTickLabels(true);
		savingSlider.setMajorTickUnit(25);
		savingSlider.setBlockIncrement(25);

		savingPane.setLeft(savingLabel);
		savingPane.setCenter(savingSlider);
		savingPane.setRight(showSavingNow);

		// interest borderpane
		BorderPane intPane = new BorderPane();
		Label intLabel = new Label("Yearly interest rate");
		Slider intSlider = new Slider(0, 10, 0);
		Label showIntNow = new Label("");
		intSlider.setShowTickMarks(true);
		intSlider.setShowTickLabels(true);
		intSlider.setMajorTickUnit(10);
		intSlider.setBlockIncrement(5);

		intPane.setLeft(intLabel);
		intPane.setCenter(intSlider);
		intPane.setRight(showIntNow);

		// add to vBox
		vBox.getChildren().addAll(savingPane, intPane);

		// vBox styling
		vBox.setPadding(new Insets(10, 10, 10, 10));

		// line chart
		NumberAxis xAxis = new NumberAxis(0, 30, 1);
		NumberAxis yAxis = new NumberAxis();
		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle("Yearly saving");
		lineChart.setLegendVisible(false);

		// a default XYChart series - saving series
		XYChart.Series defaultSeries = new XYChart.Series<>();
		for (int i = 0; i <= 30; i++) {
			defaultSeries.getData().add(new XYChart.Data<>(i, savingSlider.getValue() * i * 12));
		}
		lineChart.getData().add(defaultSeries);

		// slider listener
		// Although these code works, these 2 listeners code aren't clean.
		// I should create an individual object to "updateChart(params, ...)" to help update each
		// others' solution is much clearner and will not show a repeating error
		savingSlider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> change, Number oldValue, Number newValue) {

				if (lineChart.getData().contains(defaultSeries)) {
					lineChart.getData().remove(defaultSeries);
				}
				showSavingNow.setText(String.format("%.1f", savingSlider.getValue()));
				XYChart.Series savingSeries = new XYChart.Series();
				for (int i = 0; i <= 30; i++) {
					savingSeries.getData().add(new XYChart.Data<>(i, savingSlider.getValue() * i * 12));
				}
				lineChart.getData().add(savingSeries);
			}

		});

		intSlider.valueProperty().addListener(new ChangeListener<Number>() {

			@Override
			public void changed(ObservableValue<? extends Number> change, Number oldValue, Number newValue) {
				// 2. let the 2 XYChart series exist the same time
				String intSliderValue = String.format("%.2f", intSlider.getValue());
				showIntNow.setText(intSliderValue);

				// interest series line
				// lineChart.getData().clear();
				XYChart.Series intSeries = new XYChart.Series();
				// yearlyBalance = ( yearlybal + saving ) * (1 + interest rate)
				double yearlyBalance = 0.00;

				// if monthly = 25, this is 300 // every year, save this amount of money
				double yearlySaving = savingSlider.getValue() * 12;
				double intRate = 1 + intSlider.getValue() / 100;
				for (int i = 0; i <= 30; i++) {
					if (i == 0) {
						intSeries.getData().add(new XYChart.Data<>(i, yearlyBalance));
						continue;
					}
					yearlyBalance = (yearlyBalance + yearlySaving) * (intRate);
					intSeries.getData().add(new XYChart.Data<>(i, yearlyBalance));
				}
				lineChart.getData().add(intSeries);
			}
		});

		// the layout of the software
		BorderPane layout = new BorderPane();
		layout.setTop(vBox);
		layout.setCenter(lineChart);

		Scene scene = new Scene(layout, 600, 480);
		window.setScene(scene);
		window.show();

	}

	public static void main(String[] args) {
		launch(SavingsCalculatorApplication.class);
	}

}
