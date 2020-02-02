package com.example.desafioSpring.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import com.example.desafioSpring.domain.dto.evento.request.EventoRequest;
import com.example.desafioSpring.domain.dto.evento.request.EventoSearchData;
import com.example.desafioSpring.domain.dto.evento.request.EventoUpdate;
import com.example.desafioSpring.domain.dto.evento.request.StatusChange;
import com.example.desafioSpring.domain.dto.evento.response.EventoResponse;
import com.example.desafioSpring.domain.entities.CategoriaEvento;
import com.example.desafioSpring.domain.entities.Evento;
import com.example.desafioSpring.domain.entities.StatusEvento;
import com.example.desafioSpring.repository.CategoriaEventoRepository;
import com.example.desafioSpring.repository.EventoRepository;
import com.example.desafioSpring.repository.EventoStatusRepository;
import com.example.desafioSpring.utils.IntegrationTestConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * EventoControllerTestInt
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = IntegrationTestConfig.appProperties)
@ActiveProfiles("test")
public class EventoControllerTestInt {
        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper mapper;

        @Autowired
        private EventoRepository eventoRepository;

        @Autowired
        private EventoStatusRepository eventoStatusRepository;

        @Autowired
        private CategoriaEventoRepository categoriaEventoRepository;

        @Test
        public void should_create_whenPostValid() throws JsonProcessingException, Exception {
                Calendar ini = Calendar.getInstance();
                ini.add(Calendar.DATE, 1);
                Calendar fim = Calendar.getInstance();
                fim.add(Calendar.DATE, 1);
                fim.add(Calendar.HOUR, 2);
                StatusEvento statusEvento = StatusEvento.builder().idEventoStatus(1).NomeStatus("Nome").build();
                CategoriaEvento categoriaEvento = CategoriaEvento.builder().idCategoriaEvento(1).nomeCategoria("nome")
                                .build();
                eventoStatusRepository.saveAndFlush(statusEvento);
                categoriaEventoRepository.saveAndFlush(categoriaEvento);
                EventoRequest request = EventoRequest.builder().dataHoraInicio(ini.getTime()).dataHoraFim(fim.getTime())
                                .descricao("Descricao aqui").idCategoriaEvento(1).limiteVagas(2)
                                .local("Local do evento").nome("Nome do envento").build();

                MvcResult result = mockMvc
                                .perform(MockMvcRequestBuilders.post("/eventos").contentType(MediaType.APPLICATION_JSON)
                                                .content(mapper.writeValueAsString(request)))
                                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                                .andReturn();

                EventoResponse response = mapper.readValue(result.getResponse().getContentAsString(),
                                EventoResponse.class);

                assertNotNull(response.getIdEvento());
        }

