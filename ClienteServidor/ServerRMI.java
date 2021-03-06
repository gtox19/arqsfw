package tp3cliserv;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

public class ServerRMI {

    public static void main(String[] args) throws RemoteException {

        try {
            java.rmi.registry.LocateRegistry.createRegistry(5000);
            System.out.println("RMI registry ready.");
        } catch (Exception e) {
            System.out.println("Exception starting RMI registry:");
        }
        try {
            String name = "Storage";

            Vector<Integer> xdk1_reading_1 = new Vector<>();
            xdk1_reading_1.add(23);
            xdk1_reading_1.add(2);
            xdk1_reading_1.add(3);
            xdk1_reading_1.add(54);
            xdk1_reading_1.add(32);

            Vector<Integer> xdk1_reading_2 = new Vector<>();
            xdk1_reading_2.add(22);
            xdk1_reading_2.add(24);
            xdk1_reading_2.add(3);
            xdk1_reading_2.add(4);
            xdk1_reading_2.add(5);

            // Criação e exportação do objecto remoto
            DataStoreInterface ds = new DataStore();
            DataStoreInterface stub = (DataStoreInterface) UnicastRemoteObject.exportObject(ds, 0);

            // simular a recepÃ§Ã£o de valores
            ds.update(1, xdk1_reading_1);
            ds.update(1, xdk1_reading_2);

            // Registo do objecto remoto
            Registry registry = LocateRegistry.getRegistry(5000);
            registry.rebind(name, stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.err.println("exception:" + e.toString());
        }
    }
}
