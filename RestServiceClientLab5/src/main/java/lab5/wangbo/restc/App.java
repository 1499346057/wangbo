package lab5.wangbo.restc;

import com.sun.jersey.api.client.Client;
/**
 * @author WangBo
 * @date 24.05.2019
 */
public class App {
    public static void main(String[] args) {
        Client client = Client.create();
        ActionMenu menu = new ActionMenu();
        menu.start(client);
    }
}
