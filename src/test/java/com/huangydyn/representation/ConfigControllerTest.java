package com.huangydyn.representation;

import com.huangydyn.base.IntegrationTest;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ConfigControllerTest extends IntegrationTest {

    @Test
    public void should_get_value() throws Exception {
        mockMvc.perform(get("/v1/config/value"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.date").isNotEmpty())
                .andExpect(jsonPath("$.configValue").value("test"));
    }
}
