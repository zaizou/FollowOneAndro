package followone.followone;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends android.support.v4.app.Fragment {

    boolean switcher;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((Button)this.getActivity().findViewById(R.id.btnCLick)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!switcher)
                    ((FollowOneMain) getActivity()).hideAppBar();
                else
                    ((FollowOneMain) getActivity()).showAppBar();
                switcher=!switcher;

            }
        });
    }


}
