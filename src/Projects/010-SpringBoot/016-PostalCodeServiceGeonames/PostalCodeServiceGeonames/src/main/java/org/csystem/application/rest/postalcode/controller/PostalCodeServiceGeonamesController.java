package org.csystem.application.rest.postalcode.controller;

import org.csystem.application.rest.postalcode.dto.PostalCodeInfoDTO;
import org.csystem.application.rest.postalcode.service.PostalCodeAppService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/postalcodes")
public class PostalCodeServiceGeonamesController {
    private final PostalCodeAppService m_postalCodeAppService;

    public PostalCodeServiceGeonamesController(PostalCodeAppService postalCodeAppService)
    {
        m_postalCodeAppService = postalCodeAppService;
    }

    @GetMapping("postalcode")
    public List<PostalCodeInfoDTO> findPostalCodeInfoByPostalCode(@RequestParam("code") int postalCode)
    {
        return m_postalCodeAppService.findPostalCodeInfoByPostalCode(postalCode);
    }

    @GetMapping("rpostalcode")
    public ResponseEntity<List<PostalCodeInfoDTO>> findPostalCodeInfoByPostalCodeRE(@RequestParam("code") int postalCode)
    {
        throw new UnsupportedOperationException("TODO:Please write that action method");
    }

    @GetMapping("epostalcode")
    public ResponseEntity<List<PostalCodeInfoDTO>> findPostalCodeInfoByPostalCode(@RequestParam("code") String postalCode)
    {
        throw new UnsupportedOperationException("TODO:Please write that action method");
    }

    //http://host:50501/api/postalcodes/postalcode/country?code=6700&country=EN -> default TR olacak
    @GetMapping("postalcode/country")
    public ResponseEntity<List<PostalCodeInfoDTO>> findPostalCodeInfoByPostalCodeAndCountry(
            @RequestParam("code") int postalCode, @RequestParam(defaultValue = "TR") String country)
    {
        throw new UnsupportedOperationException("TODO:Please write that action method");
    }

}
