import java.util.Scanner;

public class Battle  {
    private Character player1;
    private Character player2;

    public Battle(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void StartingBattle () {

        int round = 1;
        Scanner myScanner = new Scanner(System.in);

        int numberOfRounds = 10;
        while(round <= numberOfRounds) {
            System.out.println("Start the round\uD83D\uDD25"+ round++);
            player1.attack(player2);
            System.out.println(player2.getName() + " has " + player2.getHp() + " health left\n");

            System.out.println(player2.getName() + " strikes back ------");
            player2.attack(player1);
            System.out.println(player1.getName() + " has " + player1.getHp() + " health left\n");


            if(player1.getHp() > 0 && player2.getHp() > 0) {
                System.out.println("Press enter to start the next round");
                myScanner.nextLine();


            } else if(player1.getHp() == 0) {
                System.out.println("End of the round! Winner is " + player2.getName() + " HP\uD83C\uDFC6");
                break;
            } else if(player2.getHp() == 0) {
                System.out.println("End of the round! Winner is " + player1.getName() + " HP\uD83C\uDFC6");
                break;
            } else {
                System.out.println("End of the battle!");
                break;
            }
        }

        int winner1 = player1.getHp();
        int winner2 = player2.getHp();

        if ((winner1 > winner2)) {
            System.out.println("\n🏆 ¡Winner: " + player1.getName() + "!");
        } else if ((winner2 > winner1) ) {
            System.out.println("\n🏆 ¡Winner: " + player2.getName() + "!");
        } else {
            System.out.println("Draw!");
        }
        myScanner.close();
    }


}
