package org.natalie.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UI {

    private final PokemonCenter pokemonCenter;

    private final PokemonArena pokemonArena;

    public UI(PokemonCenter pokemonCenter) {
        this.pokemonCenter = pokemonCenter;
        this.pokemonArena = new PokemonArena();
    }


    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        // Schritt 1: Nutzer wählt sein Pokemon aus einer Liste
        System.out.println("Wähle dein Pokemon:");
        pokemonCenter.listPokemon();
        System.out.print("Index des Pokemon: ");
        int userPokemonIndex = scanner.nextInt();
        scanner.nextLine();

        Pokemon userPokemon = pokemonCenter.getPokemon(userPokemonIndex);

        // Schritt 2: Attacken auswählen
        System.out.println("Wähle deine Attacke:");
        userPokemon.listAttacks();
        System.out.print("Index der 1. Attacke: ");
        int userAttackIndex1 = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Index der 2. Attacke: ");
        int userAttackIndex2 = scanner.nextInt();
        scanner.nextLine();

        // Die ausgewählte Attacke erhalten
        Attack userAttack1 = userPokemon.getAttackByAttackIndex(userAttackIndex1);
        Attack userAttack2 = userPokemon.getAttackByAttackIndex(userAttackIndex2);


        // Überprüfen, ob die ausgewählte Attacke nicht null ist
        if (userAttack1 == null) {
            System.out.println("Ungültige Attacke.");
            return;
        }
        if (userAttack2 == null) {
            System.out.println("Ungültige Attacke.");
            return;
        }

        // Kontrollausgabe
        System.out.println();
        System.out.println("Du hast das Pokemon " + userPokemon.getName() + " und die Attacke " + userAttack1.getName() + " und die Attacke " + userAttack2.getName() + " ausgewählt.");


        // PC Pokemon Auswahl random

        Pokemon pcPokemon = pokemonCenter.getRandomPokemon();
        Attack pcAttack1 = pcPokemon.generateRandomAttacks();
        Attack pcAttack2 = pcPokemon.generateRandomAttacks();


        List<Attack> userAttacks = new ArrayList<>();
        List<Attack> pcAttacks = new ArrayList<>();
        userAttacks.add(userAttack1);
        userAttacks.add(userAttack2);
        pcAttacks.add(pcAttack1);
        pcAttacks.add(pcAttack2);
        // Kontrollausgabe
        System.out.println();
        System.out.println("Der PC hat das Pokemon " + pcPokemon.getName() + " und die Attacke " + pcAttack1.getName() + " und die Attacke " + pcAttack2.getName() + " ausgewählt.");


        Pokemon attacker = pokemonArena.FirstAttacker(userPokemon, pcPokemon);
        Pokemon defender = (attacker == pcPokemon) ? userPokemon : pcPokemon;
        System.out.println();
        System.out.println("First : " + attacker);
        System.out.println("Second: " + defender);

        int counter = 0;
        while (userPokemon.getHP() > 0 && pcPokemon.getHP() > 0) {
            // User wählt eine Attacke aus
            System.out.println("Wähle deine Attacke:");
            for (int i = 0; i < userAttacks.size(); i++) {
                Attack attack = userAttacks.get(i);
                System.out.println((i + 1) + ". " + attack.getName());

            }
            counter++;
            System.out.print("Index der Attacke: ");
            int userAttackChoice;
            do {
                userAttackChoice = scanner.nextInt();

            } while (userAttackChoice < 1 || userAttackChoice > userAttacks.size());
            Attack selectedUserAttack = userAttacks.get(userAttackChoice - 1);

            // PC Attacke wird zufällig generiert
            Attack selectedPcAttack = pcAttacks.get((int) (Math.random() * pcAttacks.size()));

            System.out.println();
            System.out.println(" Fighting Round " + counter);
            pokemonArena.fight(userPokemon, pcPokemon, selectedUserAttack, selectedPcAttack, counter);


            // Loop Benutzer wählt nächste Attacke
        }

        scanner.close();
    }

}