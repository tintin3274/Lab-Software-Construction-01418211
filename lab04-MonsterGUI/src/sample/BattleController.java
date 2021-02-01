package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.util.Scanner;


public class BattleController {

    private Monster m1, m2;
    private GameController gameController;
    private Timer tmFxNull;

    @FXML Button attackButton, healingButton;
    @FXML Label detailsMonster1, detailsMonster2, roundDisplay, turnDisplay, nameM1, nameM2, winLabel;
    @FXML TextField healingField;
    @FXML ProgressBar hpBarM1, hpBarM2;

    @FXML
    ImageView m1Image, m2Image, m1AFxImage, m2AFxImage, m1HFxImage, m2HFxImage;

    @FXML public void initialize(){
        Scanner sc = new Scanner(System.in);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    m1Image.setImage(new Image(getClass().getResource(m1.getImgPath()).toURI().toString()));
                    m2Image.setImage(new Image(getClass().getResource(m2.getImgPath()).toURI().toString()));
                    nameM1.setText(m1.getName());
                    nameM2.setText(m2.getName());
                    m1AFxImage.setImage(null);
                    m2AFxImage.setImage(null);
                    m1HFxImage.setImage(null);
                    m2HFxImage.setImage(null);

                    gameController = new GameController(m1, m2);
                    display();


                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void setMonster1(Monster m) { this.m1 = m; }
    public void setMonster2(Monster m){
        this.m2 = m;
    }

    @FXML public void handleAtkBtnOnAction(ActionEvent event) {
        attackButton.setDisable(true);
        healingButton.setDisable(true);
        healingField.setDisable(true);


        if(gameController.getTurn() == 1){
            m2AFxImage.setImage(new Image(getClass().getResource("/images/fire.gif").toString()));
        }
        else if(gameController.getTurn() == 2){
            m1AFxImage.setImage(new Image(getClass().getResource("/images/fire.gif").toString()));
        }

        // call atk method in gameController
        gameController.attackState();

        // check isWin
        if (gameController.isWin()){
            winLabel.setText("Game End!! Winner is "+gameController.getWinMonster().getName());
            System.out.println("Winner is "+gameController.getWinMonster().getName());
            if(m1.isDead()){
                m1Image.setImage(new Image(getClass().getResource("/images/rip.gif").toString()));
            }
            else if(m2.isDead()){
                m2Image.setImage(new Image(getClass().getResource("/images/rip.gif").toString()));
            }
        }

        // display
        display();
    }

    @FXML public void handleHealBtnOnAction(ActionEvent event)  {
        if (!healingField.getText().equals("")){
            attackButton.setDisable(true);
            healingButton.setDisable(true);
            healingField.setDisable(true);

            if(gameController.getTurn() == 1){
                m1HFxImage.setImage(new Image(getClass().getResource("/images/healing.gif").toString()));
            }
            else if(gameController.getTurn() == 2){
                m2HFxImage.setImage(new Image(getClass().getResource("/images/healing.gif").toString()));
            }
            gameController.healState(Integer.parseInt(healingField.getText()));
            healingField.setText("");

            display();
        }
    }

    public void display(){
        tmFxNull = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                m1AFxImage.setImage(null);
                m2AFxImage.setImage(null);
                m1HFxImage.setImage(null);
                m2HFxImage.setImage(null);
                if (!gameController.isWin()){
                    attackButton.setDisable(false);
                    healingButton.setDisable(false);
                    healingField.setDisable(false);
                }
                tmFxNull.stop();
            }
        });
        tmFxNull.start();

        detailsMonster1.setText(m1.toString());
        detailsMonster2.setText(m2.toString());

        hpBarM1.setProgress(m1.getCurrentHp()/(double) m1.getMaxHp());
        hpBarM2.setProgress(m2.getCurrentHp()/(double) m2.getMaxHp());
        if(m1.getCurrentHp()/(double) m1.getMaxHp()>0.5){
            hpBarM1.setStyle("-fx-accent: green");
        }
        else if(m1.getCurrentHp()/(double) m1.getMaxHp()>0.3){
            hpBarM1.setStyle("-fx-accent: yellow");
        }
        else{
            hpBarM1.setStyle("-fx-accent: red");
        }
        if(m2.getCurrentHp()/(double) m2.getMaxHp()>0.5){
            hpBarM2.setStyle("-fx-accent: green");
        }
        else if(m2.getCurrentHp()/(double) m2.getMaxHp()>0.3){
            hpBarM2.setStyle("-fx-accent: yellow");
        }
        else{
            hpBarM2.setStyle("-fx-accent: red");
        }

        if (!gameController.isWin()){
            roundDisplay.setText("<Round - "+gameController.getRound()+">");
            turnDisplay.setText("<Turn Monster - "+gameController.getTurn()+">");
        }
    }
}
