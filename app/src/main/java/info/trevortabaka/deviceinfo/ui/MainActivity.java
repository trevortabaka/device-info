package info.trevortabaka.deviceinfo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import info.trevortabaka.deviceinfo.AndroidModule;
import info.trevortabaka.deviceinfo.DaggerMainComponent;
import info.trevortabaka.deviceinfo.R;
import info.trevortabaka.deviceinfo.api.Api;

public class MainActivity extends AppCompatActivity {

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
        ListAdapter adapter = new ApiListAdapter(this, apis);
        list.setAdapter(adapter);
    }

}
