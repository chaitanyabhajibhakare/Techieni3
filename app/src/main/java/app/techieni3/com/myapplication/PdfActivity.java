package app.techieni3.com.myapplication;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;

import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends ActionBarActivity {


    Button next, previous;
    int pageCount = 0;

    PDFView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);

        view = (PDFView) findViewById(R.id.pdfView);

        next = (Button) findViewById(R.id.next);
        previous = (Button) findViewById(R.id.previous);

        readPdf();

    }

    private void readPdf() {

        view .fromAsset(getIntent().getStringExtra("pdf"))
                // all pages are displayed by default
                .enableSwipe(true)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .load();
    }


}
