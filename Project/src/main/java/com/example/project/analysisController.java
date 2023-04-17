package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class analysisController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    private String username;

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    private float balance;

    @FXML
    private Label incomes;
    @FXML
    private Label expenses;
    @FXML
    private Label savings;
    @FXML
    private Label percentDiffs;
    private float totalIncome;
    private float totalExpense;
    private float total;

    @FXML
    void initializing(String username) throws FileNotFoundException {
        Queue<Float> income = new LinkedList<>();
        Queue<Float> expense = new LinkedList<>();

        try {
            File folder = new File("target/classes/com/example/project/" + getUsername());
            File file = new File(folder + "/transactions.txt");

            System.out.println(getUsername());
            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {
                String in = input.nextLine();
                String[] wiw1 = in.split(",");
                if (wiw1[4].equals("income")) {
                    income.offer(Float.parseFloat(wiw1[2]));
                }
                if (wiw1[4].equals("expense")) {
                    expense.offer(Float.parseFloat(wiw1[2]));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        while(!income.isEmpty()){
            totalIncome += income.poll();

        }
        while(!expense.isEmpty()){
            totalExpense += expense.poll();
        }
        total = getBalance() + totalIncome - totalExpense;

        float percentDiff = (total - getBalance()/getBalance()) * 100;

        incomes.setText(String.valueOf(totalIncome));
        expenses.setText(String.valueOf(totalExpense));
        savings.setText(String.valueOf(total));
        percentDiffs.setText(String.valueOf(percentDiff+"%"));
    }
    @FXML
    void backClick(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main_Menu.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        mainMenuController main = loader.getController();
        main.setBalance(getBalance());
        main.setUsername(getUsername());

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1049, 518);
        stage.setScene(scene);
        stage.show();
    }
}