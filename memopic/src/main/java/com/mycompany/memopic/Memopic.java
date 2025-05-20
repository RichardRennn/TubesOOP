package com.mycompany.memopic;

import java.util.*;

public class Memopic {
    static Scanner scanner = new Scanner(System.in);
    static User currentUser;
    

    public static void main(String[] args) {
        DatabaseManager.initDatabase();
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Pilih: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> System.exit(0);
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    static void register() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (User.register(username, email, password)) {
            System.out.println("Registrasi berhasil!");
        } else {
            System.out.println("Username sudah digunakan!");
        }
    }

    static void login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        currentUser = User.login(username, password);
        if (currentUser != null) {
            currentUser.showWelcomeMessage();
            diaryMenu();
        } else {
            System.out.println("Login gagal. Coba lagi.");
        }
    }

    static void diaryMenu() {
        MemoActions memo = new MemoImpl(); // ✔️ jika kamu punya class seperti ini

        while (true) {
            System.out.println("\n1. Tambah Catatan\n2. Lihat Catatan\n3. Logout");
            System.out.print("Pilih: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Judul: ");
                    String title = scanner.nextLine();
                    System.out.print("Isi: ");
                    String content = scanner.nextLine();
                    memo.addEntry(currentUser, title, content,null);
                }
                case 2 -> memo.viewEntries(currentUser);
                case 3 -> {
                    currentUser = null;
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}