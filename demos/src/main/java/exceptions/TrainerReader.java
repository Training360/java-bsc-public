package exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrainerReader {

    public static final String SEPARATOR = ";";

    public List<Trainer> read() {
        List<Trainer> trainers = new ArrayList<>();
        Scanner scanner = new Scanner(TrainerReader.class.getResourceAsStream("trainers.csv"));

        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Trainer trainer = parseLine(line);
                trainers.add(trainer);
            }
        }
        catch (NumberFormatException nfe) {
            throw new IllegalStateException("Error by parsing, invalid number", nfe);
        }
        catch (IllegalArgumentException iae) {
            throw new IllegalStateException("Error by parsing, invalid line", iae);
        }
        finally {
            scanner.close();
        }
        return trainers;
    }

    private Trainer parseLine(String line) {
        String[] fields = line.split(SEPARATOR);
        if (fields.length != 2) {
            throw new IllegalArgumentException("Invalid line: " + line);
        }
        if (fields[0].length() == 0) {
            throw new IllegalArgumentException("Empty name in line: " + line);
        }
        return new Trainer(fields[0], Integer.parseInt(fields[1]));
    }

}
