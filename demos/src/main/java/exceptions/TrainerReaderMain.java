package exceptions;

import java.util.List;

public class TrainerReaderMain {

    public static void main(String[] args) {
        TrainerReader trainerReader = new TrainerReader();
        List<Trainer> trainers = trainerReader.read();
        System.out.println(trainers);
    }
}
