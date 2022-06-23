package com.example.toki.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toki.R;

import java.util.List;

import Models.Contact;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactViewHolder> {

    private List<Contact> contactsAdapter;
    //private final LayoutInflater inflater;
    private final LayoutInflater inflater;
    private onContactListener listener;

    public ContactsAdapter(Context context, onContactListener listener) {
        //inflater = null;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }

    public void setContacts(List<Contact> s) {
        this.contactsAdapter = s;
        notifyDataSetChanged();
    }

    public List<Contact> getContacts() {
        return this.contactsAdapter;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        ItemContainerContactBinding itemContainerContactBinding = ItemContainerContactBinding.inflate(
//                LayoutInflater.from(parent.getContext()),
//                parent,
//                false
//        );
        View itemContainer = inflater.inflate(R.layout.item_container_contact, parent, false);
        return new ContactViewHolder(itemContainer, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ContactViewHolder holder, int position) {
        if (contactsAdapter != null && contactsAdapter.size() >= position) {
            Contact current = contactsAdapter.get(position);
            holder.nickname.setText(current.getName());
            holder.lastMsgContent.setText(current.getLast());
            holder.lastMsgDate.setText(current.getLast());
        }
    }

    @Override
    public int getItemCount() {
        return contactsAdapter!=null ? contactsAdapter.size() : 0 ;
    }



    class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView nickname;
        private TextView lastMsgContent;
        private TextView lastMsgDate;
//        private String profileImg;
        onContactListener listener;

        public ContactViewHolder(@NonNull View view, onContactListener l) {
            super(view);
            this.listener = l;
            this.nickname = view.findViewById(R.id.contact_nick);
            this.lastMsgContent = view.findViewById(R.id.contact_last_message);
            this.lastMsgDate = view.findViewById(R.id.contact_msg_date);
            itemView.setOnClickListener(this);
        }

//        ItemContainerContactBinding binding;
//        public ContactViewHolder(ItemContainerContactBinding itemContainerContactBinding) {
//            super(itemContainerContactBinding.getRoot());
//            binding = itemContainerContactBinding;
//        }

//        void setContactData(List<Contact> cons) {
//            binding.textName.setText(cont.getName());
//            binding.textLastMessage.setText(cont.getLast());
//            //TODO ADD PROFILE IMAGE #6 TUTORIAL
//            //binding.profileImage.setImage...
//        }


        @Override
        public void onClick(View v) {
            this.listener.onContactClick(getAdapterPosition());
        }
    }
    public interface onContactListener {
        void onContactClick(int position);
    }
}
