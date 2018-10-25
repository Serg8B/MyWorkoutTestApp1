package app.test.com.myworkouttestapp.models;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;

import app.test.com.myworkouttestapp.R;

public class Exercise {
    public @StringRes int name;
    public @StringRes int description;
    public @DrawableRes int image;

    private Exercise(int name, int description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public static final Exercise allExercises[]={
        new Exercise(R.string.exercise_1, R.string.exercise_1_description, R.drawable.ic_excercise1),
        new Exercise(R.string.exercise_2, R.string.exercise_2_description, R.drawable.ic_excercise2),
        new Exercise(R.string.exercise_3, R.string.exercise_3_description, R.drawable.ic_excercise3),
        new Exercise(R.string.exercise_4, R.string.exercise_4_description, R.drawable.ic_excercise4),
        new Exercise(R.string.exercise_5, R.string.exercise_5_description, R.drawable.ic_excercise5),
        new Exercise(R.string.exercise_6, R.string.exercise_6_description, R.drawable.ic_excercise6),
        new Exercise(R.string.exercise_7, R.string.exercise_7_description, R.drawable.ic_excercise7)
    };
}
