package uk.co.tommywebdesign.feedmeapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import uk.co.tommywebdesign.feedmeapplication.R;

public class Coord extends AppCompatActivity {


    ImageButton gotoIngredientsBtn;
    ImageButton gotoRecipeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coord_act);
        initatieInterfaceObjects();
        setListeners();


    }

    private void setListeners(){

        gotoIngredientsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadActivity(v);
            }
        });

        gotoRecipeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadActivity(v);
            }
        });

    }

    private  void initatieInterfaceObjects(){
        gotoIngredientsBtn=(ImageButton)findViewById(R.id.goto_act_ingredients);
        gotoRecipeBtn=(ImageButton)findViewById(R.id.goto_act_ingredients);

    }

    private void loadActivity(View view){
        if(view.getId() == R.id.goto_act_ingredients){
            Intent intent = new Intent("uk.co.tommy.INGREDIENTS");
            startActivity(intent);
        }else if(view.getId() ==R.id.goto_act_recipe){
            Intent intent = new Intent("uk.co.tommy.RECIPE");
            startActivity(intent);
        }



    }




    public void getNewIngredientFrag(){

    }


}
