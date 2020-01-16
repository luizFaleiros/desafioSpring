package com.example.desafioSpring.services.client;

import java.util.List;
import java.util.Optional;

import com.example.desafioSpring.domain.entities.Client;
import com.example.desafioSpring.exception.DataNotFoundException;
import com.example.desafioSpring.repository.Client.ClientRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client model) {
        return clientRepository.save(model);
    }

    public List<Client> listClient() {
        return clientRepository.findAll();
    }

    public Client findById(Integer id) {
        Optional<Client> client = clientRepository.findById(id);
        return client.orElseThrow(() -> new DataNotFoundException("Client Not found"));
    }

    public Boolean deletClient(Integer id) {
        Client client = findById(id);
        clientRepository.deleteById(id);
        return true;
        
    }


}
