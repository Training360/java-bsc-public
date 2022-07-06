package catalog;

import java.util.List;

public class CourseBook extends Book {

    private String lector;

    public CourseBook(String title, int numberOfPages, List<String> authors, String lector) {
        super(title, numberOfPages, authors);
        if (Validators.isBlank(lector)) {
            throw new IllegalArgumentException("No lector");
        }
        this.lector = lector;
    }

    @Override
    public List<String> getContributors() {
        List<String> contributors = super.getContributors();
        contributors.add(lector);
        return contributors;
    }

    public String getLector() {
        return lector;
    }
}
