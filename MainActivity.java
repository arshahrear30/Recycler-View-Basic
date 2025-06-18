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

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // ListView এডাপ্টার খায় .. রিসাইকেল ভিউ তেমনি এডাপটার খায় কিন্তু এটা একটু অন্য ধরনের
        recyclerView =findViewById(R.id.recyclerView);

        Myadapter adapter=new Myadapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

//Main activity open
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

            holder.textView.setText("Item Position:"+position);

        }

        @Override
        public int getItemCount() {
            return 10; // loop কতবার চলবে return এ set করবো
        }



    }

//=----==========================
}
