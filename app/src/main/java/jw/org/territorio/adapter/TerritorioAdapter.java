package jw.org.territorio.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.ColorRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import jw.org.territorio.R;
import jw.org.territorio.model.Territorio;

/**
 * Created by Des. Android on 26/07/2017.
 */

public class TerritorioAdapter extends RecyclerView.Adapter<TerritorioAdapter.ViewHolder> {

    public static final String DRAWABLE = "drawable";
    private static final String ICON_TERRITORIO = "icon_territorio_";
    private final Resources mResources;
    private final String mPackageName;
    private final Activity mActivity;
    private final Context mContext;
    private final LayoutInflater mLayoutInflater;
    private List<Territorio> territorios;

    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onClick(View view, int position);
    }

    public TerritorioAdapter(Activity activity, List<Territorio> data) {
        mActivity = activity;
        mContext = mActivity.getApplicationContext();
        mResources = mActivity.getResources();
        mPackageName = mActivity.getPackageName();
        mLayoutInflater = LayoutInflater.from(activity.getApplicationContext());
        territorios = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_territorio, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Territorio territorio = territorios.get(position);
        Glide.with(mContext).load(mResources.getIdentifier("territorio_" + territorio.getNumeroTerritorio(), DRAWABLE, mPackageName)).into(holder.category_icon);
        holder.itemView.setBackgroundColor(getColor(territorio.getTematerritorio().getWindowBackgroundColor()));
        holder.category_title.setText(territorio.getNumeroTerritorio());
        holder.category_title.setTextColor(getColor(territorio.getTematerritorio().getTextPrimaryColor()));
        holder.category_title.setBackgroundColor(getColor(territorio.getTematerritorio().getPrimaryColor()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(v, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return territorios.get(position).getNumeroTerritorio().hashCode();
    }

    @Override
    public int getItemCount() {
        return territorios.size();
    }

    public Territorio getItem(int position) {
        return territorios.get(position);
    }

    public final void notifyItemChanged(String id) {
        notifyItemChanged(getItemPositionById(id));
    }

    private int getItemPositionById(String id) {
        for (int i = 0; i < territorios.size(); i++) {
            if (territorios.get(i).getNumeroTerritorio().equals(id)) {
                return i;
            }

        }
        return -1;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    private int getColor(@ColorRes int colorRes) {
        return ContextCompat.getColor(mActivity, colorRes);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView category_icon;
        TextView category_title;

        public ViewHolder(View itemView) {
            super(itemView);
            category_icon = (ImageView) itemView.findViewById(R.id.category_icon);
            category_title = (TextView) itemView.findViewById(R.id.category_title);
        }
    }
}
