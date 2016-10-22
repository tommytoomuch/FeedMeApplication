package uk.co.tommywebdesign.feedmeapplication.app_classes;

/**
 * Created by tommy on 18/10/16.
 */

public class Ingredient {

    public enum Catagories{
        Meat,Veg,EveryThingElse
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public Catagories getCatagoryName() {
        return catagoryName;
    }

    public void setCatagoryName(Catagories catagoryName) {
        this.catagoryName = catagoryName;
    }

    private String ingredientName;
    private Catagories catagoryName;












}
