package com.example.abbes.calendarviewtest.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abbes.calendarviewtest.R;
import com.example.abbes.calendarviewtest.entity.Task;

import org.w3c.dom.Text;

/**
 * Created by Abbes on 19/04/2016.
 */
public class ListTaskAdapter extends RecyclerView.Adapter<ListTaskAdapter.ViewHolder> {


    Task[] task;
    Context context;

    public ListTaskAdapter(Context context, Task[] task) {
        this.context = context;
        this.task = task;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.taskName.setText(task[position].getName());
        holder.time.setText(task[position].getTime());
        holder.duration.setText(task[position].getDuration());
        holder.adress.setText(task[position].getAddress());
        holder.image.setImageResource(task[position].getImage());
    }

    @Override
    public int getItemCount() {
        return task.length;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView taskName;
        TextView time;
        TextView duration;
        TextView adress;
        ImageView image ;

        public ViewHolder(View itemView) {
            super(itemView);

            taskName = (TextView) itemView.findViewById(R.id.taskName);
            time = (TextView) itemView.findViewById(R.id.time);
            duration = (TextView) itemView.findViewById(R.id.duration);
            adress = (TextView) itemView.findViewById(R.id.adr);
            image = (ImageView) itemView.findViewById(R.id.logoTask);
        }
    }
}
