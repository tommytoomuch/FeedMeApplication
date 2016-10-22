package uk.co.tommywebdesign.feedmeapplication.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import uk.co.tommywebdesign.feedmeapplication.activities.Ingredients;
import uk.co.tommywebdesign.feedmeapplication.app_classes.Ingredient;

/**
 * Created by tommy on 22/10/16.
 */

public class DBHandler extends SQLiteOpenHelper {



    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "IngredientsDatabase";
    // Contacts table name
    private static final String INGREDIENTS_TABLE = "ingredientsTable";
    // Shops Table Columns names
    private static final String KEY_ID ="_id";
    private static final String KEY_NAME = "name";
    private static final String KEY_CATAGORY = "catagory";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_INGREDIENTS_TABLE = "CREATE TABLE "+ INGREDIENTS_TABLE + " (" +KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+KEY_NAME + " TEXT, "+
                KEY_CATAGORY + " TEXT )";
        db.execSQL(CREATE_INGREDIENTS_TABLE);
        Log.d("TOMMY", "databasecreated");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+INGREDIENTS_TABLE);
        onCreate(db);
    }


    public void addIngredient(String aName, String aCatagory){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME,aName);
        values.put(KEY_CATAGORY,aCatagory);
        db.insert(INGREDIENTS_TABLE,null,values);
        db.close();
    }

    public List<Ingredient> getIngredients(){
        List<Ingredient> ingredientList = new ArrayList<>();

        String[] colums ={KEY_ID,KEY_NAME,KEY_CATAGORY};
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(INGREDIENTS_TABLE,colums,null,null,null,null,null);
        //cursor.moveToFirst();
       //Log.d("TOMMY", "name" + cursor.getString(cursor.getColumnIndex(KEY_NAME)));

        try{
            while (cursor.moveToNext()){
                Ingredient ingredient = new Ingredient();
                ingredient.setIngredientName(cursor.getString(cursor.getColumnIndex(KEY_NAME)));
                ingredient.setCatagoryName(Ingredient.Catagories.valueOf(cursor.getString(cursor.getColumnIndex(KEY_CATAGORY))));
                ingredientList.add(ingredient);
            }
        }finally {
            cursor.close();
        }


        return ingredientList;
    }

}
