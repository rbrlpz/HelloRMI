import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * User: rober
 * Date: 1/10/13
 * Time: 01:23 PM
 * Agregar la descripción del archivo
 */
public class Server implements Hello {

    @Override
    public String dimeHola() throws RemoteException {
        return "Hola";  //To change body of implemented methods use File | Settings | File Templates.
    }

    public static void main(String args[]){
        try{
        Server s = new Server();
        Hello publicado = (Hello)UnicastRemoteObject.exportObject(s,5000);
        Registry registro = LocateRegistry.getRegistry();
        registro.bind("Hola",publicado);
              System.out.println("Server Running");
        }catch (RemoteException re){
            System.out.println("Algo salio mal: "+re.getMessage());
        } catch (AlreadyBoundException e) {
            System.out.println("Ya esta registrado");
        }
    }
}
