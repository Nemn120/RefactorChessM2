package business.businessdelegate;

public class Client {
    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService)
    {
        this.businessService  = businessService;
    }

    public void doTask(String historial)
    {
        businessService.doTask(historial);
    }
}
