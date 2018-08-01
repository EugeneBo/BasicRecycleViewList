package eugenebo.com.github.basicrecycleviewlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter {

    private final static int CONTACT = 0;
    private final static int DIVIDER = 1;

    private List<RecycledItemView> items;


    public ItemAdapter(List<RecycledItemView> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == CONTACT)
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_layout, parent, false);
        else
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.divider_layout, parent, false);

        return new ItemViewHolder(view, viewType); //возвращаем инстанс ViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemViewHolder) holder).bindData(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Contact) return CONTACT;
        else return DIVIDER;
    }
}
