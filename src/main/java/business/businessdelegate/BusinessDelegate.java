package business.businessdelegate;

public class BusinessDelegate {
    private final BusinessLookUp lookupService = new BusinessLookUp();
    private String serviceType;

    public void setServiceType(String serviceType)
    {
        this.serviceType = serviceType;
    }

    public void doTask(Historial historial)
    {
        BusinessService businessService = lookupService.getBusinessService(serviceType);
        businessService.doProcessing(historial);
    }
}
