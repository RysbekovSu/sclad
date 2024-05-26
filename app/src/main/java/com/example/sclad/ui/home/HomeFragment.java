package com.example.sclad.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sclad.databinding.FragmentHomeBinding;
import com.example.sclad.model.Order;
import com.example.sclad.remote_data.RetrofitBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    HomeAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Call<List<Order>> apiCall= RetrofitBuilder.getInstance().getApi().getAllOrders();
        apiCall.enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                if(response.isSuccessful() && response.body()!=null){
                    ArrayList<Order> list =( ArrayList<Order>) response.body();
                    adapter = new HomeAdapter(requireActivity(), list);
                    binding.rvMainListAllOrders.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<List<Order>> call, Throwable throwable) {
                Toast.makeText(requireActivity(), "No data", Toast.LENGTH_SHORT).show();

            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}