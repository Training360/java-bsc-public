package catalog;

import java.util.List;

public interface LibraryItem {

    List<String> getContributors();

    String getTitle();

    boolean isPrinted();

    boolean isAudio();
}
