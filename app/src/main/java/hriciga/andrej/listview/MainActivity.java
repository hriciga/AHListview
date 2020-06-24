package hriciga.andrej.listview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<DataItem> lstData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstData = new ArrayList<>();
        String[] titles  = getResources().getStringArray(R.array.title_array);
        String[] texts  = getResources().getStringArray(R.array.text_array);
        String[] imageArray  = getResources().getStringArray(R.array.image_array);

        for(int i = 0; i < titles.length; i++) {
            // for image resources it is necessary to convert string to int resource
            String imageId = imageArray[i];
            int id = getResources().getIdentifier(imageId, "drawable", getPackageName());
            // then you can populate the array
            lstData.add(new DataItem((id),(titles[i]), (texts[i])));
        }

        ListView listView = findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this,R.layout.itemrow,lstData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent();
                intent.putExtra("title", lstData.get(position).title);
                intent.putExtra("image", lstData.get(position).resIdThumbnail);
                intent.putExtra("text", lstData.get(position).text);

                intent.setClass(MainActivity.this, DetailActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.moreapps:
                Intent moreapps = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/hriciga"));
                startActivity(moreapps);
                return true;
            // other cases were removed for github as not necessary for learning purposes
        }
        return super.onOptionsItemSelected(item);
    }


}
