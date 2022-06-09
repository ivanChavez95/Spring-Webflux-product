package com.nttdata.product.service;

import com.nttdata.product.model.dto.ClientDto;
import com.nttdata.product.model.dto.PersonDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.nttdata.product.constant.PersonConstant.FIND_ALL_PERSONS;
import static com.nttdata.product.constant.PersonConstant.FIND_PERSON_BY_ID;

public class PersonRestService {
    private WebClient webclient;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    public PersonRestService(WebClient webclient){this.webclient = webclient;}

    public Flux<PersonDto> findAllPersons(){
        return webclient.get().uri(FIND_ALL_PERSONS)
                .retrieve()
                .bodyToFlux(PersonDto.class);
    }

    //Finds a Company CLient by its ID
    public Mono<ClientDto> findPersonById(String id){
        try{
            return webclient.get().uri(FIND_PERSON_BY_ID,id)
                    .retrieve()
                    .bodyToMono(ClientDto.class);
        }catch(WebClientException ex){
            LOGGER.error("Web CLient Error Trying to retrieve person by its id");
            LOGGER.error("Error in findPersonById: " + ex.getMessage());
            throw ex;
        }
        catch(Exception e){
            LOGGER.error("Error Trying to retrieve person by its id");
            LOGGER.error("Error in findPersonById: " + e.getMessage());
            throw e;
        }
    }
}
