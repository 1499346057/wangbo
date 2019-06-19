package lab7.wangbo;

import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.ServiceDetail;
import org.uddi.api_v3.Name;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @author WangBo
 * @date 26.05.2019
 */
public class App {
    private static final String LOGIN = "uddiadmin";
    private static final String PASSWORD = "da_password1";
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        System.out.println("Start");

        try {
            System.out.println("Enter path to file with UDDI settings");
            String pathToUddiSettings = br.readLine();
            JUDDIController juddiController = new JUDDIController(pathToUddiSettings);
            juddiController.setAuthenticate(LOGIN, PASSWORD);

            while (true) {
                System.out.println("Please, select the type of action: 0 - create service, 1 - get and use service, 2 - quit");
                String actionType = br.readLine();
                try {
                    switch (actionType) {
                        case "0":
                            CreateService(juddiController);
                            break;
                        case "1":
                            getAndUseService(juddiController);
                        case "2":
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Wrong choose");
                            break;
                    }
                } catch (Exception ex) {
                    System.out.println("Received error: " + ex.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void CreateService(JUDDIController juddiController) throws IOException {
        String bkey, sname, surl;
        System.out.println("Enter business key: ");
        bkey =  br.readLine().trim();

        System.out.println("Enter service name: ");
        sname = br.readLine().trim();

        System.out.println("Enter wsdl link: ");
        surl = br.readLine().trim();
        ServiceDetail sdetail = juddiController.publish(bkey, sname, surl);
        printServiceInfo(sdetail.getBusinessService());
    }

    private static void getAndUseService(JUDDIController juddiController) throws IOException {
        String sname, skey;
        try {
            System.out.println("Enter service name: ");
            sname = br.readLine().trim();
            ServiceDetail fdetail = juddiController.findServiceByName(sname);
            printServiceInfo(fdetail.getBusinessService());
            System.out.println("Enter service key: ");
            skey = br.readLine().trim();
            juddiController.useService(skey);
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }

    public static void printServiceInfo(List<BusinessService> serviceInfos) {
        for (int i = 0; i < serviceInfos.size(); i++) {
            System.out.println("Service Key: " + serviceInfos.get(i).getServiceKey());
            System.out.println("Owning Business Key: " + serviceInfos.get(i).getBusinessKey());
            System.out.println("Name: " + ListToString(serviceInfos.get(i).getName()) + "\n");
        }
    }

    private static String ListToString(List<Name> name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.size(); i++) {
            sb.append(name.get(i).getValue()).append(" ");
        }
        return sb.toString();
    }
}
