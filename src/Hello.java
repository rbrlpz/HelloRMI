import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote {
    String dimeHola() throws RemoteException;
    //implementamos un segundo metodo remoto con paso de parametros
    int suma(int a, int b) throws RemoteException;
}