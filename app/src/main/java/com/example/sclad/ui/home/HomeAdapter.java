package com.example.sclad.ui.home;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sclad.databinding.ItemOrderScladBinding;
import com.example.sclad.model.Order;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private ItemOrderScladBinding binding;
    private final Context context;
    private final ArrayList<Order> list;

    public HomeAdapter(Context context, ArrayList<Order> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemOrderScladBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
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
        private final ItemOrderScladBinding binding;

        public ViewHolder(@NonNull ItemOrderScladBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(Order order) {
            binding.nameUser.setText(order.getNameUser() != null ? order.getNameUser() : "");
            binding.nameProductCard.setText(order.getNameProduct() != null ? order.getNameProduct() : "");
            binding.priceCard.setText(order.getPriceProduct() != null ? order.getPriceProduct().toString() : "");
            binding.addressUser.setText(order.getAddressUser() != null ? order.getAddressUser() : "");
            binding.productsCounter.setText(String.valueOf(order.getProductCount()));
            Picasso.get().load(order.getImage()).into(binding.imageCard);
        }
    }
}