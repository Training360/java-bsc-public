package catalog;

import java.util.ArrayList;
import java.util.List;

public class AudioBook implements LibraryItem {

    private String title;

    private List<String> authors;

    private List<String> performers;

    private int length;

    public AudioBook(String title, List<String> authors, List<String> performers, int length) {
        validate(title, authors, performers, length);
        this.title = title;
        this.authors = authors;
        this.performers = performers;
        this.length = length;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        contributors.addAll(authors);
        contributors.addAll(performers);
        return contributors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isPrinted() {
        return false;
    }

    @Override
    public boolean isAudio() {
        return true;
    }

    public int getLength() {
        return length;
    }

    private void validate(String title, List<String> authors, List<String> performers, int length) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("No author");
        }
        if (Validators.isEmpty(performers)) {
            throw new IllegalArgumentException("No performer");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Illegal length: " + length);
        }
    }
}
