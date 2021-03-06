package ru.gkkdev.x.dynamicimage.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

import ru.gkkdev.x.dynamicimage.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link three_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link three_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class three_fragment extends Fragment {

    ImageView imageView;
    Timer timer;
    int iImageCount = 0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public three_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment three_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static three_fragment newInstance(String param1, String param2) {
        three_fragment fragment = new three_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.first_fragment, container, false);

        timer = new Timer();
        timer.schedule(new UpdateTimeTask(), 0, 30000); //тикаем 30 секунд без задержки

        imageView = (ImageView) v.findViewById(R.id.imageView);

        return v;
    }

    class UpdateTimeTask extends TimerTask {
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    // Stuff that updates the UI
                    iImageCount++;
                    if(iImageCount == 1) {
                        imageView.setImageResource(R.drawable.afrika_2);
                    } else if(iImageCount == 2) {
                        imageView.setImageResource(R.drawable.afrika_3);
                    } else if(iImageCount >= 3) {
                        timer.cancel();
                    }
                }
            });

        }
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
