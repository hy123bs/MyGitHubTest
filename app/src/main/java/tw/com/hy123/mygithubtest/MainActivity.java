package tw.com.hy123.mygithubtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btntest1;
    private MyView myView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myView = findViewById(R.id.myview);
        btntest1 = findViewById(R.id.btnTest1);

        btntest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this,Page3Activity.class);
                a.putExtra("name","junp page3");
                startActivityForResult(a,333);
            }
        });
    }

    public void Test2(View view) {
        Intent aa = new Intent(this,Page2Activity.class);
        aa.putExtra("name","jump page2");
//        startActivity(aa);
        startActivityForResult(aa,222);
    }

    public  void Test3(View view){
        myView.clear();
    }

    public void Test4(View view){
        myView.undo();
    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int a = requestCode;
        int b = resultCode;
        Log.v("chris","onActivityResult_requestCode:" + a);
        Log.v("chris","onActivityResult_resultCode:" + b);

        if(requestCode == 229) {
            int aa = data.getIntExtra("key1", -1);
            String bb = data.getStringExtra("key2");
            Log.v("chris", aa + ":" + bb);
        }


    }

}
