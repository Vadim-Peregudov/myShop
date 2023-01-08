package my.web.site.shop.service.client;

import my.web.site.shop.model.client.Client;
import my.web.site.shop.repository.client.ClientRepository;
import my.web.site.shop.inerf.crud.client.ClientServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientServiceInterfaceImpl implements ClientServiceInterface {
    @Autowired
    private ClientRepository repository;


    @Override
    public void addServiceElement(Client client) {
        if (!repository.findAll().contains(client)){
            repository.save(client);
        }
    }

    @Override
    public Client getServiceElement(Long id) {
        var client = repository.findById(id);
        if(client.isPresent()){
            return client.get();
        }
        throw new NullPointerException("This client by id is null");
    }

    @Override
    public boolean updateServiceElement(Long id, Client newClient) {
        var optionalUser = repository.findById(id);
        if(optionalUser.isPresent()){
            var client = optionalUser.get();
            client.setEmail(newClient.getEmail());
            client.setFullName(newClient.getFullName());
            client.setMobilePhone(newClient.getMobilePhone());
            client.setCommentToOrder(newClient.getCommentToOrder());
            client.setDateOrder(newClient.getDateOrder());
            repository.saveAndFlush(client);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteServiceElement(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Client saveAndGetServiceElement(Client client) {
        if(repository.findAll().contains(client)){
            return repository.findAll().stream().filter(element -> element.equals(client)).findFirst().get();
        } else {
            repository.save(client);
            return client;
        }
    }

    @Override
    public List<Client> getListAllElements() {
        return repository.findAll();
    }

    @Override
    public List<Client> getListClientByNameAndEmailAndPhone(Client client) {
        return repository.findByFullNameAndMobilePhoneAndEmail(client.getFullName(), client.getMobilePhone(), client.getEmail());
    }

}
