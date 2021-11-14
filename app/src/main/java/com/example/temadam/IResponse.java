package com.example.temadam;

import java.util.List;

public interface IResponse {

    public void onSuccess(List<Antrenament> list);
    public void onError(String errorMessage);
}
