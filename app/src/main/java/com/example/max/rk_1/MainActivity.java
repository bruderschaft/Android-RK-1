package com.example.max.rk_1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class MainActivity extends ActionBarActivity {

    String[] names = { "Иван", "Марья", "Петр", "Антон", "Даша", "Борис",
            "Костя", "Игорь", "Анна", "Денис", "Андрей" };
    ArrayList<Technology> technologiesArrayList = new ArrayList<Technology>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String technologies = getIntent().getStringExtra("technologies");

        JSONObject techsObjects = new JSONObject();
        try {
            techsObjects = new JSONObject(technologies);
            Iterator<String> techsIter = techsObjects.getJSONObject("technology").keys();
            Technology newTechnology;
            JSONObject technology;
            String info;
            for(Iterator iterator = techsObjects.getJSONObject("technology").keys(); iterator.hasNext();) {
                technology = ((JSONObject)techsObjects.get((String) iterator.next()));
                info = null;
                try {
                    info = technology.getString("info");
                } catch (JSONException e){
                    e.printStackTrace();
                }
                if (info != null) {
                    technologiesArrayList.add(new Technology(technology.getString("title"), technology.getString("picture"), info));
                } else {

                    technologiesArrayList.add(new Technology(technology.getString("title"), technology.getString("picture")));
                }

            }
        } catch (JSONException e){
            e.printStackTrace();
        }

        ((TextView)findViewById(R.id.technologies)).setText(technologies);

        ListView listView = (ListView) findViewById(R.id.list_item);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, names);

        listView.setAdapter(adapter);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    class Technology {
        String title,
             picture,
             info;
        public Technology(String title, String picture, String info){
            this.title = title;
            this.picture = picture;
            this.info = info;
        }
        public Technology(String title, String picture){
            this.title = title;
            this.picture = picture;
        }
    }
}
