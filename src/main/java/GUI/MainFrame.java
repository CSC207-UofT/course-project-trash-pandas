package GUI;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;


import javax.swing.*;

import Music.MusicHandler;
import characters.CharacterInventoryFacade;
import characters.CharacterInventoryFacadeManager;
import characters.NonPlayerCharacter;
import combat_system.Combat;
import items.Item;
import scene_system.Scene;
import scene_system.SceneManager;

public class MainFrame {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel,  mainTextPanel, choiceButtonPanel, playerPanel, textInputPanel, combatPanel,
            turnPanel, gameOverPanel, overButtonPanel, savePanel;
    JLabel titleNameLabel, hpLabel, hpLabelNumber, areaLabel, gameOverLabel;
    JTextArea mainTextArea;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 128);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 42);
    JButton startButton, choice1, choice2, choice3, choice4, inventory, defend, attack, ability, nextTurn, overButton,
            save;
    ImageIcon imageIcon = new ImageIcon("resources/racoon icon.png");
    JTextField entryField, combatField;
    JScrollPane scroll;
    double heightScale, widthScale;
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize();

    boolean travel, search, talk;

    MusicHandler mu = new MusicHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler(this);
    CombatChoiceHandler combatHandler;
    InputActionListener textActionListener = new InputActionListener(this);
    CombatInputListener combatInputListener;
    guiLogic logicHandler = new guiLogic();
    SceneManager sceneManager;
    String currentScene;
    CharacterInventoryFacade player;
    CharacterInventoryFacadeManager cifManager;

    /**
     * Initializes all of the variables needed to create a new window
     * @param firstScene the starting scene that the game will be in
     * @param player the player character
     */
    public MainFrame(String firstScene, CharacterInventoryFacade player, SceneManager scManager,
                     CharacterInventoryFacadeManager cifManager) {
        this.currentScene = firstScene;
        this.player = player;
        this.cifManager = cifManager;
        this.sceneManager = scManager;
        this.combatHandler = new CombatChoiceHandler(this);
        this.combatInputListener = new CombatInputListener(this);
        this.heightScale = size.getHeight()/1080;
        this.widthScale = size.getWidth()/1920;
    }

    /**
     * Simple getter method for getting the current scene displayed
     *
     * @return the name of the current displayed scene
     */
    public String getCurrentScene() {
        return currentScene;
    }

    /**
     * Returns the scene manager.
     *
     * @return the scene manager.
     */
    public SceneManager getSceneManager(){
        return sceneManager;
    }

    /**
     * The title frame is a simple button that transitions to the main game frame
     */
    public void titleFrame() {
        mu.setFile("resources/city.wav"); //https://www.zapsplat.com/sound-effect-category/city-and-urban/page/2/
        //Vancouver, night, roaring traffic, cars, buses, pedestrians walking and talking
        mu.loop();

        window = new JFrame();
        window.setSize((int) (1920*widthScale),(int)(1080*heightScale)); // sets size
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the program so it doesn't run forever
        window.getContentPane().setBackground(Color.black); //sets color
        window.setLayout(null); //custom layout
        window.setVisible(true); //Allows the user to see it
        window.setIconImage(imageIcon.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel(); //title
        titleNamePanel.setBounds((int) (250*widthScale), (int)(heightScale*250), (int)(widthScale*1450), (int)(heightScale*375)); //Sets size for Title
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Trash Pandas");
        titleNameLabel.setForeground(Color.red); //text color
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel(); //start button
        startButtonPanel.setBounds((int)(widthScale*600), (int)(heightScale*650), (int)(widthScale*770), (int)(heightScale*250));
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

    /**
     * This is the main frame that the game will take place in. It has all the buttons required for the game and all
     * the action listeners.
     */
    public void gameFrame() {
        con.removeAll();

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds((int)(widthScale*210), (int)(heightScale*200), (int)(widthScale*1500), (int)(heightScale*500));
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);

        mainTextArea = new JTextArea("Testing");
        mainTextArea.setBounds((int)(widthScale*210), (int)(heightScale*200), (int)(widthScale*1500), (int)(heightScale*500));
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);
        scroll = new JScrollPane(mainTextArea);
        scroll.setBounds((int)(widthScale*210), (int)(heightScale*200), (int)(widthScale*1500), (int)(heightScale*500));
        scroll.setAutoscrolls(true);
        scroll.setPreferredSize(new Dimension((int)(widthScale*1500), (int)(heightScale*450)));
        mainTextPanel.add(scroll);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds((int)(widthScale*560), (int)(heightScale*700), (int)(widthScale*750), (int)(heightScale*290));
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
        playerPanel.setBounds((int)(widthScale*210), (int)(heightScale*15), (int)(widthScale*1500), (int)(heightScale*160));
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
        textInputPanel.setBounds((int)(widthScale*300), (int)(heightScale*800), (int)(widthScale*250), (int)(heightScale*290));
        textInputPanel.setBackground(Color.black);
        textInputPanel.setLayout(new GridLayout(4,1)); //Makes the buttons go 4 vertical and 1 horizontal
        con.add(textInputPanel);

        entryField = new JTextField("Enter here");
        entryField.setVisible(true);
        entryField.addActionListener(textActionListener);
        textInputPanel.add(entryField);

        savePanel = new JPanel();
        savePanel.setBounds((int)(widthScale*1310), (int)(heightScale*700), (int)(widthScale*300), (int)(heightScale*290));
        savePanel.setBackground(Color.black);
        savePanel.setLayout(new GridLayout(1,1)); //Makes the buttons go 4 vertical and 1 horizontal
        con.add(savePanel);

        save = new JButton("save");
        save.setBackground(Color.black);
        save.setForeground(Color.blue);
        save.setFont(normalFont);
        savePanel.add(save);
        save.setFocusPainted(false);
        save.addActionListener(choiceHandler);
        save.setActionCommand("c5");

        displayScene(currentScene);
        SwingUtilities.updateComponentTreeUI(window);
    }

    /**
     * Creates a combat frame with all the new buttons and action listeners required
     * Also starts a combat object
     */
    public void combatFrame() {
        mu.stop();
        mu.setFile("resources/combat.wav"); //Music: “Smash Bros”, from PlayOnLoop.com
        mu.loop();
        con.remove(choiceButtonPanel);
        con.remove(savePanel);
        textInputPanel.remove(entryField);
        combatField = new JTextField("Enter here");
        combatField.setVisible(true);
        combatField.addActionListener(combatInputListener);
        textInputPanel.add(combatField);
        mainTextArea.setText("");
        for(String npc: sceneManager.getNPC(currentScene)) {
            String combatText = cifManager.getDialogue(npc);
            if(!Objects.equals(combatText, "")){
                displayCombatText(combatText);
            }
        }
        displayCombatText("-------------------");
        displayCombatText("Combat begins");

        combatPanel = new JPanel();
        combatPanel.setBounds((int)(widthScale*560), (int)(heightScale*700), (int)(widthScale*750), (int)(heightScale*290));
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
        turnPanel.setBounds((int)(widthScale*1310), (int)(heightScale*700), (int)(widthScale*300), (int)(heightScale*290));
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
        this.createCombat().startCombat(this);
    }

    /**
     * Helper method, creates or returns the instance of combat in the current scene.
     * @return the combat class in the current scene.
     */
    public Combat createCombat(){
        ArrayList<CharacterInventoryFacade> combatants = cifManager.getCombatParticipants
                (this.sceneManager.getNPC(this.currentScene));
        return this.sceneManager.getCombat(this.currentScene, combatants);
    }

    /**
     * Transitions back to the normal frame, maintains the text from combat so that it does not jump from combat
     * to out of combat in a jarring way
     */
    public void exitCombatFrame() {
        mu.stop();
        mu.setFile("resources/city.wav");
        mu.loop();
        String combat_text = mainTextArea.getText();
        con.remove(combatPanel);
        textInputPanel.remove(combatField);
        con.remove(turnPanel);
        con.add(savePanel);
        con.add(choiceButtonPanel);
        textInputPanel.add(entryField);
        displayScene(currentScene);
        mainTextArea.setText(combat_text);
    }

    /**
     * Displays a game over scene
     */
    public void gameOver() {
        mu.stop();
        mu.setFile("resources/gameOver.wav"); // plays game over music
        mu.loop();
        con.removeAll();
        gameOverPanel = new JPanel(); //title
        gameOverPanel.setBounds((int)(widthScale*250), (int)(heightScale*250), (int)(widthScale*1450), (int)(heightScale*375));
        gameOverPanel.setBackground(Color.black);
        gameOverLabel = new JLabel("You DIED");
        gameOverLabel.setForeground(Color.red);
        gameOverLabel.setFont(titleFont);

        overButtonPanel = new JPanel();
        overButtonPanel.setBounds((int)(widthScale*600), (int)(heightScale*650), (int)(widthScale*770), (int)(heightScale*250));
        overButtonPanel.setBackground(Color.black);

        overButton = new JButton("End Game");
        overButton.setBackground(Color.black);
        overButton.setForeground(Color.white);
        overButton.setFont(normalFont);
        GameOverActionListener overHandler = new GameOverActionListener(this);
        overButton.addActionListener(overHandler);
        overButton.setFocusPainted(false);

        gameOverPanel.add(gameOverLabel);
        overButtonPanel.add(overButton);
        con.add(gameOverPanel);
        con.add(overButtonPanel);
        SwingUtilities.updateComponentTreeUI(window);
    }

    /**
     * Sets the HP for the player
     */
    public void setHpLabel() {
        hpLabel.setText("HP: " + player.getCharacter().getCharacter().getCurrentHealth());
    }

    /**
     * Displays the scene on the gui
     * @param sc the name of the scene to be displayed
     */
    public void displayScene(String sc) {
        search = false;
        talk = false;
        travel = false;
        entryField.setText("");
        areaLabel.setText("Area: " + sc);
        this.currentScene = sc;
        mainTextArea.setText(sceneManager.displayScene(sc));
        SwingUtilities.updateComponentTreeUI(window);
    }

    /**
     * Displays all the options for travel
     * @param travelOptions an arraylist of scenes
     */
    public void displayTravelOptions(ArrayList<String> travelOptions) {
        travel = true;
        search = false;
        talk = false;
        ArrayList<String> text = logicHandler.displayTravelOptions(travelOptions);
        mainTextArea.setText(text.get(1));
        entryField.setText(text.get(0));
    }

    /**
     * Displays the choices of characters to talk to
     * @param characters a list of all the names of characters in the current scene so that
     *                   the user can target the character
     */
    public void displayNpcs(ArrayList<String> characters) {
        talk = true;
        search = false;
        travel = false;
        ArrayList<String> text = logicHandler.displayNpcs(characters);
        mainTextArea.setText(text.get(1));
        entryField.setText(text.get(0));
    }

    /**
     * Displays the items in the list in a way that is understandable
     * Also displays entry field text
     * @param items a list of all the names of items the player has
     */
    public void displayItems(ArrayList<String> items) {
        search = true;
        talk = false;
        travel = false;
        ArrayList<String> text = logicHandler.displayItems(items);
        mainTextArea.setText(text.get(1));
        entryField.setText(text.get(0));
    }

    /**
     * Displays text during a combat encounter by adding it on to the end of a scrollable screen, also auto scrolls
     * to the bottom of the text
     * @param text the String to display
     */
    public void displayCombatText(String text) {
        mainTextArea.append("\n" + text);
        mainTextArea.setCaretPosition(mainTextArea.getDocument().getLength());
    }

    /**
     * Displays text in the input area (place where user types targets) during a combat encounter
     * @param text the text to display
     */
    public void displayCombatInput(String text) {
        combatField.setText(text);
    }

    public void save() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("save_game.txt"));
            bw.write(currentScene);
            bw.close();
        } catch (Exception e) {
        }
    }
}

