package com.example.sclad.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sclad.databinding.ItemUserScladBinding;
import com.example.sclad.model.User;

import java.util.ArrayList;


public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private final Context context;
    private final ArrayList<User> list;

    public UserAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemUserScladBinding binding = ItemUserScladBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemUserScladBinding binding;

        public ViewHolder(@NonNull ItemUserScladBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(User user) {
            binding.nameUser.setText(user.getName() != null ? user.getName() : "No Name");
            binding.emailUser.setText(user.getEmail() != null ? user.getEmail() : "No Email");
        }
    }
}