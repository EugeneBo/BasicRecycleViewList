package eugenebo.com.github.basicrecycleviewlist;

public class Divider implements ItemView {

    private String dividersHeader;

    public Divider(final String dividersHeader) {
        this.dividersHeader = dividersHeader;
    }

    public String getDividersHeader() {
        return dividersHeader;
    }

    public void setDividersHeader(final String dividersHeader) {
        this.dividersHeader = dividersHeader;
    }
}
