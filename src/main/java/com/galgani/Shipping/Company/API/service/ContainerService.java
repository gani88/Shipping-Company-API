package com.galgani.Shipping.Company.API.service;

import com.galgani.Shipping.Company.API.dto.request.*;
import com.galgani.Shipping.Company.API.dto.response.ContainerResponse;
import com.galgani.Shipping.Company.API.dto.response.CustomerResponse;
import com.galgani.Shipping.Company.API.entity.Container;
import com.galgani.Shipping.Company.API.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContainerService {
    Container create(NewContainerRequest newContainerRequest);
    Container getById(String id);
    List<Container> searchContainer(SearchContainerRequest searchContainerRequest);
    ContainerResponse update(UpdateContainerRequest updateContainerRequest);
    void deleteById(String id);
}
