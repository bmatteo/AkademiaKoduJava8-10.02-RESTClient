package pl.academy.code;

import org.springframework.web.client.RestTemplate;
import pl.academy.code.model.Country;
import pl.academy.code.model.GetAllCountriesResponse;
import pl.academy.code.model.GetCountryRequest;
import pl.academy.code.model.GetCountryResponse;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName("Poland");

        String url = "http://localhost:8080/api/getCountryByName";

        RestTemplate restTemplate = new RestTemplate();
        GetCountryResponse response = restTemplate.postForObject(url,
                request,
                GetCountryResponse.class,
                new HashMap<>());

        System.out.println(response.getCountry().getName());
        System.out.println(response.getCountry().getCapital());
        System.out.println(response.getCountry().getPopulation());

        String urlGet = "http://localhost:8080/api/getAllCountries";

        GetAllCountriesResponse responseGEt = restTemplate.getForObject(urlGet,
                GetAllCountriesResponse.class,
                new HashMap<>());

        for (Country c : responseGEt.getCountryList()) {
            System.out.println("---------------------------------");
            System.out.println(c.getName());
            System.out.println(c.getCapital());
            System.out.println(c.getPopulation());
        }
    }
}
