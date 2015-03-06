package at.markushi.circlebutton.example;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import at.markushi.ui.CircleButton;

public class MainActivity extends ActionBarActivity {

    static int checkedCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceholderFragment()).commit();
        }
    }

    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            rootView.findViewById(R.id.button0).setOnClickListener(this);
            rootView.findViewById(R.id.button1).setOnClickListener(this);
            rootView.findViewById(R.id.button2).setOnClickListener(this);

            // Two checkable buttons, wired up so only first/last on/off is animated
            rootView.findViewById(R.id.buttoncheck0).setOnClickListener(new CheckableListener());
            rootView.findViewById(R.id.buttoncheck1).setOnClickListener(new CheckableListener());

            return rootView;
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), "Button clicked", Toast.LENGTH_SHORT).show();
        }

        public static class CheckableListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                CircleButton cb = (CircleButton) v;

                if (!cb.getChecked()) {
                    checkedCount++;
                    cb.setCheckAnimation((checkedCount == 1));
                } else {
                    cb.setCheckAnimation((checkedCount == 1));
                    checkedCount--;
                }

                cb.setChecked(!cb.getChecked());
            }
        }
    }
}
