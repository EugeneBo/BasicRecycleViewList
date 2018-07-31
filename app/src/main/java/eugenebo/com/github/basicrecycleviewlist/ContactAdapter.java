package eugenebo.com.github.basicrecycleviewlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter {


    private List<Contact> contacts;
    private Context context;

    public ContactAdapter(List<Contact> contacts, Context context) {
        this.contacts = contacts;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ContactViewHolder(view, context); //возвращаем инстанс ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ContactViewHolder) holder).bindData(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.contact_layout;
    }
}
