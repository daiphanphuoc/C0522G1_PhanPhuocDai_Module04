package dai_phan.exercise.model;

public class EmailConfiguration {
    private int id;
    private String languages;
    private int pages;
    private boolean spamFilter;
    private String signature;

    public EmailConfiguration() {
    }

    public EmailConfiguration(int id, String languages, int pages, boolean spamFilter, String signature) {
        this.id = id;
        this.languages = languages;
        this.pages = pages;
        this.spamFilter = spamFilter;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isSpamFilter() {
        return spamFilter;
    }

    public void setSpamFilter(boolean spamFilter) {
        this.spamFilter = spamFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
