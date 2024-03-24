import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokemon {

    private final int defense;
    final int speed;
    private final int index;
    private final String name;
    private final String type1;
    private final String type2;
    private final int total;
    private final int attack;
    private final int spAttack;
    private final int spDefense;

    private List<Attack> attacks;
    private final List<Attack> userAttacks = new ArrayList<>();
    private final List<Attack> pcAttacks = new ArrayList<>();
    private double hp;


    public Pokemon(int index, String name, String typ1, String typ2, int total, double hp, int attack, int defense, int spAttack, int spDefense, int speed) {
        this.index = index;
        this.name = name;
        this.type1 = typ1;
        this.type2 = typ2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.attacks = new ArrayList<>();
    }

    public  int getDefense() {
        return defense;
    }

    public int getIndex() {
        return index;
    }


    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public Attack generateRandomAttacks() {
        Collections.shuffle(attacks);
        pcAttacks.add(attacks.getFirst());
        return attacks.getFirst();
    }

    public void listAttacks() {
        System.out.println("Attacken:");
        attacks.sort(Comparator.comparingInt(Attack::getAttackIndex));
        for (Attack attack : attacks) {
            System.out.println(attack);
        }
    }

    public int getAttack() {
        return attack;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public Attack getAttackByAttackIndex(int index) {
        for (Attack attack : attacks) {
            if (attack.getAttackIndex() == index) {
                userAttacks.add(attack);
                return attack;
            }
        }
        return null;
    }

    @Override
    public String toString() {

        return String.format("%03d %-10s %-8s %-8s %3d %3s %3d %3d %3d %3d %3d", index, name, type1, type2, total, hp, attack, defense, spAttack, spDefense, speed);
    }

    public void decreaseHP(double damage) {
        this.hp -= damage;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public double getHP() {
        return this.hp;
    }



    public boolean hasType(String type) {
        return type1.equals(type) || type2.equals(type);

    }

}


