package ethens.swiggy.adapter;

import android.view.View;
import ethens.swiggy.di.master.ComponentFactory;
import ethens.swiggy.models.Variant;
import ethens.swiggy.widget.BaseExpandableListViewHeader;
import java.util.List;

/**
 * Created by ethens on 18/10/17.
 */

public class VariantListHeaderViewHolder extends BaseExpandableListViewHeader<Variant> {

  public VariantListHeaderViewHolder(View convertView) {
    super(convertView);
    ComponentFactory.getInstance().getDashboardComponent().inject(this);
  }

  public void setDataToParentLayout(List<String> headers, int groupPosition, Variant mVariant,
      boolean isExpanded) {
    super.setDataToParentLayout(headers, groupPosition, mVariant, isExpanded);
    heading.setText(mVariant.getVariantGroups().get(groupPosition).getName());
  }
}
