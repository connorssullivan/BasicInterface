package com.example.basicinterface;

import com.example.basicinterface.datamodel.Lift;
import com.example.basicinterface.datamodel.LiftData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<Lift> lifts;

    @FXML
    private ListView<Lift> liftsListView;

    @FXML
    private TextArea liftDetailsTextArea;

    @FXML
    private Label dateLabel;

    public void initialize() {
//        Lift lift0 = new Lift("Upper", "Bench: 10x3\nPull Ups: 10x3\nPush Ups 10x3",
//                LocalDate.of(2022, Month.JUNE, 1));
//        Lift lift1 = new Lift("Upper", "Bench: 10x3\nPull Ups: 10x3\nPush Ups 10x3",
//                LocalDate.of(2022, Month.JUNE, 6));
//        Lift lift2 = new Lift("Lower", "Squat: 10x3\nHamstring Curls: 10x3\nCalf Raise 10x3",
//                LocalDate.of(2022, Month.JUNE, 7));
//        Lift lift3 = new Lift("Upper", "Bench: 10x3\nPull Ups: 10x3\nPush Ups 10x3",
//                LocalDate.of(2022, Month.JUNE, 8));
//
//        lifts = new ArrayList<Lift>();
//        lifts.add(lift0);
//        lifts.add(lift1);
//        lifts.add(lift2);
//        lifts.add(lift3);
//
//        LiftData.getInstance().setLifts(lifts);

        liftsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Lift>() {
            @Override
            public void changed(ObservableValue<? extends Lift> observableValue, Lift oldLift, Lift newLIft) {
                if (newLIft != null) {
                    Lift lift1 = liftsListView.getSelectionModel().getSelectedItem();
                    liftDetailsTextArea.setText(lift1.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    dateLabel.setText(df.format(lift1.getDateTime()));
                }
            }
        });

        liftsListView.getItems().setAll(LiftData.getInstance().getLifts());
        liftsListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        liftsListView.getSelectionModel().selectFirst();
        //DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        //dateLabel.setText(df.format(lifts.get(0).getDateTime()));
    }

    @FXML
    public void handleClickedLiftListView() {
        Lift lift1 = liftsListView.getSelectionModel().getSelectedItem();
        liftDetailsTextArea.setText(lift1.getDetails());
        dateLabel.setText(lift1.getDateTime().toString());


    }

}