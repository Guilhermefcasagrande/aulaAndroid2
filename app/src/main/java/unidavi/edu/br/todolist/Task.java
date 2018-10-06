package unidavi.edu.br.todolist;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tasks")
public class Task {

    @PrimaryKey(autoGenerate = true)
    private final Integer id;

    private final String title;
    private final boolean done;

    private final String data;


    @Ignore
    public Task(String title, boolean done, String data) {
        this.id = null;
        this.title = title;
        this.done = done;
        this.data = data;
    }

    public Task(Integer id, String title, boolean done, String data) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.data = data;
    }


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }

    public String getData() {
        return data;
    }
}
