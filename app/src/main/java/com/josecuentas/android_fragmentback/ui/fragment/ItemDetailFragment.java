package com.josecuentas.android_fragmentback.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.josecuentas.android_fragmentback.R;
import com.josecuentas.android_fragmentback.ui.fragment.dummy.DummyContent;

public class ItemDetailFragment extends Fragment {
    // The request code must be 0 or greater.
    private static final int PLUS_ONE_REQUEST_CODE = 0;
    // The URL to +1.  Must be a valid URL.
    private final String PLUS_ONE_URL = "http://developer.android.com";
    // TODO: Rename and change types of parameters
    private TextView mTviTitle, mTviMessage;
    private Button mButAtras;
    private DummyContent.DummyItem dummyItem;

    public ItemDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PlusOneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemDetailFragment newInstance(String param1, String param2) {
        ItemDetailFragment fragment = new ItemDetailFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dummyItem = (DummyContent.DummyItem) getArguments().getSerializable("body");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plus_one, container, false);
        //Find the +1 button
        mTviTitle = (TextView) view.findViewById(R.id.tviTitle);
        mTviMessage = (TextView) view.findViewById(R.id.tviMessage);
        mButAtras = (Button) view.findViewById(R.id.butAtras);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Refresh the state of the +1 button each time the activity receives focus.
        mTviTitle.setText(dummyItem.id);
        mTviMessage.setText(dummyItem.details);
        mButAtras.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
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
}
