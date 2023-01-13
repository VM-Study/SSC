package com.example.ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderFastFood extends Application {
    private static final List<String> names = new ArrayList<>();
    private static final List<Boolean> check = new ArrayList<>();
    private static final List<Double> prices = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        Label label = new Label("What do you like to order: ");
        String dollar = " -- $";
        CheckBox c1 = new CheckBox(names.get(0) + dollar + prices.get(0));
        CheckBox c2 = new CheckBox(names.get(1) + dollar + prices.get(1));
        CheckBox c3 = new CheckBox(names.get(2) + dollar + prices.get(2));
        CheckBox c4 = new CheckBox(names.get(3) + dollar + prices.get(3));
        CheckBox c5 = new CheckBox(names.get(4) + dollar + prices.get(4));
        CheckBox c6 = new CheckBox(names.get(5) + dollar + prices.get(5));
        Label label2 = new Label("Extra info for order: ");
        TextField info = new TextField();
        Button orderButton = new Button("Order");

        c1.selectedProperty().addListener((observableValue, aBoolean, t1) -> checkerBool(0));
        c2.selectedProperty().addListener((observableValue, aBoolean, t1) -> checkerBool(1));
        c3.selectedProperty().addListener((observableValue, aBoolean, t1) -> checkerBool(2));
        c4.selectedProperty().addListener((observableValue, aBoolean, t1) -> checkerBool(3));
        c5.selectedProperty().addListener((observableValue, aBoolean, t1) -> checkerBool(4));
        c6.selectedProperty().addListener((observableValue, aBoolean, t1) -> checkerBool(5));

        orderButton.setOnAction(event -> order(info.getText()));


        VBox root = new VBox();
        root.getChildren().addAll(label, c1, c2, c3, c4, c5, c6, label2, info, orderButton);
        Scene scene = new Scene(root, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Order food");
        primaryStage.show();
    }

    private static void totalInfo(String text) {
        Stage primaryStage = new Stage();

        Label label = new Label(text);
        Button orderButton = new Button("Close");
        orderButton.setOnAction(event -> Platform.exit());

        VBox root = new VBox();
        root.getChildren().addAll(label, orderButton);
        Scene scene = new Scene(root, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Order food");
        primaryStage.show();
    }

    private static void order(String extraInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("Your order")
                .append("\n\n-------------------------------\n");
        double totalPrice = 0;
        for (int i = 0; i < check.size(); i++) {
            if (Boolean.TRUE.equals(check.get(i))) {
                totalPrice += prices.get(i);
                stringBuilder.append(names.get(i)).append(" -- $").append(prices.get(i)).append("\n");
            }
        }
        if (!extraInfo.isEmpty()) {
            stringBuilder.append("Extra info: ").append(extraInfo);
        }
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance();
        stringBuilder
                .append("\n\n-------------------------------")
                .append("\nTotal price: $").append(decimalFormat.format(totalPrice));

        totalInfo(String.valueOf(stringBuilder));
    }


    private void checkerBool(int index) {
        check.set(index, !check.get(index));
    }

    public static void main(String[] args) {
        names.add("Hamburger");
        names.add("Cheeseburger");
        names.add("Hot Dog");
        names.add("Fries");
        names.add("Shake");
        names.add("Soda");
        prices.add(3.95);
        prices.add(4.80);
        prices.add(3.50);
        prices.add(2.00);
        prices.add(4.10);
        prices.add(1.45);
        check.add(false);
        check.add(false);
        check.add(false);
        check.add(false);
        check.add(false);
        check.add(false);
        launch();
    }
}