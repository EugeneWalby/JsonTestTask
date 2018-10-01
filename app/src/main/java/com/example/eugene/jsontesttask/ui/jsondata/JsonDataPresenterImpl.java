package com.example.eugene.jsontesttask.ui.jsondata;

import com.example.eugene.jsontesttask.data.model.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonDataPresenterImpl implements JsonDataPresenter<JsonDataView> {
    private JsonDataView view;
    private List<JsonDataModel> jsonDataModelList = new ArrayList<>();

    public JsonDataPresenterImpl(final JsonDataView view) {
        this.view = view;
    }

    @Override
    public void parseJson(final String jsonString, final boolean isActive) {
        try {
            final JSONObject obj = new JSONObject(jsonString);
            final JSONArray events = obj.getJSONArray("events");

            for (int i = 0; i < events.length(); i++) {
                final JSONObject event = events.getJSONObject(i);
                final boolean active = event.getBoolean("active");
                if (active == isActive) {
                    final int id = event.getInt("id");
                    final String name = event.getString("name");
                    jsonDataModelList.add(new JsonDataModel(id, name, true));
                }
            }
            view.showJsonData(jsonDataModelList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
