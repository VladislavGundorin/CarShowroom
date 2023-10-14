package com.example.CarShowroom.init;
import com.example.CarShowroom.dtos.*;
import com.example.CarShowroom.models.Client;
import com.example.CarShowroom.models.CarKomplektatsiya;
import com.example.CarShowroom.models.Manager;
import com.example.CarShowroom.repositories.ManagerRepository;
import com.example.CarShowroom.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.CarShowroom.models.Car;
import com.example.CarShowroom.models.Komplektatsiya;
import com.example.CarShowroom.services.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.ReactiveAdapterRegistry;
import org.springframework.stereotype.Component;
import com.example.CarShowroom.models.Car;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Component
    public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private ManagerService managerService;
    @Autowired
    private KomplektatsiyaService komplektatsiyaService;
    @Autowired
    private CarService carService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private CarKomplektatsiyaService carKomplektatsiyaService;
    @Autowired
    private ClientManagerService clientManagerService;

    @Override
    public void run(String... args) throws Exception {
        seedData();
    }

    private void seedData() throws IOException {
        //Создание Машины
        CarDto car1 = new CarDto(0, "Renault", "Кросовер", 2016, "Франция", 150000);
        CarDto car2 = new CarDto(0, "Ford", "Седан", 1965, "США", 150000);
        CarDto car3 = new CarDto(0, "Ferrari", "Купе", 2018, "Италия", 1000);
        CarDto car4 = new CarDto(0, "GTR", "Купе", 2017, "Япония", 12000000);
        //Добавление
        carService.createCar(car1);
        carService.createCar(car2);
        carService.createCar(car3);
        carService.createCar(car4);
        // Получение списка всех объектов Car
//        List<CarDto> cars = carService.getAllCars();
//        System.out.println(cars);
        // Получение объекта Car по идентификатору
//        Optional<CarDto> carById = carService.getCarById(1);
//        carById.ifPresent(System.out::println);
        // Обновление информации об объекте Car
//        car1.setPrice(900000);
//        CarDto updatedCar = carService.updateCar(car1);
//        System.out.println(updatedCar);
        // Удаление объекта Car
//        carService.deleteCar(2);
//        List<CarDto> remainingCars = carService.getAllCars();
//        System.out.println("Оставшиеся машины:");
//        for (CarDto car : remainingCars) {
//            System.out.println(car);
        //Получить Автомобиле по Году выпуска старше 2016
//        carService.findCarsByYearOfReleaseGreaterThan(2016).forEach(System.out::println);
        //Получить все автомобиле тип кузова которых:
//        carService.findCarsByTypeOfBody("Купе").forEach(System.out::println);
        //Создаем Клиентов
        ClientDto client1 = new ClientDto(0, 100000, "Постоянный клиент", false, "Влад");
        ClientDto client2 = new ClientDto(0, 300000, "Постоянный клиент", true, "Денис");
        ClientDto client3 = new ClientDto(0, 100000, "Новый клиент ", true, "Артем");
        // Сохранение клиентов
        clientService.createClient(client1);
        clientService.createClient(client2);
        clientService.createClient(client3);
        //Получение списка всех объектов Client
//            List<ClientDto> clients = clientService.getAllClients();
//            System.out.println(clients);
        //Получение клиента по ID
//            Optional<ClientDto> clientById = clientService.getClientById(1);
//            System.out.println(clientById);
        //Изменение клиента
//        client1.setCash(3000000);
//        ClientDto updateClient = clientService.updateClient(client1);
//        System.out.println(updateClient);
//        //удаление клиента по ид
//        clientService.deleteClient(3);
//        List<ClientDto> remainingClients = clientService.getAllClients();
//        System.out.println("Оставшиеся клиенты:");
//        for (ClientDto client : remainingClients) {
//            System.out.println(client);
        //Подучить всех клиентов с статусом:
//        clientService.findClientsByClientStatus("Постоянный клиент").forEach(System.out::println);
        //Создание комплектаций
        KomplektatsiyaDto komplektatsiya1 = new KomplektatsiyaDto(0, "Двигатель 1.6L", "Базовая", "Автоматическая", true);
        KomplektatsiyaDto komplektatsiya2 = new KomplektatsiyaDto(0, "Двигатель 2.0L", "Премиум", "Автоматическая", true);
        KomplektatsiyaDto komplektatsiya3 = new KomplektatsiyaDto(0, "Двигатель 3.0L", "Люкс", "Механическая", true);
        KomplektatsiyaDto komplektatsiya4 = new KomplektatsiyaDto(0, "Двигатель 2.5L", "Спорт", "Автоматическая", true);
        //добавление комплектации
        komplektatsiyaService.createKomplektatsiya(komplektatsiya1);
        komplektatsiyaService.createKomplektatsiya(komplektatsiya2);
        komplektatsiyaService.createKomplektatsiya(komplektatsiya3);
        komplektatsiyaService.createKomplektatsiya(komplektatsiya4);
        //соединение машин и комплектации
        carKomplektatsiyaService.addCarToKomplektatsiya(1, 1);
        carKomplektatsiyaService.addCarToKomplektatsiya(2, 2);
        carKomplektatsiyaService.addCarToKomplektatsiya(3, 3);
        carKomplektatsiyaService.addCarToKomplektatsiya(4, 4);
        // Вывод всех комплектаций
//            List<KomplektatsiyaDto> allKomplektatsiyas = komplektatsiyaService.getAllKomplektatsiyas();
//            System.out.println(allKomplektatsiyas);
        //Получение клиента по ID
//            Optional<KomplektatsiyaDto> KomplektatsiyaById = komplektatsiyaService.getKomplektatsiyaById(1);
//            System.out.println(KomplektatsiyaById);
        //Изменение клиента
//        Optional<KomplektatsiyaDto> komplektatsiyaDtoOptional = komplektatsiyaService.getKomplektatsiyaById(4);
//        if (komplektatsiyaDtoOptional.isPresent()) {
//            KomplektatsiyaDto komplektatsiyaDto = komplektatsiyaDtoOptional.get();
//            komplektatsiyaDto.setTransmissionType("Механическая");
//            KomplektatsiyaDto updatedKomplektatsiyaDto = komplektatsiyaService.updateKomplektatsiya(4, komplektatsiyaDto);
//            System.out.println(updatedKomplektatsiyaDto);
        //удаление клиента по ид
//        komplektatsiyaService.deleteKomplektatsiya(3);
//        List<KomplektatsiyaDto> remainingKomplektatsiya = komplektatsiyaService.getAllKomplektatsiyas();
//        System.out.println("Оставшиеся клиенты:");
//        for (KomplektatsiyaDto komplektatsiya : remainingKomplektatsiya) {
//            System.out.println(komplektatsiya);
        //вывод комплектация с определнной трансмисией
//            komplektatsiyaService.findKomplektatsiyaByTransmissionType("Автоматическая").forEach(System.out::println);
        //Создание Менеджеров
        ManagerDto manager1 = new ManagerDto(0, 0, 100, "Влад");
        ManagerDto manager2 = new ManagerDto(0, 0, 100, "Денис");
        ManagerDto manager3 = new ManagerDto(0, 0, 10, "Артём");
        ManagerDto manager4 = new ManagerDto(0, 0, 20, "Гоша");
        //Cохранение Менеджера
        managerService.createManager(manager1);
        managerService.createManager(manager2);
        managerService.createManager(manager3);
        managerService.createManager(manager4);
        //создание Менеджеров работающих с клиентами
        clientManagerService.addManagerToClient(1,1);
        clientManagerService.addManagerToClient(2,1);
        clientManagerService.addManagerToClient(3,1);

//        managerService.findNumberOfRegularClientsByManagerId(1).forEach(System.out::println);
        //Получение списка всех объектов Manager
//        List<ManagerDto> managers = managerService.getAllManagers();
//        System.out.println(managers);
        //Получение менеджера по ID
//        Optional<ManagerDto> managerById = managerService.getManagerById(1);
//        System.out.println(managerById);
        //Изменение менеджера
//        Optional<ManagerDto> managerDtoOptional = managerService.getManagerById(4);
//        if (managerDtoOptional.isPresent()) {
//            ManagerDto managerDto = managerDtoOptional.get();
//            managerDto.setSkidkaKliyentu(15);
//            ManagerDto updatedManagerDto = managerService.updateManager(managerDto);
//            System.out.println(updatedManagerDto);
        //Удаление менеджера по ID
//        managerService.deleteManager(4);
//        List<ManagerDto> remainingManagers = managerService.getAllManagers();
//        System.out.println("Оставшиеся менеджеры:");
//        for (ManagerDto managerDto : remainingManagers) {
//            System.out.println(managerDto);
        //получение списка менеджеров в алфавитном порядке
//        managerService.findAllByOrderByNameBadgeAsc().forEach(System.out::println);

    }
}




