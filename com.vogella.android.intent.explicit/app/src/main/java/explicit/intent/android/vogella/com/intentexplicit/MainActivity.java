package explicit.intent.android.vogella.com.intentexplicit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.startintent:
                EditText text = (EditText) findViewById(R.id.inputforintent);
                // used later
                String value = text.getText().toString();
                Log.i("inputString",value);
                Intent intent = new Intent(this,ResultActivity.class);
                intent.putExtra("input", value);
                startActivityForResult(intent, 11);
                break;
            case R.id.URLintent: // a test to call an system intent.
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vogella.com"));
                startActivity(intent);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 10 && requestCode == 11) {
            if (data.hasExtra("return")) {
                String result = data.getExtras().getString("return");
                if (result != null && result.length() > 0) {
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
