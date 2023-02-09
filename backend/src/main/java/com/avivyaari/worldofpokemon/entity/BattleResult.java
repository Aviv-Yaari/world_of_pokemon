package com.avivyaari.worldofpokemon.entity;

public class BattleResult {
    BattleStatus status;
    String message;

    public BattleResult() {
    }

    public BattleResult(BattleStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public BattleStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setStatus(BattleStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
