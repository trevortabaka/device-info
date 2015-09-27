package info.trevortabaka.deviceinfo;

import dagger.Component;
import info.trevortabaka.deviceinfo.ui.MainActivity;

@Component(modules = {ApisModule.class})
public interface MainComponent {
    void inject(MainActivity activity);
}
