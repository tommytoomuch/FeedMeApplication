package uk.co.tommywebdesign.feedmeapplication.fragments;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uk.co.tommywebdesign.feedmeapplication.R;
import uk.co.tommywebdesign.feedmeapplication.activities.Coord;
import uk.co.tommywebdesign.feedmeapplication.activities.Ingredients;
import uk.co.tommywebdesign.feedmeapplication.app_classes.Ingredient;
import uk.co.tommywebdesign.feedmeapplication.app_classes.IngredientAdapter;
import uk.co.tommywebdesign.feedmeapplication.app_classes.IngredientsData;

/**
 * A simple {@link Fragment} subclass.
 */
public class IngredientsFragment extends Fragment implements IngredientAdapter.ItemClickCallback {


    private RecyclerView ingredientsRecycleView;
    private IngredientAdapter adapter;
    private ArrayList listData;
    private ImageButton meatBtn;
    private ImageButton vegBtn;
    private ImageButton allBtn;
    private int  listColor =0;
    private Button newIngredientBtn;
    private  Button getRecipesBtn;

    private String fragColors[] ={"#ff554c","#39ff64", "#3d7eff","#fff185"};



    public IngredientsFragment() {
        // Required empty public constructor
    }



    public void setColors(int colorId){
        Fragment fragment = getFragmentManager().findFragmentById(R.id.ingredients_fragment);
        FrameLayout listHolder =(FrameLayout) fragment.getActivity().findViewById(R.id.recycler_holder);
        LinearLayout btnHolder =(LinearLayout)fragment.getActivity().findViewById(R.id.cat_btn_container);

        listHolder.setBackgroundColor(Color.parseColor(fragColors[colorId]));
        btnHolder.setBackgroundColor(Color.parseColor(fragColors[colorId]));
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ingredients_frag, container, false);
       setRecycler(view);
        setInterfaceObjects(view);

        return view;
    }

    public void setInterfaceListeners(){
        meatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIngredientsRecycleList(getNewList(v),listColor);
            }
        });

        vegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIngredientsRecycleList(getNewList(v),listColor);
            }
        });
        allBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIngredientsRecycleList(getNewList(v),listColor);
            }
        });
        newIngredientBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Ingredients)getActivity()).swapFragments(v,1);
            }
        });

        getRecipesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Ingredients)getActivity()).swapFragments(v,2);
            }
        });


    }




    public void setInterfaceObjects(View view){
        meatBtn =(ImageButton)view.findViewById(R.id.cat_btn_meat);
        vegBtn =(ImageButton)view.findViewById(R.id.cat_btn_veg);
        allBtn =(ImageButton)view.findViewById(R.id.cat_btn_all);
        newIngredientBtn=(Button)view.findViewById(R.id.new_ingredient_btn);
        getRecipesBtn=(Button)view.findViewById(R.id.find_recipes_btn);

        this.setInterfaceListeners();
    }



    public void setRecycler(View view){
        listData=(ArrayList) IngredientsData.getMeatIngredients();
        ingredientsRecycleView = (RecyclerView)view.findViewById(R.id.all_ingredients_recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        ingredientsRecycleView.setLayoutManager(linearLayoutManager);
        adapter = new IngredientAdapter(listData,getActivity());
        ingredientsRecycleView.setAdapter(adapter);
        adapter.setBgColor(0);
        adapter.setItemClickCallback(this);
    }


    public void newIngredientsRecycleList(List<Ingredient>newList, int listColor){
        listData=(ArrayList)newList;
        Fragment fragment = getFragmentManager().findFragmentById(R.id.ingredients_fragment);
        ingredientsRecycleView = (RecyclerView)fragment.getActivity().findViewById(R.id.all_ingredients_recycle_view);
        adapter = new IngredientAdapter(listData,getActivity());
        adapter.setBgColor(listColor);
        setColors(listColor);
        ingredientsRecycleView.swapAdapter(adapter,false);
        adapter.setItemClickCallback(this);

    }

    private List<Ingredient> getNewList(View v) {
        List<Ingredient> listToUse = new ArrayList<>();
        if(v.getId() == R.id.cat_btn_meat){

            listToUse.addAll(IngredientsData.getMeatIngredients());
            // listToUse = IngredientsData.getMeatIngredients();
            listColor=0;
        }else if(v.getId()==R.id.cat_btn_veg){
            listToUse = IngredientsData.getVegIngredients();
            listColor=1;
        }else if(v.getId()==R.id.cat_btn_grain){
            listToUse = IngredientsData.getEEIngredients();
            listColor=2;
        }else if(v.getId()==R.id.cat_btn_all){
            listToUse = IngredientsData.getMeatIngredients();
            listToUse.addAll(IngredientsData.getVegIngredients());
            listToUse.addAll(IngredientsData.getEEIngredients());
            listColor=3;
        }
        return listToUse;
    }
    @Override
    public void onItemClick(int p) {
        Ingredient ingredient=(Ingredient)listData.get(p);
        Toast.makeText(getActivity(),ingredient.getIngredientName().toString(),Toast.LENGTH_SHORT).show();
    }
}
