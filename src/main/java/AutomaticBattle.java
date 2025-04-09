import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class AutomaticBattle {

    public static Character getRival() throws IOException {
        newRandomRivals();

        Character randomPlayer = null;
        File automaticBattleChar = new File("automatic-battle.csv");
        Scanner scanner = new Scanner(automaticBattleChar);

        String randomLine = scanner.nextLine();
        if (!randomLine.isEmpty() && scanner.hasNextLine()) {
            String[] fields = randomLine.split(", ");
            String type = fields[0];
            String name = fields[1];
            randomPlayer = CharacterFactory.createPlayer2(type, name);
            return randomPlayer;
        }
        scanner.close();
        return randomPlayer;
    }

    public static void newRandomRivals() throws IOException {
        FileWriter randomAttackersFile = new FileWriter("automatic-battle.csv");
        String randomType;
        String randomName;

        for (int i=0; i<10; i++) {
            randomType = randomizeType();
            randomName = randomizeName();
            randomAttackersFile.write(randomType + ", " + randomName + "\n");
        }
        randomAttackersFile.close();
    }

    private static String randomizeName() {
        Random random = new Random();
        String[] titles= {"Sir", "Lady", "King", "Princess", "Big", "Evil", "Wise"};
        String[] syllable1= {"Lu", "Ga", "A", "E", "Fen", "Zor", "Xer", "Vel", "Thal", "Mor", "Dra"};
        String[] syllable2= {"a", "e", "i", "o", "u", "ar", "el", "ir", "or", "ul", "an", "en", "on", "la", "na"};
        String[] syllable3= {"ion", "or", "ar", "ek", "os", "an", "eth", "mir", "dor", "ax", "oth", "ys", "den", "ris", "el"};

        String title = titles[random.nextInt(titles.length)];
        String first = syllable1[random.nextInt(syllable1.length)];
        String second = syllable2[random.nextInt(syllable2.length)];
        String third = syllable3[random.nextInt(syllable3.length)];
        String name = title + first + second + third;
        return name;
    }

    private static String randomizeType() {
        Random random = new Random();
        String[] types= {"Warrior", "Wizard"};
        return types[random.nextInt(types.length)];
    }
}
