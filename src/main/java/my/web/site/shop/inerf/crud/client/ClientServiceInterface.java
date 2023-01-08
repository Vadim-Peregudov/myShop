package my.web.site.shop.inerf.crud.client;

import my.web.site.shop.inerf.crud.CRUDServiceInterface;
import my.web.site.shop.inerf.get.save.SaveAndGetServiceElementInterface;
import my.web.site.shop.inerf.get.save.list.GetListAllElementInterface;
import my.web.site.shop.inerf.get.set.GetListClientByNameAndEmailAndPhoneInterface;
import my.web.site.shop.model.client.Client;

public interface ClientServiceInterface extends CRUDServiceInterface<Client>,
        SaveAndGetServiceElementInterface<Client>, GetListAllElementInterface<Client> , GetListClientByNameAndEmailAndPhoneInterface {
}
