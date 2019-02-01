package j.mihir.martian.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import j.mihir.martian.R;

public class MainActivity extends AppCompatActivity {
    private EditText nameField;
    private Button StartButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameField =(EditText) findViewById(R.id.nameEditText);
        StartButton =(Button) findViewById(R.id.StartButton);

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= nameField.getText().toString();
                startStory(name);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        nameField.setText("");
    }

    private void startStory(String name) {
        Intent intent =new Intent(this,StoryActivity.class);
        Resources res=getResources();
        String key=res.getString(R.string.key_name);
        intent.putExtra(key,name);
        startActivity(intent);
    }
}
