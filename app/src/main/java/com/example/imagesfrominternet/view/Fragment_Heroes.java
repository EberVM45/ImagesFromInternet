package com.example.imagesfrominternet.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.imagesfrominternet.MainActivity;
import com.example.imagesfrominternet.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_Heroes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Heroes extends Fragment {
    private RecyclerView recyclerViewHero;
    private Adapter_Heroes adapterHeroes;
    private GridLayoutManager layoutManager;
    MainActivity mainActivity;
    Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
        }
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_Heroes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Heroes.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Heroes newInstance(String param1, String param2) {
        Fragment_Heroes fragment = new Fragment_Heroes();
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
        View v=inflater.inflate(R.layout.fragment__heroes, container, false);
        recyclerViewHero= v.findViewById(R.id.ViewerImages);
        layoutManager=new GridLayoutManager(getActivity(),2);
        adapterHeroes=new Adapter_Heroes(getActivity(),MainActivity.ArrayListHeroes);
        recyclerViewHero.setLayoutManager(layoutManager);
        recyclerViewHero.setAdapter(adapterHeroes);
        return v;
    }
}