package progweb3.acontecenacidade;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import progweb3.acontecenacidade.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventoFragment extends Fragment {


    public EventoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_evento, container, false);
    }

}
