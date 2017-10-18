package ethens.swiggy.widget;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import ethens.swiggy.R;
import ethens.swiggy.common.ParameterCallback;

/**
 * Created by ethens on 17/10/17.
 */

public abstract class BaseExpandableListChild<T, U> extends RecyclerView.ViewHolder {
  public View variantCard;
  protected TextView variantName;
  protected TextView variantPrice;
  protected TextView inStock;
  protected Button button;

  public BaseExpandableListChild(View variantCardLl) {
    super(variantCardLl);
    variantName = variantCardLl.findViewById(R.id.variant_name);
    variantPrice = variantCardLl.findViewById(R.id.variant_price);
    inStock = variantCardLl.findViewById(R.id.in_stock);
    button = variantCardLl.findViewById(R.id.button);
    variantCard = variantCardLl;
  }

  public abstract void setOnlyDataToViews(T dataToSet);

  public void setDataToViewAndAttachListener(T data, ParameterCallback<T, U> callback) {
    setOnlyDataToViews(data);
    attachListener(data, callback);
  }

  public abstract void attachListener(T dataToSet, ParameterCallback<T, U> callback);
}
