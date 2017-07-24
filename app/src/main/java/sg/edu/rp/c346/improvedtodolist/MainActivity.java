package sg.edu.rp.c346.improvedtodolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

        ListView lvToDo;
        ArrayList<ToDoItem> toDoList;
        CustomAdapter caToDo;
        Button btnRemove;
        Button btnAdd;
        EditText etTitle;
        RadioButton rBtnImpt;
        RadioButton rBtnToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRemove = (Button) findViewById(R.id. buttonRemove);
        btnAdd = (Button) findViewById(R.id. buttonAdd);
        etTitle = (EditText) findViewById(R.id. editTextName);
        rBtnImpt = (RadioButton) findViewById(R.id. radioButtonImpt);
        rBtnToDo = (RadioButton) findViewById(R.id. radioButtonToDo);

        lvToDo = (ListView)findViewById(R.id.listViewToDo);
        toDoList = new ArrayList<ToDoItem>();

        caToDo = new CustomAdapter(this, R.layout.todoitem_row, toDoList);
        lvToDo.setAdapter(caToDo);

        Calendar d1 = Calendar.getInstance();
        ToDoItem item1 = new ToDoItem("MSA",d1,true);

        Calendar d2 = Calendar.getInstance();
        d2.set(2016,9,20);
        ToDoItem item2 = new ToDoItem("Go for haircut",d2,false);
        toDoList.add(item2);

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toDoList.clear();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = etTitle.getText().toString();
                Calendar dAdd = Calendar.getInstance();
                dAdd.set(dAdd.get(Calendar.YEAR), dAdd.get(Calendar.MONTH),dAdd.get(Calendar.DATE));
                if(rBtnImpt.isChecked()){
                    ToDoItem item = new ToDoItem(title ,dAdd,true);
                    toDoList.add(item);
                }
                else if(rBtnToDo.isChecked()){
                    ToDoItem item = new ToDoItem(title ,dAdd,false);
                    toDoList.add(item);
                }
                else{
                    ToDoItem item = new ToDoItem(title ,dAdd,false);
                    toDoList.add(item);
                }

            }
        });
    }
}
