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
import com.example.qrcodeticketing.adapter.ParticipantListAdapter;
import com.example.qrcodeticketing.model.Participant;

public class ListParticipants extends AppCompatActivity {

    RecyclerView participantsList;
    TextInputEditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_participants);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        participantsList=(RecyclerView)findViewById(R.id.participantList);

        Participant participants[] = new Participant[]{};

        ParticipantListAdapter adapter=new ParticipantListAdapter(participants,this);
        participantsList.setHasFixedSize(true);
        participantsList.setLayoutManager(new LinearLayoutManager(this));
        participantsList.setAdapter(adapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog=new Dialog(ListParticipants.this);
                dialog.setTitle("Add Channel:");
                dialog.setContentView(R.layout.add_participant_dialog);
                ed1=(TextInputEditText)dialog.findViewById(R.id.partiname);
                ed1=(TextInputEditText)dialog.findViewById(R.id.partimail);
                dialog.show();
                Button btn=(Button) dialog.findViewById(R.id.addpartibtn);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ListParticipants.this, ed1.getText().toString(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
            }
        });
    }

}
