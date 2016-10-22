package uk.co.tommywebdesign.feedmeapplication.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uk.co.tommywebdesign.feedmeapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SavedRecipeFragment extends Fragment {


    public SavedRecipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.saved_recipe_frag, container, false);
    }

}
