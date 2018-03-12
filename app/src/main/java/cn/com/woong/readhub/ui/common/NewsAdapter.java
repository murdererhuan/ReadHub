package cn.com.woong.readhub.ui.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import cn.com.woong.readhub.App;
import cn.com.woong.readhub.R;
import cn.com.woong.readhub.bean.NewsMo;
import cn.com.woong.readhub.di.scope.PerFragment;

/**
 * Created by wong on 2018/3/9.
 */

public class NewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<NewsMo> mNewsMos = new ArrayList<>();

    @Inject
    public NewsAdapter(Context context) {
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(App.getAppContext()).inflate(R.layout.item_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((NewsViewHolder) holder).bind(mNewsMos.get(position));
    }

    @Override
    public int getItemCount() {
        return mNewsMos.size();
    }

    public void updateNews(ArrayList<NewsMo> newsMos, int page) {
        if (page == 1) {
            mNewsMos.clear();
        }

        mNewsMos.addAll(newsMos);
        notifyDataSetChanged();
    }
}
