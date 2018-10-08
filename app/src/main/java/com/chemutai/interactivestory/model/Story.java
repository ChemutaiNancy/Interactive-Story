package com.chemutai.interactivestory.model;

import com.chemutai.interactivestory.R;

public class Story {

    private Page[] mPages;

    public Story() {
        mPages = new Page[7];

        mPages[0] = new Page(
                R.drawable.mars_2018,
                "I am the bread of life, every one who believes in me should not hunger, and not perish",
                new Choice("Stop and Investigate", 1),
                new Choice("Continue home to earth", 2));

        mPages[1] = new Page(
                R.drawable.tree1,
                "I am the bread of life, every one who believes in me should not hunger, and not perish",
                new Choice("Explore the cave", 3),
                new Choice("Explore the rover", 4));

        mPages[2] = new Page(
                R.drawable.tree2,
                "I am the bread of life, every one who believes in me should not hunger, and not perish",
                new Choice("Head back to mass to investigate", 4),
                new Choice("Continue home to earth", 6));

        mPages[3] = new Page(
                R.drawable.tree3,
                "I am the bread of life, every one who believes in me should not hunger, and not perish",
                new Choice("Refill to ship and explore to rover", 4),
                new Choice("Continue towards the faint light", 5));

        mPages[4] = new Page(
                R.drawable.tree4,
                "I am the bread of life, every one who believes in me should not hunger, and not perish",
                new Choice("Explore the coordinates", 5),
                new Choice("Return to earth", 6));

        mPages[5] = new Page(
                R.drawable.tree5,
                "I am the bread of life, every one who believes in me should not hunger, and not perish"
                /*new Choice("Stop and Investigate", 1),
                new Choice("Continue home and earth", 2)*/
        );

        mPages[6] = new Page(
                R.drawable.marssurface,
                "I am the bread of life, every one who believes in me should not hunger, and not perish"
                /*new Choice("Stop and Investigate", 1),
                new Choice("Continue home and earth", 2)*/
        );
       /* mPages[0].setmImageId(R.drawable.Whitaker_Studio_Joshua_Tree_Residence_04_Approaching_by_Foot_1024x819);
        mPages[0].setText("text");
        mPages[0].setChoice1(new Choice());
        mPages[0].setChoice2(new Choice());*/
    }

    public Page getPage(int pageNumber){
        return mPages[pageNumber];
    }
}
