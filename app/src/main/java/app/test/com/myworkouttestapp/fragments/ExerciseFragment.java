package app.test.com.myworkouttestapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import app.test.com.myworkouttestapp.R;
import app.test.com.myworkouttestapp.common.IntentHelper;
import app.test.com.myworkouttestapp.models.Exercise;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExerciseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExerciseFragment extends Fragment {
    private int exerciseNum;
    private TextView tvTitle;
    private ImageView imageView;
    private TextView tvDescription;

    public static ExerciseFragment newInstance(int exerciseNum) {
        ExerciseFragment fragment = new ExerciseFragment();
        Bundle args = new Bundle();
        args.putInt(IntentHelper.EXTRA_EXERCISE_NUM, exerciseNum);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTitle=view.findViewById(R.id.tvTitle);
        imageView=view.findViewById(R.id.imageView);
        tvDescription=view.findViewById(R.id.tvDescription);

        if(savedInstanceState!=null)
            setExerciseNum(savedInstanceState.getInt(IntentHelper.EXTRA_EXERCISE_NUM));
        else if(getArguments()!=null)
            setExerciseNum(getArguments().getInt(IntentHelper.EXTRA_EXERCISE_NUM));
    }

    public void setExerciseNum(int exerciseNum)
    {
        this.exerciseNum=exerciseNum;

        Exercise exercise=Exercise.allExercises[exerciseNum];
        tvTitle.setText(exercise.name);
        imageView.setImageResource(exercise.image);
        tvDescription.setText(exercise.description);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(IntentHelper.EXTRA_EXERCISE_NUM, exerciseNum);
        super.onSaveInstanceState(outState);
    }
}
