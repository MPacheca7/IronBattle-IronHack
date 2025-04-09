import java.util.concurrent.ThreadLocalRandom;

public class Wizard extends Character {
    private int mana;
    private int intelligence;

    public Wizard(String name) {
        super(name, ThreadLocalRandom.current().nextInt(50, 101));//Hp wizards
        this.mana = ThreadLocalRandom.current().nextInt(10, 51);
        this.intelligence = ThreadLocalRandom.current().nextInt(10, 51);
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.max(0, mana);
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = Math.max(1, Math.min(50, intelligence));
    }

    public void fireball(Character rival) {
        if (mana >= 5) {
            int damage = intelligence;
            rival.setHp(rival.getHp() - damage);
            mana -= 5;
            System.out.println("Wizard " + getName() + " attacks with FIREBALL!! The damage is " + damage + " points");
        } else {
            staffHit(rival);
        }
    }

    public void staffHit(Character rival) {
        if (mana >= 1) {
            int damage = 2;
            rival.setHp(rival.getHp() - damage);
            mana -= 1;
            System.out.println(getName() + " attacks with STAFF HIT! The damage is " + damage + " points");
        } else {
            mana += 2;
            System.out.println("Wizard's mana is too low... this attack won't inflict damage. Wizard's mana recovers 2 points");
        }
    }

    public void attack(Character rival) {
        if (!isAlive()) return;
        int attackType = ThreadLocalRandom.current().nextInt(0, 2);
        if (attackType == 0) {
            fireball(rival);
        } else {
            staffHit(rival);
        }
        if (rival.getHp() <= 0) {
            rival.setAlive(false);
            System.out.println(rival.getName() + " was defeated by the wizard " + getName() + "!");
        }
    }
}
