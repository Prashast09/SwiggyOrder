package ethens.swiggy.network;

import ethens.swiggy.models.Variants;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ethens on 17/10/17.
 */

public interface HttpApiService {

  @GET("bins/3b0u2") Call<Variants> getVariant();
}
