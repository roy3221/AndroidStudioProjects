package activity.lifecycle.android.vogella.com.lifecycleactivity;

import android.os.Bundle;

/**
 * Created by churong1 on 5/13/16.
 */
public class SecondActivity extends TracerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}