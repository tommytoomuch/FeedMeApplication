package uk.co.tommywebdesign.feedmeapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.co.tommywebdesign.feedmeapplication.R;
import uk.co.tommywebdesign.feedmeapplication.app_classes.Ingredient;

/**
 * Created by tommy on 18/10/16.
 */

public class IngredientsData {


    private  List<Ingredient>allIngriedents;
    private  List<Ingredient> meatList;
    private  List<Ingredient> vegList;
    private  List<Ingredient> eeList;


    public IngredientsData(){

        allIngriedents = TempInformation.getTempListOfIngredients();//change to sql
        meatList = new ArrayList<>();
        vegList = new ArrayList<>();
        eeList = new ArrayList<>();

        for(Ingredient i: allIngriedents){
            if(i.getCatagoryName().equals(Ingredient.Catagories.Meat)){
                meatList.add(i);
            }else if(i.getCatagoryName().equals(Ingredient.Catagories.Veg)){
                vegList.add(i);
            }else if(i.getCatagoryName().equals(Ingredient.Catagories.EveryThingElse)){
                eeList.add(i);
            }
        }

    }



    public  List<Ingredient> getIngredients() {

        return allIngriedents;
    }

    public  List<Ingredient> getMeatList() {
        return meatList;
    }

    public List<Ingredient> getVegList() {
        return vegList;
    }

    public List<Ingredient> getEeList() {
        return eeList;
    }
}
