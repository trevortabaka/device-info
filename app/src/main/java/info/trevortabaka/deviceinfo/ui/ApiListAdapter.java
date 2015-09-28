package info.trevortabaka.deviceinfo.ui;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
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
    private final Object lock = new Object();
    private List<Api> items;
    private List<Api> originalItems;
    private ApiFilter filter;

    public ApiListAdapter(Context context, List<Api> objects) {
        super(context, LAYOUT_ID);
        items = objects;
        layoutInflater = LayoutInflater.from(context);
        resources = context.getResources();
    }

    @Override
    public Filter getFilter() {
        if (filter == null) {
            filter = new ApiFilter();
        }
        return filter;
    }

    @Override
    public Api getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public void sort(Comparator<? super Api> comparator) {
        synchronized (lock) {
            if (originalItems != null) {
                Collections.sort(originalItems, comparator);
            } else {
                Collections.sort(items, comparator);
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = createView(parent);
        }

        Api api = getItem(position);

        Holder holder = (Holder) convertView.getTag();
        holder.update(api);

        int backgroundColor = resources.getColor(colors[api.getApiLevel()]);
        convertView.setBackgroundColor(backgroundColor);

        return convertView;
    }

    @NonNull
    private View createView(ViewGroup parent) {
        View view = layoutInflater.inflate(LAYOUT_ID, parent, false);
        Holder holder = new Holder(view);
        view.setTag(holder);
        return view;
    }

    private static class Holder {
        private final TextView name;
        private final TextView humanReadableValue;
        private final TextView value;
        private final TextView apiLevel;
        private final TextView className;

        public Holder(View view) {
            className = (TextView) view.findViewById(R.id.class_name);
            name = (TextView) view.findViewById(R.id.name);
            value = (TextView) view.findViewById(R.id.value);
            humanReadableValue = (TextView) view.findViewById(R.id.human_readable_value);
            apiLevel = (TextView) view.findViewById(R.id.api_level);
        }

        public void update(Api api) {
            className.setText(api.getClassName());
            name.setText(api.getName());
            humanReadableValue.setText(api.getHumanReadableValue());
            value.setText(api.getValue());
            apiLevel.setText(String.valueOf(api.getApiLevel()));
        }
    }

    private class ApiFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<Api> list;

            copyOriginalItemsDuringFirstFilter();

            if (TextUtils.isEmpty(charSequence)) {
                list = getCopyOfOriginalItems();
            } else {
                list = getFilteredItems(charSequence);
            }

            FilterResults results = new FilterResults();
            results.values = list;
            results.count = list.size();
            return results;
        }

        private void copyOriginalItemsDuringFirstFilter() {
            synchronized (lock) {
                if (originalItems == null) {
                    originalItems = new ArrayList<>(items);
                }
            }
        }

        @NonNull
        private ArrayList<Api> getCopyOfOriginalItems() {
            synchronized (lock) {
                return new ArrayList<>(originalItems);
            }
        }

        @NonNull
        private ArrayList<Api> getFilteredItems(CharSequence charSequence) {
            ArrayList<Api> list = new ArrayList<>();

            ArrayList<Api> copyToSearch = getCopyOfOriginalItems();

            charSequence = charSequence.toString().toLowerCase();

            for (Api api : copyToSearch) {
                if (api.getClassName().toLowerCase().contains(charSequence)
                        || api.getName().toLowerCase().contains(charSequence)
                        || api.getValue().toLowerCase().contains(charSequence)
                        || api.getHumanReadableValue().toLowerCase().contains(charSequence)) {
                    list.add(api);
                }
            }
            return list;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            items = (List<Api>) filterResults.values;
            if (filterResults.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }
    }
}
