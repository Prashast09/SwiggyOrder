package ethens.swiggy.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ethens on 18/10/17.
 */

public class Variants {

  @SerializedName("variants") Variant variant;

  public Variant getVariant() {
    return variant;
  }

  public void setVariant(Variant variant) {
    this.variant = variant;
  }
}
