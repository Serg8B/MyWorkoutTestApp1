package app.test.com.myworkouttestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import app.test.com.myworkouttestapp.adapters.ExerciseAdapter;
import app.test.com.myworkouttestapp.common.IntentHelper;
import app.test.com.myworkouttestapp.fragments.ExerciseFragment;
import app.test.com.myworkouttestapp.models.Exercise;

public class MainActivity extends AppCompatActivity {
    private boolean twoPane=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twoPane=findViewById(R.id.frExercise)!=null;

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new ExerciseAdapter(Exercise.allExercises, new ExerciseAdapter.OnExerciseClickListener() {
            @Override
            public void onExerciseClick(int exercisePos) {
                if(twoPane)
                {
                    showDetailFragment(exercisePos);
                }
                else
                {
                    startActivity(new Intent(MainActivity.this, DetailActivity.class)
                            .putExtra(IntentHelper.EXTRA_EXERCISE_NUM, exercisePos));
                }
            }
        }));

        if(twoPane&&savedInstanceState==null)
            showDetailFragment(0);
    }

    private void showDetailFragment(int exerciseNum)
    {
        ExerciseFragment exerciseFragment=(ExerciseFragment)getSupportFragmentManager().findFragmentById(R.id.frExercise);
        exerciseFragment.setExerciseNum(exerciseNum);
    }
}
