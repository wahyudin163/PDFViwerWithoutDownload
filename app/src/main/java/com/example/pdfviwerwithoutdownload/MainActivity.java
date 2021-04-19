package com.example.pdfviwerwithoutdownload;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public static List<PDFModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RV);

        list = new ArrayList<>();
        list.add(new PDFModel("Buku 1","https://sman3simpanghilir.sch.id/download/file/XI_Matematika_Peminatan_KD_3_1_Persamaan_Trigonometri.pdf"));
        list.add(new PDFModel("Buku 2", "http://enos.itcollege.ee/~jpoial/allalaadimised/reading/Android-Programming-Cookbook.pdf"));
        list.add(new PDFModel("Buku 3","https://www.w3.org/WAI/ER/tests/xhtml/testfiles/resources/pdf/dummy.pdf"));
        list.add(new PDFModel("Buku 4","http://www.africau.edu/images/default/sample.pdf"));
        list.add(new PDFModel("Buku 5","http://www.pdf995.com/samples/pdf.pdf"));
        list.add(new PDFModel("Buku 6","https://www.cs.cmu.edu/afs/cs.cmu.edu/user/gchen/www/download/java/LearnJava.pdf"));
        list.add(new PDFModel("Buku 7","https://www.cs.cmu.edu/afs/cs.cmu.edu/user/gchen/www/download/java/LearnJava.pdf"));

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(MainActivity.this,PDFActivity.class);
                //intent.putExtra("url",list.get(position).getPdfUrl());
                intent.putExtra("position",position);
                startActivity(intent);
            }
        };

        PDFAdapter adapter = new PDFAdapter(list,this,itemClickListener);
        recyclerView.setAdapter(adapter);
    }
}
