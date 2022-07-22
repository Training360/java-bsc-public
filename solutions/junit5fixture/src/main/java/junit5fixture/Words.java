package junit5fixture;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public List<String> getWords() {
        return words;
    }

    public void addWord(String word) {
        words.add(word);
    }

    public void removeWordsWithoutLetter(String letter) {
        List<String> wordsToRemove = new ArrayList<>();
        for (String word : words) {
            if (word.indexOf(letter) == -1) {
                wordsToRemove.add(word);
            }
        }
        words.removeAll(wordsToRemove);
    }

    public void removeWordsWithOtherLength(int length) {
        List<String> wordsToRemove = new ArrayList<>();
        for (String word : words) {
            if (word.length() != length) {
                wordsToRemove.add(word);
            }
        }
        words.removeAll(wordsToRemove);
    }
}
