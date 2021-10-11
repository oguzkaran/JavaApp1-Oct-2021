package org.csystem.application.rest.postalcode.service;

import org.csystem.application.rest.postalcode.data.dal.PostalCodeServiceHelper;
import org.csystem.application.rest.postalcode.data.entity.PostalCode;
import org.csystem.application.rest.postalcode.data.entity.PostalCodeInfo;
import org.csystem.application.rest.postalcode.dto.PostalCodeInfoDTO;
import org.csystem.application.rest.postalcode.geonames.json.dto.PostalCodeGeoNames;
import org.csystem.application.rest.postalcode.mapper.IPostalCodeMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostalCodeAppService {
    private final PostalCodeServiceHelper m_postalCodeServiceHelper;
    private final RestTemplate m_restTemplate;
    private final IPostalCodeMapper m_postalCodeInfoMapper;

    @Value("${geonames.uri}")
    private String m_urlTemplate;

    public void getAndSavePostalCodesForEachCallback(PostalCodeInfo postalCodeInfo, PostalCode postalCode)
    {
        postalCodeInfo.postalCode = postalCode;
        m_postalCodeServiceHelper.savePostalCodeInfo(postalCodeInfo);
    }

    public List<PostalCodeInfoDTO> getAndSavePostalCodes(int postalCode)
    {
        var url = String.format(m_urlTemplate, postalCode);

        var postalCodes = Objects.requireNonNull(m_restTemplate.getForObject(url, PostalCodeGeoNames.class), "Geonames get errors")
                .postalCodeGeoNames;

        var pc = m_postalCodeServiceHelper.savePostalCode(new PostalCode(postalCode));

        postalCodes.stream().map(m_postalCodeInfoMapper::toPostalCodeInfo)
                .forEach(pci -> getAndSavePostalCodesForEachCallback(pci, pc));

        return postalCodes.stream().map(m_postalCodeInfoMapper::toPostalCodeInfoDTO).collect(Collectors.toList());
    }

    public List<PostalCodeInfoDTO> getPostalCodes(int postalCode)
    {
        return StreamSupport.stream(m_postalCodeServiceHelper.findPostalCodeInfoByPostalCode(postalCode).spliterator(), false)
                .map(m_postalCodeInfoMapper::toPostalCodeInfoDTO).collect(Collectors.toList());
    }

    public PostalCodeAppService(PostalCodeServiceHelper postalCodeServiceHelper,
                                RestTemplate restTemplate,
                                IPostalCodeMapper postalCodeInfoMapper)
    {
        m_postalCodeServiceHelper = postalCodeServiceHelper;
        m_restTemplate = restTemplate;
        m_postalCodeInfoMapper = postalCodeInfoMapper;
    }

    public List<PostalCodeInfoDTO> findPostalCodeInfoByPostalCode(int postalCode)
    {
        return m_postalCodeServiceHelper.existsPostalCodeById(postalCode) ? getPostalCodes(postalCode)
                : getAndSavePostalCodes(postalCode);
    }
}
