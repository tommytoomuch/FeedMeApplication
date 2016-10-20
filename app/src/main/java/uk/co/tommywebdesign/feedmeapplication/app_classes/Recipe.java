package uk.co.tommywebdesign.feedmeapplication.app_classes;

import android.widget.ImageView;

/**
 * Created by tommy on 20/10/16.
 */

public class Recipe {


    private String title;

    private String rank;
    private int recipeImage;

    public int getRecipeImage() {
        return recipeImage;
    }

    public void setRecipeImage(int recipeImage) {
        this.recipeImage = recipeImage;
    }






    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }






}
