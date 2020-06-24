package hriciga.andrej.listview;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        importExtras();
    }

    private void importExtras() {
        TextView textView = findViewById(R.id.text);
        textView.setText(getIntent().getStringExtra("text"));
        String title = getIntent().getStringExtra("title");
        setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_menu, menu);
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

