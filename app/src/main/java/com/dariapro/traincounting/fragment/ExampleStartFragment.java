package com.dariapro.traincounting.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.dariapro.traincounting.R;
import com.dariapro.traincounting.activity.ExampleStartActivity;

public class ExampleStartFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    public static final int REQUEST_EVENT = 1;
    public static final String MODE = "com.dariapro.traincounting.mode";

    private String modeValue;

    private SeekBar levelSeekBar;
    private SeekBar timeSeekBar;
    private Button start;
    private TextView levelSet;
    private TextView timeSet;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        modeValue = getArguments().getString(MODE);

        View view = inflater.inflate(R.layout.example_start_fragment, container,false);

        levelSeekBar = view.findViewById(R.id.level_slider);
        levelSeekBar.setMax(100);
        levelSeekBar.setProgress(50);
        levelSeekBar.setOnSeekBarChangeListener(this);

        timeSeekBar = view.findViewById(R.id.time_slider);
        timeSeekBar.setMax(100);
        timeSeekBar.setProgress(50);
        timeSeekBar.setOnSeekBarChangeListener(this);

        start = view.findViewById(R.id.start_randoms);

        final String sendMode = modeValue;
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ExampleStartActivity.newExampleIntent(getActivity());
                intent.putExtra(MODE, sendMode);
                startActivityForResult(intent, REQUEST_EVENT);
            }
        });

        levelSet = view.findViewById(R.id.level_set);
        timeSet = view.findViewById(R.id.time_set);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.main_fragment, menu);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {

            case R.id.level_slider:
                levelSet.setText("" + progress);
                break;

            case R.id.time_slider:
                timeSet.setText("" + progress + "Minutes");
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}