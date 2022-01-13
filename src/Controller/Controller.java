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
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class Controller {
    String[] AlgoNames = {"Insertion", "Merge", "Heap", "Quick", "Counting", "Radix", "nSquare", "nlogn", "Kplusn", "dkplusdn"};

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
    private CheckBox nSquare;

    @FXML
    private CheckBox nlogn;

    @FXML
    void GenerateNUms(ActionEvent event) throws IOException {
        int fileSize;
        try {
            fileSize = Integer.parseInt(ElementSIze.getText());
            Randnumbers.GenerateNums(fileSize);
            AlertBox.display("Success","File Generated");
        } catch (Exception x) {
            AlertBox.display("error", "you need to input a number please try again.");
        }

    }

    int step_size = 0;

    @FXML
    void LoadGraph(ActionEvent event) throws IOException {
        try {
            step_size = Integer.parseInt(StepSize.getText());
        } catch (Exception e) {
            step_size = 1;
            AlertBox.display("error", "input was not a number so the graph will be shown using one as step size");
        }
        ChartComp.getData().clear();
        ChartComp.cacheProperty().unbind();
        int tbox = -1;
        int numoftrueboxes = 0;
        boolean[] boxesBool = new boolean[8];
        CheckBox[] boxes = {Insertion, Merge, Heap, Quick, Counting, Radix};

        //Selected
        for (int i = 0; i < 6; i++) {
            if (boxes[i].isSelected()) {
                numoftrueboxes++;
                boxesBool[i] = true;
                tbox = i;
            } else {
                boxesBool[i] = false;
            }
        }


        if (numoftrueboxes < 1) {
            AlertBox.display("no boxes is picked", "please pick a box");
            return;
        } else if (numoftrueboxes == 1) {
            if (tbox == 0) {
                graphme(6);
            } else if (tbox == 2 || tbox == 1 || tbox==3) {
                graphme(7);
            } else if (tbox == 4) {
                graphme(8);
            } else {
                graphme(9);
            }
        }


        for (int z = 0; z < 6; z++) {
            if (boxesBool[z]) {
                graphme(z);
            }
        }
    }

    void graphme(int z) throws IOException {
        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        algotest test = new algotest();
        int[] RR = test.call(z);
        for (int i = 0; i < RR.length; i += step_size) {
            series.getData().add(new XYChart.Data<String, Number>(String.valueOf(i), RR[i]));

        }
        series.setName(AlgoNames[z]);
        ChartComp.getData().add(series);
    }

}

