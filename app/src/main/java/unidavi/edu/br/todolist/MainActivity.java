package unidavi.edu.br.todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TaskAdapter adapter = new TaskAdapter(new TaskAdapter.OnTaskClickListener() {
        @Override
        public void onClick(Task task) {
            Intent intent = new Intent(getApplicationContext(), TaskDetailActivity.class);
            intent.putExtra("id", task.getId());
            startActivity(intent);
        }
    });
//    private DatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        helper = new DatabaseHelper(this);

        RecyclerView tasklist = findViewById(R.id.task_list);
        tasklist.setLayoutManager(new LinearLayoutManager(this));
        tasklist.setAdapter(adapter);

        FloatingActionButton buttonCreate = findViewById(R.id.button_create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Quando clicar no botão de adicionar, joga pra outra tela
                startActivity(new Intent(getApplicationContext(), NewTaskActivity.class));
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        List<Task> tasks = TasksStore.getInstance(this).getTasksDao().fetcTasks();
        adapter.setUp(tasks);
    }
}
