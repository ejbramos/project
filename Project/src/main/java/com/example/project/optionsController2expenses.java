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

import java.io.IOException;

public class optionsController2expenses {

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
    protected void expenseBudgetClick(ActionEvent event){
    FXMLLoader loader = new FXMLLoader(getClass().getResource("Expenses.fxml"));
    Parent root = null;
    try {
        root = loader.load();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    expenseController main = loader.getController();
    main.setBalance(getBalance());
    main.setUsername(getUsername());

    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root, 1049, 518);
    stage.setScene(scene);
    stage.show();

    }
@FXML
protected void expenseCategoriesClick(ActionEvent event){
    FXMLLoader loader = new FXMLLoader(getClass().getResource("categoriesExpense.fxml"));
    Parent root = null;
    try {
        root = loader.load();
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    categoriesExpenseController main = loader.getController();
    main.setBalance(getBalance());
    main.setUsername(getUsername());

    stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    scene = new Scene(root, 1049, 518);
    stage.setScene(scene);
    stage.show();
}
    @FXML
    protected void exitClick(){
        Platform.exit();
    }

}