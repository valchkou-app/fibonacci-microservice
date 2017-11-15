package com.valchkou.cloud.service

import com.valchkou.cloud.service.alg.LoopAlgorithm
import com.valchkou.cloud.service.alg.AlgorithmFib
import com.valchkou.cloud.service.alg.BinetAlgorithm
import com.valchkou.cloud.service.alg.RecursiveAlgorithm
import spock.lang.Specification
import spock.lang.Unroll

class FibonacciServiceTest extends Specification {

    @Unroll
    def "Calculate N-th Fibonaccy Number. Binet"() {
        given:
        BinetAlgorithm alg = new BinetAlgorithm()
        when:
        long ret = alg.calc(nth)
        then:
        ret == result
        where:
        nth | result
        2   | 1
        3   | 2
        10  | 55
    }

    @Unroll
    def "Calculate N-th Fibonaccy Number. Loop"() {
        given:
        LoopAlgorithm alg = new LoopAlgorithm()
        when:
        long ret = alg.calc(nth)
        then:
        ret == result
        where:
        nth | result
        2   | 1
        3   | 2
        10  | 55
    }

    @Unroll
    def "Calculate N-th Fibonaccy Number. Recursive"() {
        given:
        AlgorithmFib alg = new RecursiveAlgorithm()
        when:
        long ret = alg.calc(nth)
        then:
        ret == result
        where:
        nth | result
        2   | 1
        3   | 2
        10  | 55
    }


}
