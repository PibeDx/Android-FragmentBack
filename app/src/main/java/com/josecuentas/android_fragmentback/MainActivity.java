package com.josecuentas.android_fragmentback;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.josecuentas.android_fragmentback.ui.fragment.ItemFragment;
import com.josecuentas.android_fragmentback.ui.fragment.ItemDetailFragment;
import com.josecuentas.android_fragmentback.ui.fragment.dummy.DummyContent;

public class MainActivity extends AppCompatActivity
        implements ItemFragment.OnListFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private int mNumero = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ItemDetailFragment plusOneFragment = new ItemDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("title", mNumero++);
        plusOneFragment.setArguments(bundle);
        ft.replace(R.id.rlaContainer, ItemFragment.newInstance(2));
        ft.commit();
    }

    @Override protected void onResume() {
        super.onResume();
    }

    @Override public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.d(TAG, "onListFragmentInteraction() called with: item = [" + item + "]");
        FragmentManager fm= getSupportFragmentManager();
        FragmentTransaction ft= fm.beginTransaction();
        ItemDetailFragment plusOneFragment = new ItemDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("body", item);
        plusOneFragment.setArguments(bundle);
        ft.replace(R.id.rlaContainer, plusOneFragment);
        ft.addToBackStack(null);
        ft.commit();
    }
}
