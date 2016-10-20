package uk.co.tommywebdesign.feedmeapplication.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import uk.co.tommywebdesign.feedmeapplication.R;
import uk.co.tommywebdesign.feedmeapplication.app_classes.IngredientAdapter;
import uk.co.tommywebdesign.feedmeapplication.app_classes.IngredientsData;
import uk.co.tommywebdesign.feedmeapplication.app_classes.SearchResultData;
import uk.co.tommywebdesign.feedmeapplication.app_classes.SearchResultsAdapter;

/**
 * Created by tommy on 20/10/16.
 */

public class SearchResultsFragment extends Fragment implements SearchResultsAdapter.ItemClickCallback {


    private RecyclerView recipeRecycleView;
    private SearchResultsAdapter adapter;
    private ArrayList listData;


   public SearchResultsFragment(){

   }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.search_results_frag, container, false);
        setRecycler(view);
        //setInterfaceObjects(view);
        //setInterfaceListeners();

        return view;
    }

    public void setRecycler(View view){
        listData=(ArrayList) SearchResultData.getRecipes();
       recipeRecycleView = (RecyclerView)view.findViewById(R.id.recipe_results_recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recipeRecycleView.setLayoutManager(linearLayoutManager);
        adapter = new SearchResultsAdapter(listData,getActivity());
        recipeRecycleView.setAdapter(adapter);
        adapter.setItemClickCallback(this);
    }


    @Override
    public void onItemClick(int p) {


    }






}
