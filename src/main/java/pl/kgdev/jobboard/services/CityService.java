package pl.kgdev.jobboard.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kgdev.jobboard.entities.City;
import pl.kgdev.jobboard.repositories.CityRepository;

import java.util.List;

@Service
public class CityService {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAll(){
        return cityRepository.findAll();
    }
}
