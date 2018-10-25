package app.test.com.myworkouttestapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.test.com.myworkouttestapp.R;
import app.test.com.myworkouttestapp.models.Exercise;

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {
    private Exercise mData[];
    private OnExerciseClickListener onExerciseClickListener;

    public ExerciseAdapter(Exercise[] mData, OnExerciseClickListener onExerciseClickListener) {
        super();
        this.mData = mData;
        this.onExerciseClickListener = onExerciseClickListener;
    }
    @NonNull
    @Override
    public ExerciseAdapter.ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final ExerciseViewHolder viewHolder=new ExerciseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exercise, parent, false));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onExerciseClickListener.onExerciseClick(viewHolder.getAdapterPosition());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseAdapter.ExerciseViewHolder holder, int position) {
        holder.tvTitle.setText(mData[position].name);
    }

    @Override
    public int getItemCount() {
        return mData.length;
    }

    static class ExerciseViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvTitle;
        public ExerciseViewHolder(View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.tvTitle);
        }
    }
    public interface OnExerciseClickListener
    {
        void onExerciseClick(int exercisePos);
    }
}
