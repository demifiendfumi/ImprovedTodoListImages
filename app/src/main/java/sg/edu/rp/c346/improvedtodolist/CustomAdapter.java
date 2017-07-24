package sg.edu.rp.c346.improvedtodolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;

    ArrayList<ToDoItem> toDoList;
    Button btnRemove;


    public CustomAdapter(Context context, int resource,
                          ArrayList<ToDoItem> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        toDoList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(layout_id, parent, false);


        TextView tvTitle = (TextView) rowView.findViewById(R.id.textViewTitle);
        TextView tvDate = (TextView) rowView.findViewById(R.id.textViewDate);
        ImageView ivImpt = (ImageView) rowView.findViewById(R.id.imageViewImpt);


        ToDoItem currentItem = toDoList.get(position);


        tvTitle.setText(currentItem.getTitle());
        tvDate.setText(currentItem.getDateString());

        if(currentItem.isImportant() == true){
            ivImpt.setImageResource(R.drawable.impt);
        }
        else{
            ivImpt.setImageResource(R.drawable.todo);
        }

        btnRemove = (Button) rowView.findViewById(R.id. buttonRemove);


        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toDoList.clear();
            }
        });

        //return the View corresponding to the data at the specified position.
        return rowView;
    }
}
