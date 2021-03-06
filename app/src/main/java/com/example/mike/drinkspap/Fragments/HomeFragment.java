package com.example.mike.drinkspap.Fragments;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.mike.drinkspap.Adapters.MainAdapter;
import com.example.mike.drinkspap.Custom.BadgeDrawable;
import com.example.mike.drinkspap.Custom.SliderLayout;
import com.example.mike.drinkspap.Interfaces.NavigationInterface;
import com.example.mike.drinkspap.Pojo.CategoryObject;
import com.example.mike.drinkspap.Pojo.DrinksObject;
import com.example.mike.drinkspap.Pojo.MainObject;
import com.example.mike.drinkspap.Pojo.TiltleObject;
import com.example.mike.drinkspap.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HomeFragment extends Fragment implements ViewPagerEx.OnPageChangeListener, BaseSliderView.OnSliderClickListener, NavigationInterface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private SliderLayout mDemoSlider;
    ArrayAdapter<String> stringAdapter;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("HomeFragment","onCreate()");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d("HomeFragment","onCreateView()");

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.mainView);
        recyclerView.setAdapter(new MainAdapter(getContext(),initializeData(), this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        initializeLayout(view);
        return view;
    }

    private List<MainObject> initializeData(){
        List<MainObject> mainObjects = new ArrayList<>();
        Log.d("HomeFragment","initializeData()");
        for (int i = 0; i <= 5; i++) {
            TiltleObject tiltleObject = new TiltleObject();
            tiltleObject.setTitle("test title");
            List<DrinksObject> drinksObjectList = new ArrayList<>();
            for (int v = 0; v <= 5; v++){
                DrinksObject drinksObject = new DrinksObject();
                drinksObject.setName("Test name");
                drinksObject.setType("Test type");
                drinksObject.setPrice("1000");
                drinksObjectList.add(drinksObject);
            }

            tiltleObject.setDrinksObjects(drinksObjectList);
            mainObjects.add(tiltleObject);
        }
        return mainObjects;
    }

    private void initializeLayout(View view) {
        Log.d("HomeFragment","initializeLayout()");

        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        String[] colors = getResources().getStringArray(R.array.colorList);

        stringAdapter = new ArrayAdapter<String>(getContext(), R.layout.row, colors);


        mDemoSlider = (SliderLayout) view.findViewById(R.id.slider);

        HashMap<String,Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("First",R.drawable.tester);
        file_maps.put("Second",R.drawable.tester);
        file_maps.put("Third",R.drawable.tester);
        file_maps.put("Fourth", R.drawable.tester);
        file_maps.put("Fifth", R.drawable.tester);

        for(String name : file_maps.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.CenterCrop)
                    .setOnSliderClickListener(this);


            textSliderView.bundle(new Bundle());
            // textSliderView.getBundle().putString("extra",name);

            mDemoSlider.addSlider(textSliderView);
        }
        mDemoSlider.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mDemoSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mDemoSlider.setCustomAnimation(new DescriptionAnimation());
        mDemoSlider.setDuration(4000);
        mDemoSlider.addOnPageChangeListener(this);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void fragmentNavigation(Fragment fragment) {
        FragmentManager manager = getFragmentManager();
        ProductFragment fragment1 = (ProductFragment) fragment;
        fragment1.show(manager,"Product");
    }
}
