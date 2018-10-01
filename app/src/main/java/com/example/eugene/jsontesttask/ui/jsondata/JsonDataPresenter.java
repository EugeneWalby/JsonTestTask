package com.example.eugene.jsontesttask.ui.jsondata;

import com.example.eugene.jsontesttask.ui.base.BasePresenter;

public interface JsonDataPresenter<JsonDataView> extends BasePresenter {
    void parseJson(final String jsonString, final boolean isActive);
}
