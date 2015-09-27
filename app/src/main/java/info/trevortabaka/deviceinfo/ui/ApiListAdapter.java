package info.trevortabaka.deviceinfo.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.Comparator;
import java.util.List;

import info.trevortabaka.deviceinfo.R;
import info.trevortabaka.deviceinfo.api.Api;

class ApiListAdapter extends ArrayAdapter<Api> {
    private static final int LAYOUT_ID = R.layout.item_row;
    private static final int[] colors = {
            0,
            R.color.base,
            R.color.base_1_1,
            R.color.cupcake,
            R.color.donut,
            R.color.eclair,
            R.color.eclair_0_1,
            R.color.eclair_mr1,
            R.color.froyo,
            R.color.gingerbread,
            R.color.gingerbread_mr1,
            R.color.honeycomb,
            R.color.honeycomb_mr1,
            R.color.honeycomb_mr2,
            R.color.ice_cream_sandwich,
            R.color.ice_cream_sandwich_mr1,
            R.color.jelly_bean,
            R.color.jelly_bean_mr1,
            R.color.jelly_bean_mr2,
            R.color.kitkat,
            R.color.kitkat_watch,
            R.color.lollipop,
            R.color.lollipop_mr1,
            R.color.marshmallow
    };
    private final LayoutInflater layoutInflater;
    private final Resources resources;

    public ApiListAdapter(Context context, List<Api> objects) {
        super(context, LAYOUT_ID, objects);
        layoutInflater = LayoutInflater.from(context);
        resources = context.getResources();
    }

    @Override
    public void sort(Comparator<? super Api> comparator) {
        super.sort(comparator);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = createView(parent);
        }

        Api api = getItem(position);

        Holder holder = (Holder) convertView.getTag();
        holder.className.setText(api.getClassName());
        holder.name.setText(api.getName());
        holder.value.setText(api.getHumanReadableValue() + " (" + api.getValue() + ")");
        holder.api.setText(String.valueOf(api.getApiLevel()));

        int backgroundColor = resources.getColor(colors[api.getApiLevel()]);
        convertView.setBackgroundColor(backgroundColor);

        return convertView;
    }

    @NonNull
    private View createView(ViewGroup parent) {
        View view = layoutInflater.inflate(LAYOUT_ID, parent, false);
        Holder holder = new Holder();
        holder.className = (TextView)view.findViewById(R.id.class_name);
        holder.name = (TextView) view.findViewById(R.id.name);
        holder.value = (TextView) view.findViewById(R.id.value);
        holder.api = (TextView) view.findViewById(R.id.api_level);
        view.setTag(holder);
        return view;
    }

    private static class Holder {
        TextView name;
        TextView value;
        TextView api;
        TextView className;
    }
}
