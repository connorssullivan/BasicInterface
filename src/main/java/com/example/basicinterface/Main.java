package com.example.basicinterface;

import com.example.basicinterface.datamodel.LiftData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader root = new FXMLLoader(Main.class.getResource("mainwindow.fxml"));
        Scene scene = new Scene(root.load(), 900, 500);
        stage.setTitle("Checklist");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        try {
            LiftData.getInstance().storeLifts();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws Exception {
        try {
            LiftData.getInstance().loadLifts();

        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}