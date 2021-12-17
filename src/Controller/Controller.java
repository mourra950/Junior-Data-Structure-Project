package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Main.algotest;
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
    void LoadGraph(ActionEvent event) throws IOException {

        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        algotest test = new algotest();
        int[] RR = test.call();
//        algotest test = new algotest();
//        int[] RR = test.call();
        for (int i = 0; i < RR.length; i++) {
            series.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), RR[i]));
        }
        //        series.getData().add(new XYChart.Data<String,Number>("20",20));
//        series.getData().add(new XYChart.Data<String,Number>("30",20));
//        series.getData().add(new XYChart.Data<String,Number>("40",5000));
//        series.getData().add(new XYChart.Data<String,Number>("50",10000));
//        System.out.println("i am 3");

        series.setName("test");


        ChartComp.getData().add(series);


    }

    @FXML
    void initialize() {


    }

}

