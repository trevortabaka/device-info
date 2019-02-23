package info.trevortabaka.deviceinfo.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import info.trevortabaka.deviceinfo.R;
import info.trevortabaka.deviceinfo.api.Api;

class ApiListAdapter extends RecyclerView.Adapter<ApiListAdapter.Holder> {
    private static final int LAYOUT_ID = R.layout.item_row;

    private final LayoutInflater layoutInflater;
    private final Object lock = new Object();
    private List<Api> items;
    private List<Api> originalItems;
    private ApiFilter filter;

    ApiListAdapter(Context context, List<Api> objects) {
        items = objects;
        layoutInflater = LayoutInflater.from(context);
    }

    Filter getFilter() {
        if (filter == null) {
            filter = new ApiFilter();
        }
        return filter;
    }

    private Api getItem(int position) {
        return items.get(position);
    }

    void sort(Comparator<? super Api> comparator) {
        synchronized (lock) {
            if (originalItems != null) {
                Collections.sort(originalItems, comparator);
            }
            Collections.sort(items, comparator);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(LAYOUT_ID, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.update(getItem(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class Holder extends RecyclerView.ViewHolder {
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
        private final TextView name;
        private final TextView humanReadableValue;
        private final TextView value;
        private final TextView apiLevel;
        private final TextView className;

        Holder(View view) {
            super(view);
            className = view.findViewById(R.id.class_name);
            name = view.findViewById(R.id.name);
            value = view.findViewById(R.id.value);
            humanReadableValue = view.findViewById(R.id.human_readable_value);
            apiLevel = view.findViewById(R.id.api_level);
        }

        void update(Api api) {
            className.setText(api.getClassName());
            name.setText(api.getName());
            humanReadableValue.setText(api.getHumanReadableValue());
            value.setText(api.getValue());
            apiLevel.setText(String.valueOf(api.getApiLevel()));
            int backgroundColor = itemView.getContext().getResources().getColor(colors[api.getApiLevel()]);
            itemView.setBackgroundColor(backgroundColor);
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
                String humanReadableValue = api.getHumanReadableValue();
                if (api.getClassName().toLowerCase().contains(charSequence)
                        || api.getName().toLowerCase().contains(charSequence)
                        || api.getValue().toLowerCase().contains(charSequence)
                        || (humanReadableValue != null && humanReadableValue.toLowerCase().contains(charSequence))) {
                    list.add(api);
                }
            }
            return list;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            items = (List<Api>) filterResults.values;
            notifyDataSetChanged();
        }
    }
}
