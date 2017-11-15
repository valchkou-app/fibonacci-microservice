package com.valchkou.cloud.service.alg;

import com.valchkou.cloud.model.CalcMode;
import org.springframework.stereotype.Component;

/**
 * Created by evalchkou on 9/22/2017.
 */
@Component
public class LoopAlgorithm extends AlgorithmFib {

    {
        mode = CalcMode.LOOP;
    }

    @Override
    public long calc(long n) {
        if (n==0) return 0;
        if (n<3) return 1;

        long prev = 1;
        long next = 1;
        long fib = 0;
        for (long i=3; i<=n; i++) {
            fib = prev + next;
            prev = next;
            next = fib;
        }
        return fib;
    }
}
