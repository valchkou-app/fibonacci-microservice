package com.valchkou.cloud.service.alg;

import com.valchkou.cloud.model.CalcMode;
import org.springframework.stereotype.Component;

/**
 * Created by evalchkou on 9/22/2017.
 */
@Component
public class RecursiveAlgorithm extends AlgorithmFib {

    {
        mode = CalcMode.RECURSIVE;
    }

    @Override
    public long calc(long n) {
        if (n==0) return 0;
        if (n<3) return 1;
        return calc(n-1)+ calc(n-2);
    }
}
