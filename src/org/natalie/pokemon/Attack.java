package org.natalie.pokemon;

public class Attack {


/*#;Name;Effect;Type;Kind;Power;Accuracy;PP
1;Pound;Deals damage with no additional effect.;Normal;Physical;40;100%;35*/

    private final int attackIndex;
    private String name;
    private String effect;

    private String type;
    private String kind;
    private int power;
    private  String accuracy;
    private int pp;

    public Attack(int attackIndex, String name, String effect, String type, String kind, int power, String accuracy, int pp) {
        this.attackIndex = attackIndex;
        this.name = name;
        this.effect = effect;
        this.type = type;
        this.kind = kind;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;

    }

    public int getPower() {
        return power;
    }

    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }

    public int getAttackIndex() {
        return attackIndex;
    }


    @Override
    public String toString() {
        return String.format("%03d %-15s %-8s %3d  %4s  %3d",attackIndex,name,type,power,accuracy,pp);

    }

}
