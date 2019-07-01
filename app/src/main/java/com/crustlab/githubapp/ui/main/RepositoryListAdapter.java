package com.crustlab.githubapp.ui.main;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.crustlab.githubapp.R;
import com.crustlab.githubapp.model.Repository;

public class RepositoryListAdapter extends
        RecyclerView.Adapter<RepositoryListAdapter.RepositoryHolder> {

    private final List<Repository> repositoryList;
    private final LayoutInflater inflater;
    private LongClickListener longClickListener;

    interface LongClickListener {

        boolean onLongClick(Repository repository);
    }

    class RepositoryHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_repo_name)
        TextView tvRepoName;

        @BindView(R.id.tv_repo_url)
        TextView tvRepoUrl;

        @BindView(R.id.tv_repo_created_date)
        TextView tvRepoCreatedDate;

        RepositoryHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    RepositoryListAdapter(Context context) {
        this.repositoryList = new ArrayList<>();
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RepositoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RepositoryHolder(inflater.inflate(R.layout.item_repo, parent, false));
    }

    @Override
    public void onBindViewHolder(RepositoryHolder holder, int position) {
        Repository repository = repositoryList.get(position);
        holder.tvRepoName.setText(repository.getName());
        holder.tvRepoUrl.setText(repository.getUrl());
        holder.tvRepoCreatedDate.setText(repository.getCreated());
        holder.itemView.setOnLongClickListener(view -> longClickListener.onLongClick(repository));
    }

    @Override
    public int getItemCount() {
        return repositoryList.size();
    }

    public void updateRepositoryList(List<Repository> repositories) {
        repositoryList.clear();
        repositoryList.addAll(repositories);
        notifyDataSetChanged();
    }

    public void setLongClickListener(LongClickListener longClickListener) {
        this.longClickListener = longClickListener;
    }
}
