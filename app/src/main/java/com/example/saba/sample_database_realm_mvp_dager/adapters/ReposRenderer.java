package com.example.saba.sample_database_realm_mvp_dager.adapters;

import android.annotation.SuppressLint;
import android.widget.TextView;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.GitHubRepo;
import com.zuluft.autoadapter.renderables.Renderer;
import com.zuluft.autoadapterannotations.Render;
import com.zuluft.autoadapterannotations.ViewField;
import com.zuluft.generated.ReposRendererViewHolder;

import javax.annotation.Nonnull;

@Render(layout = R.layout.repo_item,
        views = {
                @ViewField(
                        id = R.id.list_name,
                        name = "name",
                        type = TextView.class),
                @ViewField(
                        id = R.id.list_desc,
                        name = "desc",
                        type = TextView.class),
                @ViewField(
                        id = R.id.list_language,
                        name = "language",
                        type = TextView.class),
                @ViewField(
                        id = R.id.list_stars,
                        name = "stars",
                        type = TextView.class),
                @ViewField(
                        id = R.id.list_id,
                        name = "id",
                        type = TextView.class)
        })
public class ReposRenderer extends Renderer<ReposRendererViewHolder>{

        @Nonnull
        public GitHubRepo repo;

        public ReposRenderer(@Nonnull final GitHubRepo gitHubRepo) { this.repo = gitHubRepo; }

        @SuppressLint("SetTextI18n")
        @Override
        public void apply(ReposRendererViewHolder viewHolder) {
                viewHolder.name.setText(repo.getName());
                viewHolder.language.setText(repo.getLanguage());
                viewHolder.stars.setText(Integer.toString(repo.getStarCount()));
                viewHolder.desc.setText(repo.getDescription());
                viewHolder.id.setText(Integer.toString(repo.getId()));
        }
}
