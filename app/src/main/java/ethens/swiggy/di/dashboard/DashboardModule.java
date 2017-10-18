package ethens.swiggy.di.dashboard;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

/**
 * Created by ethens on 17/10/17.
 */

@Module public class DashboardModule {

  public AppCompatActivity activity;

  public DashboardModule(AppCompatActivity activity) {
    this.activity = activity;
  }

  @Provides @Named("inflater") public LayoutInflater getLayoutInflater() {
    return activity.getLayoutInflater();
  }
}
