package com.example.saba.sample_database_realm_mvp_dager.adapters;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.widget.TextView;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.responseModels.RepoModel;
import com.facebook.drawee.view.SimpleDraweeView;
import com.zuluft.autoadapter.renderables.OrderableRenderer;
import com.zuluft.autoadapterannotations.Render;
import com.zuluft.autoadapterannotations.ViewField;
import com.zuluft.generated.ReposRendererViewHolder;
import javax.annotation.Nonnull;

@Render(layout = R.layout.repo_item,
        views = {
                @ViewField(
                        id = R.id.list_avatar,
                        name = "avatar",
                        type = SimpleDraweeView.class),
                @ViewField(
                        id = R.id.list_user,
                        name = "user",
                        type = TextView.class),
                @ViewField(
                        id = R.id.list_name,
                        name = "name",
                        type = TextView.class),
                @ViewField(
                        id = R.id.list_language,
                        name = "language",
                        type = TextView.class),
                @ViewField(
                        id = R.id.list_stars,
                        name = "stars",
                        type = TextView.class)
        })
public class ReposRenderer extends OrderableRenderer<ReposRendererViewHolder> {

        @Nonnull
        public final RepoModel repo;

        public ReposRenderer(@Nonnull final RepoModel repoModel) { this.repo = repoModel; }

        @SuppressLint("SetTextI18n")
        @Override
        public void apply(ReposRendererViewHolder viewHolder) {
                viewHolder.avatar.setImageURI(Uri.parse(repo.getOwner().getAvatar()));
                viewHolder.user.setText(repo.getOwner().getLogin());
                viewHolder.name.setText(repo.getName());
                viewHolder.language.setText(repo.getLanguage());
                viewHolder.stars.setText(Integer.toString(repo.getStarCount()));
        }

        private RepoModel getRepo(@Nonnull final OrderableRenderer orderableRenderer){
                return ((ReposRenderer)orderableRenderer).repo;
        }

        @Override
        public int compareTo(@NonNull OrderableRenderer renderer) {
                return Integer.compare(getRepo(renderer).getStarCount(),repo.getStarCount());
        }

        @Override
        public boolean areContentsTheSame(@NonNull OrderableRenderer renderer) {
                return Integer.valueOf(repo.getId()).equals(getRepo(renderer).getId());
        }

        @Override
        public boolean areItemsTheSame(@NonNull OrderableRenderer renderer) {
                return Integer.valueOf(repo.getId()).equals(getRepo(renderer).getId());
        }
}
