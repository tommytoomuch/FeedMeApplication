package uk.co.tommywebdesign.feedmeapplication.fragments;


import android.app.Dialog;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import uk.co.tommywebdesign.feedmeapplication.R;
import uk.co.tommywebdesign.feedmeapplication.app_classes.Ingredient;
import uk.co.tommywebdesign.feedmeapplication.data.DBHandler;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewIngredientFragment extends Fragment {

    private Button backBtn;
    private Button addBtn;
    private ImageView meatIcon;
    private ImageView vegIcon;
    private ImageView eeIcon;
    private ImageView selectedIcon;
    private EditText ingredientNameInput;


    private boolean catagorySelected = false;
    private final String[] catagoryType = {"Meat", "Veg", "EveryThingElse"} ;
    private String catagoryPicked;
    private final int[] catImageId = {R.drawable.meat_btn, R.drawable.veg_btn,R.drawable.ee_btn, R.drawable.holding};





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
        addBtn = (Button)view.findViewById(R.id.add_ingredient_btn);
        meatIcon=(ImageView)view.findViewById(R.id.new_ingredient_cat_meat);
        vegIcon=(ImageView)view.findViewById(R.id.new_ingredient_cat_veg);
        eeIcon=(ImageView)view.findViewById(R.id.new_ingredient_cat_ee);
        selectedIcon=(ImageView)view.findViewById(R.id.new_ingredient_selected_cat);
       ingredientNameInput = (EditText)view.findViewById(R.id.new_ingredient_txt_input);
        this.setInterfaceListeners();

    }

    public void setInterfaceListeners(){
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((Ingredients)getActivity()).swapFragments(v,0);
                showTest();
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewIngredient();

            }
        });

        meatIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSelectedCat(v);
            }
        });

        vegIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSelectedCat(v);
            }
        });

        eeIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSelectedCat(v);
            }
        });

    }

    private void addNewIngredient() {
        String name ;
        String catagory;
        if(ingredientValid()){
            name=ingredientNameInput.getText().toString();
            catagory=getCatagory();
            DBHandler db = new DBHandler(getActivity());
            db.addIngredient(name, catagory);

            Dialog dialog = new Dialog(getActivity());
            dialog.setTitle("Ingredient added");
            dialog.show();
        }




    }

    private String getCatagory() {
        AtomicReference<String> cat= new AtomicReference<>("");
        if(catagoryPicked.equals( catagoryType[0])){
            cat.set(catagoryType[0]);
        }else if(catagoryPicked.equals(catagoryType[1])){
            cat.set(catagoryType[1]);
        }else if(catagoryPicked.equals(catagoryType[2])){
            cat.set(catagoryType[2]);
        }

        return cat.get();
    }

    private boolean ingredientValid() {
        AtomicBoolean valid= new AtomicBoolean(false);
        if(ingredientNameInput.getText().toString().length()>2 && catagorySelected){
            valid.set(true);
        }else{
            if(ingredientNameInput.getText().toString().length()<2){
                Toast.makeText(getActivity(),"No Name",Toast.LENGTH_SHORT).show();
                valid.set(false);
            }else if(!catagorySelected){
                Toast.makeText(getActivity(),"No Catagory",Toast.LENGTH_SHORT).show();
                valid.set(false);
            }
        }
        return valid.get();
    }


    private void showTest(){
        DBHandler db = new DBHandler(getActivity());
        List<Ingredient> list = db.getIngredients();
        for(Ingredient i:list){
            Log.d("TOMMY","name"+i.getIngredientName());
            Log.d("TOMMY","cat"+i.getCatagoryName().toString());
        }
    }

    private void addSelectedCat(View v) {

        if(v.getId()==R.id.new_ingredient_cat_meat){
           selectedIcon.setImageResource(catImageId[0]);
            this.catagorySelected=true;
            this.catagoryPicked=catagoryType[0];
        }else if(v.getId()==R.id.new_ingredient_cat_veg){
            selectedIcon.setImageResource(catImageId[1]);
            this.catagorySelected=true;
            this.catagoryPicked=catagoryType[1];
        }else if(v.getId()==R.id.new_ingredient_cat_ee){
            selectedIcon.setImageResource(catImageId[2]);
            this.catagorySelected=true;
            this.catagoryPicked=catagoryType[2];
        }

    }







}
