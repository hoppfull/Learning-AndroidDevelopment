package com.example.hoppf.ex14_masterdetail;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MasterFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_master, container, false);
        RecyclerView rcv_mylist = (RecyclerView) view.findViewById(R.id.rcv_mylist);

        rcv_mylist.setLayoutManager(new LinearLayoutManager(getContext()));

        GeneralAdapter<String, MyViewHolder> myAdapter =
                new GeneralAdapter<>(new String[]{ "huey", "dewey", "louie" },
                        R.layout.card_mylist,
                        new GeneralAdapter.Builder<String, MyViewHolder>() {
                            @Override
                            public MyViewHolder viewHolderBuilder(ViewGroup viewGroup) {
                                return new MyViewHolder(viewGroup);
                            }

                            @Override
                            public void viewHolderBinder(MyViewHolder viewHolder, String item) {
                                viewHolder.txv_mylist_title.setText(item);
                                viewHolder.viewGroup.setOnClickListener(v -> {
                                    Bundle bundle = new Bundle();
                                    bundle.putString("data", item);
                                    ((IMainActivity) getContext()).loadDetailFragment(bundle);
                                });
                            }
                        });

        rcv_mylist.setAdapter(myAdapter);

        return view;
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        public final TextView txv_mylist_title;
        public final ViewGroup viewGroup;
        MyViewHolder(ViewGroup viewGroup) {
            super(viewGroup);
            txv_mylist_title = (TextView) viewGroup.findViewById(R.id.txv_mylist_title);
            this.viewGroup = viewGroup;
        }
    }
}
