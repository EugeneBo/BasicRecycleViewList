package eugenebo.com.github.basicrecycleviewlist;

public class Divider implements RecycledItemView {

    private String dividersHeader;

    public Divider(String dividersHeader) {
        this.dividersHeader = dividersHeader;
    }

    public String getDividersHeader() {
        return dividersHeader;
    }

    public void setDividersHeader(String dividersHeader) {
        this.dividersHeader = dividersHeader;
    }
}
