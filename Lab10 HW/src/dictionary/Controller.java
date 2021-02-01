package dictionary;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;

public class Controller implements Serializable {
    @FXML Button clearButton, removeButton, editButton, addButton, exportXMLButton, exportJSONButton;
    @FXML TextField searchTextField, wordTextField, partOfSpeechTextField;
    @FXML TextArea meaningTextArea, exampleTextArea;
    @FXML TableView<Vocabulary> dictionaryTable;
    @FXML TableColumn<Vocabulary, String> wordTable;
    @FXML TableColumn<Vocabulary, String> partOfSpeechTable;
    private Dictionary dictionary = new Dictionary();
    private Vocabulary vocabularySelect = null;
    private int index = -1;

    @FXML public void initialize(){
        wordTable.setCellValueFactory(new PropertyValueFactory<>("word"));
        partOfSpeechTable.setCellValueFactory(new PropertyValueFactory<>("partOfSpeech"));
        dictionaryTable.setItems(listData);

        FilteredList<Vocabulary> filteredListData = new FilteredList<>(listData, b -> true);
        searchTextField.textProperty().addListener(((observable, oldValue, newValue) -> {
            filteredListData.setPredicate(vocabulary -> {
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                String lowerCaseFilter = newValue.toLowerCase();
                if(vocabulary.getWord().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else if(vocabulary.getPartOfSpeech().toLowerCase().indexOf(lowerCaseFilter) != -1){
                    return true;
                }
                else{
                    return false;
                }
            });
        }));

        SortedList<Vocabulary> sortedListData = new SortedList<>(filteredListData);
        sortedListData.comparatorProperty().bind(dictionaryTable.comparatorProperty());
        dictionaryTable.setItems(sortedListData);

        load();

//        Vocabulary v1 = new Vocabulary("motherboard", "NOUN", "the main printed circuit board that contains the CPU of a computer and makes it possible for the other parts of a computer to communicate with each other","Thus, after the selection of the motherboard alone the working-memory resource shows a deficit.");
//        Vocabulary v2 = new Vocabulary("microphone", "NOUN", "a piece of equipment that you speak into to make your voice louder, or to record your voice or other sounds", "1. The interviewer asked her to speak into/use the microphone.\n" +
//                "2. My laptop has a built-in microphone.");
//        Vocabulary v3 = new Vocabulary("blender","NOUN","an electric machine used in the kitchen for breaking down foods or making smooth liquid substances from soft foods and liquids","The dried plant parts were milled to a fine powder using an electric blender.");
//        Vocabulary v4 = new Vocabulary("announce","VERB","to make something known or tell people about something officially","1. They announced the death of their mother in the local paper.\n" +
//                "2. She announced the winner of the competition to an excited audience.\n" +
//                "3. The prime minister has announced that public spending will be increased next year.");
//        Vocabulary v5 = new Vocabulary("drift","VERB","to move slowly, especially as a result of outside forces, with no control over direction","1. No one noticed that the boat had begun to drift out to sea.\n" +
//                "2. A mist drifted in from the marshes.\n" +
//                "3. After the band stopped playing, people drifted away in twos and threes.\n" +
//                "4. The talk drifted aimlessly from one subject to another.");
//        dictionary.addVocabulary(v1.getWord() ,v1);
//        dictionary.addVocabulary(v2.getWord() ,v2);
//        dictionary.addVocabulary(v3.getWord() ,v3);
//        dictionary.addVocabulary(v4.getWord() ,v4);
//        dictionary.addVocabulary(v5.getWord() ,v5);
//        listData.addAll(v1, v2, v3, v4, v5);
    }

    final ObservableList<Vocabulary> listData = FXCollections.observableArrayList();

    @FXML private void handleAddButtonOnAction(ActionEvent event){
        if(!wordTextField.getText().equals("")){
            String word = wordTextField.getText();
            String partOfSpeech = partOfSpeechTextField.getText();
            String meaning = meaningTextArea.getText();
            String example = exampleTextArea.getText();
            Vocabulary vocabulary = new Vocabulary(word, partOfSpeech, meaning, example);
            dictionary.addVocabulary(word ,vocabulary);
            listData.add(vocabulary);
            wordTextField.setText("");
            partOfSpeechTextField.setText("");
            meaningTextArea.setText("");
            exampleTextArea.setText("");
            vocabularySelect = null;
            save();
        }
    }

    @FXML private void handleEditButtonOnAction(ActionEvent event){
        if(!listData.isEmpty()){
            if(index != -1 && vocabularySelect != null && !wordTextField.getText().equals("")){
                String word = wordTextField.getText();
                String partOfSpeech = partOfSpeechTextField.getText();
                String meaning = meaningTextArea.getText();
                String example = exampleTextArea.getText();
                if(vocabularySelect.getWord().equals(word)){
                    vocabularySelect.setPartOfSpeech(partOfSpeech);
                    vocabularySelect.setMeaning(meaning);
                    vocabularySelect.setExample(example);
                }
                else {
                    listData.remove(index);
                    dictionary.removeVocabulary(vocabularySelect);
                    Vocabulary vocabulary = new Vocabulary(word, partOfSpeech, meaning, example);
                    dictionary.addVocabulary(word ,vocabulary);
                    listData.add(index, vocabulary);
                }

                wordTextField.setText("");
                partOfSpeechTextField.setText("");
                meaningTextArea.setText("");
                exampleTextArea.setText("");
                vocabularySelect = null;
                dictionaryTable.refresh();
                save();
            }
        }
    }

    @FXML private void handleRemoveButtonOnAction(ActionEvent event){
        if(!listData.isEmpty()){
            if(index != -1 && vocabularySelect != null){
                listData.remove(index);
                dictionary.removeVocabulary(vocabularySelect);
                wordTextField.setText("");
                partOfSpeechTextField.setText("");
                meaningTextArea.setText("");
                exampleTextArea.setText("");
                vocabularySelect = null;
                dictionaryTable.refresh();
                save();
            }
        }
    }

    @FXML private void handleClearButtonOnAction(ActionEvent event){
        searchTextField.setText("");
        wordTextField.setText("");
        partOfSpeechTextField.setText("");
        meaningTextArea.setText("");
        exampleTextArea.setText("");
        vocabularySelect = null;
        index = -1;
    }

    @FXML private void handleDictionaryTableClicked(MouseEvent event){
        if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 1) {
            index = dictionaryTable.getSelectionModel().getSelectedIndex();
            if(index != -1){
                vocabularySelect = listData.get(index);
                wordTextField.setText(vocabularySelect.getWord());
                partOfSpeechTextField.setText(vocabularySelect.getPartOfSpeech());
                meaningTextArea.setText(vocabularySelect.getMeaning());
                exampleTextArea.setText(vocabularySelect.getExample());
                dictionaryTable.refresh();
            }
        }
    }

