package j.mihir.martian.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Stack;

import j.mihir.martian.R;
//import j.mihir.martian.model.Page;
import j.mihir.martian.model.Page;
import j.mihir.martian.model.story;

public class StoryActivity extends AppCompatActivity {

    private String name;
    private story sty;
//    private story sty =new story();
    private ImageView storyimageview;
    private TextView storytextview;
    private Button choice1button;
    private Button choice2button;
    private Stack<Integer> pagestack =new Stack<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyimageview =(ImageView)findViewById(R.id.storyimageView);
        storytextview=(TextView) findViewById(R.id.storytextview);
        choice1button =(Button) findViewById(R.id.choice1button);
        choice2button =(Button) findViewById(R.id.choice2button);

        Intent intent =getIntent();
        name=intent.getStringExtra(getString(R.string.key_name));
        if (name==null||name.isEmpty()){
            name="friend";
            }
        sty = new story();
        loadPage(0);
    }

    private void loadPage(int pgnumber) {
        pagestack.push(pgnumber);
        final Page page=sty.getPage(pgnumber);

        Drawable image  =ContextCompat.getDrawable(this,page.getImageId());
        storyimageview.setImageDrawable(image);
        String pageText =getString(page.getTextId());
        pageText=String.format(pageText,name);
        storytextview.setText(pageText);

        if(page.isFinalPage()){
            choice1button.setVisibility(View.INVISIBLE);
            choice2button.setText(getString(R.string.plag_again));
            choice2button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    finish();
                        loadPage(0);
                }

            });

        }
        else {
            loadbuttons(page);
        }
    }

    private void loadbuttons(final Page page) {
        choice1button.setVisibility(View.VISIBLE);
        choice1button.setText(page.getChoice1().getTextId());
        choice1button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextpage = page.getChoice1().getNextPage();
                loadPage(nextpage);
            }
        });

        choice2button.setText(page.getChoice2().getTextId());
        choice2button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int nextpage = page.getChoice2().getNextPage();
                loadPage(nextpage);
            }
        });
    }

    @Override
    public void onBackPressed() {
        pagestack.pop();
        if(pagestack.isEmpty()) {
            super.onBackPressed();
        }
        else{
            loadPage(pagestack.pop());
        }
    }
}
