package uk.co.tommywebdesign.feedmeapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import uk.co.tommywebdesign.feedmeapplication.R;

public class Recipe extends AppCompatActivity {


    private Recipe recipeToView;



    public Recipe getRecipeToView() {
        return recipeToView;
    }

    public void setRecipeToView(Recipe recipeToView) {
        this.recipeToView = recipeToView;
    }








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_act);

        loadWebView();
    }

    private void loadWebView() {

        WebView myWebView = (WebView)findViewById(R.id.recipe_web_view);
        WebSettings webSettings = myWebView.getSettings();
        //webSettings.setJavaScriptEnabled(true);

        //myWebView.setWebViewClient(new WebViewClient());


        myWebView.loadUrl("http://allrecipes.com/recipe/89539/slow-cooker-chicken-tortilla-soup/");


    }
}
