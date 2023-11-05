package Controller;

import config.HibernateUtils;

import java.util.Scanner;

public class FilmManagementSystem {
    private static Scanner scanner = new Scanner(System.in);

    public static void displayMenuFilmManagementSystem() {
        System.out.println("Kullanıcı Girişi için 1" +
                "\nAdmin Girişi için 2:" +
                "\nArşiv Görüntüleme 3");
        int select = scanner.nextInt();
        scanner.nextLine();

        if (select == 1) {
            displayUserMenu();
        } else if (select == 2) {
            displayAdminMenu();
        }  else if (select == 3) {
            displayFilmArchive();
        } else {
            System.out.println("Geçersiz tuşlama");
        }


    }

    private static void displayAdminMenu() {
        System.out.println("****YÖNETİCİ SAYFASI*****");
        boolean exit = false;
        while (!exit) {
            System.out.println("1)" +//tüm işlemler id ile yapılacak
                             "\n2)" +
                             "\n3)" +
                             "\n4)" +
                             "\n0)ÇIKIŞ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    exit = true;
                    System.out.println("Yönetici sayfasından Çıkıyorsunuz");
                    HibernateUtils.shutDown();
                    break;
                default:
                    System.out.println("Yanlış Tuşlama");


            }
        }
    }//değişebilir içeriği


    private static void displayUserMenu() {
        System.out.println("****KULLANICI SAYFASI****");

        boolean exit = false;
        while (!exit) {
            System.out.println("1)Tüm Filmleri Görüntüleme" +
                             "\n2)En Son Eklenen Filmleri Görüntüleme" +//en son eklenen 3 filmi getirme
                             "\n3)Kategorisine Göre Filmleri Görüntüleme" +//KATEGORİ seçenkleri sunulup ona göre filmleri getirme
                             "\n4)Dillere Göre Görüntüleme" +
                             "\n5)IMDB puanına Göre Görüntüleme" +//bu kısımda içinde 2 seçenek daha sunulabilir artan ve azalan
                             "\n6)Film Arama" +//lıke veya ~ kullanarak film ismini bulma
                    "\n0)ÇIKIŞ ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //service classından tüm filmleri gösteren method yazma
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    exit = true;
                    System.out.println("Good BYE");
                    HibernateUtils.shutDown();
                    break;
                default:
                    System.out.println("Yanlış Tuşlama");
            }
        }
    }

    public static void displayFilmArchive() {

        boolean exit = false;

        while (!exit) {
            System.out.println("******* Film Archive Menu *******");
            System.out.println("1. Film Operations");
            System.out.println("2. Actor Operations");
            System.out.println("3. Category Operations");
            System.out.println("4. Language Operations");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 0:
                    exit = true;
                    System.out.println("Good bye...");
                    HibernateUtils.shutDown();
                    break;
                default:
                    System.out.println("Invalid choice, Please try again");
                    break;
            }

        }
    }


}
