package com.valchkou.cloud.web

import com.valchkou.cloud.Main
import com.valchkou.cloud.model.CalcMode
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
class FibonacciControllerTest {

    private static final String BASE_URL = "/api/fibonacci"

    @Autowired
    private MockMvc mvc

    @Test
    void testCalcNSuccess() throws Exception {
        int n = 10;
        String url = BASE_URL+"/$n"

        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.result', is(55)))
                .andExpect(jsonPath('$.mode', is(CalcMode.BINET.name())))
    }

    @Test
    void testCalcNLoop() throws Exception {
        int n = 10;
        String url = BASE_URL+"/$n/${CalcMode.LOOP}"

        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.result', is(55)))
                .andExpect(jsonPath('$.mode', is(CalcMode.LOOP.name())))
    }

    @Test
    void testCalcNRecursive() throws Exception {
        int n = 10;
        String url = BASE_URL+"/$n/${CalcMode.RECURSIVE}"

        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.result', is(55)))
                .andExpect(jsonPath('$.mode', is(CalcMode.RECURSIVE.name())))
    }

    @Test
    void testCalcNScientific() throws Exception {
        int n = 10;
        String url = BASE_URL+"/$n/${CalcMode.BINET}"
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath('$.result', is(55)))
                .andExpect(jsonPath('$.mode', is(CalcMode.BINET.name())))
    }

    @Test
    void testCalcNUnknown() throws Exception {
        int n = 10;
        String url = BASE_URL+"/$n/Wrong"
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())

    }

}
