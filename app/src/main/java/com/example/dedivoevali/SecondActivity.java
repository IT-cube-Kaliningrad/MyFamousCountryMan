package com.example.dedivoevali;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {


    int images[] = {R.drawable.c123, R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground};
    String names[] = {"First person", "Second person", "Third name"};
    String desc[] = {"Sample Text", "Sample Text", "Sample Text"};
    List<ItemsModel> itemsList = new ArrayList<>();

    GridView gridView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        gridView = findViewById(R.id.gridView);


        for (int i = 0; i < names.length; i++) {

            ItemsModel itemsModel = new ItemsModel(names[i], desc[i], images[i]);
            itemsList.add(itemsModel);

        }
        customAdapter = new CustomAdapter(itemsList, this);
        gridView.setAdapter(customAdapter);
    }


        public class CustomAdapter extends BaseAdapter {
            private List<ItemsModel> itemsModelList;
            private List<ItemsModel> itemsModelListFiltered;
            private Context context;


    public CustomAdapter(List<ItemsModel> itemsModelList, Context context) {
        this.itemsModelList = itemsModelList;
        this.itemsModelListFiltered = itemsModelList;
        this.context = context;


    }

    @Override
    public int getCount() {
        return itemsModelListFiltered.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View view = getLayoutInflater().inflate(R.layout.row_items, null);
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView tvNames = view.findViewById(R.id.tvName);
        TextView tvDesc = view.findViewById(R.id.tvDesc);
        imageView.setImageResource(itemsModelListFiltered.get(position).getImage());
        tvNames.setText(itemsModelListFiltered.get(position).getName());
        tvDesc.setText(itemsModelListFiltered.get(position).getDesc());




        return view;
    }
}

}