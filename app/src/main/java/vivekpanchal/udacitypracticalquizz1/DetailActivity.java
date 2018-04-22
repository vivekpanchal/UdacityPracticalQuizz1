package vivekpanchal.udacitypracticalquizz1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;


public class DetailActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView userName, userEmail, userAbout;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.app_name));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        userName = findViewById(R.id.usernamedetail);
        userEmail = findViewById(R.id.emaildetail);
        userAbout = findViewById(R.id.user_about);

        getDataFromSharedPreference();

    }

    private void getDataFromSharedPreference() {
        preferences = PreferenceManager.getDefaultSharedPreferences(DetailActivity.this);
        String name = preferences.getString("name", "Demo User");
        String email = preferences.getString("email", "demouser@demo.com");
        String about = preferences.getString("about", getResources().getString(R.string.info));

        userName.setText(name);
        userEmail.setText(email);
        userAbout.setText(about);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return false;
    }
}
