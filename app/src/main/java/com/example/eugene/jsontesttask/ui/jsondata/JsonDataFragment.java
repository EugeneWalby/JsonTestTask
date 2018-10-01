package com.example.eugene.jsontesttask.ui.jsondata;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.eugene.jsontesttask.R;
import com.example.eugene.jsontesttask.data.adapter.JsonDataAdapter;
import com.example.eugene.jsontesttask.data.model.JsonDataModel;
import com.example.eugene.jsontesttask.ui.base.BaseFragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonDataFragment extends BaseFragment implements JsonDataView {
    private RecyclerView rvJsonData;
    private JsonDataPresenter<JsonDataView> presenter;

    public static JsonDataFragment newInstance() {
        Bundle args = new Bundle();
        JsonDataFragment fragment = new JsonDataFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int provideLayout() {
        return R.layout.fragment_json_data;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new JsonDataPresenterImpl(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        presenter.parseJson(loadJSONFromAsset(), true);
    }

    @Override
    public void showJsonData(final List<JsonDataModel> jsonDataModelList) {
        rvJsonData.setAdapter(new JsonDataAdapter(jsonDataModelList));
    }

    private void initViews(@NonNull View view) {
        rvJsonData = view.findViewById(R.id.rvJsonData);
        rvJsonData.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    private String loadJSONFromAsset() {
        final String json;
        try {
            final InputStream is = getActivity().getAssets().open("events1.json");
            final int size = is.available();
            final byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
            Log.d("JSON", json);
        } catch (final IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
