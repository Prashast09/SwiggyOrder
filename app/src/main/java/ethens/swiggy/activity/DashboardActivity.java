package ethens.swiggy.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import ethens.swiggy.R;
import ethens.swiggy.common.BaseActivity;
import ethens.swiggy.di.master.ComponentFactory;

/**
 * Created by ethens on 17/10/17.
 */

public class DashboardActivity extends BaseActivity {

  DashboardActivityViewHolder dashboardActivityViewHolder;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setupUI(R.layout.activity_dashboard, R.id.layout_dashboard);
  }

  @Override public void setupComponent() {
    ComponentFactory.getInstance().getDashboardComponent(this).inject(this);
  }

  @Override protected void setupViewHolder(View view) {
    dashboardActivityViewHolder = new DashboardActivityViewHolder(this, view);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    ComponentFactory.getInstance().removeDashboardComponent();
  }
}
