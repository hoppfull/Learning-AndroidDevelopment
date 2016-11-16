package com.example.hoppf.ex14_masterdetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        TextView txv_mytitle = (TextView) view.findViewById(R.id.txv_mytitle);

        String data = getArguments().getString("data");

        txv_mytitle.setText(data);

        return view;
    }
}
