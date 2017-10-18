package ethens.swiggy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Toast;
import ethens.swiggy.R;
import ethens.swiggy.di.master.ComponentFactory;
import ethens.swiggy.models.ExclusionItem;
import ethens.swiggy.models.Variant;
import ethens.swiggy.models.VariantGroup;
import ethens.swiggy.models.Variation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by ethens on 18/10/17.
 */

public class VariantListAdapter extends BaseExpandableListAdapter {

  @Inject @Named("inflater") LayoutInflater layoutInflater;
  @Inject Context context;
  ArrayList<ArrayList<ExclusionItem>> allExclusionItems;
  private Variant mVariant;
  private List<String> headers;
  private Map<String, Variation> mResponse = new HashMap<>();

  public VariantListAdapter(Variant variant, Map<String, Variation> response) {
    response = this.mResponse;
    ComponentFactory.getInstance().getDashboardComponent().inject(this);
    allExclusionItems = variant.getExclusionPairses();
    addDataToAdapter(variant);
  }

  @Override public int getGroupCount() {
    return headers.size();
  }

  @Override public int getChildrenCount(int groupPosition) {
    return mVariant.getVariantGroups().get(groupPosition).getVariations().size();
  }

  @Override public Object getGroup(int groupPosition) {
    return headers.get(groupPosition);
  }

  @Override public Object getChild(int groupPosition, int childPosition) {
    return mVariant.getVariantGroups()
        .get(groupPosition)
        .getVariations()
        .get(getChildrenCount(groupPosition) - childPosition - 1);
  }

  @Override public long getGroupId(int groupPosition) {
    return mVariant.getVariantGroups().get(groupPosition).getGroupId();
  }

  @Override public long getChildId(int groupPosition, int childPosition) {
    return mVariant.getVariantGroups()
        .get(groupPosition)
        .getVariations()
        .get(getChildrenCount(groupPosition) - childPosition - 1)
        .getId();
  }

  @Override public boolean hasStableIds() {
    return true;
  }

  @Override public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
      ViewGroup parent) {
    VariantListHeaderViewHolder parentViewHolder;

    if (convertView == null) {
      convertView = layoutInflater.inflate(R.layout.item_variation_list_heading, parent, false);
      parentViewHolder = new VariantListHeaderViewHolder(convertView);
    } else {
      parentViewHolder = (VariantListHeaderViewHolder) convertView.getTag();
    }

    parentViewHolder.setDataToParentLayout(headers, groupPosition, mVariant, isExpanded);
    convertView.setTag(parentViewHolder);
    return convertView;
  }

  @Override public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
      View convertView, ViewGroup parent) {
    VariantListChildViewHolder holder;
    Variation childTransaction = ((Variation) getChild(groupPosition, childPosition));
    if (convertView == null) {
      convertView = layoutInflater.inflate(R.layout.item_variant_detail, parent, false);
      holder = new VariantListChildViewHolder(convertView);
      convertView.setTag(holder);
    } else {
      holder = (VariantListChildViewHolder) convertView.getTag();
    }

    holder.setDataToViewAndAttachListener(childTransaction, (variation, status) -> {

      if (!isAllItemsFlagged(groupPosition, childPosition)) {

        //check if status is active then add data to response and change variations data too
        if (status.equals("ACTIVE")) {
          if (mResponse.get(headers.get(groupPosition)) == null) {
            mResponse.put(headers.get(groupPosition), variation);
            ((Variation) getChild(groupPosition, childPosition)).setState(status);
          } else {
            Toast.makeText(context, "Already item added from this category", Toast.LENGTH_SHORT)
                .show();
          }
        } else {
          unFlagElement(groupPosition, childPosition);
          mResponse.remove(headers.get(groupPosition));
          ((Variation) getChild(groupPosition, childPosition)).setState(status);
        }

        notifyDataSetChanged();
      } else {
        Toast.makeText(context, "Sorry! Make some other choice", Toast.LENGTH_SHORT).show();
      }
    });

    convertView.setTag(holder);
    return convertView;
  }

  @Override public boolean isChildSelectable(int groupPosition, int childPosition) {
    return true;
  }

  public void setData(Variant variant) {
    addDataToAdapter(variant);
    notifyDataSetChanged();
  }

  public boolean isAllItemsFlagged(int groupPosition, int childPosition) {

    ExclusionItem temp = new ExclusionItem();

    for (ArrayList<ExclusionItem> exclusionItems : allExclusionItems) {
      int length = exclusionItems.size();

      int count = 0;

      for (ExclusionItem exclusionItem : exclusionItems) {
        if (exclusionItem.getGroupId() == getGroupId(groupPosition)
            && exclusionItem.getVariationId() == getChildId(groupPosition, childPosition)) {
          exclusionItem.setFlag(1);
          temp = exclusionItem;
        }
        count += exclusionItem.getFlag();
        if (count == length) {
          temp.setFlag(0);
          return true;
        }
      }
    }
    return false;
  }

  public void unFlagElement(int groupPosition, int childPosition) {
    for (ArrayList<ExclusionItem> exclusionItems : allExclusionItems) {
      for (ExclusionItem exclusionItem : exclusionItems) {
        if (exclusionItem.getGroupId() == getGroupId(groupPosition)
            && exclusionItem.getVariationId() == getChildId(groupPosition, childPosition)) {
          exclusionItem.setFlag(0);
        }
      }
    }
  }

  public Map<String, Variation> fetchResponse() {
    if (mResponse.size() == headers.size()) {
      return mResponse;
    } else {
      Toast.makeText(context, "Please make choice from all sections", Toast.LENGTH_SHORT).show();
    }
    return null;
  }

  private void addDataToAdapter(Variant variant) {
    this.mVariant = variant;
    headers = new ArrayList<>();
    for (VariantGroup variantGroup : mVariant.getVariantGroups())
      headers.add(variantGroup.getName());
  }
}
