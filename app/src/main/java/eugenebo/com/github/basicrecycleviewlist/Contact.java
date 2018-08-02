package eugenebo.com.github.basicrecycleviewlist;


public class Contact implements ItemView {

    private String name;
    private String description;


    public Contact(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

}
