
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class CharacterFactory {

    public static Character createPlayer1(){
        var myScanner = new Scanner(System.in);
        System.out.println("To start the battle, first choose your character type. To select a wizard, write 1; if you want to be a warrior, write 2: ");
        var userInput = myScanner.nextInt();
        String chosenType;
        if (userInput == 1) {
            chosenType = "Wizard";
        } else if (userInput == 2) {
            chosenType = "Warrior";
        } else {
            chosenType = "Wizard";
            System.out.println("You choosed wrong, so you were asigned a wizard character randomly");//refactorizar a dowhile para volver a la pregunta
        }

        myScanner.nextLine();
        System.out.println("Choose a name for your new " + chosenType + ": ");
        String chosenName = myScanner.nextLine();
        System.out.println("Hi " + chosenName + ", welcome");

        Character player3;
        if (chosenType.equals("Wizard")) {
            player3 = new Wizard(chosenName);
            Wizard wizardPlayer = (Wizard) player3;
            System.out.println("You have " + wizardPlayer.getHp() + "HP, " + wizardPlayer.getMana() + " of Mana, and " + wizardPlayer.getIntelligence() + " Intelligence");
        } else {
            player3 = new Warrior(chosenName);
            Warrior warriorPlayer = (Warrior) player3;
            System.out.println("You have " + warriorPlayer.getHp() + "HP, " + warriorPlayer.getStamina() + " of Stamina, and " + warriorPlayer.getStrength() + " Strength");
        }
        System.out.println("To find a rival for the battle, please write any text in the console");
        myScanner.nextLine();

        return player3;
    }

    public static Character createPlayer2(String type, String name) {
        Character rival = null;
        if (type.equals("Wizard")) {
            rival = new Wizard(name);
            Wizard wizard = (Wizard) rival;
            System.out.println("Your rival is the Wizard " + rival.getName() +
                    " with " + wizard.getHp() + "HP, " + wizard.getMana() + " Mana, " + wizard .getIntelligence() + " Intelligence.");

        }  else if (type.equals("Warrior")) {
            rival = new Warrior(name);
            Warrior warrior = (Warrior) rival;
            System.out.println("Your rival is the Warrior " + rival.getName() +
                    " with " + warrior.getHp() + "HP, " + warrior.getStamina() + " Stamina, " + warrior.getStrength() + " Strength.");

        }
        return rival;
    }
}
