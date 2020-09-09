package ShowPet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tst.R;

import java.util.ArrayList;
import java.util.List;

import remote.animals.Animal;


public class ShowPetsAdapter extends RecyclerView.Adapter<ShowPetsAdapter.MyViewHolder> {
    List<Animal> mData=new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout;
        layout = LayoutInflater.from(mContext).inflate(R.layout.show_pets_item, parent, false);
        return new MyViewHolder(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.title.setText(mData.get(position).getAge());
        holder.description.setText(mData.get(position).getDescription());
        holder.date.setText(mData.get(position).getGender());


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    Context mContext;


    public ShowPetsAdapter(Context mContext, List<Animal> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, description, date;
//        ImageView petsimage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title);
            description = itemView.findViewById(R.id.tv_description);
            date = itemView.findViewById(R.id.tv_date);
//            petsimage = itemView.findViewById(R.id.img_recycler);
        }
    }
}
