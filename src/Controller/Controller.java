package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Generator.Randnumbers;
import Main.algotest;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controller {

    public TextField ElementSIze;

    public TextField StepSize;
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
    void GenerateNUms(ActionEvent event) throws IOException {
        int fileSize;
        try {
            fileSize = Integer.parseInt(ElementSIze.getText());
            Randnumbers.GenerateNums(fileSize);
            System.out.println("it is a integer keep going champ");
        } catch (Exception x) {
            AlertBox.display("error","you need to input a number please try again.");
        }

    }


    @FXML
    void LoadGraph(ActionEvent event) throws IOException {
        ChartComp.getData().clear();
        ChartComp.cacheProperty().unbind();
        int numoftrueboxes = 0;
        boolean[] boxesBool = new boolean[6];
        CheckBox[] boxes = {Insertion, Merge, Heap, Quick, Counting, Radix};
        String[] AlgoNames = {"Insertion", "Merge", "Heap", "Quick", "Counting", "Radix"};
        //Selected
        for (int i = 0; i < 6; i++) {
            if (boxes[i].isSelected()) {
                numoftrueboxes++;
                boxesBool[i] = true;

            } else {
                boxesBool[i] = false;
            }
        }


        if (numoftrueboxes < 1) {
            AlertBox.display("no boxes is picked", "please pick a box");
            return;
        }
        for (int z = 0; z < 6; z++) {
            if (boxesBool[z]) {
                XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
                algotest test = new algotest();
                int[] RR = test.call(z);
                for (int i = 0; i < RR.length; i++) {
                    series.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), RR[i]));

                }
                series.setName(AlgoNames[z]);
                ChartComp.getData().add(series);
            }
        }
    }

}

