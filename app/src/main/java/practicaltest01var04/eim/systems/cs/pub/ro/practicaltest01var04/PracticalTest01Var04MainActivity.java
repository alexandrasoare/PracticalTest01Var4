package practicaltest01var04.eim.systems.cs.pub.ro.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {
    private Button topLeftButton;
    private Button topRightButton;
    private Button centerButton;
    private Button bottomLeftButton;
    private Button bottomRigntButton;
    private Button navigateButton;

    private TextView textView;
    private TextView textViewNumber;

    private int totalClicks = 0;

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        topLeftButton = (Button) findViewById(R.id.top_left);
        topRightButton = (Button) findViewById(R.id.top_right);
        centerButton = (Button) findViewById(R.id.center);
        bottomLeftButton = (Button) findViewById(R.id.bottom_left);
        bottomRigntButton = (Button) findViewById(R.id.bottom_right);
        navigateButton = (Button) findViewById(R.id.navigate_button);

        textView = (TextView) findViewById(R.id.text_view);
        textViewNumber = (TextView) findViewById(R.id.text_view_number);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("totalClicks"))
                textViewNumber.setText(savedInstanceState.getString("totalClicks"));
            else
                textViewNumber.setText(String.valueOf(totalClicks));
        }

        topLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals(""))
                    textView.append("Top Left");
                else
                    textView.append(", Top Left");
                totalClicks++;
                textViewNumber.setText(String.valueOf(totalClicks));
            }
        });

        topRightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals(""))
                    textView.append("Top Right");
                else
                    textView.append(", Top Right");
                totalClicks++;
                textViewNumber.setText(String.valueOf(totalClicks));
            }
        });

        centerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals(""))
                    textView.append("Center");
                else
                    textView.append(", Center");
                totalClicks++;
                textViewNumber.setText(String.valueOf(totalClicks));
            }
        });

        bottomLeftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals(""))
                    textView.append("Bottom Left");
                else
                    textView.append(", Bottom Left");
                totalClicks++;
                textViewNumber.setText(String.valueOf(totalClicks));
            }
        });

        bottomRigntButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textView.getText().equals(""))
                    textView.append("Bottom right");
                else
                    textView.append(", Bottom Right");
                totalClicks++;
                textViewNumber.setText(String.valueOf(totalClicks));
            }
        });

        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PracticalTest01Var04MainActivity.this, PracticalTest01Var04SecondaryActivity.class);
                intent.putExtra("text", textView.getText().toString());
                startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("totalClicks", String.valueOf(totalClicks));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("totalClicks")) {
            textViewNumber.setText(savedInstanceState.getString("totalClicks"));
        } else {
            textViewNumber.setText(String.valueOf(totalClicks));
        }
        Toast.makeText(this, textViewNumber.getText().toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "Result : " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}
