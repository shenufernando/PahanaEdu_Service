package db;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHasher {

//    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String adminPassword = encoder.encode("admin123");
//        String userPassword = encoder.encode("customer123");
//
//        System.out.println("Admin Hashed Password: " + adminPassword);
//        System.out.println("Customer Hashed Password: " + userPassword);
//    }
    // Singleton encoder instance (best practice)
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // ✅ Hash the password
    public static String hashPassword(String password) {
        return encoder.encode(password);
    }

    // ✅ Check password match
    public static boolean checkPassword(String rawPassword, String hashedPassword) {
        return encoder.matches(rawPassword, hashedPassword);
    }
}