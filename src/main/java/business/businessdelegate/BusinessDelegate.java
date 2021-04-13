package business.businessdelegate;

public class BusinessDelegate {
    private BusinessLookUp lookupService = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType)
    {
        this.serviceType = serviceType;
    }

    public void doTask(Historial historial)
    {
        businessService = lookupService.getBusinessService(serviceType);
        businessService.doProcessing(historial);
    }
}
