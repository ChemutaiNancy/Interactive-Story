package com.chemutai.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chemutai.interactivestory.R;
import com.chemutai.interactivestory.model.Choice;
import com.chemutai.interactivestory.model.Page;
import com.chemutai.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {

//    private Page[] mPages;
        private Story mStory = new Story();
        private ImageView mImageView;
        private TextView mTextView;
        private Button mChoice1;
        private Button mChoice2;
        private String mName;
        private Page mCurrentPage;


    public static final String TAG = StoryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        String mName = intent.getStringExtra(getString(R.string.key_name));

        if (mName == null){
            mName = "Friend";
        }
        Log.d(TAG, mName);

        mImageView = (ImageView) findViewById(R.id.imgStory);
        mTextView = (TextView) findViewById(R.id.txtStory);
        mChoice1 = (Button) findViewById(R.id.btnChoice1);
        mChoice2 = (Button) findViewById(R.id.btnChoice2);

        loadPage(0);

//        mPages = new Page[7];
    }

    private void loadPage(int choice){
        mCurrentPage = mStory.getPage(choice);

        Drawable drawable = getResources().getDrawable(mCurrentPage.getmImageId());
        mImageView.setImageDrawable(drawable);//calling an image

        String pageText = mCurrentPage.getText();

        pageText = String.format(pageText, mName);
        mTextView.setText(mCurrentPage.getText());

        if (mCurrentPage.isFinal()){
            mChoice1.setVisibility(View.INVISIBLE);
            mChoice2.setText("Play Again");
            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
        else
        {
            mChoice1.setText(mCurrentPage.getChoice1().getText());
            mChoice2.setText(mCurrentPage.getChoice2().getText());

            mChoice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = mCurrentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            mChoice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = mCurrentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        }


    }
}
