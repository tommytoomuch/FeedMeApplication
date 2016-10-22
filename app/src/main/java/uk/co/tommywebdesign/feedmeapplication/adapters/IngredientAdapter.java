package uk.co.tommywebdesign.feedmeapplication.adapters;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uk.co.tommywebdesign.feedmeapplication.R;
import uk.co.tommywebdesign.feedmeapplication.app_classes.Ingredient;

/**
 * Created by tommy on 18/10/16.
 */

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.AppHolder> {

    private List<Ingredient> listData;
    private LayoutInflater inflater;
    private ItemClickCallback itemClickCallback;
    private ItemLongClickCallback itemLongClickCallback;

    private String[] listBGColors={"#e4908e","#a2b89e", "#879da7"};
    private int[] catImageIds = {R.drawable.meat_list_item,R.drawable.veg_list_item,R.drawable.ee_list_item};


    public IngredientAdapter(List<Ingredient> listItem, Context c){
        this.inflater=LayoutInflater.from(c);
        this.listData=listItem;
    }




    public interface   ItemClickCallback{
        void onItemClick(int p);
    }

    public interface ItemLongClickCallback{
        void onItemLongClick(int p);
    }

    public void  setItemClickCallback(final  ItemClickCallback itemClickCallback){
        this.itemClickCallback=itemClickCallback;
    }

    @Override
    public AppHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.ingredients_listitem,parent,false);
        return new AppHolder(view);
    }

    @Override
    public void onBindViewHolder(AppHolder holder, int position) {

        Ingredient ingredient =listData.get(position);
        holder.title.setText(ingredient.getIngredientName());
        if(ingredient.getCatagoryName().equals(Ingredient.Catagories.Meat)){
            holder.icon.setImageResource(catImageIds[0]);
            holder.container.setBackgroundColor(Color.parseColor(listBGColors[0]));
        }
        if(ingredient.getCatagoryName().equals(Ingredient.Catagories.Veg)){
            holder.icon.setImageResource(catImageIds[1]);
            holder.container.setBackgroundColor(Color.parseColor(listBGColors[1]));
        }
        if(ingredient.getCatagoryName().equals(Ingredient.Catagories.EveryThingElse)){
            holder.icon.setImageResource(catImageIds[2]);
            holder.container.setBackgroundColor(Color.parseColor(listBGColors[2]));
        }


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class AppHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private TextView title;
        private ImageView icon;
        private View container;

        public AppHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.list_item_txt);
            icon = (ImageView) itemView.findViewById(R.id.list_item_icon);
            container = itemView.findViewById(R.id.list_item_container);
            container.setOnClickListener(this);
            container.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View v) {
            itemClickCallback.onItemClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View v) {

            itemLongClickCallback.onItemLongClick(getAdapterPosition());
            return true;
        }
    }

}