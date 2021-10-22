package com.example.cs180.Week9.Debugging.work;
public class RegularSprite extends Sprite {
    //Indicates whether store aims to make regular sprite more accessible than other types of sprite or not (false by default)
    private boolean moreAccessible;
    //Constructor calls default constructor in superclass for regular sprite
    public RegularSprite() {
        super();
        moreAccessible = false;
    }

    //Constructor that calls default constructor in superclass and takes in moreAccessible boolean
    public RegularSprite(boolean moreAccessible) {
        super();
        this.moreAccessible = moreAccessible;
    }

    //Returns moreAccessible instance variable
    public boolean isMoreAccessible() {
        return moreAccessible;
    }
}
