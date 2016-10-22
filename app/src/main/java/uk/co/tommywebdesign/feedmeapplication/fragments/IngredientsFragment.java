package uk.co.tommywebdesign.feedmeapplication.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uk.co.tommywebdesign.feedmeapplication.R;
import uk.co.tommywebdesign.feedmeapplication.activities.Ingredients;
import uk.co.tommywebdesign.feedmeapplication.app_classes.Ingredient;
import uk.co.tommywebdesign.feedmeapplication.adapters.IngredientAdapter;
import uk.co.tommywebdesign.feedmeapplication.data.IngredientsData;

/**
 * A simple {@link Fragment} subclass.
 */
public class IngredientsFragment extends Fragment implements IngredientAdapter.ItemClickCallback {


    private RecyclerView ingredientsRecycleView;
    private IngredientAdapter adapter;
    private ArrayList listData;
    private ImageView meatBtn;
    private ImageView vegBtn;
    private ImageView eeBtn;
    private ImageView allBtn;
    private Button newIngredientBtn;
    private  Button getRecipesBtn;
    private IngredientsData ingredientsData;





    public IngredientsFragment() {
        // Required empty public constructor
    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.ingredients_frag, container, false);
         ingredientsData= new IngredientsData();
        setRecycler(view);
        setInterfaceObjects(view);
        return view;
    }



    public void setInterfaceListeners(){
        meatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIngredientsRecycleList(getNewList(v));
            }
        });

        vegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIngredientsRecycleList(getNewList(v));
            }
        });
        eeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIngredientsRecycleList(getNewList(v));
            }
        });

        allBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newIngredientsRecycleList(getNewList(v));
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
        meatBtn =(ImageView) view.findViewById(R.id.cat_btn_meat);
        vegBtn =(ImageView) view.findViewById(R.id.cat_btn_veg);
        eeBtn = (ImageView) view.findViewById(R.id.cat_btn_grain);
        allBtn =(ImageView) view.findViewById(R.id.cat_btn_all);
        newIngredientBtn=(Button)view.findViewById(R.id.new_ingredient_btn);
        getRecipesBtn=(Button)view.findViewById(R.id.find_recipes_btn);

        this.setInterfaceListeners();
    }



    public void setRecycler(View view){
        listData=(ArrayList) ingredientsData.getMeatList();
        ingredientsRecycleView = (RecyclerView)view.findViewById(R.id.all_ingredients_recycle_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        ingredientsRecycleView.setLayoutManager(linearLayoutManager);
        adapter = new IngredientAdapter(listData,getActivity());
        ingredientsRecycleView.setAdapter(adapter);
        adapter.setItemClickCallback(this);
    }


    public void newIngredientsRecycleList(List<Ingredient>newList){
        listData=(ArrayList)newList;
        Fragment fragment = getFragmentManager().findFragmentById(R.id.ingredients_fragment);
        ingredientsRecycleView = (RecyclerView)fragment.getActivity().findViewById(R.id.all_ingredients_recycle_view);
        adapter = new IngredientAdapter(listData,getActivity());
        ingredientsRecycleView.swapAdapter(adapter,false);
        adapter.setItemClickCallback(this);
    }

    private List<Ingredient> getNewList(View v) {
        List<Ingredient> listToUse = new ArrayList<>();
       if (v.getId()==R.id.cat_btn_meat){
           listToUse.addAll(ingredientsData.getMeatList());
       }else if(v.getId()==R.id.cat_btn_veg){
           listToUse.addAll(ingredientsData.getVegList());
       }else if(v.getId()==R.id.cat_btn_grain){
           listToUse.addAll(ingredientsData.getEeList());
       }else if(v.getId()==R.id.cat_btn_all){
           listToUse.addAll(ingredientsData.getIngredients());
       }
        return listToUse;
    }
    @Override
    public void onItemClick(int p) {
        Ingredient ingredient=(Ingredient)listData.get(p);
        Toast.makeText(getActivity(),ingredient.getIngredientName().toString(),Toast.LENGTH_SHORT).show();
    }
}
