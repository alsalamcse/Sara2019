package data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sarataskmng.R;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

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
        final MyTask myTask = getItem(position);

        // todo טיפול באירוע מחיקה
        //albaremtrat ale btlkaha m03alg al hadath bt3alg al hdth
        cbIsCompleted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    //todo delete this item
                    FirebaseUtils.getReference().child(myTask.getKey()).removeValue(new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            if(databaseError==null)
                            {

                                Toast.makeText(getContext(), "deleted", Toast.LENGTH_SHORT).show();

                            }
                            else {
                                Toast.makeText(getContext(), "not deleted"+databaseError.getMessage(), Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                }

            }
        });

        //connect item view to data source
        tvTitle.setText(myTask.getTitle());
        tvSubject.setText(myTask.getSubject());
        rbPrio.setRating(myTask.getImportant());
        cbIsCompleted.setChecked(false);

        return vitem;



    }
}
