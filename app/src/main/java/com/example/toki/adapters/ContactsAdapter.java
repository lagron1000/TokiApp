package com.example.toki.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toki.MyApplication;
import com.example.toki.databinding.ItemContainerContactBinding;

import java.util.List;

import Models.Contact;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    private final List<Contact> contactsAdapter;
    //private final LayoutInflater inflater;
    private final LayoutInflater inflater;

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemContainerContactBinding itemContainerContactBinding = ItemContainerContactBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ContactViewHolder(itemContainerContactBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ContactViewHolder holder, int position) {
        holder.setContactData(contactsAdapter.get(position));
    }

    @Override
    public int getItemCount() {
        return contactsAdapter.size();
    }

    public ContactsAdapter(List<Contact> contacts) {
        this.contactsAdapter = contacts;
        //inflater = null;
        this.inflater = LayoutInflater.from(MyApplication.context);
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {
        ItemContainerContactBinding binding;
        ContactViewHolder(ItemContainerContactBinding itemContainerContactBinding) {
            super(itemContainerContactBinding.getRoot());
            binding = itemContainerContactBinding;
        }
        void setContactData(Contact cont) {
            binding.textName.setText(cont.getName());
            binding.textLastMessage.setText(cont.getLast());
            //TODO ADD PROFILE IMAGE #6 TUTORIAL
            //binding.profileImage.setImage...
        }
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
