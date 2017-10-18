package ethens.swiggy.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 * Created by ethens on 17/10/17.
 */

public class VariantGroup {

  @SerializedName("group_id") long groupId;
  String name;
  ArrayList<Variation> variations;

  public long getGroupId() {
    return groupId;
  }

  public void setGroupId(long groupId) {
    this.groupId = groupId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<Variation> getVariations() {
    return variations;
  }

  public void setVariations(ArrayList<Variation> variations) {
    this.variations = variations;
  }
}
