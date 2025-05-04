// interface file
package exp5; // here add you package name

import java.rmi.*;

public interface PrintI extends Remote {
    void show() throws RemoteException;
}

// class file

package exp5; // here add you package name

import java.rmi.*;
import java.util.*;
import java.rmi.server.*;
import exp5.PrintI;

public class PrintC extends UnicastRemoteObject implements PrintI {
    public PrintC() throws RemoteException {
        super();
    }

    public void show() {
        Scanner sc = new Scanner(System.in);
        int option = 1;
        while(option == 1) {
            int ch;
            System.out.println("Choose 1");
            System.out.println("1.) String");
            System.out.println("2.) Number");
            ch = sc.nextInt();
            sc.nextLine();

            switch(ch) {
                case 1: 
                    String str;
                    System.out.println("Enter String: ");
                    str = sc.nextLine();
                    str = str.replaceAll("\\s", "").toLowerCase();
                    String reversed = new StringBuilder(str).reverse().toString();
                    if(str.equals(reversed)) {
                        System.out.println("String is Palindrome");
                    } else {
                        System.out.println("String is not Palindrome");
                    }
                    break;
                case 2: 
                    int num;
                    System.out.println("Enter Number: ");
                    num = sc.nextInt();
                    int original = num, reversedNum = 0;
                    while(num > 0) {
                        int digit = num % 10;
                        reversedNum = reversedNum * 10 + digit;
                        num /= 10;
                    }

                    if(original == reversedNum) {
                        System.out.println("Number is Palindrome");
                    } else {
                        System.out.println("Number is not Palindrome");
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("Do you want to continue? (1 for Yes, 0 for No)");
            option = sc.nextInt();
        }
    }
}

// server file
package exp5; // here add you package name

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import exp5.PrintI;

public class Server {
    public static void main(String args[]) throws RemoteException, AlreadyBoundException {
        PrintC obj = new PrintC();
        Registry registry = LocateRegistry.createRegistry(5000);
        try {
            registry.bind("DISPLAY", obj);
            System.out.println("Server is ready");
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}

// client file
package exp5; // here add you package name

import java.rmi.*;
import java.util.*;
import java.rmi.registry.*;
import exp5.PrintI;

public class Client {
    public static void main(String args[]) throws RemoteException, MalformedURLException, NotBoundException {
        try {
            PrintI obj = (PrintI) Naming.lookup("rmi://localhost:5000/DISPLAY");
            obj.show();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}