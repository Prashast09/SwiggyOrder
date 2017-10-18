package ethens.swiggy.di.master;

import android.content.Context;
import dagger.Module;
import dagger.Provides;
import ethens.swiggy.activity.SwiggyApplication;
import javax.inject.Singleton;

/**
 * Created by ethens on 17/10/17.
 */
@Module public class AppModule {

  public SwiggyApplication swiggyApplication;

  public AppModule(SwiggyApplication swiggyApplication) {
    this.swiggyApplication = swiggyApplication;
  }

  @Provides @Singleton SwiggyApplication providesSwiggyApplication() {
    return swiggyApplication;
  }

  @Provides @Singleton Context providesContext() {
    return swiggyApplication.getApplicationContext();
  }
}
