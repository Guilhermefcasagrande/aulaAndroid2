package unidavi.edu.br.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTaskActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);


        Button buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText inputNewTask = findViewById(R.id.input_new_task);
                String value = inputNewTask.getText().toString();

                String pattern = "dd/MM/yyyy, hh:mm";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String data = simpleDateFormat.format(new Date());

                if(!value.isEmpty()){
                    TasksStore.getInstance(getApplicationContext())
                            .getTasksDao().insert(new Task(value, false, data));
                    finish();
                }
            }
        });
    }
}
