package eugenebo.com.github.basicrecycleviewlist;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    private static final String TAG = "TEST";

    private TextView nameTextView;
    private TextView descriptionTextView;
    private TextView avatarLettersTextView;
    private ImageView avatarImageView;
    private Context context;

    public ContactViewHolder(View itemView, Context context) {  //инициализируем объекты view
        super(itemView);


        this.context = context;
        nameTextView = itemView.findViewById(R.id.nameTextView);
        descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        avatarLettersTextView = itemView.findViewById(R.id.avatarLetters);
        avatarImageView = itemView.findViewById(R.id.avatarImageView);


    }

    public void bindData(final Contact contact) {    //привязываем данные контакта к конкретным View в элементе списка
        nameTextView.setText(contact.getName());
        descriptionTextView.setText(contact.getDescription());
        avatarLettersTextView.setText(contact.getAvatarLetters());

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Drawable drawable = context.getDrawable(R.drawable.avatar_circle_40dp);
            GradientDrawable gradientDrawable = (GradientDrawable) drawable;
            if (gradientDrawable != null) {
                Log.i(TAG, "COLOuR: " + contact.getAvatarColor());
                gradientDrawable.setColor((contact.getAvatarColor()));
            }
        }


    }


}