        @Test
        public void should_getEmptyList_whenGetEmpty() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.get("/eventos")) // Executa
                                .andDo(MockMvcResultHandlers.print()) // pega resultado
                                .andExpect(MockMvcResultMatchers.status().isOk()) // faz a validação.
                                .andExpect(MockMvcResultMatchers.content()
                                                .contentType(MediaType.APPLICATION_JSON_UTF8));
        }

        @Test
        public void should_get_whenGetById() throws Exception {
                StatusEvento statusEvento = StatusEvento.builder().idEventoStatus(1).NomeStatus("Nome").build();
                CategoriaEvento categoriaEvento = CategoriaEvento.builder().idCategoriaEvento(1).nomeCategoria("nome")
                                .build();
                eventoStatusRepository.saveAndFlush(statusEvento);
                categoriaEventoRepository.saveAndFlush(categoriaEvento);
                Evento model = Evento.builder().dataHoraFim(new Date()).dataHoraInicio(new Date())
                                .descricao("Descricao do evento").idEvento(1).limiteVagas(10).local("Local do evento")
                                .nome("Nomde do evento").categoriaEvento(categoriaEvento).eventoStatus(statusEvento)
                                .build();
                eventoRepository.saveAndFlush(model);

                mockMvc.perform(MockMvcRequestBuilders.get("/eventos/" + model.getIdEvento())) // Executa
                                .andDo(MockMvcResultHandlers.print()) // pega resultado
                                .andExpect(MockMvcResultMatchers.status().isOk()); // faz a validação.
        }

        @Test
        public void should_put_whenPutIsValid() throws Exception {
                Calendar ini = Calendar.getInstance();
                ini.add(Calendar.DATE, 1);
                Calendar fim = Calendar.getInstance();
                fim.add(Calendar.DATE, 1);
                fim.add(Calendar.HOUR, 2);

                // MOCKANDO O STATUS
                StatusEvento statusEvento = StatusEvento.builder().idEventoStatus(1).NomeStatus("Nome").build();
                eventoStatusRepository.saveAndFlush(statusEvento);

                // MOCKANDO A CATEGORIA
                CategoriaEvento categoriaEvento = CategoriaEvento.builder().idCategoriaEvento(1).nomeCategoria("nome")
                                .build();
                categoriaEventoRepository.saveAndFlush(categoriaEvento);

                // MOCKANDO O EVENTO
                Evento model = Evento.builder().dataHoraFim(new Date()).dataHoraInicio(new Date())
                                .descricao("Descricao do evento").idEvento(1).limiteVagas(10).local("Local do evento")
                                .nome("Nomde do evento").categoriaEvento(categoriaEvento).eventoStatus(statusEvento)
                                .build();
                eventoRepository.saveAndFlush(model);

                // CRIANDO UM REQUEST DE UPDATE
                EventoUpdate request = EventoUpdate.builder().dataHoraInicio(ini.getTime()).dataHoraFim(fim.getTime())
                                .descricao("Descricao aqui").idCategoriaEvento(1).limiteVagas(2)
                                .local("Local do evento").nome("Nome do envento").idEventoStatus(1).build();

                MvcResult result = mockMvc
                                .perform(MockMvcRequestBuilders.put("/eventos/" + model.getIdEvento())
                                                .contentType(MediaType.APPLICATION_JSON) //
                                                .content(mapper.writeValueAsString(request))) // Executa
                                .andDo(MockMvcResultHandlers.print()) // pega resultado
                                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

                EventoResponse response = mapper.readValue(result.getResponse().getContentAsString(),
                                EventoResponse.class);

                assertNotNull(response.getIdEvento());
        }

        @Test
        public void should_list_WhenCategoriaIsValid() throws Exception {

                StatusEvento statusEvento = StatusEvento.builder().idEventoStatus(1).NomeStatus("Nome").build();
                CategoriaEvento categoriaEvento = CategoriaEvento.builder().idCategoriaEvento(1).nomeCategoria("nome")
                                .build();
                eventoStatusRepository.saveAndFlush(statusEvento);
                categoriaEventoRepository.saveAndFlush(categoriaEvento);
                Evento model = Evento.builder().dataHoraFim(new Date()).dataHoraInicio(new Date())
                                .descricao("Descricao do evento").idEvento(1).limiteVagas(10).local("Local do evento")
                                .nome("Nomde do evento").categoriaEvento(categoriaEvento).eventoStatus(statusEvento)
                                .build();
                eventoRepository.saveAndFlush(model);

                mockMvc.perform(MockMvcRequestBuilders
                                .get("/eventos/categoria/" + model.getCategoriaEvento().getIdCategoriaEvento())) // Executa
                                .andDo(MockMvcResultHandlers.print()) // pega resultado
                                .andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers
                                                .content().contentType(MediaType.APPLICATION_JSON_UTF8));

        }

        @Test
        public void should_list_WhenDateIsVAlid() throws Exception {
                Calendar ini = Calendar.getInstance();
                Calendar fim = Calendar.getInstance();
                fim.add(Calendar.HOUR, 4);

                StatusEvento statusEvento = StatusEvento.builder().idEventoStatus(1).NomeStatus("Nome").build();
                eventoStatusRepository.saveAndFlush(statusEvento);

                CategoriaEvento categoriaEvento = CategoriaEvento.builder().idCategoriaEvento(1).nomeCategoria("nome")
                                .build();
                categoriaEventoRepository.saveAndFlush(categoriaEvento);

                Evento model = Evento.builder().dataHoraFim(new Date()).dataHoraInicio(new Date())
                                .descricao("Descricao do evento").idEvento(1).limiteVagas(10).local("Local do evento")
                                .nome("Nomde do evento").categoriaEvento(categoriaEvento).eventoStatus(statusEvento)
                                .build();
                eventoRepository.saveAndFlush(model);

                EventoSearchData request = EventoSearchData.builder().dataHoraFim(fim.getTime())
                                .dataHoraInicio(ini.getTime()).build();

                mockMvc.perform(MockMvcRequestBuilders.post("/eventos/dataSearch/")
                                .contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(request)))
                                .andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk())
                                .andExpect(MockMvcResultMatchers.content()
                                                .contentType(MediaType.APPLICATION_JSON_UTF8));

        }

        @Test
        public void should_changeStatus_whenStatusAndDateIsValid() throws JsonProcessingException, Exception {
                Calendar ini = Calendar.getInstance();
                ini.add(Calendar.DAY_OF_MONTH, 2);
                Calendar fim = Calendar.getInstance();
                fim.add(Calendar.DAY_OF_MONTH, 2);
                fim.add(Calendar.HOUR, 4);

                StatusEvento statusEvento = StatusEvento.builder().idEventoStatus(1).NomeStatus("Nome").build();
                eventoStatusRepository.saveAndFlush(statusEvento);

                CategoriaEvento categoriaEvento = CategoriaEvento.builder().idCategoriaEvento(1).nomeCategoria("nome")
                                .build();
                categoriaEventoRepository.saveAndFlush(categoriaEvento);

                Evento model = Evento.builder().dataHoraFim(fim.getTime()).dataHoraInicio(ini.getTime())
                                .descricao("Descricao do evento").idEvento(1).limiteVagas(10).local("Local do evento")
                                .nome("Nomde do evento").categoriaEvento(categoriaEvento).eventoStatus(statusEvento)
                                .build();
                eventoRepository.saveAndFlush(model);

                StatusChange request = StatusChange.builder().idEventoStatus(1).build();

                MvcResult result = mockMvc
                                .perform(MockMvcRequestBuilders.patch("/eventos/Status/" + model.getIdEvento())
                                                .content(mapper.writeValueAsString(request))
                                                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

                EventoResponse response = mapper.readValue(result.getResponse().getContentAsString(),
                                EventoResponse.class);

        }
}