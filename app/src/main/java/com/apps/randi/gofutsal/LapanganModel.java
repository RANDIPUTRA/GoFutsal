package com.apps.randi.gofutsal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LapanganModel {
    private String result;
    private List<ItemLapangan> item = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<ItemLapangan> getItem() {
        return item;
    }

    public void setItem(List<ItemLapangan> item) {
        this.item = item;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
