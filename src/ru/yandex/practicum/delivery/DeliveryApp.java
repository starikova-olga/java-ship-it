package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static List<StandardParcel> standardParcels = new ArrayList<>();
    private static List<PerishableParcel> perishableParcels = new ArrayList<>();
    private static List<FragileParcel> fragileParcels = new ArrayList<>();


    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    updateLocations();
                    break;
                case 5:
                    showBoxContents();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Обновить местоположение трекинговых посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберите тип посылки:");
        System.out.println("1 - Стандартная");
        System.out.println("2 - Скоропортящаяся");
        System.out.println("3 - Хрупкая");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите описание посылки:");
        String description = scanner.nextLine();

        System.out.println("Введите вес посылки:");
        int weight = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите адрес назначения:");
        String deliveryAddress = scanner.nextLine();

        System.out.println("Введите день отправки:");
        int sendDay = scanner.nextInt();
        scanner.nextLine();


        int timeToLive = 0;
        if (choice == 2) {
            System.out.println("Введите время хранения (timeToLive):");
            timeToLive = scanner.nextInt();
            scanner.nextLine();
        }
        Parcel parcel;
        switch (choice) {
            case 1 -> {
                parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                standardParcels.add((StandardParcel) parcel);
            }
            case 2 -> {
                parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                perishableParcels.add((PerishableParcel) parcel);
            }
            case 3 -> {
                parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                fragileParcels.add((FragileParcel) parcel);
                trackableParcels.add((Trackable) parcel);

            }

            default -> {
                System.out.println("Неизвестный тип посылки.");
                return;
            }
        }
        allParcels.add(parcel);
        System.out.println("Посылка добавлена успешно.");
    }


    private static void sendParcels() {
        System.out.println("Введите текущий день месяца:");
        int currentDay = Integer.parseInt(scanner.nextLine());
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            if (parcel instanceof PerishableParcel) {
                PerishableParcel perishableParcel = (PerishableParcel) parcel;
                if (perishableParcel.isExpired(currentDay)) {
                    System.out.println("Посылка " + perishableParcel.getDescription() + " испортилась и не может быть отправлена.");
                } else {
                    parcel.packageItem();
                    parcel.deliver();
                }
            } else {
                parcel.packageItem();
                parcel.deliver();
            }
        }
    }


    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double totalCost = 0.0;

        for (Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }

        System.out.println("Общая стоимость всех доставок: " + totalCost);
    }

    static void updateLocations() {
        System.out.println("Введите новое местоположение:");
        String newLocation = scanner.nextLine();
        for (Trackable parcel : trackableParcels) {
            parcel.reportStatus(newLocation);


        }
    }

    private static void showBoxContents() {
        System.out.println("Выберите тип коробки:");
        System.out.println("1 - Стандартная");
        System.out.println("2 - Скоропортящаяся");
        System.out.println("3 - Хрупкая");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1 -> showContents(standardParcels);
            case 2 -> showContents(perishableParcels);
            case 3 -> showContents(fragileParcels);

            default -> System.out.println("Неизвестный тип посылки.");

        }
    }


    private static void showContents(List<? extends Parcel> parcels) {
        for (Parcel parcel : parcels) {
            System.out.println(parcel.getDescription());
        }
    }
}






