package info.trevortabaka.deviceinfo.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
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
    private final List<Api> items;

    public ApiListAdapter(Context context, List<Api> items) {
        super(context, LAYOUT_ID);
        this.items = createCachedList(items);
        layoutInflater = LayoutInflater.from(context);
        resources = context.getResources();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Api getItem(int position) {
        return items.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = createView(parent);
        }

        Api api = getItem(position);

        Holder holder = (Holder) convertView.getTag();
        holder.name.setText(api.getName());
        holder.value.setText(api.getValue());
        holder.api.setText(String.valueOf(api.getApiLevel()));

        int backgroundColor = resources.getColor(colors[api.getApiLevel()]);
        convertView.setBackgroundColor(backgroundColor);

        return convertView;
    }

    @NonNull
    private View createView(ViewGroup parent) {
        View view = layoutInflater.inflate(LAYOUT_ID, parent, false);
        Holder holder = new Holder();
        holder.name = (TextView) view.findViewById(R.id.name);
        holder.value = (TextView) view.findViewById(R.id.value);
        holder.api = (TextView) view.findViewById(R.id.api_level);
        view.setTag(holder);
        return view;
    }

    private List<Api> createCachedList(List<Api> objects) {
        List<Api> cacheApi = new ArrayList<>(objects.size());
        for (Api object : objects) {
            cacheApi.add(new CachedApi(object));
        }
        return cacheApi;
    }

    private static class Holder {
        TextView name;
        TextView value;
        TextView api;
    }

    private static class CachedApi implements Api {
        private String cached;
        private Api api;

        public CachedApi(Api api) {
            this.api = api;
        }

        @Override
        public int getApiLevel() {
            return api.getApiLevel();
        }

        @Override
        public String getName() {
            return api.getName();
        }

        @Override
        public String getValue() {
            if (cached == null) {
                cached = api.getValue();
            }
            return cached;
        }
    }
}
