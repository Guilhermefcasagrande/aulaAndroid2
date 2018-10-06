package unidavi.edu.br.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class TaskDetailActivity extends AppCompatActivity {

    private Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        task = getIntent().getParcelableExtra("task");
        setTitle(task.getTitle());
    }
}
