// interface file

package exp8;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.RemoteException;

public interface PrintI extends Remote {
    public void show() throws RemoteException;
}

// class file
package exp8;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class PrintC extends UnicastRemoteObject implements PrintI {
    public PrintC() throws RemoteException {
        super();
    }

    public void show() {
        Scanner sc = new Scanner(System.in);
        int option = 1;
        while(option) {
            System.out.println("Enter a number to calculate factorial:");
            int num = sc.nextInt();
            sc.nextLine();

            if(num < 0) {
                System.out.println("Factorial of negative numbers is not defined.");
            } else {
                int fact = 1;
                for(int i = 1; i <= num; i++) {
                    fact *= i;
                }
                System.out.println("Factorial of " + num + " is: " + fact);
            }

            System.out.println("Do you want to continue? (1 for Yes, 0 for No):");
            option = sc.nextInt();
        }
        sc.close();
    }
}

// server file

package exp8;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class Server {
    public static void main(String args[]) throws RemoteException, AlreadyBoundException {
        PrintC obj = new PrintC();
        Registry registry = LocateRegistry.createRegistry(6000);
        try {
            registry.bind("DISPLAY", obj);
        } catch(AlreadyBoundException e) {
            System.out.println("Already bound exception: " + e);
        }
    }
}

// client file
package exp8;
import java.rmi.*;
import java.util.*;
import java.net.MalformedURLException;

public class Client {
    public static void main(String args[]) throws RemoteException, MalformedURLException {
        try {
            PrintI obj = (PrintI) Naming.lookup("rmi://localhost:6000/DISPLAY");
            obj.show();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}