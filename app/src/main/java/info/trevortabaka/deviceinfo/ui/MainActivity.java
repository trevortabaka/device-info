package info.trevortabaka.deviceinfo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

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

        ListView list = (ListView) findViewById(R.id.list);
        adapter = new ApiListAdapter(this, apis);
        list.setAdapter(adapter);
        adapter.sort(SortingStrategies.API_LEVEL);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
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
}
