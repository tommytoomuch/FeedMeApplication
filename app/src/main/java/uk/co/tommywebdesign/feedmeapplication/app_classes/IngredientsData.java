package uk.co.tommywebdesign.feedmeapplication.app_classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.co.tommywebdesign.feedmeapplication.R;

/**
 * Created by tommy on 18/10/16.
 */

public class IngredientsData {

    private  static final String[] meatIngredients = {"chicken","chicken leg","chicken breast","chicken wings",
            "chicken shredded","Beef","Beef mince","Beef diced","Beef loin","Bacon" };

    private  static final String[] vegIngredients = {"brocolli","peas","carrots","potato","onion"};

    private  static final String[] everthingElseIngredients = {"pasta","rice","bread","tomato","baked beans"};



   private static final int[] catagoryId= {R.drawable.meat_and_fish,R.drawable.fruit_and_veg,
   R.drawable.everything_else,R.drawable.all_ingreidents};



    public static List<Ingredient>getMeatIngredients(){
        List<Ingredient> meatList = new ArrayList<>();
        for(int i =0;i<meatIngredients.length;i++){

            Ingredient ingredient = new Ingredient();
            ingredient.setIngredientName(meatIngredients[i]);
            ingredient.setCatId(catagoryId[0]);
            meatList.add(ingredient);
        }

        return meatList;
    }

    public static List<Ingredient>getVegIngredients(){
        List<Ingredient> meatList = new ArrayList<>();
        for(int i =0;i<vegIngredients.length;i++){

            Ingredient ingredient = new Ingredient();
            ingredient.setIngredientName(vegIngredients[i]);
            ingredient.setCatId(catagoryId[1]);
            meatList.add(ingredient);
        }

        return meatList;
    }


    public static List<Ingredient>getEEIngredients(){
        List<Ingredient> meatList = new ArrayList<>();
        for(int i =0;i<everthingElseIngredients.length;i++){

            Ingredient ingredient = new Ingredient();
            ingredient.setIngredientName(everthingElseIngredients[i]);
            ingredient.setCatId(catagoryId[2]);
            meatList.add(ingredient);
        }

        return meatList;
    }



}
