package ethens.swiggy.di.master;

import android.support.v7.app.AppCompatActivity;
import ethens.swiggy.activity.SwiggyApplication;
import ethens.swiggy.di.dashboard.DashboardComponent;
import ethens.swiggy.di.dashboard.DashboardModule;
import ethens.swiggy.di.http.HttpModule;

/**
 * Created by ethens on 17/10/17.
 */

public class ComponentFactory {
  public static ComponentFactory componentFactory;
  public SwiggyComponent swiggyComponent;
  public DashboardComponent dashboardComponent;

  public static ComponentFactory getInstance() {
    if (componentFactory == null) {
      componentFactory = new ComponentFactory();
    }

    return componentFactory;
  }

  public ComponentFactory initializeComponent(SwiggyApplication swiggyApplication) {
    swiggyComponent = DaggerSwiggyComponent.builder()
        // This also corresponds to the name of your module: %component_name%Module
        .appModule(new AppModule(swiggyApplication)).build();
    return componentFactory;
  }

  public SwiggyComponent getSwiggyComponent() {
    return swiggyComponent;
  }

  public DashboardComponent getDashboardComponent(AppCompatActivity appCompatActivity) {
    if (dashboardComponent == null) {
      dashboardComponent =
          getSwiggyComponent().plus(new DashboardModule(appCompatActivity), new HttpModule());
    }
    return dashboardComponent;
  }

  public DashboardComponent getDashboardComponent() {
    return dashboardComponent;
  }

  public void removeDashboardComponent() {
    dashboardComponent = null;
  }
}
