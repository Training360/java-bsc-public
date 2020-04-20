package exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class TrainerReader {

    public static final String SEPARATOR = ";";

    private String values;

    public TrainerReader(String values) {
        this.values = values;
    }

    public List<Trainer> read() {
        List<Trainer> trainers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new StringReader(values));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
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
        catch (IOException ioe) {
            throw new IllegalStateException("Error by parsing, general io", ioe);
        }
        finally {
            closeReader(reader);
        }
        return trainers;
    }

    private void closeReader(Reader reader) {
        try {
            reader.close();
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot close", ioe);
        }
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
