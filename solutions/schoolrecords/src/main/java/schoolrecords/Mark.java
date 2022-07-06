package schoolrecords;

public class Mark {

    private MarkType markType;

    private Subject subject;

    private Tutor tutor;

    public Mark(MarkType markType, Subject subject, Tutor tutor) {
        if (subject == null || tutor == null) {
            throw new IllegalArgumentException("Both subject and tutor must be provided!");
        }
        this.markType = markType;
        this.subject = subject;
        this.tutor = tutor;
    }

    public int getMarkValue() {
        return markType.getValue();
    }

    public String getSubjectName() {
        return subject.getName();
    }

    public MarkType getMarkType() {
        return markType;
    }

    public Subject getSubject() {
        return subject;
    }

    public Tutor getTutor() {
        return tutor;
    }

    @Override
    public String toString() {
        return subject.getName()
                + " - "
                + markType.getDescription()
                + "("
                + markType.getValue()
                + ")";
    }
}
