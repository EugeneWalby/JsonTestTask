package com.example.eugene.jsontesttask.ui.jsondata;

import com.example.eugene.jsontesttask.data.model.JsonDataModel;
import com.example.eugene.jsontesttask.ui.base.BaseView;

import java.util.List;

public interface JsonDataView extends BaseView {
    void showJsonData(final List<JsonDataModel> jsonDataModelList);
}
