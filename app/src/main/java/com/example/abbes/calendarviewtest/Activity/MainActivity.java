package com.example.abbes.calendarviewtest.Activity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.abbes.calendarviewtest.Adapter.ListTaskAdapter;
import com.example.abbes.calendarviewtest.R;
import com.example.abbes.calendarviewtest.entity.Task;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    CaldroidListener caldroidListener;
    CaldroidFragment caldroidFragment;
    Calendar currentSelected;
    Calendar calendar;
    Task[] tasks;
    private LinearLayoutManager mLayoutManager;
    RecyclerView listTask = null;
    ListTaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listTask = (RecyclerView) findViewById(R.id.listTask);
        caldroidFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        calendar = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, calendar.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, calendar.get(Calendar.YEAR));

        caldroidFragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.cal, caldroidFragment);
        fragmentTransaction.commit();

        listenerCalendar();

        caldroidFragment.setCaldroidListener(caldroidListener);
        ColorDrawable grey = new ColorDrawable(getResources().getColor(R.color.greyItem));
        caldroidFragment.setBackgroundDrawableForDate(grey, calendar.getTime());
        currentSelected = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        currentSelected.setTime(calendar.getTime());


    }

    private void setRecycleView() {

        listTask.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        listTask.setLayoutManager(mLayoutManager);
        Log.d("auto", tasks.length + "");
        adapter = new ListTaskAdapter(this, tasks);
        listTask.setAdapter(adapter);

    }

    private void listenerCalendar() {

        caldroidListener = new CaldroidListener() {
            @Override
            public void onSelectDate(Date date, View view) {
                Log.d("Date", date.toString());
                Log.d("Calendar", calendar.getTime().toString());
                Log.d("CurrentSelected", currentSelected.getTime().toString());

                if (currentSelected.getTime() == calendar.getTime()) {
                    Log.d("Test", "True");
                } else {
                    ColorDrawable white = new ColorDrawable(getResources().getColor(R.color.caldroid_white));
                    caldroidFragment.setBackgroundDrawableForDate(white, currentSelected.getTime());
                    Log.d("Test", "False");
                }
                currentSelected.setTime(date);
                ColorDrawable blue = new ColorDrawable(getResources().getColor(R.color.bleuItem));
                caldroidFragment.setBackgroundDrawableForDate(blue, date);
                ColorDrawable grey = new ColorDrawable(getResources().getColor(R.color.greyItem));
                caldroidFragment.setBackgroundDrawableForDate(grey, calendar.getTime());
                caldroidFragment.refreshView();


                //TODO getList Task
                tasks = new Task[5];
                tasks[0] = new Task("Running at Parc", "4:35", "35min", "parcours, tunis");
                tasks[1] = new Task("Running at Parc", "5:35", "35min", "parcours, tunis");
                tasks[2] = new Task("Running at Parc", "6:35", "25min", "parcours, tunis");
                tasks[3] = new Task("Running at Parc", "7:35", "1h", "parcours, tunis");
                tasks[4] = new Task("Running at Parc", "8:35", "35min", "parcours, tunis");
                setRecycleView();


            }


        };
    }


}
