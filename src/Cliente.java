import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * User: rober
 * Date: 1/10/13
 * Time: 01:49 PM
 * Agregar la descripción del archivo
 */
public class Cliente {
    public static void main(String args[]){
        String host= "127.0.0.1";
        try {
            Registry registro = LocateRegistry.getRegistry(host);
            Hello remoto = (Hello)registro.lookup("Hola");
            String respuesta = remoto.dimeHola();
            System.out.println(respuesta);
        } catch (RemoteException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (NotBoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
