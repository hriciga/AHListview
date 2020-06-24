package hriciga.andrej.listview;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<DataItem> {

    Context context;
    int layoutResourceId;
    List<DataItem> data=null;

    public CustomAdapter(Context context, int resource, List<DataItem> objects) {
        super(context, resource, objects);

        this.layoutResourceId = resource;
        this.context= context;
        this.data=objects;
    }

    static class DataHolder
    {
        ImageView image;
        TextView title;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DataHolder holder =null;
        if(convertView==null)   {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId,parent,false);
            holder = new DataHolder();
            holder.image = convertView.findViewById(R.id.image);
            holder.title = convertView.findViewById(R.id.title);
            convertView.setTag(holder);
        }   else    {
         holder = (DataHolder)convertView.getTag();
        }

        DataItem dataItem = data.get(position);
        holder.title.setText(dataItem.title);
        holder.image.setImageResource(dataItem.resIdThumbnail);

        return  convertView;
    }
}
