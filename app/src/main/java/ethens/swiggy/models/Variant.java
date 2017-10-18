package ethens.swiggy.models;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/**
 * Created by ethens on 17/10/17.
 */

public class Variant {

  @SerializedName("variant_groups") ArrayList<VariantGroup> variantGroups;
  @SerializedName("exclude_list") ArrayList<ArrayList<ExclusionItem>> exclusionPairses;

  public ArrayList<ArrayList<ExclusionItem>> getExclusionPairses() {
    return exclusionPairses;
  }

  public void setExclusionPairses(ArrayList<ArrayList<ExclusionItem>> exclusionPairses) {
    this.exclusionPairses = exclusionPairses;
  }

  public ArrayList<VariantGroup> getVariantGroups() {
    return variantGroups;
  }

  public void setVariantGroups(ArrayList<VariantGroup> variantGroups) {
    this.variantGroups = variantGroups;
  }
}
