package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
{
    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mFirstButton;
    Button mSecondButton;
    TextView mStory;
    int mStoryIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mFirstButton = (Button) findViewById(R.id.buttonTop);
        mSecondButton = (Button) findViewById(R.id.buttonBottom);
        mStory = (TextView) findViewById(R.id.storyTextView);

        final String story[] = {getString(R.string.T1_Story), getString(R.string.T2_Story),
                getString(R.string.T3_Story), getString(R.string.T4_End),
                getString(R.string.T5_End), getString(R.string.T6_End)};

        final String optionsTop[] = {getString(R.string.T1_Ans1), getString(R.string.T2_Ans1),
                getString(R.string.T3_Ans1)};

        final String optionsBottom[] = {getString(R.string.T1_Ans2), getString(R.string.T2_Ans2),
                getString(R.string.T3_Ans2)};

        mStory.setText(story[mStoryIndex]);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mFirstButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(mStory.getText().equals(story[0]))
                {
                    mStory.setText(story[2]);
                    mFirstButton.setText(R.string.T3_Ans1);
                    mSecondButton.setText(R.string.T3_Ans2);
                    mStoryIndex++;
                }
                else if(mStory.getText().equals(story[1]))
                {
                    mStory.setText(story[2]);
                    mFirstButton.setText(R.string.T3_Ans1);
                    mSecondButton.setText(R.string.T3_Ans2);
                    mStoryIndex++;
                }
                else if(mStory.getText().equals(story[2]))
                {
                    mStory.setText(story[5]);
                    mStoryIndex++;
                }

                if(mStoryIndex >= 3 || mStory.getText().equals(story[5])
                        || mStory.getText().equals(story[4]))
                {
                    mFirstButton.setVisibility(View.GONE);
                    mSecondButton.setVisibility(View.GONE);
                }
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mSecondButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mStoryIndex++;

                if(mStory.getText().equals(story[0]))
                {
                    mStory.setText(story[1]);
                    mFirstButton.setText(optionsTop[1]);
                    mSecondButton.setText(optionsBottom[1]);
                }
                else if(mStory.getText().equals(story[1]))
                {
                    mStory.setText(story[3]);
                }
                else if(mStory.getText().equals(story[2]))
                {
                    mStory.setText(story[4]);
                }

                if(mStoryIndex >= 3 || mStory.getText().equals(story[3])
                        || mStory.getText().equals(story[4]))
                {
                    mFirstButton.setVisibility(View.GONE);
                    mSecondButton.setVisibility(View.GONE);
                }
            }
        });
    }
}