package uk.co.tommywebdesign.feedmeapplication.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import uk.co.tommywebdesign.feedmeapplication.R;
import uk.co.tommywebdesign.feedmeapplication.activities.Ingredients;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewIngredientFragment extends Fragment {

    private Button backBtn;





    public NewIngredientFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ingredient_new_frag, container, false);

        this.setInterfaceObjects(view);

        return view;
    }


    public void setInterfaceObjects(View view){
        backBtn=(Button)view.findViewById(R.id.cancel_add_ingredient_btn);

        this.setInterfaceListeners();

    }

    public void setInterfaceListeners(){
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Ingredients)getActivity()).swapFragments(v,0);
            }
        });
    }


}
