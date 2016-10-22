package uk.co.tommywebdesign.feedmeapplication.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.atomic.AtomicReference;

import uk.co.tommywebdesign.feedmeapplication.R;
import uk.co.tommywebdesign.feedmeapplication.fragments.IngredientsFragment;
import uk.co.tommywebdesign.feedmeapplication.fragments.NewIngredientFragment;
import uk.co.tommywebdesign.feedmeapplication.fragments.SearchResultsFragment;

public class Ingredients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingredients_act);
    }

    public void gotoRecipeActivity(int p){
        //TODO get the data from recipeclicked
        Intent intent = new Intent("uk.co.tommy.RECIPE");
        startActivity(intent);
    }


    public void swapFragments(View view, int FragNum){
        Fragment newFrag = getNewFragment(FragNum);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_container,newFrag);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    private Fragment getNewFragment(int fragNum) {
        AtomicReference<Fragment> frag = new AtomicReference<>(new Fragment());
        if(fragNum==0){
            frag.set(new IngredientsFragment());
        }else if(fragNum==1){
            frag.set(new NewIngredientFragment());
        }else if(fragNum==2){
            frag.set(new SearchResultsFragment());
        }
        return frag.get();


    }







}
