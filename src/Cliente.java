/*
* Antes de ejecutar ésta clase, debe ejecutarse la clase server (obviamente)
* Tomar en cuenta que al realizar un deploy final, la interfáz del cliente, debe coincidir
* con la interfaz del server para que puedan comunicarse en el mismo canal.
* */
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {

        String host = "127.0.0.1";
        try {
            //Buscamos el registro en la direccion del servidor, lo almacenamos en la variable registro
            Registry registro = LocateRegistry.getRegistry(host);
            //buscamos el dato que registramos en el server, EXACTAMENTE CON EL MISMO NOMBRE
            //como sabemos que lo que guardamos alli, proviene de la interface Hello, realizamos
            //un casting para poder manipularlo.
            Hello remoto = (Hello) registro.lookup("Hola");
            //ahora que tenemos el objeto podemos mandar llamar cualquiera de sus métodos diréctamente.
            System.out.println("Respuesta del server: " + remoto.dimeHola());
            System.out.println("Sumando: " + remoto.suma(2,5));

        } catch (Exception e) {
            System.err.println("Error: " + e.toString());
            e.printStackTrace();
        }
    }
}