    @FXML private void handleXMLButtonOnAction(ActionEvent event){
        String textXML = dictionary.format(new MyFormatter() {
            @Override
            public String format(Object obj) {
                HashMap<String, HashSet> dictionary = (HashMap<String, HashSet>) obj;
                String textXMLBuild = "<Dictionary>";
                for(String key : dictionary.keySet()){
                    HashSet<Vocabulary> vocabularyHashSet = (HashSet<Vocabulary>) dictionary.get(key);
                    for(Vocabulary v : vocabularyHashSet){
                        textXMLBuild += "\n\t<Vocab word=\""+v.getWord()+"\">\n";
                        textXMLBuild += "\t\t<PartOfSpeech>"+v.getPartOfSpeech()+"</PartOfSpeech>\n";
                        textXMLBuild += "\t\t<Meaning>"+v.getMeaning()+"</Meaning>\n";
                        textXMLBuild += "\t\t<Example>"+v.getExample()+"</Example>\n";
                        textXMLBuild += "\t</Vocab>";
                    }
                }
                textXMLBuild += "\n</Dictionary>";
                return textXMLBuild;
            }
        });
        handleExportButtonOnAction(event, "XML", textXML);
//        System.out.println(textXML);
//        System.out.println("---------------------------------------------");
    }

    @FXML private void handleJSONButtonOnAction(ActionEvent event){
        String textJSON = dictionary.format(new MyFormatter() {
            @Override
            public String format(Object obj) {
                HashMap<String, HashSet> dictionary = (HashMap<String, HashSet>) obj;
                String textJSONBuild = "[";
                for(String key : dictionary.keySet()){
                    HashSet<Vocabulary> vocabularyHashSet = (HashSet<Vocabulary>) dictionary.get(key);
                    for(Vocabulary v : vocabularyHashSet){
                        textJSONBuild += "\n\t{\n";
                        textJSONBuild += "\t\tvocab: \""+v.getWord()+"\",\n";
                        textJSONBuild += "\t\tpartOfSpeech: \""+v.getPartOfSpeech()+"\",\n";
                        textJSONBuild += "\t\tmeaning: \""+v.getMeaning()+"\",\n";
                        textJSONBuild += "\t\texample: \""+v.getExample()+"\"\n";
                        textJSONBuild += "\t},";
                    }
                }
                if(textJSONBuild.lastIndexOf(",") != -1){
                    textJSONBuild = textJSONBuild.substring(0, textJSONBuild.lastIndexOf(","));
                }
                textJSONBuild += "\n]";
                return textJSONBuild;
            }
        });
        handleExportButtonOnAction(event, "JSON", textJSON);
//        System.out.println(textJSON);
//        System.out.println("---------------------------------------------");
    }

    @FXML private void handleExportButtonOnAction(ActionEvent event, String formatName, String text){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("export.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Dictionary "+formatName+" 6110405949");
            stage.setScene(new Scene(root, 600, 400));
            ExportController exportController = fxmlLoader.getController();
            exportController.setFormatName(formatName);
            exportController.setText(text);
            stage.show();
            //save();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void save(){
        File dir = new File("DictionaryData");
        if (!dir.exists()){
            dir.mkdirs();
        }
        //File file = new File("Dictionary/data.dic");
        try {
            //file.createNewFile();
            FileOutputStream fs = new FileOutputStream("DictionaryData/data.dic");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(dictionary);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load(){
        File dir = new File("DictionaryData");
        if (!dir.exists()){
            dir.mkdirs();
        }
        else {
            try {
                FileInputStream fileStream = new FileInputStream("DictionaryData/data.dic");
                ObjectInputStream os = new ObjectInputStream(fileStream);
                Object one = os.readObject();
                dictionary = (Dictionary) one;
                for(String key : dictionary.getDictionary().keySet()){
                    HashSet<Vocabulary> vocabularyHashSet = (HashSet<Vocabulary>) dictionary.getDictionary().get(key);
                    for(Vocabulary v : vocabularyHashSet){
                        listData.add(v);
                    }
                }
                os.close();
            } catch (FileNotFoundException e) {
                System.err.println(e.getMessage());
                //e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
