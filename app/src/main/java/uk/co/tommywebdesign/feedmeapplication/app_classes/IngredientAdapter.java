package uk.co.tommywebdesign.feedmeapplication.app_classes;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uk.co.tommywebdesign.feedmeapplication.R;

/**
 * Created by tommy on 18/10/16.
 */

public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.AppHolder> {

    private List<Ingredient> listData;
    private LayoutInflater inflater;
    private ItemClickCallback itemClickCallback;

    private String[] listBGColors={"#ff554c","#39ff64", "#3d7eff","#fff185"};

    private int bgColor =1;

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }




    public IngredientAdapter(List<Ingredient> listItem, Context c){
        this.inflater=LayoutInflater.from(c);
        this.listData=listItem;

    }




    public interface   ItemClickCallback{
        void onItemClick(int p);
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
        holder.icon.setImageResource(ingredient.getCatId());
        holder.container.setBackgroundColor(Color.parseColor(listBGColors[bgColor]));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class AppHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView title;
        private ImageView icon;
        private View container;

        public AppHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.list_item_txt);
            icon = (ImageView) itemView.findViewById(R.id.list_item_icon);
            container = itemView.findViewById(R.id.list_item_container);
            container.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            itemClickCallback.onItemClick(getAdapterPosition());
        }
    }

}