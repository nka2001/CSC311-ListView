package com.mycompany.listview;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.Scanner;

public class PrimaryController {

    @FXML
    private ListView<String> listViewShows;
    @FXML
    private TextField textField;
    @FXML
    private Button AddShowButton;
    @FXML
    private Button clearButton;
    @FXML
    private Button readFromFile;
    
    public void initialize() {//Part 1, add and initialize method to put some data into the listView CHECK SPELLING
    
        ObservableList<String> i = listViewShows.getItems();//creates an observable list to show the items in the listView
        i.add("What we do in the shadows");//sample text 1
        i.add("Superstore");//sample text 2

    }

    @FXML
    private void addShow(ActionEvent event) {//Part 2, add button on the GUI, it does....
        
        String str = textField.getText();//gets the text from the user in a textfield
       
        ObservableList<String> i = listViewShows.getItems();//again, creates an observable list
        i.add(str);//adds string to the listview
        
        textField.setText("");//clears the text of the textField, so the text isnt added twice by mistake
    }

    @FXML
    private void clearList(ActionEvent event) {//Part 3, clear button on the GUI, it does...
        
        ObservableList<String> i = listViewShows.getItems();//creates an observable list
        i.clear();//then clears the list completely 
        
    }
    
    @FXML
    protected void handleListViewItemsMouseClick(MouseEvent e){//Part 4,is used to show items clicked on in the listview, it prints to the console not the GUI
        ObservableList<String> ov = listViewShows.getItems();//creates an observable list
        
        int selectedIndex = listViewShows.getSelectionModel().getSelectedIndex();//this will grab the index of the clicked item on the listview and set it to the variable selectedIndex
        
        if(selectedIndex >= 0 && selectedIndex < ov.size()){//this will check and make sure the selected index is positive and it is not greater than the listview's size 
            System.out.println("Selected Item: " + ov.get(selectedIndex));//finally, prints out the selected index
        }
    }

    @FXML
    private void readFromFile(ActionEvent event) throws FileNotFoundException {//Part 5, this will read from a file and insert the items in the file and add them to the list 
        
        File f = new File("Shows.txt");//create a new file object
        
        
        Scanner scan = new Scanner(f);//creates scanner object, this is for reading from the file
        
        while(scan.hasNextLine()){//while the file has a next line...
             ObservableList<String> i = listViewShows.getItems();//creates an observable list
             String str = scan.nextLine();//gets the text from the file's current line 
             i.add(str);//adds the string to the file
        }
        
        
    }
    
}
