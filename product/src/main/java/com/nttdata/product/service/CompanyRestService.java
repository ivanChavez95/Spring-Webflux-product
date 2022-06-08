package com.nttdata.product.service;

import com.nttdata.product.model.dto.ClientDto;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import static com.nttdata.product.constant.CompanyConstants.FIND_ALL_COMPANIES;
import static com.nttdata.product.constant.CompanyConstants.FIND_COMPANY_BY_ID;

public class CompanyRestService {
    private WebClient webclient;
    public CompanyRestService(WebClient webclient){this.webclient = webclient;}

    //Calls all Company Clients
    public List<ClientDto> findAllCompanies(){
        return webclient.get().uri(FIND_ALL_COMPANIES)
                .retrieve()
                .bodyToFlux(ClientDto.class)
                .collectList()
                .block();
    }

    //Finds a Company CLient by its ID
    public ClientDto findCompanyById(String id){
        return webclient.get().uri(FIND_COMPANY_BY_ID)
                .retrieve()
                .bodyToMono(ClientDto.class)
                .block();
    }

}
