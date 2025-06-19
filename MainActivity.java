package com.example.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HashMap<String,String>hashMap;
    ArrayList<HashMap<String,String>>arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // ListView এডাপ্টার খায় .. রিসাইকেল ভিউ তেমনি এডাপটার খায় কিন্তু এটা একটু অন্য ধরনের
        recyclerView =findViewById(R.id.recyclerView);

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("video_id", "tL5eNq2k78E");
        hashMap.put("title", "Nasheed - Нашид (Sabeelu dummu)");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id", "9s-M8p3aUwI");
        hashMap.put("title", "Нашид - Ахи Анта Хуррун | Ahi Anta Hurrun slowed-reverb");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id", "1ZAPyPq4T6w");
        hashMap.put("title", "Video 3");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("video_id", "VbqIkqKo0QU");
        hashMap.put("title", "This is video 4");
        arrayList.add(hashMap);

        Myadapter adapter=new Myadapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    //--------------------------------------------------------end oncreate
    //Adapter create //view holder way
    //view holder create
    // step 1 : myViewHolder a mouse click kore red bulb a click then "Create constructor matching super
    private class Myadapter extends RecyclerView.Adapter <Myadapter.myViewHolder> {

        //step 2 : <> set : Myadapter হল myViewHolder এর help নিয়ে তার নিজের life cycle নিয়ন্তন করবে
        //step 3 : Myadapter এর red bulb এ click করবো implement methods >> ok >>
        private class myViewHolder extends RecyclerView.ViewHolder{

            ImageView imageView;
            TextView textView;
            public myViewHolder(@NonNull View itemView) {
                super(itemView); /////----/////

                imageView=itemView.findViewById(R.id.imageView);
                textView=itemView.findViewById(R.id.textView);

            }
        }
//---------------------------------------implement hoicay
        @NonNull
        @Override
        public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            // সবার আগে onCreateViewHolder কাজ করে

            LayoutInflater inflater = getLayoutInflater();
            View myView = inflater.inflate(R.layout.recycle_item,parent,false);

            return new myViewHolder(myView); //myview টা myViewHolder দিয়ে pass  হয়ে itemView এর মধ্যে ঢুকবে /////-----////
        }

        @Override
        public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
            //data input এর জন্য onBindViewHolder use করবো

            hashMap = arrayList.get(position);
            String title = hashMap.get("title");
            String video_id = hashMap.get("video_id");
            String imageUrl = "https://img.youtube.com/vi/"+video_id+"/0.jpg";

            holder.textView.setText(title);

        }

        @Override
        public int getItemCount() {
            return arrayList.size(); // loop কতবার চলবে return এ set করবো
        }



    }

//=----==========================
}
