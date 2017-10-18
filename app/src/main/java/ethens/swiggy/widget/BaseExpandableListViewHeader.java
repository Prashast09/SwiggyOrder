package ethens.swiggy.widget;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import ethens.swiggy.R;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by ethens on 17/10/17.
 */

public abstract class BaseExpandableListViewHeader<V> {
  protected CardView cv;
  protected ImageView indicator;
  protected TextView heading;
  @Inject Context context;

  public BaseExpandableListViewHeader(View view) {
    cv = view.findViewById(R.id.card);
    indicator = view.findViewById(R.id.indicator);
    heading = view.findViewById(R.id.name);
  }

  public void setDataToParentLayout(List<String> keyList, int groupPosition, V dataMap,
      boolean isExpanded) {
    if (isExpanded) {
      cv.setCardBackgroundColor(ContextCompat.getColor(context, R.color.cardview_dark_background));
      Picasso.with(context)
          .load(R.drawable.list_arrow_up_white)
          .placeholder(R.drawable.background_fill)
          .into(indicator);
    } else {
      cv.setCardBackgroundColor(ContextCompat.getColor(context, R.color.cardview_dark_background));
      Picasso.with(context)
          .load(R.drawable.list_arrow_down_white)
          .placeholder(R.drawable.background_fill)
          .into(indicator);
    }
  }
}
