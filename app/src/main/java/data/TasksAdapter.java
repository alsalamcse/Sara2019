package data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sarataskmng.R;

public class TasksAdapter extends ArrayAdapter <MyTask>{
    public TasksAdapter(@NonNull Context context) {
        super(context, R.layout.taskitem);
    }

    /**
     *
     * @param position his number
     * @param convertView the item
     * @param parent
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //building item view
        View vitem=LayoutInflater.from(getContext()).inflate(R.layout.taskitem,parent,false);
        TextView tvTitle=vitem.findViewById(R.id.itmTvTitle);
        TextView tvSubject=vitem.findViewById(R.id.itmTvSubject);
        RatingBar rbPrio=vitem.findViewById(R.id.itmRatingPrio);
        CheckBox cbIsCompleted =vitem.findViewById(R.id.itmChbxlsCompleted);
       ImageView ivInfo =vitem.findViewById(R.id.imageView2);

        //getting data source
        MyTask myTask = getItem(position);

        // todo טיפול באירוע מחיקה
        cbIsCompleted.setOnCheckedChangeListener(new);

        //connect item view to data source
        tvTitle.setText(myTask.getTitle());
        tvSubject.setText(myTask.getSubject());
        rbPrio.setRating(myTask.getImportant());
        cbIsCompleted.setChecked(false);

        return vitem;



    }
}
