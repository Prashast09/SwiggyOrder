package ethens.swiggy.adapter;

import android.content.Context;
import android.view.View;
import ethens.swiggy.common.ParameterCallback;
import ethens.swiggy.di.master.ComponentFactory;
import ethens.swiggy.models.Variation;
import ethens.swiggy.widget.BaseExpandableListChild;
import javax.inject.Inject;

/**
 * Created by ethens on 18/10/17.
 */

public class VariantListChildViewHolder extends BaseExpandableListChild<Variation, String> {

  @Inject Context context;

  public VariantListChildViewHolder(View variationCardLl) {
    super(variationCardLl);
    ComponentFactory.getInstance().getDashboardComponent().inject(this);
  }

  @Override public void setOnlyDataToViews(Variation variation) {
    variantName.setText(variation.getName());
    variantPrice.setText(String.valueOf(variation.getPrice()));
    String availability = variation.getInStock() > 0 ? "Available" : "Sold Out";
    inStock.setText(availability);
    button.setText(variation.getState());

    changeButtonText(variation);
  }

  @Override
  public void attachListener(Variation variation, ParameterCallback<Variation, String> callback) {
    button.setOnClickListener(view -> {

      String status = button.getText().equals("ADD") ? "ACTIVE" : "NOT_ACTIVE";

      callback.onResponse(variation, status);
    });
  }

  public void changeButtonText(Variation variation) {
    if (variation.getState() == null || variation.getState().equals("NOT_ACTIVE")) {
      button.setText("ADD");
    } else {
      button.setText("REMOVE");
    }
  }
}
