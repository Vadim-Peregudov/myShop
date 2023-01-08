package my.web.site.shop.inerf.get.set;

import my.web.site.shop.model.client.Client;

import java.util.List;

public interface GetListClientByNameAndEmailAndPhoneInterface {
    public List<Client> getListClientByNameAndEmailAndPhone(Client client);
}
