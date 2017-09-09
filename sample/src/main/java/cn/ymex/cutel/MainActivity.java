package cn.ymex.cutel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;

import cn.ymex.log.L;
import cn.ymex.log.SimplePrinter;
import cn.ymex.cutel.model.Data;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById(R.id.btn_base).setOnClickListener(this);
        findViewById(R.id.btn_ob).setOnClickListener(this);
        findViewById(R.id.btn_null).setOnClickListener(this);
        findViewById(R.id.btn_list).setOnClickListener(this);
        findViewById(R.id.btn_map).setOnClickListener(this);
        findViewById(R.id.btn_array).setOnClickListener(this);
        findViewById(R.id.btn_json).setOnClickListener(this);
        findViewById(R.id.btn_thread).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_base://base type
                L.i(1);
                L.d(2.0);
                L.e(false);
                L.w("this is String type!");
                break;
            case R.id.btn_ob://object type
                L.d("tag", Data.object());
                break;
            case R.id.btn_null:// object is null
                L.d(new Object());
                break;
            case R.id.btn_list: // list type
                L.d(Data.list());
                break;
            case R.id.btn_map://map type
                L.w(Data.map());
                break;
            case R.id.btn_array://array type

                L.e(Data.array());
                break;
            case R.id.btn_json://json data:
                String json = new Gson().toJson(Data.array());
                L.tag("abc").logD(json, json, json);//多参数

                L.tag("abc").logD(1, 2, 3, 4, 5, 6);

                L.d("def", json);
                break;
            case R.id.btn_thread:

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String tson = new Gson().toJson(Data.array());
                        L.i(tson);
                        callBack.runlog();
                    }
                }).start();
                break;
        }
    }


    private CallBack callBack = new CallBack() {
        @Override
        public void runlog() {
            String tson = new Gson().toJson(Data.array());
            L.i(tson);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String tson = new Gson().toJson(Data.array());
                    L.i(tson);
                }
            }).start();
        }
    };

    private interface CallBack {
        void runlog();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
