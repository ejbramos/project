package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class transHisController {

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
    private Label date1;
    @FXML
    private Label date2;
    @FXML
    private Label date3;
    @FXML
    private Label date4;
    @FXML
    private Label date5;
    @FXML
    private Label desc1;
    @FXML
    private Label desc2;
    @FXML
    private Label desc3;
    @FXML
    private Label desc4;
    @FXML
    private Label desc5;
    @FXML
    private Label amount1;
    @FXML
    private Label amount2;
    @FXML
    private Label amount3;
    @FXML
    private Label amount4;
    @FXML
    private Label amount5;
    @FXML
    private TableView<trans> table;
    @FXML
    private TableColumn<trans,String> date;
    @FXML
    private TableColumn<trans,String> desc;
    @FXML
    private TableColumn<trans,String> amount;
    private int counter;

    @FXML
    void initializing(String username) throws FileNotFoundException {
        Stack<trans> stack = new Stack<>();
        try {
            File folder = new File("target/classes/com/example/project/" + getUsername());
            File file = new File(folder + "/transactions.txt");

            System.out.println(getUsername());
            Scanner input = new Scanner(file);

            date.setCellValueFactory(new PropertyValueFactory<trans,String>("date"));
            desc.setCellValueFactory(new PropertyValueFactory<trans,String>("description"));
            amount.setCellValueFactory(new PropertyValueFactory<trans,String>("amount"));

            while (input.hasNextLine()) {
                String in = input.nextLine();
                String[] wiw1 = in.split(",");
                stack.push(new trans(wiw1[0],wiw1[1],wiw1[2]));


            }

        }
        catch (Exception e){
            System.out.println(e);
        }
        while(!stack.isEmpty()) {
            trans wiw = stack.pop();
            ObservableList<trans> history = FXCollections.observableArrayList(wiw);
            table.setItems(history);

        }
    }

}