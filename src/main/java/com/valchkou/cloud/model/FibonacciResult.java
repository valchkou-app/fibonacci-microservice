package com.valchkou.cloud.model;

import java.util.Date;


public class FibonacciResult {
    private long result;
    private CalcMode mode;
    private long calcTimeMillis;
    private Date responseTs;

    public FibonacciResult(CalcMode mode, long result, long calcTimeMillis) {
        this.mode = mode;
        this.result = result;
        this.calcTimeMillis = calcTimeMillis;
        this.responseTs = new Date();
    }

    public long getResult() {
        return result;
    }

    public CalcMode getMode() {
        return mode;
    }

    public long getCalcTimeMillis() {
        return calcTimeMillis;
    }

    public Date getResponseTs() {
        return responseTs;
    }
}
