package com.example.qrcodeticketing.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.qrcodeticketing.ListParticipants;
import com.example.qrcodeticketing.R;
import com.example.qrcodeticketing.ScanParticipants;
import com.example.qrcodeticketing.model.Channel;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListAdapter.ViewHolder> {
    private Channel channelList[];
    private Context context;
    public ChannelListAdapter(Channel[] channelList, Context context) {
        this.channelList = channelList;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.channel_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Channel channel = channelList[position];
        holder.textView.setText(channelList[position].getId());
        holder.textView2.setText(channelList[position].getName());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ListParticipants.class));
            }
        });
        holder.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, ScanParticipants.class));
            }
        });
    }


    @Override
    public int getItemCount() {
        return channelList.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public TextView textView2;
        public Button button;
        public Button button1;
        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.cid);
            this.textView2 = (TextView) itemView.findViewById(R.id.cname);
            this.button = (Button) itemView.findViewById(R.id.aadp);
            this.button1 = (Button) itemView.findViewById(R.id.scanp);
        }
    }
}
