package pl.kgdev.jobboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.kgdev.jobboard.entities.City;
import pl.kgdev.jobboard.entities.Role;
import pl.kgdev.jobboard.entities.RoleEnum;
import pl.kgdev.jobboard.entities.User;
import pl.kgdev.jobboard.repositories.CityRepository;
import pl.kgdev.jobboard.repositories.RoleRepository;
import pl.kgdev.jobboard.repositories.UserRepository;
import pl.kgdev.jobboard.services.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InitialDataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private UserService userService;

    private boolean initNeeded = false;

    @Override
    public void run(String... args) throws Exception {
        if(initNeeded) {
            initializeCities();
            initializeRoles();

            User admin = new User("Administrator", " ", "Admin", "admin@admin.pl", "660770890", " ");
            admin.encode("admin");
            userService.saveAdmin(admin);
        }
    }

    private void initializeRoles(){
        List<RoleEnum> roleNames = Arrays.asList(RoleEnum.values());
        roleNames.forEach(roleEnum -> roleRepository.save(new Role(roleEnum.name())));
    }

    private void initializeCities(){
        String cityNames[] = {"Warszawa","Kraków", "Łódź", "Wrocław", "Poznań", "Gdańsk", "Szczecin", "Bydgoszcz", "Lublin", "Białystok", "Katowice",
                "Gdynia", "Częstochowa", "Radom", "Toruń", "Sosnowiec", "Kielce", "Rzeszów", "Gliwice", "Zabrze", "Olsztyn", "Bielsko-Biała", "Bytom", "Zielona Góra", "Rybnik", "Ruda Śląska", "Opole", "Tychy", "Gorzów Wielkopolski", "Dąbrowa Górnicza", "Elbląg", "Płock", "Wałbrzych", "Włocławek", "Tarnów", "Chorzów", "Koszalin", "Kalisz"};
        Arrays.asList(cityNames).forEach(cityName -> cityRepository.save(new City(cityName)));
    }
}
