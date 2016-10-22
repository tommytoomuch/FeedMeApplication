package uk.co.tommywebdesign.feedmeapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import uk.co.tommywebdesign.feedmeapplication.R;
import uk.co.tommywebdesign.feedmeapplication.app_classes.Recipe;

/**
 * Created by tommy on 20/10/16.
 */

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.AppHolder> {

    private List<Recipe> listData;
    private LayoutInflater inflater;
    private SearchResultsAdapter.ItemClickCallback itemClickCallback;

    private String[] listBGColors={"#ff554c","#39ff64", "#3d7eff","#fff185"};

    private int bgColor =1;

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }




    public SearchResultsAdapter(List<Recipe> listItem, Context c){
        this.inflater=LayoutInflater.from(c);
        this.listData=listItem;

    }




    public interface   ItemClickCallback{
        void onItemClick(int p);
    }

    public void  setItemClickCallback(final SearchResultsAdapter.ItemClickCallback itemClickCallback){
        this.itemClickCallback=itemClickCallback;
    }

    @Override
    public SearchResultsAdapter.AppHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.search_result_card_item,parent,false);
        return new SearchResultsAdapter.AppHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchResultsAdapter.AppHolder holder, int position) {

       Recipe recipe =listData.get(position);
        holder.recipeTitle.setText(recipe.getTitle());
        holder.recipeImg.setImageResource(recipe.getRecipeImage());
       // holder.container.setBackgroundColor(Color.parseColor(listBGColors[bgColor]));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class AppHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView recipeTitle;
        private ImageView recipeImg;
        private View container;
        private Button actionBtn;

        public AppHolder(View itemView) {
            super(itemView);
           recipeTitle = (TextView) itemView.findViewById(R.id.search_res_item_title);
            recipeImg = (ImageView) itemView.findViewById(R.id.serach_res_item_image);
            actionBtn = (Button)itemView.findViewById(R.id.goto_recipe_activity_btn);
            //container = itemView.findViewById(R.id.search_result_item_container);
            actionBtn.setOnClickListener(this);
            //container.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {
            itemClickCallback.onItemClick(getAdapterPosition());
        }
    }

}
