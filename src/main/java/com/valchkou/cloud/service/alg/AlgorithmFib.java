package com.valchkou.cloud.service.alg;

import com.valchkou.cloud.model.CalcMode;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public abstract class AlgorithmFib {
    private static Map<CalcMode, AlgorithmFib> algs = new HashMap<>();

    public abstract CalcMode getMode();
    public abstract long calc(long i);

    public static AlgorithmFib get(CalcMode m) {
        return algs.get(m);
    }

    @PostConstruct
    private void init(){
        algs.put(this.getMode(), this);
    }
}
