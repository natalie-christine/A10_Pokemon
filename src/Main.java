
import org.natalie.pokemon.Pokemon;
import org.natalie.pokemon.PokemonArena;
import org.natalie.pokemon.PokemonCenter;
import org.natalie.pokemon.UI;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        PokemonCenter pokemonCenter = new PokemonCenter();
        UI ui = new UI(pokemonCenter);
        ui.startGame();
    }
    // "C:\Users\JodaBook\Documents\Java\A10_Pokemon\src\2023-03-13-org.natalie.pokemon.Pokemon.csv"
    // "C:\Users\JodaBook\Documents\Java\A10_Pokemon\src\2023-04-03-Attacks.csv"
    // "C:\Users\JodaBook\Documents\Java\A10_Pokemon\src\2023-03-16-Effectiveness.csv"

}