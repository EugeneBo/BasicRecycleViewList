package eugenebo.com.github.basicrecycleviewlist;

import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "ItemViewHolder";

    private TextView nameTextView;
    private TextView descriptionTextView;
    private TextView avatarLettersTextView;
    private ImageView imageView;

    private int viewType;

    public ItemViewHolder(final View itemView, final int viewType) {  //инициализируем объекты view
        super(itemView);
        this.viewType = viewType;

        if (viewType == 0) {
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            avatarLettersTextView = itemView.findViewById(R.id.avatarLetters);
            imageView = itemView.findViewById(R.id.avatarImageView);
        } else {
            nameTextView = itemView.findViewById((R.id.dividerTextView));
        }

    }

    public void bindData(final ItemView item) {    //привязываем данные контакта к конкретным View в элементе списка

        if (viewType == ItemAdapter.CONTACT) {
            Contact contactItem = (Contact) item;

            nameTextView.setText(contactItem.getName());
            descriptionTextView.setText(contactItem.getDescription());
            avatarLettersTextView.setText(getContactAvatarLetters(contactItem));

            drawAvatarCircle(contactItem);

        } else {
            Divider divider = (Divider) item;
            nameTextView.setText(divider.getDividersHeader());
        }
    }


    private void drawAvatarCircle(final Contact contactItem) {
        ShapeDrawable avatarShape = new ShapeDrawable(new OvalShape());
        avatarShape.setIntrinsicHeight(40);
        avatarShape.setIntrinsicWidth(40);
        avatarShape.getPaint().setColor(colorGenerator(contactItem));
        imageView.setImageDrawable(avatarShape);

    }


    private int colorGenerator(final Contact contactItem) {

        int red = 2 * contactItem.getName().trim().charAt(0);
        int green;
        int blue;

        if (red % 5 == 0) {
            green = 95;
            blue = 75;
        } else if (red % 3 == 0) {
            green = 190;
            blue = 90;
        } else if (red % 7 == 0) {
            green = 100;
            blue = 190;
        } else if (red % 6 == 0) {
            green = 60;
            blue = 30;
        } else {
            green = 125;
            blue = 120;
        }
        // Log.i(TAG, "COLOR: " + Color.rgb(red, green, blue));
        return (Color.rgb(red, green, blue));

    }

    private String getContactAvatarLetters(final Contact contactItem) {

        String[] strings = contactItem.getName().trim().split("\\s+");

        if (strings.length >= 2) {
            return (strings[0].substring(0, 1) + strings[1].substring(0, 1));
        } else if (strings.length == 1) {
            return (strings[0].substring(0, 1));
        } else return ("N/A");

    }


}
