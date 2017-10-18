package ethens.swiggy.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import ethens.swiggy.R;
import ethens.swiggy.adapter.VariantListAdapter;
import ethens.swiggy.di.master.ComponentFactory;
import ethens.swiggy.models.Variant;
import ethens.swiggy.models.Variants;
import ethens.swiggy.models.Variation;
import ethens.swiggy.network.HttpApiService;
import ethens.swiggy.widget.OneButtonSimpleDialog;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ethens on 18/10/17.
 */

public class DashboardActivityViewHolder {

  @Inject @Named("background") HttpApiService httpApiService;

  VariantListAdapter adapter;
  ExpandableListView expandableListView;
  LinearLayout submit;
  Variant variant;
  Map<String, Variation> mResponse = new HashMap<>();

  DashboardActivityViewHolder(AppCompatActivity appCompatActivity, View view) {
    expandableListView = view.findViewById(R.id.elv_variant);
    submit = view.findViewById(R.id.submit_ll);

    ComponentFactory.getInstance().getDashboardComponent().inject(this);
    httpApiService.getVariant().enqueue(new Callback<Variants>() {
      @Override public void onResponse(Call<Variants> call, Response<Variants> response) {
        variant = response.body().getVariant();
        adapter = new VariantListAdapter(variant, mResponse);
        expandableListView.setAdapter(adapter);
      }

      @Override public void onFailure(Call<Variants> call, Throwable t) {

      }
    });

    submit.setOnClickListener(view1 -> {
      Map<String, Variation> response = adapter.fetchResponse();
      if (response != null) {
        String message = convertToMessage(response);
        new OneButtonSimpleDialog("OK", appCompatActivity, "Order Summary", message);
      }
    });
  }

  private String convertToMessage(Map<String, Variation> mResponse) {
    String message = "";
    for (String category : mResponse.keySet()) {
      String dishName = mResponse.get(category).getName();
      message += String.format("\n Category : %s && Choice: %s \n", category, dishName);
    }
    return message;
  }
}
