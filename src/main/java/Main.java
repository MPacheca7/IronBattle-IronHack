import java.util.Scanner;
import java.io.IOException;

public class Main {

    static Scanner myScanner = new Scanner(System.in);

    public static void startGame() throws IOException {
        Character player1 = CharacterFactory.createPlayer1();
        Character player2 = AutomaticBattle.getRival();


        System.out.println("Welcome to the Ironbattle. The game is about to start ⚔\uFE0F. Please, press any key and press enter");
        myScanner.nextLine();

        Battle battle = new Battle(player1, player2);
        battle.StartingBattle();
    }

    public static void main(String[] args) throws IOException {
        startGame();
        System.out.println("The battle has ended, thank you for playing. Please, exit the program.");
    }

}
