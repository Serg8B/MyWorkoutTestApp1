package app.test.com.myworkouttestapp.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.math.MathUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

import app.test.com.myworkouttestapp.R;

public class StopWatchFragment extends Fragment {
    private TextView tvCounter;
    private long seconds=0;
    private boolean running=false;
    private static final int DELAY = 1000;
    private final Handler handler = new Handler();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stopwatch, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvCounter=view.findViewById(R.id.tvCounter);
        if(savedInstanceState!=null)
        {
            seconds=savedInstanceState.getLong("seconds");
            running=savedInstanceState.getBoolean("running");
        }
        view.findViewById(R.id.bReset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seconds=0;
                updateCounter();
            }
        });
        view.findViewById(R.id.bPause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false;
                handler.removeCallbacksAndMessages(null);
            }
        });
        view.findViewById(R.id.bStart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!running)
                {
                    runTimer();
                    running = true;
                }
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("running", running);
        outState.putLong("seconds", seconds);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onStop() {
        handler.removeCallbacksAndMessages(null);
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(running) runTimer();
    }

    private void runTimer() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                updateCounter();
                ++seconds;
                handler.postDelayed(this, DELAY);
            }
        });

    }

    private void updateCounter()
    {
        long hours = TimeUnit.SECONDS.toHours(seconds);
        long minutes = TimeUnit.SECONDS.toMinutes(seconds-TimeUnit.HOURS.toSeconds(hours));
        long secs = seconds%60;
        String time = String.format(Locale.getDefault(),"%d:%02d:%02d", hours, minutes, secs);
        tvCounter.setText(time);
    }
}
