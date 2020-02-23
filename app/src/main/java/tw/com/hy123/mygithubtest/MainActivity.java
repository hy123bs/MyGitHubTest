package tw.com.hy123.mygithubtest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btntest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btntest = findViewById(R.id.btnTest);


        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i("aaa","bbb");



            }
        });





    }
}
