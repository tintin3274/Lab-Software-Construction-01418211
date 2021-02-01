package to_do_list;

import javafx.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {
    @FXML Button saveButton, removeButton, statusButton, editButton;
    @FXML TextField titleFieldInput, titleFieldShow, date_timeFieldShow;
    @FXML TextArea descriptionFieldInput, descriptionFieldShow;
    @FXML DatePicker dateFieldInput, dateFieldShow;
    @FXML Spinner hourFieldInput, minuteFieldInput;
    @FXML TableView<ToDoList> listTable;
    @FXML TableColumn<ToDoList, LocalDate> dateTable;
    @FXML TableColumn<ToDoList, String> titleTable;
    @FXML TableColumn<ToDoList, String> statusTable;
    @FXML TableColumn<ToDoList, String> descriptionTable;
    @FXML TableColumn<ToDoList, String> date_timeTable;


    @FXML public void initialize(){
        dateTable.setCellValueFactory(new PropertyValueFactory<>("date"));
        date_timeTable.setCellValueFactory(new PropertyValueFactory<>("date_time"));
        titleTable.setCellValueFactory(new PropertyValueFactory<>("title"));
        statusTable.setCellValueFactory(new PropertyValueFactory<>("statusText"));
        descriptionTable.setCellValueFactory(new PropertyValueFactory<>("description"));
        listTable.setItems(listData);
        SpinnerValueFactory<Integer> hourFieldInputValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,23,12);
        SpinnerValueFactory<Integer> minuteFieldInputValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);
        this.hourFieldInput.setValueFactory(hourFieldInputValueFactory);
        this.minuteFieldInput.setValueFactory(minuteFieldInputValueFactory);
    }

    final ObservableList<ToDoList> listData = FXCollections.observableArrayList();

    @FXML private void handleSaveButtonOnAction(ActionEvent event) {
        if((dateFieldInput.getValue() != null) && !titleFieldInput.getText().equals("") && !descriptionFieldInput.getText().equals("")){
            String time = "";
            int h = (int) hourFieldInput.getValue();
            int m = (int) minuteFieldInput.getValue();
            if(h < 10){
                time += "0"+h+":";
            }
            else{
                time += h+":";
            }
            if(m < 10){
                time += "0"+m;
            }
            else{
                time += m;
            }
            listData.add(new ToDoList(dateFieldInput.getValue(), dateFieldInput.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))+" / "+time,titleFieldInput.getText(), descriptionFieldInput.getText(), h, m));
            dateFieldInput.setValue(null);
            titleFieldInput.setText("");
            descriptionFieldInput.setText("");
            SpinnerValueFactory<Integer> hourFieldInputValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,23,12);
            SpinnerValueFactory<Integer> minuteFieldInputValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,0);
            this.hourFieldInput.setValueFactory(hourFieldInputValueFactory);
            this.minuteFieldInput.setValueFactory(minuteFieldInputValueFactory);
        }
    }

    @FXML private void handleTableClicked(MouseEvent event){
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1) {
            int index = listTable.getSelectionModel().getSelectedIndex();
            if(index != -1){
                dateFieldShow.setValue(listData.get(index).getDate());
                titleFieldShow.setText(listData.get(index).getTitle());
                descriptionFieldShow.setText(listData.get(index).getDescription());
                date_timeFieldShow.setText(listData.get(index).getDate_time());
                listTable.refresh();
            }
        }
    }

    @FXML private void handleRemoveButton(ActionEvent event){
        if(!listData.isEmpty()){
            int index = listTable.getSelectionModel().getSelectedIndex();
            if(index != -1){
                listData.remove(index);
                dateFieldShow.setValue(null);
                titleFieldShow.setText("");
                descriptionFieldShow.setText("");
                date_timeFieldShow.setText("");
                listTable.refresh();
            }
        }
    }

    @FXML private void handleStatusButton(ActionEvent event){
        if(!listData.isEmpty()){
            int index = listTable.getSelectionModel().getSelectedIndex();
            if(index != -1){
                listData.get(index).setStatus();
                listData.get(index).setStatusText();
                listTable.refresh();
            }
        }
    }

    @FXML private void handleEditButton(ActionEvent event){
        if(!listData.isEmpty()){
            int index = listTable.getSelectionModel().getSelectedIndex();
            if(index != -1){
                dateFieldInput.setValue(listData.get(index).getDate());
                titleFieldInput.setText(listData.get(index).getTitle());
                descriptionFieldInput.setText(listData.get(index).getDescription());
                SpinnerValueFactory<Integer> hourFieldInputValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,23,listData.get(index).getHour());
                SpinnerValueFactory<Integer> minuteFieldInputValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,59,listData.get(index).getMinute());
                this.hourFieldInput.setValueFactory(hourFieldInputValueFactory);
                this.minuteFieldInput.setValueFactory(minuteFieldInputValueFactory);
                dateFieldShow.setValue(null);
                titleFieldShow.setText("");
                descriptionFieldShow.setText("");
                date_timeFieldShow.setText("");
                listTable.refresh();
            }
        }
    }
}