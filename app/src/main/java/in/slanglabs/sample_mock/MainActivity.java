package in.slanglabs.sample_mock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import in.slanglabs.platform.SlangBuddy;

/**
 * An example activity that shows the Slang trigger
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        SlangBuddy.getBuiltinUI().show(this);
    }
}
