package aforandroid.usingpiechart;

import android.content.Context;

/**
 * Created by Ramya on 24/01/18.
 */

public class MyUtils {

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}