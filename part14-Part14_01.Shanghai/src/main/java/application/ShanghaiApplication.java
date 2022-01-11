package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

	@Override
	public void start(Stage window) {

		// create the axes for the chart
		NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
		NumberAxis yAxis = new NumberAxis(0, 100, 10);

		// set the titles
		xAxis.setLabel("Year");
		yAxis.setLabel("Ranking");

		// create the line chart
		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle("University of Helsinki, Shanghai ranking");
		
		// lineChart.setLegendVisible(false);   // this line helps to set the "indicator" invisible

		
		XYChart.Series dota = new XYChart.Series();

		dota.getData().add(new XYChart.Data<>(2007, 73));
		dota.getData().add(new XYChart.Data<>(2008, 68));
		dota.getData().add(new XYChart.Data<>(2009, 72));
		dota.getData().add(new XYChart.Data<>(2010, 72));
		dota.getData().add(new XYChart.Data<>(2011, 74));
		dota.getData().add(new XYChart.Data<>(2012, 73));
		dota.getData().add(new XYChart.Data<>(2013, 76));
		dota.getData().add(new XYChart.Data<>(2014, 73));
		dota.getData().add(new XYChart.Data<>(2015, 67));
		dota.getData().add(new XYChart.Data<>(2016, 56));
		dota.getData().add(new XYChart.Data<>(2017, 56));

		/*
		2007 73
		2008 68
		2009 72
		2010 72
		2011 74
		2012 73
		2013 76
		2014 73
		2015 67
		2016 56
		2017 56
		 */
		lineChart.getData().add(dota);
		Scene scene = new Scene(lineChart, 640, 480);
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args) {
		launch(ShanghaiApplication.class);
	}

}
