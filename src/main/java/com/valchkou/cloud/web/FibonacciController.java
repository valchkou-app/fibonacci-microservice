package com.valchkou.cloud.web;

import com.valchkou.cloud.model.CalcMode;
import com.valchkou.cloud.model.FibonacciResult;
import com.valchkou.cloud.service.FibonacciService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Fibonacci Calculator")
@RestController
@RequestMapping("/api/fibonacci")
public class FibonacciController {

    Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    FibonacciService fibonacciService;

    @ApiOperation(value = "Calculate Fibonaccy N-th number")
    @RequestMapping(value = "{nth}", method = RequestMethod.GET)
    @ResponseBody FibonacciResult calcN(@PathVariable int nth) {
        return calcN(nth, CalcMode.BINET);
    }

    @ApiOperation(value = "Calculate Fibonaccy N-th number")
    @RequestMapping(value = "{nth}/{mode}", method = RequestMethod.GET)
    @ResponseBody FibonacciResult calcN(@PathVariable int nth,
                            @ApiParam(value = "Calc Mode", required = true)
                            @PathVariable(required = true) CalcMode mode) {
        log.info("calculate number {} using alg {}", nth, mode);
        return fibonacciService.calcNthNumber(nth, mode);
    }
}
