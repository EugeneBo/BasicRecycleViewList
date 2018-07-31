package eugenebo.com.github.basicrecycleviewlist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ItemViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "ItemViewHolder";

    private TextView nameTextView;
    private TextView descriptionTextView;
    private TextView avatarLettersTextView;

    private Context context;

    private int viewType;

    public ItemViewHolder(View itemView, int viewType, Context context) {  //инициализируем объекты view
        super(itemView);
        this.context = context;
        this.viewType = viewType;

        if (viewType == 0) {
            nameTextView = itemView.findViewById(R.id.nameTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
            avatarLettersTextView = itemView.findViewById(R.id.avatarLetters);
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

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Drawable drawable = context.getResources().getDrawable(R.drawable.avatar_circle_40dp);  //Тут что-то не так с заменой цветов!!!
                GradientDrawable gradientDrawable = (GradientDrawable) drawable;
               // Log.i(TAG, "COLOR: " + contactItem.getAvatarColor());
                gradientDrawable.setColor(contactItem.getAvatarColor());
            }
        } else {
            Divider divider = (Divider) item;
            nameTextView.setText(divider.getDividersHeader());
        }
    }

}
