package tech.othmane.sa.service;

import org.springframework.stereotype.Service;
import tech.othmane.sa.entites.Client;
import tech.othmane.sa.repository.ClientRepository;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client){
        this.clientRepository.save(client);
    }
}
