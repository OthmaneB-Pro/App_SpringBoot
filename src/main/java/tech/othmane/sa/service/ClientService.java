package tech.othmane.sa.service;

import org.springframework.stereotype.Service;
import tech.othmane.sa.entites.Client;
import tech.othmane.sa.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void create(Client client){
        this.clientRepository.save(client);
    }

    public Client lire(int id){
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public void delete(int id) {
        this.clientRepository.deleteById(id);
    }

    public void modify(int id, String email) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setEmail(email);
            this.clientRepository.save(client);
        }
        else {
            throw new RuntimeException("Client with ID " + id + " not found.");
        }

    }

    public Client lireOuCreer(Client client) {
        Client clientDansLaBDD = this.clientRepository.findByEmail(client.getEmail());
        if (clientDansLaBDD == null){
            clientDansLaBDD = this.clientRepository.save(client);
        }
        return clientDansLaBDD;
    }
}
