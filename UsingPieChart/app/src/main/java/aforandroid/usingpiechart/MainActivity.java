package aforandroid.usingpiechart;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
/**
 * Created by Ramya on 24/01/18.
 */

public class MainActivity extends Activity {
    TextView txtinfo;
    LinearLayout lvOne, lvTwo, lvparent;
    TextView txtOne, txtTwo;
    PieView pieView;

    String[] projsoftware = new String[] { "Android Studio", "Eclipse (ADT)" };
    int[] percentage = new int[] { 80, 20};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pieView = (PieView) findViewById(R.id.pie_view);

        lvOne = (LinearLayout) findViewById(R.id.lvOne);
        lvTwo = (LinearLayout) findViewById(R.id.lvTwo);

        lvparent = (LinearLayout) findViewById(R.id.lvparent);

        txtOne = (TextView) findViewById(R.id.txtOne);
        txtTwo = (TextView) findViewById(R.id.txtTwo);

        set(pieView);
    }


    private void set(PieView pieView) {
        ArrayList<PieHelper> pieHelperArrayList = new ArrayList<PieHelper>();

        int color0 = Color.rgb(14, 214, 115);
        int color1 = Color.rgb(247, 39, 115);

        pieHelperArrayList.add(new PieHelper(80, color0));
        pieHelperArrayList.add(new PieHelper(20, color1));

        lvOne.setBackgroundColor(color0);
        txtOne.setText(projsoftware[0].toString());
        lvTwo.setBackgroundColor(color1);
        txtTwo.setText(projsoftware[1]);


        pieView.setDate(pieHelperArrayList);
        pieView.setOnPieClickListener(new PieView.OnPieClickListener() {
            @Override
            public void onPieClick(int index) {
                if (index != PieView.NO_SELECTED_INDEX) {
                    txtinfo.setText(percentage[index] + "% owns "
                            + projsoftware[index] + ".");
                } else {
                    txtinfo.setText("No selected pie");
                }
            }
        });
    }
}