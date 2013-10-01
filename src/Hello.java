import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * User: rober
 * Date: 1/10/13
 * Time: 01:20 PM
 * Agregar la descripción del archivo
 */
public interface Hello extends Remote {
    public String dimeHola() throws RemoteException;

}
