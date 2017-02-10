package app.techieni3.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PdfListActivity extends ActionBarActivity {

    ListView listView;
    String[] pdf = {"1","2","3","4","5","6","7",};
    int [] image = {R.drawable.imagecompressed,R.drawable.asd,R.drawable.def,R.drawable.wer,

            R.drawable.imagecompressed,R.drawable.adf,R.drawable.def,};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_list);
/*
        listView = (ListView) findViewById(R.id.pdf_list);

        ArrayAdapter adapter= new ArrayAdapter(PdfListActivity.this,android.R.layout.simple_list_item_1,pdf);
*/
        listView = (ListView) findViewById(R.id.pdf_list);
        listView.setAdapter(new ListviewAdapter(PdfListActivity.this));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent i = new Intent(PdfListActivity.this,PdfActivity.class);
                i.putExtra("pdf",pdf[position]+".pdf");
                startActivity(i);

            }
        });

    }

    class ListviewAdapter extends BaseAdapter{

        Context c;

        public ListviewAdapter(PdfListActivity pdfListActivity) {

            this.c=pdfListActivity;

        }

        @Override
        public int getCount() {
            return pdf.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View v = inflater.inflate(R.layout.custom_list_layout,null);


            TextView text = (TextView) v.findViewById(R.id.listTextview);

            v.setBackgroundResource(image[position]);
            text.setText(pdf[position]);

            return v;
        }
    }

}
