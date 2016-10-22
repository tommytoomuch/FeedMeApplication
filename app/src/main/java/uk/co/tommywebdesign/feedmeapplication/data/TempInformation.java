package uk.co.tommywebdesign.feedmeapplication.data;

import java.util.ArrayList;
import java.util.List;

import uk.co.tommywebdesign.feedmeapplication.app_classes.Ingredient;

/**
 * Created by tommy on 22/10/16.
 */

public class TempInformation {

    private static String[] ingredentNames={"chicken","beef","pork","bacon","turkey","Carrots","peas","brochille","red cabbage","potatos",
            "beans","pasta","rice","noodles","rissoto rice"};


    public static List<Ingredient> getTempListOfIngredients(){

        List <Ingredient> ingredients = new ArrayList<>();
        for(int x =0;x<5;x++){
            Ingredient ingredient=new Ingredient();
            ingredient.setIngredientName(ingredentNames[x]);
            ingredient.setCatagoryName(Ingredient.Catagories.Meat);
            ingredients.add(ingredient);
        }
        for(int x =5;x<10;x++){
            Ingredient ingredient=new Ingredient();
            ingredient.setIngredientName(ingredentNames[x]);
            ingredient.setCatagoryName(Ingredient.Catagories.Veg);
            ingredients.add(ingredient);
        }
        for(int x =10;x<15;x++){
            Ingredient ingredient=new Ingredient();
            ingredient.setIngredientName(ingredentNames[x]);
            ingredient.setCatagoryName(Ingredient.Catagories.EveryThingElse);
            ingredients.add(ingredient);
        }

        return ingredients;
    }






}
