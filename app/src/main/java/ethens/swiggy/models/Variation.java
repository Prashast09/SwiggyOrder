package ethens.swiggy.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ethens on 17/10/17.
 */

public class Variation {

  String name;
  double price;
  @SerializedName("default") int defaultFlag;
  long id;
  int inStock;
  String state;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public int getDefaultFlag() {
    return defaultFlag;
  }

  public void setDefaultFlag(int defaultFlag) {
    this.defaultFlag = defaultFlag;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public int getInStock() {
    return inStock;
  }

  public void setInStock(int inStock) {
    this.inStock = inStock;
  }
}
