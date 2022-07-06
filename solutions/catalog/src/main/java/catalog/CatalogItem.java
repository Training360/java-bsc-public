package catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatalogItem {

    private String registrationNumber;

    private int pieces;

    private List<LibraryItem> libraryItems;

    public CatalogItem(String registrationNumber, int pieces, LibraryItem... libraryItems) {
        validate(registrationNumber, pieces);
        this.registrationNumber = registrationNumber;
        this.pieces = pieces;
        this.libraryItems = Arrays.asList(libraryItems);
    }

    public boolean hasAudioFeature() {
        for (LibraryItem item : libraryItems) {
            if (item.isAudio()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPrintedFeature() {
        for (LibraryItem item : libraryItems) {
            if (item.isPrinted()) {
                return true;
            }
        }
        return false;
    }

    public int getNumberOfPagesAtOneItem() {
        int numberOfPages = 0;
        for (LibraryItem item : libraryItems) {
            if (item.isPrinted()) {
                numberOfPages += ((Book) item).getNumberOfPages();
            }
        }
        return numberOfPages;
    }

    public List<String> getContributors() {
        List<String> contributors = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            List<String> contributorsToAdd = getContributorsToAdd(contributors, item.getContributors());
            contributors.addAll(contributorsToAdd);
        }
        return contributors;
    }

    public List<String> getTitles() {
        List<String> titles = new ArrayList<>();
        for (LibraryItem item : libraryItems) {
            titles.add(item.getTitle());
        }
        return titles;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getPieces() {
        return pieces;
    }

    public List<LibraryItem> getLibraryItems() {
        return new ArrayList<>(libraryItems);
    }

    private List<String> getContributorsToAdd(List<String> contributorsAlready, List<String> contributors) {
        List<String> contributorsToAdd = new ArrayList<>();
        for (String contributor : contributors) {
            if (!contributorsAlready.contains(contributor)) {
                contributorsToAdd.add(contributor);
            }
        }
        return contributorsToAdd;
    }

    private void validate(String registrationNumber, int pieces) {
        if (Validators.isBlank(registrationNumber)) {
            throw new IllegalArgumentException("Empty registration number");
        }
        if (pieces < 0) {
            throw new IllegalArgumentException("Pieces must be at least 0");
        }
    }
}
