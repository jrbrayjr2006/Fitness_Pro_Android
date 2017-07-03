package com.jaydot2.fitnessapp.core.model;

import android.media.Image;
import java.util.ArrayList;

/**
 * <b>Description:</b>
 * <p>
 *     This is the model for the menu list items
 * </p>
 * Created by jamesbray on 12/18/16.
 */

public class FitnessItem {

    private String mItemTitle;

    private int mImageId;

    public FitnessItem(String itemTitle, int imageId) {
        this.mItemTitle = itemTitle;
        this.mImageId = imageId;
    }

    public String getmItemTitle() {
        return mItemTitle;
    }

    public int getmImageId() {
        return mImageId;
    }

    private static int lastImageId = 0;

    public static ArrayList<FitnessItem> createFitnessNavigationList(int numFitnessItems) {
        ArrayList<FitnessItem> fitnessItems = new ArrayList<FitnessItem>();

        for(int i = 1; i <= numFitnessItems; i++) {
            fitnessItems.add(new FitnessItem("placeholder", ++lastImageId));
        }

        return fitnessItems;
    }
}
