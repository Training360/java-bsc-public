package catalog;

import java.util.List;

public class Book implements LibraryItem {

    private String title;

    private int numberOfPages;

    private List<String> authors;

    public Book(String title, int numberOfPages, List<String> authors) {
        validate(title, numberOfPages, authors);
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.authors = authors;
    }

    @Override
    public List<String> getContributors() {
        return authors;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public boolean isPrinted() {
        return true;
    }

    @Override
    public boolean isAudio() {
        return false;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    private void validate(String title, int numberOfPages, List<String> authors) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Empty title");
        }
        if (numberOfPages <= 0) {
            throw new IllegalArgumentException("Illegal number of pages: " + numberOfPages);
        }
        if (Validators.isEmpty(authors)) {
            throw new IllegalArgumentException("No authors");
        }
    }
}
