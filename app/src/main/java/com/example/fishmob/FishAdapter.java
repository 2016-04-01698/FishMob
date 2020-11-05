package com.example.fishmob;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Filter;
//import android.widget.Filterable;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//class FishAdapter extends RecyclerView.Adapter<FishAdapter.FishViewHolder> implements Filterable {  // impleteed filterable for new interface
//    private List<fishitemcardviewer> mfishList;
//    private  ArrayList<fishitemcardviewer>  mfishListFull;
//    public  static  class  FishViewHolder extends RecyclerView.ViewHolder{
//        public ImageView mImageView;
//        public TextView  nameTextView;
//        public TextView  weightTextView;
//        public  TextView  costTextView;
//
//        public FishViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            mImageView=itemView.findViewById(R.id.fish_image);
//            nameTextView=itemView.findViewById(R.id.name_fish);
//            weightTextView=itemView.findViewById(R.id.weight_fish);
//            costTextView=itemView.findViewById(R.id.cost_fish);
//        }
//    }
//
//    public  FishAdapter(RecyclerViewer recyclerViewer, ArrayList<fishitemcardviewer> fishitemcardviewers){
//      this.mfishList=fishitemcardviewers;
//      mfishListFull=new ArrayList<>(fishitemcardviewers);
//
//    }
//    @Override
//    public FishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fishitemcardviewer,parent,false);// when codes dont run lets check here.
//       FishViewHolder fvh = new FishViewHolder(v);
//       return  fvh;
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull FishViewHolder holder, int position) {
//       fishitemcardviewer currrentItem =mfishList.get(position);
//       holder.mImageView.setImageResource(currrentItem.getImageResource());
//       holder.nameTextView.setText(currrentItem.getNameOfFish());
//       holder.weightTextView.setText(currrentItem.getWeightOfFish());
//       holder.costTextView.setText(currrentItem.getCostOfFish());
//    }
//
//    @Override
//    public int getItemCount() {
//        return mfishList.size();
//    }
//
//    @Override
//    public Filter getFilter() {
//        return fishFilter;
//    }
//    // function to performing a filter
//    private Filter fishFilter=new Filter() {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            List<fishitemcardviewer> filteredList = new ArrayList<>();
//            if (constraint==null || constraint.length()==0){
//                filteredList.addAll(mfishListFull);
//            }
//            else {
//                String filterPattern=constraint.toString().toLowerCase().trim();
//                for (fishitemcardviewer viewer:mfishListFull){
//                    if (viewer.getNameOfFish().toLowerCase().contains(filterPattern))   // codes to check what sentence to match after user type in searchbar
//                        {
//                        filteredList.add(viewer);
//                    }
//                }
//            }
//            FilterResults results=new FilterResults();
//            results.values=filteredList;
//
//            return results;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            mfishList.clear();
//            mfishList.addAll((List)results.values);
//            notifyDataSetChanged();   // here it tells an fishAdapter to refresh a list.
//
//        }
//    };
//
//    public void setSearchOperation(List<fishitemcardviewer> newList){
//        mfishList = new ArrayList<>();
//        mfishList.addAll(newList);
//        notifyDataSetChanged();
//    }
//
//    public void updateList(List<fishitemcardviewer> list){
//        mfishList =  list;
//        notifyDataSetChanged();
//    }
//}
//
//
import android.content.Context;
        import android.view.ContextMenu;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;

        import androidx.recyclerview.widget.RecyclerView;


        import java.util.ArrayList;
        import java.util.List;



public class FishAdapter extends RecyclerView.Adapter<FishAdapter.ImageViewHolder> {
    private Context mContext;
    private List<fishitemcardviewer> mUploads;
    private OnItemClickListener mListener;

    public FishAdapter(Context mContext, List<fishitemcardviewer> mUploads) {
        this.mContext = mContext;
        this.mUploads = mUploads;
    }

    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.fishitemcardviewer,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        fishitemcardviewer currrentItem = mUploads.get(position);

        holder.mImageView.setImageResource(currrentItem.getImageResource());
        holder.nameTextView.setText(currrentItem.getNameOfFish());
        holder.weightTextView.setText(currrentItem.getWeightOfFish());
        holder.costTextView.setText(currrentItem.getCostOfFish());

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public ImageView mImageView;
        public TextView  nameTextView;
        public TextView  weightTextView;
        public  TextView  costTextView;
        public ImageViewHolder(View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.fish_image);
            nameTextView=itemView.findViewById(R.id.name_fish);
            weightTextView=itemView.findViewById(R.id.weight_fish);
            costTextView=itemView.findViewById(R.id.cost_fish);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);

        }

        @Override
        public void onClick(View v) {
            if (mListener!=null){
                //Get the position of the clicked item
                int position = getAdapterPosition();
                if (position!=RecyclerView.NO_POSITION){
                    mListener.onItemClick(position);
                }
            }
        }
        // Handle Menu Items
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem doWhatever = menu.add(Menu.NONE, 1, 1,"Verify code");
            MenuItem delete = menu.add(Menu.NONE,2,2,"Delete");
            doWhatever.setOnMenuItemClickListener(this);
            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (mListener!=null){
                //Get the position of the clicked item
                int position = getAdapterPosition();
                if (position!=RecyclerView.NO_POSITION){
                    switch (item.getItemId()){
                        case 1:
                            mListener.onVerifyClick(position);
                            return true;
                        case 2:
                            mListener.onDeleteClick(position);
                            return true;
                    }
                }
            }
            return false;
        }
    }
    public interface OnItemClickListener{
        void onItemClick(int position);

        void onVerifyClick(int position);

        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public void setSearchOperation(List<fishitemcardviewer> newList){
        mUploads = new ArrayList<>();
        mUploads.addAll(newList);
        notifyDataSetChanged();
    }
}
