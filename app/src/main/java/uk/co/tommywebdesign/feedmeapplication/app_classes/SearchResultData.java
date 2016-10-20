package uk.co.tommywebdesign.feedmeapplication.app_classes;

import java.util.ArrayList;
import java.util.List;

import uk.co.tommywebdesign.feedmeapplication.R;

/**
 * Created by tommy on 20/10/16.
 */

public class SearchResultData {
    private  static final String[] tiltes ={"Recipe1","Recipe2","Recipe3","Recipe4","Recipe5","Recipe6","Recipe7"};
    private static final int image = R.drawable.recipe_image;
    private static final String[] rank = {"rank5","rank5","rank3","rank5","rank4","rank5","rank4"};


    public static List<Recipe> getRecipes(){
        List<Recipe>recipes = new ArrayList<>();

        for(int x=0;x<4;x++){
            for(int i=0;i<tiltes.length;i++){
                Recipe recipe = new Recipe();
                recipe.setTitle(tiltes[i]);
                recipe.setRecipeImage(image);
                recipe.setRank(rank[i]);
                recipes.add(recipe);
            }
        }





        return recipes;


    }

}
