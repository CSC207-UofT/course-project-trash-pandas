package GUI;
import java.awt.*;
import java.util.ArrayList;


import javax.swing.*;

import Music.MusicHandler;
import characters.CharacterInventoryFacade;
import items.Item;
import scene_system.Scene;

public class MainFrame {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel,  mainTextPanel, choiceButtonPanel, playerPanel, textInputPanel, combatPanel,
            turnPanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, areaLabel;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 128);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 42);
    JButton startButton, choice1, choice2, choice3, choice4, inventory, defend, attack, ability, nextTurn;
    ImageIcon imageIcon = new ImageIcon("racoon icon.png");
    JTextField entryField, combatField;
    JScrollPane scroll;

    boolean travel, search, talk;

    MusicHandler mu = new MusicHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler(this);
    CombatChoiceHandler combatHandler;
    InputActionListener textActionListener = new InputActionListener(this);
    CombatInputListener combatInputListener;

    Scene currentScene;
    CharacterInventoryFacade player;

    public MainFrame(Scene firstScene, CharacterInventoryFacade player) {
        this.currentScene = firstScene;
        this.player = player;
        this.combatHandler = new CombatChoiceHandler(this);
        this.combatInputListener = new CombatInputListener(this);
    }

    public Scene getCurrentScene() {
        return currentScene;
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
        TitleFrameActionListener tsHandler = new TitleFrameActionListener(this);
        startButton.addActionListener(tsHandler); //mouse support for button, calls method
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        con.add(titleNamePanel);
        con.add(startButtonPanel);
        SwingUtilities.updateComponentTreeUI(window);
    }

    public void gameFrame() {
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
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        scroll = new JScrollPane(mainTextArea);
        scroll.setBounds(210, 200, 1500, 500);
        scroll.setAutoscrolls(true);
        scroll.setPreferredSize(new Dimension(1500, 450));
        mainTextPanel.add(scroll);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(560, 700, 750, 290);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1)); //Makes the buttons go 4 vertical and 1 horizontal
        con.add(choiceButtonPanel);

        choice1 = new JButton("Travel");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choiceButtonPanel.add(choice1);
        choice1.setFocusPainted(false); //gets rid of annoying lines on choices
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");

        choice2 = new JButton("Talk to people nearby");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choiceButtonPanel.add(choice2);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");

        choice3 = new JButton("Look around");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choiceButtonPanel.add(choice3);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");

        choice4 = new JButton("Start Combat");
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
        hpLabel = new JLabel("HP: " + player.getCharacter().getCharacter().getCurrentHealth()); // add observer of health to update this
        hpLabel.setFont(normalFont);
        hpLabel.setForeground(Color.white);
        playerPanel.add(hpLabel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.red);
        playerPanel.add(hpLabelNumber);

        areaLabel = new JLabel();
        areaLabel.setFont(normalFont);
        areaLabel.setForeground(Color.white);
        playerPanel.add(areaLabel);

        textInputPanel = new JPanel();
        textInputPanel.setBounds(300, 800, 250, 290);
        textInputPanel.setBackground(Color.black);
        textInputPanel.setLayout(new GridLayout(4,1)); //Makes the buttons go 4 vertical and 1 horizontal
        con.add(textInputPanel);

        entryField = new JTextField("Enter here");
        entryField.setVisible(true);
        entryField.addActionListener(textActionListener);
        textInputPanel.add(entryField);

        displayScene(currentScene);
        SwingUtilities.updateComponentTreeUI(window);
    }

    public void combatFrame() {
        con.remove(choiceButtonPanel);
        textInputPanel.remove(entryField);
        combatField = new JTextField("Enter here");
        combatField.setVisible(true);
        combatField.addActionListener(combatInputListener);
        textInputPanel.add(combatField);
        mainTextArea.setText("Combat begins:");

        combatPanel = new JPanel();
        combatPanel.setBounds(560, 700, 750, 290);
        combatPanel.setBackground(Color.black);
        combatPanel.setLayout(new GridLayout(4,1)); //Makes the buttons go 4 vertical and 1 horizontal
        con.add(combatPanel);

        attack = new JButton("Attack");
        attack.setBackground(Color.black);
        attack.setForeground(Color.white);
        attack.setFont(normalFont);
        combatPanel.add(attack);
        attack.setFocusPainted(false); //gets rid of annoying lines on choices
        attack.addActionListener(combatHandler);
        attack.setActionCommand("c1");

        defend = new JButton("Defend");
        defend.setBackground(Color.black);
        defend.setForeground(Color.white);
        defend.setFont(normalFont);
        combatPanel.add(defend);
        defend.setFocusPainted(false);
        defend.addActionListener(combatHandler);
        defend.setActionCommand("c2");

        ability = new JButton("Use Ability");
        ability.setBackground(Color.black);
        ability.setForeground(Color.white);
        ability.setFont(normalFont);
        combatPanel.add(ability);
        ability.setFocusPainted(false);
        ability.addActionListener(combatHandler);
        ability.setActionCommand("c3");

        inventory = new JButton("View Inventory");
        inventory.setBackground(Color.black);
        inventory.setForeground(Color.white);
        inventory.setFont(normalFont);
        combatPanel.add(inventory);
        inventory.setFocusPainted(false);
        inventory.addActionListener(combatHandler);
        inventory.setActionCommand("c4");

        turnPanel = new JPanel();
        turnPanel.setBounds(1310, 700, 300, 290);
        turnPanel.setBackground(Color.black);
        turnPanel.setLayout(new GridLayout(1,1)); //Makes the buttons go 4 vertical and 1 horizontal
        con.add(turnPanel);

        nextTurn = new JButton("Next Turn");
        nextTurn.setBackground(Color.black);
        nextTurn.setForeground(Color.blue);
        nextTurn.setFont(normalFont);
        turnPanel.add(nextTurn);
        nextTurn.setFocusPainted(false);
        nextTurn.addActionListener(combatHandler);
        nextTurn.setActionCommand("c5");


        SwingUtilities.updateComponentTreeUI(window);
        currentScene.getCombat(player).startCombat(this);
    }

    public void exitCombatFrame() {
        con.remove(combatPanel);
        textInputPanel.remove(combatField);
        con.remove(turnPanel);
        con.add(choiceButtonPanel);
        textInputPanel.add(entryField);
        displayScene(currentScene);
    }

    public void displayScene(Scene sc) {
        search = false;
        talk = false;
        travel = false;
        entryField.setText("");
        areaLabel.setText("Area: " + sc.getName());
        this.currentScene = sc;
        mainTextArea.setText(sc.getDescription());
        SwingUtilities.updateComponentTreeUI(window);
    }

    public void displayTravelOptions(ArrayList<Scene> travelOptions) {
        travel = true;
        search = false;
        talk = false;
        StringBuilder travelText = new StringBuilder();
        boolean first = true;
        entryField.setText("Write Destination Here");
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

    public void displayDialogue(ArrayList<CharacterInventoryFacade> characters) {
        talk = true;
        search = false;
        travel = false;
        StringBuilder npcText = new StringBuilder();
        if(characters.isEmpty()) {
            npcText.append("There is no one here to talk to");
            entryField.setText("There is no one here");
        }
        else {
            boolean first = true;
            entryField.setText("Write NPC Here");
            npcText.append("Who would you like to talk to? \n");
            for(CharacterInventoryFacade npc: characters) {
                if (!first) {
                    npcText.append(npc.getCharacter().getCharacter().getName());
                }
                else {
                    npcText.append("\n").append(npc.getCharacter().getCharacter().getName());
                    first = false;
                }
            }
        }
        mainTextArea.setText(npcText.toString());
    }

    public void displayItems(ArrayList<Item> items) {
        search = true;
        talk = false;
        travel = false;
        StringBuilder itemText = new StringBuilder();
        if(items.isEmpty()) {
            itemText.append("There are no items around that you can see");
            entryField.setText("There are no items");
        }
        else {
            boolean first = true;
            entryField.setText("Write Item Here");
            itemText.append("Which item would you like to pick up? \n");
            for(Item item: items) {
                if (!first) {
                    itemText.append(", ").append(item.getName());
                }
                else {
                    itemText.append(item.getName());
                    first = false;
                }
            }
        }
        mainTextArea.setText(itemText.toString());
    }

    public void displayCombatText(String text) {
        mainTextArea.append("\n" + text);
        mainTextArea.setCaretPosition(mainTextArea.getDocument().getLength());
    }

    public void displayCombatInput(String text) {
        combatField.setText(text);
    }
}

