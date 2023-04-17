package com.example.project;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class optionsController {

    @FXML
    private Button budgetApp;
    @FXML
    private Button transHis;
    @FXML
    private Button exit;
    private Stage stage;
    private Scene scene;
    private Parent root;


    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    private float balance;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    private String username;
@FXML
    protected void incomeClick(ActionEvent event){
    FXMLLoader loader = new FXMLLoader(getClass().getResource("option2income.fxml"));
    Parent root = null;
    try {
        root = loader.load();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    optionsController2 main = loader.getController();
    main.setBalance(getBalance());
    main.setUsername(getUsername());

    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root, 1049, 518);
    stage.setScene(scene);
    stage.show();

    }
@FXML
protected void expenseClick(ActionEvent event){
    try{
    FXMLLoader loader = new FXMLLoader(getClass().getResource("option2expense.fxml"));
    Parent root = null;

        root = loader.load();


    optionsController2expenses main = loader.getController();
    main.setBalance(getBalance());
    main.setUsername(getUsername());

    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root, 1049, 518);
    stage.setScene(scene);
    stage.show();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
    @FXML
    protected void analysisClick(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("option2.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        analysisController main = loader.getController();
        main.setBalance(getBalance());
        main.setUsername(getUsername());
        try {
            main.initializing(getUsername());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1049, 518);
        stage.setScene(scene);
        stage.show();
    }

}