package tw.com.hy123.mygithubtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Page2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        Log.v("chris","page2_onCreate");

        Intent g = getIntent();
        String t_Value = g.getStringExtra("name");
        Log.v("chris","page2_"+t_Value);
    }

    public void btnTest11(View view){
        Intent intent = new Intent();
        intent.putExtra("key1",789);
        intent.putExtra("key2","chris");
        setResult((int)(Math.random()*100),intent);

        finish();

    }

    @Override
    public void finish() {
        setResult(666);

        super.finish();
        Log.v("chris","page2_finish");
    }

}
