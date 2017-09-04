package encapsulated;

import sun.security.x509.X500Name;

public class EncapsulatedTypes {
    public static void main(String... args) throws Exception {
        System.out.println(new X500Name("test.com", "test",
                     "test", "US"));

    }
}
