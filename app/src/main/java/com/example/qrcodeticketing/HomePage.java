package com.example.qrcodeticketing;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.qrcodeticketing.adapter.ChannelListAdapter;
import com.example.qrcodeticketing.model.Channel;

public class HomePage extends AppCompatActivity {

    RecyclerView channelList;
    TextInputEditText ed1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        channelList = (RecyclerView) findViewById(R.id.channelList);

        Channel[] channels = new Channel[] {
        };

        ChannelListAdapter adapter=new ChannelListAdapter(channels,this);
        channelList.setHasFixedSize(true);
        channelList.setLayoutManager(new LinearLayoutManager(this));
        channelList.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(HomePage.this);
                dialog.setTitle("Add Channel:");
                dialog.setContentView(R.layout.add_channel_dialog);
                ed1=(TextInputEditText)dialog.findViewById(R.id.createChannelname);
                dialog.show();
                Button btn=(Button) dialog.findViewById(R.id.addChannelbtn);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(HomePage.this, ed1.getText().toString(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }

}
