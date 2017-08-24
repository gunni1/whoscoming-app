package fun.whoiscoming_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity
{

    private static final String USER_NAME = "fun.whoiscoming_app.USER_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view)
    {
        Intent intent = new Intent(this, HomeActivity.class);
        EditText editText = (EditText) findViewById(R.id.login_name_input);
        String userName = editText.getText().toString();
        intent.putExtra(USER_NAME,userName);
        startActivity(intent);
    }
}
