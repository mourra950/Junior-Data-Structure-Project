package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private LineChart<String, Number> ChartComp;

    @FXML
    private CheckBox Counting;

    @FXML
    private CheckBox Heap;

    @FXML
    private CheckBox Insertion;

    @FXML
    private CheckBox Merge;

    @FXML
    private CheckBox Quick;

    @FXML
    private CheckBox Radix;

    @FXML
    void GenerateNUms(ActionEvent event) {

    }

    @FXML
    void LoadGraph(ActionEvent event) {
        System.out.println("i am here");
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        System.out.println("i am 2");

        series.getData().add(new XYChart.Data<String,Number>("0",20));
        series.getData().add(new XYChart.Data<String,Number>("20",20));
        series.getData().add(new XYChart.Data<String,Number>("30",20));
        series.getData().add(new XYChart.Data<String,Number>("40",5000));
        series.getData().add(new XYChart.Data<String,Number>("50",10000));
        System.out.println("i am 3");

        series.setName("test");
        System.out.println("i am 4");

        ChartComp.getData().add(series);
        System.out.println("i am 5");

    }

    @FXML
    void initialize() {
        assert ChartComp != null : "fx:id=\"ChartComp\" was not injected: check your FXML file 'Main.fxml'.";
        assert Counting != null : "fx:id=\"Counting\" was not injected: check your FXML file 'Main.fxml'.";
        assert Heap != null : "fx:id=\"Heap\" was not injected: check your FXML file 'Main.fxml'.";
        assert Insertion != null : "fx:id=\"Insertion\" was not injected: check your FXML file 'Main.fxml'.";
        assert Merge != null : "fx:id=\"Merge\" was not injected: check your FXML file 'Main.fxml'.";
        assert Quick != null : "fx:id=\"Quick\" was not injected: check your FXML file 'Main.fxml'.";
        assert Radix != null : "fx:id=\"Radix\" was not injected: check your FXML file 'Main.fxml'.";

    }

}

