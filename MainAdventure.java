import java.util.Scanner;

public class MainAdventure {
    static Scanner sc = new Scanner(System.in);
    private static String playerName;
    String myWeapon = "Stick";
    String myArmor = "Shirt";
    int healthPoints = 10;
    int banditHP = 12;
    int banditBattle = 0;
    int banditRing = 0;
    int townAcceptance = 0;
    boolean gameStatus = true;
    boolean battleActive = false;

    public static void main(String[] args) {

        MainAdventure game;
        game = new MainAdventure();
        System.out.println("Welcome to the lovely world of Zorn!");
        System.out.println("Please enter your name:");

        playerName = sc.next();
        game.playerMovement();

        int x = 5;
        System.out.println(x > 2 ? x < 4 ? 10 : 8 : 7);


    }


    // Map for the general area

    public void mapArea() {

        System.out.println("----Zorn----");
        System.out.println("-You are in the Clearing, to the north is a town.\n" +
                "West leads to a river, East leads to a cave.\nSouth leads to a canyon.");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("         ^");
        System.out.println("         N");
        System.out.println("     < W   E > ");
        System.out.println("         S");
        System.out.println("         v");
        System.out.println("|"+playerName+"|" + " Currently Equipped: W: " + myWeapon + " A: " + myArmor + " HP: " + healthPoints);
        System.out.println("Choose a direction:");
    }


    public void playerMovement() {
        while (true) {
            String directionChoice = sc.nextLine();
            if (directionChoice.equalsIgnoreCase("quit")) {
                gameQuit();
                break;
            } else if (directionChoice.equalsIgnoreCase("n") || directionChoice.equalsIgnoreCase("north")
                    || directionChoice.equals("North")) {
                System.out.println("You moved north.");
                northDirection();
            } else if (directionChoice.equalsIgnoreCase("s") || directionChoice.equalsIgnoreCase("south")
                    || directionChoice.equals("South")) {
                System.out.println("You moved south.");
                southDirection();
            } else if (directionChoice.equalsIgnoreCase("w") || directionChoice.equalsIgnoreCase("west")
                    || directionChoice.equals("West")) {
                System.out.println("You moved west.");
                westDirection();
            } else if (directionChoice.equalsIgnoreCase("e") || directionChoice.equalsIgnoreCase("east")
                    || directionChoice.equals("East")) {
                System.out.println("You moved east.");
                eastDirection();
            }
            else {
                mapArea();
                System.out.println("Please type in a direction.");
            }
        }
    }

    public void northDirection() {

            System.out.println("There is a wooden walled in town here.\nA guard stands in front of the gate."
                    + "\n\nWhat do you do?\nChoose an option:\n\nA) Speak to Guard\nB) Attack the Guard\nC) Leave");
            areaMap:
            while (true) {
                String choiceLetter = sc.next();
                if (choiceLetter.equalsIgnoreCase("a")) {

                    if (townAcceptance == 1){
                        System.out.println("Yeah, yeah, you want in the town already right? Go on already.");
                    }
                    else {
                        if (banditRing == 1) {
                            System.out.println("Eh? You got one of their rings?  Hm, seems to be real,\n" +
                                    " very well, I'll let you in to the town,but don't start any trouble,\n" +
                                    " or I'll throw you out!");
                            sc.nextLine();
                            System.out.println("The guard grumbles as he undoes pulls the lock on the gate, \n" +
                                    "opening for you allowing you to enter.");
                            townAcceptance = 1;
                        } else {
                            System.out.println("Stand down outsider! Bandits have been raiding our town and caravans" +
                                    "\nof late. If you desire entry, you must bring me one of their signet rings to prove your worth.");
                        }
                    }

                  }else if (choiceLetter.equalsIgnoreCase("b")) {
                    System.out.println("I knew it, you were one of the bandits!");
                } else if (choiceLetter.equalsIgnoreCase("c")) {
                    System.out.println("You leave the town entrance.");
                    mapArea();
                    break;
                } else {
                    System.out.println("Please input one of the letters listed.");
                }
            }
    }


    public void westDirection(){
        System.out.println("You come across a river in the clearing, you are able to see the bottom through the clear water.\n" +
                "What do you do?\nChoose an option:\n\nA) Drink from the river.\nB) Investigate the river.\nC) Leave");
        locationMap:
        while (true) {
            String choiceLetter = sc.next();
            if (choiceLetter.equalsIgnoreCase("a")) {
                System.out.println("You drink from the river.  It is quite refreshing!\n\nGaining 2 hitpoints!");
                healthPoints += 2;
            }
            else if (choiceLetter.equalsIgnoreCase("b")) {
                System.out.println("You examine the river.\n\nAmongst the river bank you found a unsually large dirt mound with a dull shine." +
                        "\nInvestigating further, you pull out the shiny bit, revealing a new weapon!\n\nYou found a Short Sword!");
                myWeapon = "Short Sword";
            }
            else if (choiceLetter.equalsIgnoreCase("c")) {
                System.out.println("You leave the riverside.");
                mapArea();
                break;
            }
            else {
                System.out.println("Please input one of the letters listed.");
            }
        }
    }

