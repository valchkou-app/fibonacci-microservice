package com.valchkou.cloud.service;


import com.valchkou.cloud.model.CalcMode;
import com.valchkou.cloud.model.FibonacciResult;
import com.valchkou.cloud.service.alg.AlgorithmFib;
import org.springframework.stereotype.Service;

@Service
public class FibonacciService {

    public FibonacciResult calcNthNumber(long nth, CalcMode mode) {

        // resolve algorithm inplementation
        AlgorithmFib alg = AlgorithmFib.get(mode);

        // calculate with resolved algorithm
        long t = System.currentTimeMillis();
        long result = alg.calc(nth);
        t = System.currentTimeMillis() - t;

        return new FibonacciResult(mode, result, t);
    }

}
