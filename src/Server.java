/*
* Antes de ejecutar la clase Server, debe ejecutarse desde linea de comandos:
*           rmiregistry
* TENER CUIDADO, DEBE EJECUTARSE EXACTAMENTE EN LA RAIZ DONDE SE ENCUENTRAN LOS ARCHIVOS .class
* DE LO CONTRARIO FALLARÁ.
* */
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello {
    /*
    Implementamos los métodos que pertenecen a la interfaz Hello
    * */
    @Override
    public String dimeHola() {
        return "Hola!!!";
    }

    @Override
    public int suma(int a, int b) throws RemoteException {
        return (a+b);
    }

    public static void main(String args[]) {

        try {
            Server s = new Server();
            //Generamos un objeto el cual se va a publicar en un puerto determinado
            Hello st = (Hello) UnicastRemoteObject.exportObject(s,5000);

            // Vinculamos el servicio con el registro para poder recuperarlo desde el cliente.
            // si no modificamos nada, el registro queda ejecutandose en el puerto 1099
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hola", st);

            System.err.println("Servidor listo");
        } catch (RemoteException e) {
            System.err.println("Algo ha salido mal: " + e.toString());
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            System.err.println("Ya estaba vinculada: " + e.toString());
            e.printStackTrace();
        }
    }
}