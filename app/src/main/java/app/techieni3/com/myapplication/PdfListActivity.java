package app.techieni3.com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PdfListActivity extends ActionBarActivity {

    ListView listView;
    String[] pdf = {"1.pdf","2.pdf","3.pdf","4.pdf","5.pdf","6.pdf","7.pdf",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_list);

        listView = (ListView) findViewById(R.id.pdf_list);

        ArrayAdapter adapter= new ArrayAdapter(PdfListActivity.this,android.R.layout.simple_list_item_1,pdf);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(PdfListActivity.this,PdfActivity.class);
                i.putExtra("pdf",pdf[position]);
                startActivity(i);

            }
        });

    }
}
