package eugenebo.com.github.basicrecycleviewlist;

public class Header implements ItemView {

    private String dividersHeader;

    public Header(String dividersHeader) {
        this.dividersHeader = dividersHeader;
    }

    public String getDividersHeader() {
        return dividersHeader;
    }

    public void setDividersHeader(String dividersHeader) {
        this.dividersHeader = dividersHeader;
    }
}
