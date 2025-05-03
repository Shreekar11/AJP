package exp6;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAdd {
    public static void main(String args[]) {
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println("1. Address of Local Host: " + ip1.getHostName());

        InetAddress ip2 = InetAddress.getByName("www.amazon.com");
        System.out.println("2. Address of Amazon: " + ip2.getHostName());

        byte[] ipAddress = { 10, 10, 13, 38 };
        InetAddress ip3 = InetAddress.getByAddress(ipAddress);
        System.out.println("3. Address of IP: " + ip3.getHostName());

        InetAddress[] ip4 = InetAddress.getAllByName("www.pict.edu");
        for (InetAddress inetAddress : ip4) {
            System.out.println("4. Address of url: " + inetAddress);
        }
        
        InetAddress ip5 = InetAddress.getByAddress("pict.edu", ipAddress);
        System.out.println("5. Inetaddress of host with ip address and hostname: " + ip5);
        System.out.println("6. Host name of inetaddress: " + ip2.getHostName());
        System.out.println("7. Address of host hold by inetaddress object: " + ip2.getHostAddress());
        System.out.println("8. Address equals or not: " + ip2.equals(ip1));
        System.out.println("9. To sting convert: "+ ip2);
        System.out.println("10. It is multicast address or not: " + ip2.isMulticastAddress());
        System.out.println("This is InetAddress class use");
    }
}