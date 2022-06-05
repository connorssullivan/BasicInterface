package com.example.basicinterface.datamodel;

import javafx.collections.FXCollections;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

public class LiftData {
    private static LiftData instance = new LiftData();
    private static String filename = "LiftData.txt";

    private List<Lift> lifts;
    private DateTimeFormatter formatter;

    public static LiftData getInstance() {
        return instance;
    }

    private LiftData() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public List<Lift> getLifts() {
        return lifts;
    }

    public void setLifts(List<Lift> lifts) {
        this.lifts = lifts;
    }

    public void loadLifts() throws IOException {
        lifts = FXCollections.observableArrayList();
        Path path = Paths.get(filename);
        BufferedReader br = Files.newBufferedReader(path);

        String input;

        try {
            while ((input = br.readLine()) != null) {
                String[] pieces = input.split("_");


                String bodyPart = pieces[0];
                String details = pieces[1];
                String day = pieces[2];
                LocalDate date = LocalDate.parse(day, formatter);

                Lift lift = new Lift(bodyPart, details, date);
                lifts.add(lift);
            }

        } finally {
            if (br!=null) {
                br.close();
            }
        }
    }
    public void storeLifts() throws IOException {
        Path path = Paths.get(filename);
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<Lift> iter = lifts.iterator();
            while (iter.hasNext()) {
                Lift lift = iter.next();
                bw.write(String.format("%s_%s_%s",
                        lift.getBodyPart(),
                        lift.getDetails(),
                        lift.getDateTime().format(formatter)));
                bw.newLine();
            }
        }finally {
            if (bw!=null) {
                bw.close();
            }
        }
    }

}
