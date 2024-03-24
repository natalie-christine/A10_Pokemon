import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        PokemonCenter pokemonCenter = new PokemonCenter();

        try {
            PokemonCenter.readPokemon();
            PokemonCenter.readAttacks();
            for (Pokemon pokemon : pokemonCenter.getPokemons() ) {
                pokemon.setAttacks(pokemonCenter.getAttacksByType(pokemon.getType1(), pokemon.getType2()));
            }
            UI ui = new UI(pokemonCenter);

            ui.startGame();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Dateien: " + e.getMessage());
        }
    }
    // "C:\Users\JodaBook\Documents\Java\A10_Pokemon\src\2023-03-13-Pokemon.csv"
    // "C:\Users\JodaBook\Documents\Java\A10_Pokemon\src\2023-04-03-Attacks.csv"
    // "C:\Users\JodaBook\Documents\Java\A10_Pokemon\src\2023-03-16-Effectiveness.csv"

}