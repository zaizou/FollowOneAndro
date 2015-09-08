package followone.followone;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class TestingAnimation extends Fragment {


    Button button;

    public TestingAnimation() {
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
        this.button=(Button)this.getActivity().findViewById(R.id.btnCLick);


    }


    public void btnClicked(View v){
        Animation animl= AnimationUtils.loadAnimation(this.getContext(),R.anim.txt_v_anim);
        this.button.startAnimation(animl);
    }


}
