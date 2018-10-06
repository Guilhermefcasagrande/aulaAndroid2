package unidavi.edu.br.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TaskDetailActivity extends AppCompatActivity {

    private Task task;
    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_detail);

        int id = getIntent().getIntExtra("id", 0);
        task = TasksStore.getInstance(this).getTasksDao().findById(id);
        setTitle(task.getTitle());

        //Exclui a tarefa
        Button buttonDelete = findViewById(R.id.button_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TasksStore.getInstance(getApplicationContext())
                        .getTasksDao()
                        .delete(task);
                finish();
            }
        });

        //Marca tarefa como concluída
        Button buttonDone = findViewById(R.id.button_done);
        buttonDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TasksStore.getInstance(getApplicationContext())
                        .getTasksDao()
                        .update(new Task(task.getId(), task.getTitle(), true));
                finish();
            }
        });
    }
}
