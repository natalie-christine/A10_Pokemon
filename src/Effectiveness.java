import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Effectiveness {
    private static final String FILE_PATH = "C:\\Users\\JodaBook\\Documents\\Java\\A10_Pokemon\\src\\2023-03-16-Effectiveness.csv";
    private static final Map<String, Map<String, Double>> effectivenessMap;

    static {
        effectivenessMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            String[] headers = null;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                if (headers == null) {
                    headers = values;
                } else {
                    String attackerType = values[0];
                    Map<String, Double> effectiveness = new HashMap<>();
                    for (int i = 1; i < values.length; i++) {
                        effectiveness.put(headers[i], Double.parseDouble(values[i]));
                    }
                    effectivenessMap.put(attackerType, effectiveness);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static double getEffectiveness(String attackerType, String defenderType) {
        Map<String, Double> defenderEffectiveness = effectivenessMap.get(attackerType);
        if (defenderEffectiveness != null) {
            Double effectiveness = defenderEffectiveness.get(defenderType);
            if (effectiveness != null) {
                return effectiveness;
            }
        }
        // Standardwert, falls keine Übereinstimmung gefunden wird
        return 1.0;
    }


}