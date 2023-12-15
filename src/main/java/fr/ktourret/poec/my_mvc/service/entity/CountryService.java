package fr.ktourret.poec.my_mvc.service.entity;

import fr.ktourret.poec.my_mvc.dao.DAOService;
import fr.ktourret.poec.my_mvc.entity.Country;
import fr.ktourret.poec.my_mvc.repository.CountryRepository;

import java.util.List;
import java.util.Map;

public class CountryService implements DAOService<Country> {

    private CountryRepository countryRepository = CountryRepository.getRepository();

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> findBy(Map<String, Object> fields, Integer limit, Map<String, String> orders) {
        return countryRepository.findBy(fields, limit, orders);
    }

    @Override
    public Country findOneBy(String field, Object value) {
        return countryRepository.findOneBy(field, value);
    }

    @Override
    public Country save(Country o) {
        return countryRepository.save(o);
    }

    public Country handleForm(String name, String code, String nationality) {
        Country country = new Country();
        country.setCode(code);
        country.setName(name);
        country.setNationality(nationality);
        return save(country);
    }

}
