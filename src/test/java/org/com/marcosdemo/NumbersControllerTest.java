package org.com.marcosdemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NumbersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void computeTest() throws Exception {

        mockMvc.perform(get("/compute/{id}", "1, 2, 3, 4, 5, 6")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        //.andExpect(jsonPath("$", hasSize(1)));

    }


}
