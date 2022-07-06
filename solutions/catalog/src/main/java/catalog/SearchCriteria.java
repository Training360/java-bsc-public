package catalog;

public class SearchCriteria {

    private String title;

    private String contributor;

    private SearchCriteria(String title, String contributor) {
        this.title = title;
        this.contributor = contributor;
    }

    public static SearchCriteria createByTitle(String title) {
        if (Validators.isBlank(title)) {
            throw new IllegalArgumentException("Title should be given");
        }
        return new SearchCriteria(title, null);
    }

    public static SearchCriteria createByContributor(String contributor) {
        if (Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Contributor should be given");
        }
        return new SearchCriteria(null, contributor);
    }

    public static SearchCriteria createByBoth(String title, String contributor) {
        if (Validators.isBlank(title) || Validators.isBlank(contributor)) {
            throw new IllegalArgumentException("Title and contributor should be given");
        }
        return new SearchCriteria(title, contributor);
    }

    public boolean hasTitle() {
        return title != null;
    }

    public boolean hasContributor() {
        return contributor != null;
    }

    public String getTitle() {
        return title;
    }

    public String getContributor() {
        return contributor;
    }
}
