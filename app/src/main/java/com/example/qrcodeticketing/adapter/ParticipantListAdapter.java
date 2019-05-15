package com.example.qrcodeticketing.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.qrcodeticketing.R;
import com.example.qrcodeticketing.model.Participant;

public class ParticipantListAdapter extends RecyclerView.Adapter<ParticipantListAdapter.ViewHolder> {
    private Participant participants[];
    private Context context;
    public ParticipantListAdapter(Participant[] participants, Context context) {
        this.participants = participants;
        this.context=context;
    }
    @Override
    public ParticipantListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.participant_list_item, parent, false);
        ParticipantListAdapter.ViewHolder viewHolder = new ParticipantListAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ParticipantListAdapter.ViewHolder holder, int position) {
        final Participant participant = participants[position];
        holder.textView.setText(participants[position].getId());
        holder.textView2.setText(participants[position].getName());
        holder.textView3.setText(participants[position].getEmail());
        holder.linearLayout.setBackgroundColor(participants[position].isScanned()?Color.GREEN:Color.WHITE);
    }


    @Override
    public int getItemCount() {
        return participants.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView2;
        public TextView textView3;
        public LinearLayout linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.pid);
            this.textView2 = (TextView) itemView.findViewById(R.id.pname);
            this.textView3 = (TextView) itemView.findViewById(R.id.pmail);
            this.linearLayout = (LinearLayout) itemView.findViewById(R.id.plistitem);
        }
    }
}
