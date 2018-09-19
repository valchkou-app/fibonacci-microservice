package com.valchkou.cloud.service.alg;

import com.valchkou.cloud.model.CalcMode;
import org.springframework.stereotype.Component;

/**
 * Created by evalchkou on 9/22/2017.
 */
@Component
public class BinetAlgorithm extends AlgorithmFib {

    @Override
    public CalcMode getMode() {
        return CalcMode.BINET;
    }

    @Override
    public long calc(long n) {
        if (n==0) return 0;
        if (n<3) return 1;
        double root5 = Math.sqrt(5);
        double fib = 1/root5*( Math.pow((1+root5)/2, n) - Math.pow((1-root5)/2, n));
        return Math.round(fib);
    }
}
