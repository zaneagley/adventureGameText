import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameFrame {

    static JFrame window;
    static Container con;
    static JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel, areaPanel;
    static JLabel titleNameLabel, hpLabelNumber, weaponLabelName, areaName;
    static Font titleFont = new Font("AppleGothic", Font.BOLD, 70);
    static Font normalFont = new Font("Times New Roman", Font.PLAIN, 22);
    static JTextArea mainTextArea;
    static JButton startButton, choice1Button, choice2Button, choice3Button, choice4Button;
    static TitleScreenHandler tsHandler = new TitleScreenHandler();
    static ChoiceHandler choiceHandler = new ChoiceHandler();
    static String yourChoice;

    static String enemy;
    static int enemyHP = 20;
    static int playerHP;
    static String weapon, position;
    static boolean battleActive = false;

    // Items
    static int banditRing = 0;
    static int torch = 0;


    // Events
    static int banditBattle = 0;
    static int afterBanditBattleSpokeGuard = 0;




    public static void main(String[] args){
            gameWindow();
    }


    public static void gameWindow(){

        // Main Window Setup
        window = new JFrame();
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();

        // Title Setup
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600,150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Legends of Zorn II");
        titleNameLabel.setForeground(Color.red);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);

        // Start Button Setup
        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);
        startButton = new JButton("Start");
        startButton.setBackground(Color.red);
        startButton.setForeground(Color.blue);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);
        window.setVisible(true);
    }

    public static void createGameScreen() {

        // Hide the title and start button

        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);


        // The main area for large portion of text

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);


        mainTextArea = new JTextArea("Main Text Area");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextPanel.add(mainTextArea);


        // The four buttons for choices

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250,350,300,150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        con.add(choiceButtonPanel);
        //

        choice1Button = new JButton("Choice 1");
        choice1Button.setBackground(Color.black);
        choice1Button.setForeground(Color.black);
        choice1Button.setFont(normalFont);
        choice1Button.addActionListener(choiceHandler);
        choice1Button.setActionCommand("c1");
        choiceButtonPanel.add(choice1Button);

        choice2Button = new JButton("Choice 2");
        choice2Button.setBackground(Color.black);
        choice2Button.setForeground(Color.black);
        choice2Button.setFont(normalFont);
        choice2Button.addActionListener(choiceHandler);
        choice2Button.setActionCommand("c2");
        choiceButtonPanel.add(choice2Button);

        choice3Button = new JButton("Choice 3");
        choice3Button.setBackground(Color.black);
        choice3Button.setForeground(Color.black);
        choice3Button.setFont(normalFont);
        choice3Button.addActionListener(choiceHandler);
        choice3Button.setActionCommand("c3");
        choiceButtonPanel.add(choice3Button);

        choice4Button = new JButton("Choice 4");
        choice4Button.setBackground(Color.black);
        choice4Button.setForeground(Color.black);
        choice4Button.setFont(normalFont);
        choice4Button.addActionListener(choiceHandler);
        choice4Button.setActionCommand("c4");
        choiceButtonPanel.add(choice4Button);



        // Bottom Panel for Player

        playerPanel = new JPanel();
        playerPanel.setBounds(200,515,500,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1,2));
        con.add(playerPanel);

        hpLabelNumber = new JLabel();
        hpLabelNumber.setFont(normalFont);
        hpLabelNumber.setForeground(Color.white);
        playerPanel.add(hpLabelNumber);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(normalFont);
        weaponLabelName.setForeground(Color.white);
        playerPanel.add(weaponLabelName);

        areaPanel = new JPanel();
        areaPanel.setBounds(100,15,600,50);
        areaPanel.setBackground(Color.black);
        con.add(areaPanel);

        areaName = new JLabel();
        areaName.setFont(normalFont);
        areaName.setForeground(Color.white);
        areaPanel.add(areaName);


        playerSetup();

    }

    public static void playerSetup() {

        playerHP = 15;
        weapon = "Stick";
        weaponLabelName.setText("Weapon: " + weapon);
        hpLabelNumber.setText("HP: " + playerHP);
        townGate();

    }

    //
    //
    //    Locations
    //
    //
    //
    //


    public static void townGate(){
        position = "Town Gate";
        areaName.setText(position);
        mainTextArea.setText("There is a wooden walled in town here.\nA guard stands in front of the gate.\n\nWhat do you do?");
        choice1Button.setText("Speak to the Guard");
        choice2Button.setText("Attack the Guard");
        if (afterBanditBattleSpokeGuard == 1){
            choice3Button.setText("Enter Town");
        }
        else {
            choice3Button.setText("Leave");
        }
        if (afterBanditBattleSpokeGuard == 1){
            choice4Button.setText("Leave");
        }
        else {
            choice4Button.setText("");
        }
    }

    public static void speakToGuard(){
        position = "speakToGuard";
        if (banditRing == 1){
            mainTextArea.setText("Humph, one of the bandits rings?  ...Seems like it's one of theirs... You might be alright, but if you cause any trouble, I'll throw you out myself.");
            afterBanditBattleSpokeGuard = 1;
        }
        else {
            mainTextArea.setText("Guard: Stand down outsider! Bandits have been raiding our town and caravans of late. If you desire entry, you must bring me one of \ntheir signet rings to prove your worth.");
        }
        choice1Button.setText(">");
        choice2Button.setText("");
        choice3Button.setText("");
        choice4Button.setText("");

    }

    public static void attackGuard(){
        position = "attackGuard";
        mainTextArea.setText("Guard: I knew it, you were one of the bandits!\n\n\nThe guard gave you a hard hit and knocked you back. Dealing 3 \ndamage to you.");
        playerHP -= 3;
        hpLabelNumber.setText("HP: " + playerHP);
        choice1Button.setText(">");
        choice2Button.setText("");
        choice3Button.setText("");
        choice4Button.setText("");
    }


    public static void crossRoads(){
        position = "Crossroads";
        areaName.setText(position);
        mainTextArea.setText("You are at a crossroads, to the north is a town.\n" +
                "West leads to a river, East leads to a cave.\nSouth leads to a canyon.");
        choice1Button.setText("North");
        choice2Button.setText("East");
        choice3Button.setText("West");
        choice4Button.setText("South");
    }


    public static void riverside(){
        position = "Riverside";
        areaName.setText(position);
        mainTextArea.setText("You come across a river in the clearing, you are able to see the \nbottom through the clear water.\nWhat do you do?");
        choice1Button.setText("Drink from river");
        choice2Button.setText("Investigate river.");
        choice3Button.setText("Leave");
        choice4Button.setText("");
    }

    public static void riverDrink(){
        position = "riverDrink";
        mainTextArea.setText("You drink from the river.  It is quite refreshing!\n\nGaining 2 hitpoints!");
        playerHP += 2;
        hpLabelNumber.setText("HP: " + playerHP);
        choice1Button.setText(">");
        choice2Button.setText("");
        choice3Button.setText("");
        choice4Button.setText("");
    }

    public static void riverInvestigate(){
        position = "riverInvestigate";
        mainTextArea.setText("You examine the river.\n\nAmongst the river bank you found a unsually large dirt mound \nwith a dull shine." +
                "\nInvestigating further, you pull out the shiny bit, revealing a new \nweapon!\n\nYou found a Short Sword!");
        weapon = "Short Sword";
        weaponLabelName.setText("Weapon: " + weapon);
        choice1Button.setText(">");
        choice2Button.setText("");
        choice3Button.setText("");
        choice4Button.setText("");
    }

    public static void mountainCaveStart(){
        position = "AMBUSH";
        areaName.setText(position);
        mainTextArea.setText("As you approach the mountain, you come across a cavern.\nHowever you are suddenly ambushed by a bandit!");
        enemy = "Bandit";
        enemyHP = 12;
        choice1Button.setText(">");
        choice2Button.setText("");
        choice3Button.setText("");
        choice4Button.setText("");
    }

    public static void mountainCave(){
        position = "Entrance of Mountain Cavern";
        areaName.setText(position);
        mainTextArea.setText("Approaching the cave, you are weary due to the recent attack.\nThe body of the bandit still lies here near the entrance of the cave.");
        choice1Button.setText("Enter Cave");
        choice2Button.setText("Leave");
        choice3Button.setText("");
        choice4Button.setText("");
    }

    public static void caveEntrance(){
        position = "Cavern";
        areaName.setText(position);
        if (torch == 1) {
            mainTextArea.setText("Lighting your torch, you make your way into the cave.  There is a sound of creature screeching as you approach, apparently it is not fond of light and has left you alone.");
        }
        mainTextArea.setText("Approaching the cavern, it has an eerie sound coming from deep inside the pitch blackness, hiding whatever is making that sound...");
        choice1Button.setText("Continue into the cave");
        choice2Button.setText("Leave");
        choice3Button.setText("");
        choice4Button.setText("");
    }


    public static void townEntrance(){
        position = "Town Entrance";
        areaName.setText(position);
        mainTextArea.setText("You have entered the town.\nLooking around you can see it is a simple village");
        choice1Button.setText("Town Center");
        choice2Button.setText("Inn");
        choice3Button.setText("Market");
        choice4Button.setText("Leave");
    }







    // Battle Functionality

    public static void attack() {
            int playerDamage = 1;
            if (weapon.equalsIgnoreCase("Stick")) {
                playerDamage = (int) (Math.random() * 4) + 1;
            }
            if (weapon.equalsIgnoreCase("Short Sword")) {
                playerDamage = (int) (Math.random() * 10) + 2;
            }

            mainTextArea.setText("You attack, dealing: " + playerDamage + " of damage.\n\n");
            enemyHP -= playerDamage;

            if (enemyHP < 0) {
                victory();
                banditBattle = 1;
                mountainCave();
            } else {

                int enemyDamage = (int) (Math.random() * 3) + 1;
                mainTextArea.setText("You attack, dealing: " + playerDamage + " of damage.\n\n\nThe bandit retaliates and deals: " + enemyDamage + " points of damage.");
                playerHP -= enemyDamage;
                hpLabelNumber.setText("HP: " + playerHP);
                if (playerHP <= 0) {
                    battleActive = false;
                    dead();
                }
            }
    }

    public static void defend(){
        int enemyDamage = (int)(Math.random() * 2);
        mainTextArea.setText("You take a defensive stance.\n\nThe bandit attacks and deals: "+enemyDamage+" points of damage.");
        playerHP -= enemyDamage;
        hpLabelNumber.setText("HP: " +playerHP);
    }

    public static void victory(){
        mainTextArea.setText("*----You have defeated the bandit!----*\n*----  The Bandit dropped a ring. ----*");
        banditRing = 1;
        battleActive = false;
    }



    public static void battleScreen(){

        position = "Battle";
        areaName.setText(position+" against "+enemy);
        mainTextArea.setText("Fight to stay alive!");
        choice1Button.setText("Attack");
        choice2Button.setText("Defend");
        choice3Button.setText("Run Away");
        choice4Button.setText("");

    }

    public static void dead(){
        position = "Dead";
        areaName.setText("You have died.");
        mainTextArea.setText("Your journey has ended.");
        choice1Button.setText("Start Over");
        choice2Button.setText("");
        choice3Button.setText("");
        choice4Button.setText("");
    }



    public static class  TitleScreenHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }

    public static class ChoiceHandler implements  ActionListener {
        public void actionPerformed(ActionEvent event){
            yourChoice = event.getActionCommand();

            // Movement

            switch (position){
                case "Battle":
                    switch (yourChoice){
                        case "c1":
                            attack();
                            break;
                        case "c2":
                            defend();
                            break;
                        case "c3":
                            crossRoads();
                            break;
                    }
                    break;

                case "Dead":
                    switch (yourChoice){
                        case "c1":
                            gameWindow();
                    }


                case "Town Gate":
                    switch (yourChoice){
                        case "c1":
                            speakToGuard();
                            break;
                        case "c2":
                            attackGuard();
                            break;
                        case "c3":
                            if (afterBanditBattleSpokeGuard == 1) {
                                townEntrance();
                                break;
                            }
                            crossRoads();
                            break;
                        case "c4":
                            if (afterBanditBattleSpokeGuard == 1){
                                crossRoads();
                                break;
                            }
                    }
                    break;
                case "speakToGuard":
                    switch (yourChoice){
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "attackGuard":
                    switch (yourChoice){
                        case "c1":
                            townGate();
                            break;
                    }
                    break;
                case "Town Entrance":
                    switch (yourChoice){
                        case "c1":

                            break;
                        case "c2":

                            break;
                        case "c3":

                            break;
                        case "c4":
                                crossRoads();
                                break;
                    }
                case "Crossroads":
                    switch (yourChoice){
                        case "c1":
                            townGate();
                            break;
                        case "c2":
                            if (banditBattle == 1){
                                mountainCave();
                                break;
                            }
                            else {
                                mountainCaveStart();
                                break;
                            }
                        case "c3":
                            riverside();
                            break;
                        case "c4":
                            break;
                    }
                    break;
                case "Riverside":
                    switch (yourChoice){
                        case "c1":
                             riverDrink();
                             break;
                        case "c2":
                            riverInvestigate();
                            break;
                        case "c3":
                            crossRoads();
                            break;
                        case "c4":
                            break;
                    }
                    break;

                case "riverDrink":
                        switch (yourChoice){
                            case "c1":
                                riverside();
                                break;
                        }
                        break;
                case "riverInvestigate":
                    switch (yourChoice) {
                        case "c1":
                            riverside();
                            break;
                    }
                    break;
                case "AMBUSH":
                    switch (yourChoice) {
                        case "c1":
                            battleScreen();
                            break;
                    }
                    break;

                case "Entrance of Mountain Cavern":
                switch (yourChoice){
                    case "c1":
                        caveEntrance();
                        break;
                    case "c2":
                        crossRoads();
                        break;
                }
                break;

            }

        }
    }




}
