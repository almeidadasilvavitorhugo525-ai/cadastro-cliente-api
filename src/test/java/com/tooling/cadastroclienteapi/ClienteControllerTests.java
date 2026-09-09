package com.tooling.cadastroclienteapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void deveCadastrarEListarCliente() throws Exception {
        String json = "{\"nome\":\"Maria Souza\",\"email\":\"maria@email.com\",\"telefone\":\"44999998888\"}";

        mockMvc.perform(post("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nome").value("Maria Souza"));

        mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("Maria Souza"));
    }

    @Test
    void deveRetornar404ParaClienteInexistente() throws Exception {
        mockMvc.perform(get("/clientes/9999"))
                .andExpect(status().isNotFound());
    }
}
