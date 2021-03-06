package unidavi.edu.br.todolist;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private final OnTaskClickListener listener;
    private List<Task> tasks = new ArrayList<>();

    public TaskAdapter (OnTaskClickListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(inflater.inflate(
                android.R.layout.simple_list_item_2,
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Task task = tasks.get(i);
        viewHolder.title.setText(tasks.get(i).getTitle());
        viewHolder.data.setText(tasks.get(i).getData());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(task);
            }
        });
        if(task.isDone()){
            viewHolder.title.setTextColor(Color.RED);
        } else {
            viewHolder.title.setTextColor(Color.BLACK);
        }
    }


    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setUp(List<Task> tasks) {
        this.tasks.clear();
        this.tasks.addAll(tasks);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView data;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(android.R.id.text1);
            data = itemView.findViewById(android.R.id.text2);
        }
    }

    interface OnTaskClickListener{
        void onClick(Task task);
    }

}