    public void eastDirection(){
        if (banditBattle == 1){
            System.out.println("You've come to a dark cave entrance, at first glance it appears abandoned," +
                    "\nhowever with the recently dead body of the bandit proves otherwise...");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("         ^");
            System.out.println("          ");
            System.out.println("     < W     > ");
            System.out.println("          ");
            System.out.println("         v");
            System.out.println("|"+playerName+"|" + " Currently Equipped: W: " + myWeapon + " A: " + myArmor + " HP: " + healthPoints);
            System.out.println("Choose a direction:");


            while (true) {
                String directionChoice = sc.nextLine();
                if (directionChoice.equalsIgnoreCase("quit")) {
                    gameQuit();
                    break;

                } else if (directionChoice.equalsIgnoreCase("w") || directionChoice.equalsIgnoreCase("west")
                        || directionChoice.equals("West")) {
                    mapArea();
                    break;

                } else if (directionChoice.equalsIgnoreCase("s") || directionChoice.equalsIgnoreCase("south")
                        || directionChoice.equals("South") ||
                        directionChoice.equalsIgnoreCase("n") || directionChoice.equalsIgnoreCase("north")
                        || directionChoice.equals("North") ||
                        directionChoice.equalsIgnoreCase("e") || directionChoice.equalsIgnoreCase("east")
                        || directionChoice.equals("East")){
                    System.out.println("You are unable to go that direction.");
                }

                else {
                    eastDirection();
                    System.out.println("Please type in a direction.");
                }
            }




        }
        System.out.println("You are ambushed by a bandit!");
        battleScreen();
        battle();
    }

    public void southDirection(){
        System.out.println("You come out to a vast canyon with a very steep cliff." +
                "\nOverlooking the area you can see a river down below, a waterfall to the west," +
                "\nto the north leads to a crossroads with a town in the distance.");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("         ^");
        System.out.println("         N");
        System.out.println("     <       > ");
        System.out.println("          ");
        System.out.println("         v");
        System.out.println("|"+playerName+"|" + " Currently Equipped: W: " + myWeapon + " A: " + myArmor + " HP: " + healthPoints);
        System.out.println("Choose a direction:");
        while (true) {
            String directionChoice = sc.nextLine();
            if (directionChoice.equalsIgnoreCase("quit")) {
                gameQuit();
                break;

            } else if (directionChoice.equalsIgnoreCase("n") || directionChoice.equalsIgnoreCase("north")
                    || directionChoice.equals("North")) {
                mapArea();
                break;

            } else if (directionChoice.equalsIgnoreCase("s") || directionChoice.equalsIgnoreCase("south")
                    || directionChoice.equals("South") ||
                       directionChoice.equalsIgnoreCase("w") || directionChoice.equalsIgnoreCase("west")
                    || directionChoice.equals("West") ||
                       directionChoice.equalsIgnoreCase("e") || directionChoice.equalsIgnoreCase("east")
                    || directionChoice.equals("East")){
                System.out.println("You are unable to go that direction.");
                    }

            else {
                southDirection();
                System.out.println("Please type in a direction.");
            }
        }


    }



    // Battle Functionality



    public void battleScreen() {
            System.out.println("|=---------------------------------------=|");
            System.out.println("|=---------------|Bandit|----------------=|");
            System.out.println("|=----------------HP:" + banditHP + "------------------=|");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" A) Attack");
            System.out.println(" B) Defend");
            System.out.println(" C) Run Away");
            System.out.println("|" + playerName + "|" + " Equipped: W: " + myWeapon + " A: " + myArmor + " HP: " + healthPoints);
            System.out.println("Choose an action:");
    }

    public void battle(){
        Scanner sc = new Scanner(System.in);
        battleActive = true;
        while(battleActive == true) {
            String battleChoice = sc.next();
            if (battleChoice.equalsIgnoreCase("a")) {
                attack();
            }
            if (battleChoice.equalsIgnoreCase("b")) {
                defend();
            }
            if (battleChoice.equalsIgnoreCase("c")) {
                mapArea();
                battleActive = false;
            }
        }
    }


    public void attack(){
        Scanner sc = new Scanner(System.in);
        int playerDamage = 1;
        if (myWeapon.equalsIgnoreCase("Stick")){
            playerDamage = (int)(Math.random() * 4) + 1;
        }
        if (myWeapon.equalsIgnoreCase("Short Sword")){
            playerDamage =(int)(Math.random() * 10) + 2;
        }

        System.out.println("You attack, dealing: "+playerDamage +" of damage.");
        banditHP -= playerDamage;

        if (banditHP < 0) {
            victory();
            banditBattle = 1;
            sc.nextLine();
            mapArea();
        }
        else {
           int enemyDamage = (int)(Math.random() * 3) + 1;
           System.out.println("The bandit retaliates and deals: "+enemyDamage+" points of damage.");
            healthPoints -= enemyDamage;
            if (healthPoints > 0) {
                battleScreen();
            }
        }
    }

    public void defend(){
        int enemyDamage = (int)(Math.random() * 2);
        System.out.println("You take a defensive stance.\n\nThe bandit attacks and deals: "+enemyDamage+" points of damage.");
        healthPoints -= enemyDamage;
        battleScreen();
    }

    public void victory(){
        System.out.println("*----You have defeated the bandit!----*");
        System.out.println("*----  The Bandit dropped a ring. ----*");
        banditRing = 1;
        battleActive = false;
    }


    public void gameQuit() {
        gameStatus = false;
    }
}
