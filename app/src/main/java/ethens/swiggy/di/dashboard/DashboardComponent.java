package ethens.swiggy.di.dashboard;

import dagger.Subcomponent;
import ethens.swiggy.activity.DashboardActivity;
import ethens.swiggy.activity.DashboardActivityViewHolder;
import ethens.swiggy.adapter.VariantListAdapter;
import ethens.swiggy.adapter.VariantListChildViewHolder;
import ethens.swiggy.adapter.VariantListHeaderViewHolder;
import ethens.swiggy.di.http.HttpModule;

/**
 * Created by ethens on 17/10/17.
 */
@Subcomponent(modules = { DashboardModule.class, HttpModule.class }) @DashboardScope
public interface DashboardComponent {

  void inject(DashboardActivity dashboardActivity);

  void inject(VariantListAdapter variantListAdapter);

  void inject(VariantListHeaderViewHolder variantListHeaderViewHolder);

  void inject(VariantListChildViewHolder variantListChildViewHolder);

  void inject(DashboardActivityViewHolder dashboardActivityViewHolder);
}

