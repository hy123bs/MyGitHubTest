package tw.com.hy123.mygithubtest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Page3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
    }


    @Override
    public void finish() {

        setResult(777);
        super.finish();
    }
}
