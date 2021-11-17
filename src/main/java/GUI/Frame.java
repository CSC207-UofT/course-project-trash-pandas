package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.*;

import Music.MusicHandler;
import characters.NonPlayerCharacter;
import characters.PlayerCharacter;
import scene_system.Scene;

public class Frame {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel,  mainTextPanel, choiceButtonPanel, playerPanel;;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, areaLabel, codeLabelName, endGame;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 128);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 42);
    JButton startButton, choice1, choice2, choice3, choice4;
    ImageIcon imageIcon = new ImageIcon("racoon icon.png");

    MusicHandler mu = new MusicHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();
    Scene currentScene;
    PlayerCharacter player;

    public Frame(Scene firstScene, PlayerCharacter player) {
        this.currentScene = firstScene;
        this.player = player;
    }

    public void titleFrame() {
        //mu.setFile(radioNoise);
        //mu.loop();

        window = new JFrame();
        window.setSize(1920,1080); // sets size
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the program so it doesn't run forever
        window.getContentPane().setBackground(Color.black); //sets color
        window.setLayout(null); //custom layout
        window.setVisible(true); //Allows the user to see it
        window.setIconImage(imageIcon.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel(); //title
        titleNamePanel.setBounds(250, 250, 1450, 375); //Sets size for Title
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Trash Pandas");
        titleNameLabel.setForeground(Color.red); //text color
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel(); //start button
        startButtonPanel.setBounds(600, 650, 770, 250);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("Start");
        startButton.setBackground(Color.black); //Color of button (invisible)
        startButton.setForeground(Color.white); //Color of text
        startButton.setFont(normalFont);
        TitleFrameActionListener tsHandler = new TitleFrameActionListener();
        startButton.addActionListener(tsHandler); //mouse support for button, calls method
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(startButtonPanel);
        SwingUtilities.updateComponentTreeUI(window);
    }

    public void mainFrame () {
        System.out.println("Button!");
        con.removeAll();

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(210, 200, 1500, 500);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Testing");
        mainTextArea.setBounds(210, 200, 1500, 500);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true); //If text is too long it will go down a line
        mainTextArea.setEditable(false);
        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(560, 700, 750, 290);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1)); //Makes the buttons go 4 vertical and 1 horizontal
        con.add(choiceButtonPanel);

        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false); //gets rid of annoying lines on choices
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");

        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");

        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");

        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choiceButtonPanel.add(choice4);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");


        playerPanel = new JPanel();
        playerPanel.setBounds(210, 15, 1500, 160);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,4));
        con.add(playerPanel);
        hpLabel = new JLabel("HP:");
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.red);
        playerPanel.add(hpLabelNumber);

        areaLabel = new JLabel("Area:");
        areaLabel.setFont(normalFont);
        areaLabel.setForeground(Color.white);
        playerPanel.add(areaLabel);

        codeLabelName = new JLabel();
        codeLabelName.setFont(normalFont);
        codeLabelName.setForeground(Color.white);
        playerPanel.add(codeLabelName);

        displayScene(currentScene);
        SwingUtilities.updateComponentTreeUI(window);
    }

    public void displayScene(Scene sc) {
        this.currentScene = sc;
        mainTextArea.setText(sc.getDescription());
        SwingUtilities.updateComponentTreeUI(window);
    }

    public void displayTravelOptions(ArrayList<Scene> travelOptions) {
        StringBuilder travelText = new StringBuilder();
        boolean first = true;
        travelText.append("Where would you like to travel? \n");
        for(Scene sc: travelOptions) {
            if (!first) {
                travelText.append(", ").append(sc.getName());
            }
            else {
                travelText.append(sc.getName());
                first = false;
            }
        }
        mainTextArea.setText(travelText.toString());

    }

    public void displayDialogue(ArrayList<NonPlayerCharacter> characters) {


    }

    class TitleFrameActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            mainFrame();
        }
    }

    class ChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String yourChoice = event.getActionCommand();
            switch(yourChoice) {
                case "c1": displayTravelOptions(currentScene.getConnectedAreas());
                case "c2": break;
                case "c3": break;
                case "c4": currentScene.start_combat(player);
            }
        }
    }
}

