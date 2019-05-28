package in.slanglabs.sample_mock;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.slanglabs.platform.SlangBuddy;

/**
 * An example activity that shows the Slang trigger
 */
public class MainActivity extends AppCompatActivity implements CustomUIProvider.TextListener  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getStartButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomUIProvider.getInstance().getUIDelegate().notifyUserStartedSession();
            }
        });

        getStopButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomUIProvider.getInstance().getUIDelegate().notifyUserCanceled();
            }
        });

        CustomUIProvider.getInstance().setTextListener(this);
    }

    @Override
    protected  void onDestroy() {
        CustomUIProvider.getInstance().setTextListener(null);
        getStopButton().setOnClickListener(null);
        getStartButton().setOnClickListener(null);
        super.onDestroy();
    }

    @Override
    public void onSlangTextAvailable(String text) {
        getTextView().setText(text);
    }

    @Override
    public void onUserTextAvailable(String text) {
        getTextView().setText(text);
    }

    private View getStartButton() {
        return findViewById(R.id.start_listening);
    }

    private View getStopButton() {
        return findViewById(R.id.stop_listening);
    }

    private TextView getTextView() {
        return findViewById(R.id.text);
    }
}
