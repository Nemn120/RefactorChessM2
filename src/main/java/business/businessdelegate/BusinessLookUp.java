package business.businessdelegate;

public class BusinessLookUp {
    public BusinessService getBusinessService(String serviceType)
    {
        if(serviceType.equalsIgnoreCase("One"))
        {
            return new OneService();
        }
        else
        {
            return new TwoService();
        }
    }
}
