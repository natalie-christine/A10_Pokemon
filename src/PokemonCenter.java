import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PokemonCenter {

    static HashMap<String, Pokemon> pokemonNameList = new HashMap<>();
    static HashMap<Integer, Pokemon> pokemonIndexList = new HashMap<>();

    static HashMap<String, Attack> attackList = new HashMap<>();


    public static void addPokemon(Pokemon pokemon) {
        pokemonNameList.put(pokemon.getName(), pokemon);
        pokemonIndexList.put(pokemon.getIndex(), pokemon);
    }

    public static void addAttack(Attack attack) {
        attackList.put(attack.getName(), attack);
    }

    public static void readPokemon() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\JodaBook\\Documents\\Java\\A10_Pokemon\\src\\2023-03-13-Pokemon.csv"));
        String line;

        reader.readLine(); // Skip the header line
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(";");
            int index = Integer.parseInt(data[0]);
            String name = data[1];
            String type1 = data[2];
            String type2 = data[3];
            int total = Integer.parseInt(data[4]);
            int hp = Integer.parseInt(data[5]);
            int attack = Integer.parseInt(data[6]);
            int defense = Integer.parseInt(data[7]);
            int spAttack = Integer.parseInt(data[8]);
            int spDefense = Integer.parseInt(data[9]);
            int speed = Integer.parseInt(data[10]);
            Pokemon pokemon = new Pokemon(index, name, type1, type2, total, hp, attack, defense, spAttack, spDefense, speed);
            addPokemon(pokemon);
        }
        reader.close();
    }

    public static void readAttacks() throws IOException {
        BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\JodaBook\\Documents\\Java\\A10_Pokemon\\src\\2023-04-03-Attacks.csv")
        );
        reader.readLine(); // Skip header
        String currentLine = reader.readLine();
        while (currentLine != null) {
            String[] lineSplit = currentLine.split(";");
            addAttack(new Attack(Integer.parseInt(lineSplit[0]),
                    lineSplit[1],
                    lineSplit[2],
                    lineSplit[3],
                    lineSplit[4],
                    Integer.parseInt(lineSplit[5]),
                    lineSplit[6],
                    Integer.parseInt(lineSplit[7])
            ));
            currentLine = reader.readLine();
        }
        reader.close();
    }

    public static void listPokemon() {
        for (int i = 1; i <= pokemonIndexList.size(); i++) {
            Pokemon pokemon = pokemonIndexList.get(i);
            System.out.println(pokemon);
        }
    }

    public Pokemon getRandomPokemon() {
        Random random = new Random();
        List<Pokemon> pokemonList = new ArrayList<>(pokemonIndexList.values());
        int randomIndex = random.nextInt(pokemonList.size());
        return pokemonList.get(randomIndex);
    }

    public Pokemon getPokemon(int index) {
        return pokemonIndexList.get(index);
    }
    public Collection<Pokemon> getPokemons() {
        return pokemonIndexList.values();
    }

    public List<Attack> getAttacksByType(String type1, String type2) {
        List<Attack> attacksByType = new ArrayList<>();
        for (Attack attack : attackList.values()) {
            if (attack.getType().equalsIgnoreCase(type1) || attack.getType().equalsIgnoreCase(type2)) {
                attacksByType.add(attack);
            }
        }
        return attacksByType;
    }

}