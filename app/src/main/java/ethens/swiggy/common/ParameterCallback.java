package ethens.swiggy.common;

/**
 * Created by ethens on 17/10/17.
 */
public interface ParameterCallback<T, U> {
  void onResponse(T t, U u);
}
