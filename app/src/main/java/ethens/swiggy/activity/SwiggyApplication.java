package ethens.swiggy.activity;

import android.app.Application;
import ethens.swiggy.di.master.ComponentFactory;

public class SwiggyApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
    ComponentFactory.getInstance().initializeComponent(this);
  }
}
