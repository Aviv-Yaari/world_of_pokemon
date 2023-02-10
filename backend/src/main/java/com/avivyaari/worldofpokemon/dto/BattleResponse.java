package com.avivyaari.worldofpokemon.dto;

public class BattleResponse {
    private String result;

    public BattleResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
