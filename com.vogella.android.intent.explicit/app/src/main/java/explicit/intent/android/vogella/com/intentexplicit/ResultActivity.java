package explicit.intent.android.vogella.com.intentexplicit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by churong1 on 5/12/16.
 */
public class ResultActivity extends Activity {
    EditText editText;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_result);
        TextView textView = (TextView)findViewById(R.id.displayintentextra);
        editText = (EditText) findViewById(R.id.returnValue);
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            String text = extras.getString("input");
            Log.i("getInput",text);
            textView.setText(text);
        }
    }

    public void finish() {

        // TODO 1 create new Intent
        // Intent intent = new Intent();
        Intent returnData = new Intent();
        returnData.putExtra("return", editText.getText().toString());
        setResult(10, returnData);
        // TODO 2 read the data of the EditText field
        // with the id returnValue

        // TODO 3 put the text from EditText
        // as String extra into the intent
        // use editText.getText().toString();

        // TODO 4 use setResult(RESULT_OK, intent);
        // to return the Intent to the application

        super.finish();
    }
}
