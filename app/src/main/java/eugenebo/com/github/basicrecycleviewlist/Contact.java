package eugenebo.com.github.basicrecycleviewlist;


public class Contact implements RecycledItemView {

    private String name;
    private String description;
    private String avatarLetters;
    private int avatarColor;

    public Contact(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getAvatarLetters() {
        return avatarLetters;
    }

    public void setAvatarLetters(String avatarLetters) {
        this.avatarLetters = avatarLetters;
    }

    public int getAvatarColor() {
        return avatarColor;
    }

    public void setAvatarColor(int avatarColor) {
        this.avatarColor = avatarColor;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
