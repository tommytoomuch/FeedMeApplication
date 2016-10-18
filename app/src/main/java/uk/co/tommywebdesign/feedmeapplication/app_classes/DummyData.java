package uk.co.tommywebdesign.feedmeapplication.app_classes;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tommy on 18/10/16.
 */

public class DummyData {


    private static final String[] titles = {"Chicken","Beef","Pork"};
    private static final int[] icons={android.R.drawable.ic_media_play,android.R.drawable.ic_delete,android.R.drawable.ic_dialog_email};

    public static List<Ingredient>getAvailbleIngredients(){
        List<Ingredient> data = new ArrayList<>();



        for(int x=0;x<4;x++){
            for(int i=0;i<titles.length&&i<icons.length;i++){
                Ingredient ingredient = new Ingredient();
              ingredient.setIngredientName(titles[i]);
                ingredient.setCatId(icons[i]);
                data.add(ingredient);
            }
        }







        return data;
    }









}
