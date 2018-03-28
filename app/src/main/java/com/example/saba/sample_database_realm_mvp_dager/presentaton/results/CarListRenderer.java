package com.example.saba.sample_database_realm_mvp_dager.presentaton.results;


import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.widget.TextView;
import com.example.saba.sample_database_realm_mvp_dager.R;
import com.example.saba.sample_database_realm_mvp_dager.domain.models.CarModel;
import com.zuluft.autoadapter.renderables.Renderer;
import com.zuluft.autoadapterannotations.Render;
import com.zuluft.autoadapterannotations.ViewField;
import com.zuluft.generated.CarListRendererViewHolder;

@Render(layout = R.layout.recycler_view_item,
        views = {
                @ViewField(
                        id = R.id.list_mark,
                        name = "mark",
                        type = TextView.class),
                @ViewField(
                        id = R.id.list_model,
                        name = "model",
                        type = TextView.class),
                @ViewField(
                        id = R.id.list_type,
                        name = "type",
                        type = TextView.class),
                @ViewField(
                        id = R.id.list_country,
                        name = "country",
                        type = TextView.class),
                @ViewField(
                        id = R.id.list_id,
                        name = "id",
                        type = TextView.class)
        })
public class CarListRenderer extends Renderer<CarListRendererViewHolder> {

        private final CarModel car;

        CarListRenderer(final CarModel car) {
                this.car = car;
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void apply(@NonNull final CarListRendererViewHolder viewHolder) {
                viewHolder.mark.setText(car.getMark());
                viewHolder.model.setText(car.getModel());
                viewHolder.type.setText(car.getType());
                viewHolder.country.setText(car.getCountry());
                viewHolder.id.setText(Integer.toString(car.getId()));
        }
}

