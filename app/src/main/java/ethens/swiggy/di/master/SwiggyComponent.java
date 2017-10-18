package ethens.swiggy.di.master;

import dagger.Component;
import ethens.swiggy.di.dashboard.DashboardComponent;
import ethens.swiggy.di.dashboard.DashboardModule;
import ethens.swiggy.di.http.HttpModule;
import javax.inject.Singleton;

/**
 * Created by ethens on 17/10/17.
 */

@Singleton @Component(modules = AppModule.class) public interface SwiggyComponent {

  DashboardComponent plus(DashboardModule dashboardModule, HttpModule httpModule);
}
