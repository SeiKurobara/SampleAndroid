package com.example.sampleapi.APIComponent;

import java.util.HashMap;
import java.util.List;

public interface SampleCallback {
    void onSuccess(List<HashMap<String,Object>> result);
    void onFailure(String message);
}
