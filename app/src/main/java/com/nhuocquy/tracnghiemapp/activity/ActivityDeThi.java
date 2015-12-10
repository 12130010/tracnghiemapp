package com.nhuocquy.tracnghiemapp.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.nhuocquy.tracnghiemapp.R;
import com.nhuocquy.tracnghiemapp.adapter.GVAdapterDapAn;
import com.nhuocquy.tracnghiemapp.model.DapAn;

public class ActivityDeThi extends AppCompatActivity {
    private DapAn[] mThumbIds = {
            new DapAn(1,0,"Lỗi khi chay ","",true,true ),
            new DapAn(1,1,"Lỗi biên dịch dòng 3 ","",true,true),
            new DapAn(1,2,"Lỗi biên dịch dòng 5 ","",true,true),
            new DapAn(1,3,"Kết quả là: 5  ","",true,true)};
//    RadioGroup radioGroup1;
    GVAdapterDapAn gridViewAdapter;
    GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_de_thi2);

//        radioGroup1.a;
        gridView = (GridView) findViewById(R.id.gvCauhoi);

        gridViewAdapter = new GVAdapterDapAn(this, mThumbIds);
        gridView.setAdapter(gridViewAdapter);
        getListViewSize(gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ImageView imageView = (ImageView) view.findViewById(R.id.imvHinhDapAn);

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_de_thi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.item3:
                Intent intent = new Intent(this, ActivityKetQua.class);
                startActivity(intent);

                return true;
            case R.id.item2:
//                showHelp();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    public static void getListViewSize(GridView myListView) {
        GVAdapterDapAn myListAdapter = (GVAdapterDapAn) myListView.getAdapter();
        if (myListAdapter == null) {
            //do nothing return null
            return;
        }
        //set listAdapter in loop for getting final size
        int totalHeight = 0;
        for (int size = 0; size < myListAdapter.getCount()/2 + (myListAdapter.getCount()%2 ==0 ? 0: 1); size++) {
            View listItem = myListAdapter.getView(size, null, myListView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        //setting listview item in adapter
        ViewGroup.LayoutParams params = myListView.getLayoutParams();
        params.height = totalHeight ;
        myListView.setLayoutParams(params);
        // print height of adapter on log
//        Log.i("height of listItem:", String.valueOf(totalHeight));
    }


}
