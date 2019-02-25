/*
Copyright (C) 2019 Trevor Tabaka

This file is part of Device Info.

Device Info is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Device Info is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Device Info.  If not, see <https://www.gnu.org/licenses/>.
*/
package info.trevortabaka.deviceinfo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.List;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.AndroidModule;
import info.trevortabaka.deviceinfo.DaggerMainComponent;
import info.trevortabaka.deviceinfo.R;
import info.trevortabaka.deviceinfo.api.Api;

public class MainActivity extends AppCompatActivity {
    private ApiListAdapter adapter;

    @Inject
    List<Api> apis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        DaggerMainComponent.builder()
                .androidModule(new AndroidModule(this))
                .build()
                .inject(this);

        adapter = new ApiListAdapter(this, apis);
        adapter.sort(SortingStrategies.API_LEVEL);
        RecyclerView list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        setupSearchView(menu.findItem(R.id.search));
        return super.onCreateOptionsMenu(menu);
    }

    private void setupSearchView(MenuItem item) {
        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchOnQueryTextListener());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_sort_api_level:
                adapter.sort(SortingStrategies.API_LEVEL);
                return true;
            case R.id.action_sort_api_name:
                adapter.sort(SortingStrategies.API_NAME);
                return true;
            case R.id.action_sort_class_name:
                adapter.sort(SortingStrategies.CLASS_NAME);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class SearchOnQueryTextListener implements SearchView.OnQueryTextListener {
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            adapter.getFilter().filter(newText);
            return false;
        }
    }
}
