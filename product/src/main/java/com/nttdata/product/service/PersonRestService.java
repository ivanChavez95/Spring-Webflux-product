package com.nttdata.product.service;

import com.nttdata.product.model.dto.ClientDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import java.util.List;

import static com.nttdata.product.constant.PersonConstant.FIND_ALL_PERSONS;
import static com.nttdata.product.constant.PersonConstant.FIND_PERSON_BY_ID;

public class PersonRestService {
    private WebClient webclient;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    public PersonRestService(WebClient webclient){this.webclient = webclient;}

    public List<ClientDto> findAllPersons(){
        return webclient.get().uri(FIND_ALL_PERSONS)
                .retrieve()
                .bodyToFlux(ClientDto.class)
                .collectList()
                .block();
    }

    //Finds a Company CLient by its ID
    public ClientDto findCompanyById(String id){
        try{
            return webclient.get().uri(FIND_PERSON_BY_ID)
                    .retrieve()
                    .bodyToMono(ClientDto.class)
                    .block();
        }catch(WebClientException ex){
            LOGGER.error("Error Trying to retrieve company by its id");
            LOGGER.error("Error in findCompanyById: " + ex.getMessage());
            throw ex;
        }
        catch(Exception e){
            LOGGER.error("Error Trying to retrieve company by its id");
            LOGGER.error("Error in findCompanyById: " + e.getMessage());
            throw e;
        }
    }
}
