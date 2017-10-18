package ethens.swiggy.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ethens on 17/10/17.
 */

public class ExclusionItem {

  @SerializedName("variation_id") long variationId;
  @SerializedName("group_id") long groupId;
  private int flag;

  public int getFlag() {
    return flag;
  }

  public void setFlag(int flag) {
    this.flag = flag;
  }

  public long getVariationId() {
    return variationId;
  }

  public void setVariationId(long variationId) {
    this.variationId = variationId;
  }

  public long getGroupId() {
    return groupId;
  }

  public void setGroupId(long groupId) {
    this.groupId = groupId;
  }
}
