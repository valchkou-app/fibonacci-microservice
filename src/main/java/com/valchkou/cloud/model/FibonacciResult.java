package com.valchkou.cloud.model;

import java.util.Date;

public class FibonacciResult {
    long result;
    CalcMode mode;
    long calcTimeMillis;
    Date responseTs;

    public FibonacciResult(CalcMode mode, long result, long calcTimeMillis) {
        this.mode = mode;
        this.result = result;
        this.calcTimeMillis = calcTimeMillis;
        this.responseTs = new Date();
    }

    public long getResult() {
        return result;
    }

    public void setResult(long result) {
        this.result = result;
    }

    public long getCalcTimeMillis() {
        return calcTimeMillis;
    }

    public void setCalcTimeMillis(long calcTimeMillis) {
        this.calcTimeMillis = calcTimeMillis;
    }

    public Date getResponseTs() {
        return responseTs;
    }

    public void setResponseTs(Date responseTs) {
        this.responseTs = responseTs;
    }

    public CalcMode getMode() {
        return mode;
    }

    public void setMode(CalcMode mode) {
        this.mode = mode;
    }
}
