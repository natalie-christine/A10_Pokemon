
public class PokemonArena {


    public static Pokemon FirstAttacker(Pokemon userPokemon, Pokemon pcPokemon) {
        if (userPokemon.speed >= pcPokemon.speed) {
            return userPokemon;
        } else {
            return pcPokemon;
        }
    }


    public static void fight(Pokemon attacker, Pokemon defender, Attack userAttack, Attack pcAttack, int counter) {
        System.out.println(attacker.getName() + " greift " + defender.getName() + " mit " + userAttack.getName() + " an!");
        System.out.println();

        // Berechne den Schaden vom User verursacht
        double userDamage = calculateDamage(userAttack, attacker, defender,counter);
        System.out.println("Schaden von " + attacker.getName() + ": " + userDamage);
        defender.decreaseHP(userDamage);
        printHP(attacker, defender);
        System.out.println();

        // Überprüfe → Leben
        if (defender.getHP() <= 0) {
            System.out.println(defender.getName() + " wurde besiegt!");
            return;
        }

        // Defender Pokemon greift an
        System.out.println(defender.getName() + " greift mit " + pcAttack.getName() + " an!");
        System.out.println();
        double pcDamage = calculateDamage(pcAttack,defender,attacker,counter);
        System.out.println("Schaden von " + defender.getName() + ": " + pcDamage);
        attacker.decreaseHP(pcDamage);
        printHP(attacker, defender);
        System.out.println();

        // Überprüfe → Sieg
        if (attacker.getHP() <= 0) {
            System.out.println(attacker.getName() + " wurde besiegt!");
        }
    }

    private static void printHP(Pokemon attacker, Pokemon defender) {
        System.out.println(attacker.getName() + " HP: " + attacker.getHP());
        System.out.println(defender.getName() + " HP: " + defender.getHP());
    }

    public static double calculateDamage(Attack attack, Pokemon attacker, Pokemon defender, int counter) {

        double attackPower = attack.getPower();
        System.out.println(attackPower);
        double attackerAttack = attacker.getAttack();
        System.out.println(attackerAttack);
         double defenderDefense = defender.getDefense();
        System.out.println(defenderDefense);
        double stab = attacker.hasType(attack.getType()) ? 1.5 : 1.0; // STAB (Same Type Attack Bonus)
        System.out.println(stab);
        double effectiveness1 = Effectiveness.getEffectiveness(attack.getType(), defender.getType1());
        System.out.println(effectiveness1);
        double effectiveness2 = Effectiveness.getEffectiveness(attack.getType(), defender.getType2());
        System.out.println(effectiveness2);
        double rnd = Math.random() * (1.0 - 0.85) + 0.85; // Random value between 0.85 and 1.0
        System.out.println(rnd);

        return (attackPower) * ( attackerAttack / defenderDefense)* ( counter / 50.0) * rnd * stab * effectiveness1 * effectiveness2;
    } //Schaden = (Atk_Pw) * (APk_A / DPk_D) * (Lvl / 50) * Rnd * STAB * Eff1 * Eff2
}

