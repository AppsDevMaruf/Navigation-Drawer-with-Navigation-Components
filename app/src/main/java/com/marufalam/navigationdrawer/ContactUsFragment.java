package com.marufalam.navigationdrawer;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ContactUsFragment extends Fragment {
    Button play, pause, stop;
    MediaPlayer player;

    public ContactUsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        play = view.findViewById(R.id.button1);
        pause = view.findViewById(R.id.button2);
        stop = view.findViewById(R.id.button3);

        play.setOnClickListener(view1 -> {

            if (player==null){
                player = MediaPlayer.create(getActivity(),R.raw.music);
                player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        stopPlayer();
                    }
                });
            }
            player.start();
        });
        pause.setOnClickListener(view1 -> {
            if (player!=null){
                player.pause();
            }
        });
        stop.setOnClickListener(view1 -> stopPlayer());


        return view;

    }

    private void stopPlayer(){
        if (player!=null){
            player.release();
            player=null;
            Toast.makeText(requireActivity(), "MediaPlayer released", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        stopPlayer();
    }
}
