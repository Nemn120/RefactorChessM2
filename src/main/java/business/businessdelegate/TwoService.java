package business.businessdelegate;

public class TwoService implements BusinessService{
    public void doProcessing(Historial historial)
    {
        System.out.println("Processed Service Two");
    }
}
