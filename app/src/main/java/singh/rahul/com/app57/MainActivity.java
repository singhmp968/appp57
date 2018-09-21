package singh.rahul.com.app57;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_MOVE = 1000;
    TextView txtName,txtEmail,txtUserName,txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.txtName);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        txtPassword = (TextView) findViewById(R.id.txtPassword);
        txtUserName = (TextView) findViewById(R.id.txtUserName);

        findViewById(R.id.btnMove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent,REQUEST_CODE_MOVE);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_MOVE && resultCode == RESULT_OK)
        {
            String name = data.getStringExtra(SecondActivity.REQUEST_TEXT_FEILD_NAME);
            String email = data.getStringExtra(SecondActivity.REQUEST_TEXT_FEILD_EMAIL);
            String userName = data.getStringExtra(SecondActivity.REQUEST_TEXT_FEILD_USER_NAME);
            String password = data.getStringExtra(SecondActivity.REQUEST_TEXT_FEILD_PASSWORD);

        txtName.setText(name);
        txtUserName.setText(email);
        txtEmail.setText(userName);
        txtPassword.setText(password);

        }
    }
}
