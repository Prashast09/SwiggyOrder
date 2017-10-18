/*
 *
 *  * Copyright (c) N2Tech Pvt. Ltd. - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by N2Tech 14/3/2017
 *
 */

package ethens.swiggy.widget;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;

/**
 * Created by ethens on 17/10/17.
 */

public class OneButtonSimpleDialog {

  public OneButtonSimpleDialog(String positiveMessage, AppCompatActivity activity, String title,
      String message) {
    AlertDialog dialog = getDialog(activity, title, message).setPositiveButton(positiveMessage,
        (dialog1, which) -> dialog1.dismiss()).create();
    dialog.show();
  }

  private AlertDialog.Builder getDialog(AppCompatActivity activity, String title, String message) {
    return new AlertDialog.Builder(activity).setTitle(
        Html.fromHtml("<font color='#000000'>" + title + "</font>"))
        .setMessage(Html.fromHtml("<font color='#000000'>" + message + "</font>"));
  }
}
