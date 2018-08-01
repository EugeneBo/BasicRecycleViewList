package eugenebo.com.github.basicrecycleviewlist;

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

    public ItemViewHolder(View itemView, int viewType) {  //инициализируем объекты view
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

    public void bindData(final RecycledItemView item) {    //привязываем данные контакта к конкретным View в элементе списка

        if (viewType == 0) {
            Contact contactItem = (Contact) item;

            nameTextView.setText(contactItem.getName());
            descriptionTextView.setText(contactItem.getDescription());
            avatarLettersTextView.setText(contactItem.getAvatarLetters());

            drawAvatarCircle(contactItem);

        } else {
            Divider divider = (Divider) item;
            nameTextView.setText(divider.getDividersHeader());
        }
    }


    private void drawAvatarCircle(Contact contactItem) {
        ShapeDrawable avatarShape = new ShapeDrawable(new OvalShape());
        avatarShape.setIntrinsicHeight(40);
        avatarShape.setIntrinsicWidth(40);
        avatarShape.getPaint().setColor(contactItem.getAvatarColor());
        imageView.setImageDrawable(avatarShape);

    }

}
