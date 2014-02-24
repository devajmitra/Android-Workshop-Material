package com.inorexstudio.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ListView listView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        
        // Defined Array values to show in ListView
        String[] values = new String[] { "Eddard Stark ", 
                                         "Catelyn Stark",
                                         "Sansa Stark",
                                         "Arya Stark", 
                                         "Robb Stark", 
                                         "Bran Stark",
                                         "Rickon Stark",
                                         "Tyrion Lannister", 
                                         "Cersei Lannister",
                                         "Joffrey Baratheon",
                                         "Daenerys Targaryen",
                                         "Stannis Baratheon",
                                         "Robert Baratheon",
                                         "Khal Drogo"
                                        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        listView.setAdapter(adapter); 
        
        // ListView Item Click Listener
        listView.setOnItemClickListener(new OnItemClickListener() {

              @Override
              public void onItemClick(AdapterView<?> parent, View view,
                 int position, long id) {
                
               // ListView Clicked item index
               int itemPosition     = position;
               
               // ListView Clicked item value
               String  itemValue    = (String) listView.getItemAtPosition(position);
                  
                // Show Alert 
                Toast.makeText(getApplicationContext(),
                  "Position :"+itemPosition+"  ListItem : " +itemValue , Toast.LENGTH_LONG)
                  .show();
             
              }

         }); 
    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
