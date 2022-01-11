package application;

import java.nio.file.Files;
import java.nio.file.Paths;
import javafx.application.Application;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;
import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;

public class PartiesApplication extends Application {

	// save all as string because there is "-"
	private HashMap<String, HashMap<Integer, String>> partyMap;


	@Override
	public void start(Stage window) {
		this.partyMap = new HashMap<>();

		// create the axes for the chart
		NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
		NumberAxis yAxis = new NumberAxis(0, 30, 5);

		// create the LineChart object
		LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
		lineChart.setTitle("Relative support of the parties");

		// create a file reader
		try {
			// how to do with the tsv file -
			// 1. read the file
			// 2. Use hashmap to store - <party(String), <year(int), sup(double)>>
			Files.lines(Paths.get("partiesdata.tsv")).forEach(row -> {
				String[] parts = row.split("\t");

				// a hashmap to store the yearly support rate
				HashMap<Integer, String> yearSupportPair = new HashMap<>();

				// parts[1-11] is the year 1968 ~ 2008
				// use the for loop to add to hashmap
				int partsNumber = 1; // this use to increment the parts number
				for (int year = 1968; year <= 2008; year = year + 4) {
					if (parts[partsNumber].equals("-")) {
						partsNumber++;
						continue;
					}
					yearSupportPair.put(year, parts[partsNumber]);
					partsNumber++;
				}

				// save it to instance variable
				partyMap.put(parts[0], yearSupportPair);
			});

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		// remove the first element "Party"
		this.partyMap.remove("Party");

		// test to check if the hashmap is successfully created
		// System.out.println(this.partyMap.get("KESK").get(2000));
		// create the XYChart for each data
		// use stream to add the data respectively
		this.partyMap.keySet().stream().forEach(each -> {

			// each here is parties key
			// HashMap<String, HashMap<Integer, String>>
			// HashMap<Party, map<Year, rank>>
			HashMap<Integer, String> value = this.partyMap.get(each);

			XYChart.Series series = new XYChart.Series<>();
			series.setName(each);

			// go through the sub-HashMap keyset and add the XYChart Data to the series
			for (Integer per : value.keySet()) {
				series.getData().add(new XYChart.Data<>(per, Double.valueOf(value.get(per))));
			}

			// add to the linechart
			lineChart.getData().add(series);
		});

		// start the window
		Scene scene = new Scene(lineChart, 640, 480);
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args) {
		launch(PartiesApplication.class);
	}

}
