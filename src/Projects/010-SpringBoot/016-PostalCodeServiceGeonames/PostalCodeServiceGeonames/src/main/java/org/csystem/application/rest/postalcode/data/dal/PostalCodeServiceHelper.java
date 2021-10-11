package org.csystem.application.rest.postalcode.data.dal;

import org.csystem.application.rest.postalcode.data.entity.PostalCode;
import org.csystem.application.rest.postalcode.data.entity.PostalCodeInfo;
import org.csystem.application.rest.postalcode.data.repository.IPostalCodeInfoRepository;
import org.csystem.application.rest.postalcode.data.repository.IPostalCodeRepository;
import org.springframework.stereotype.Component;

import static org.csystem.util.data.DatabaseUtil.doWorkForRepository;

@Component
public class PostalCodeServiceHelper {
    private final IPostalCodeRepository m_postalCodeRepository;
    private final IPostalCodeInfoRepository m_postalCodeInfoRepository;

    public PostalCodeServiceHelper(IPostalCodeRepository postalCodeRepository, IPostalCodeInfoRepository postalCodeInfoRepository)
    {
        m_postalCodeRepository = postalCodeRepository;
        m_postalCodeInfoRepository = postalCodeInfoRepository;
    }

    public boolean existsPostalCodeById(int postalCode)
    {
        return doWorkForRepository(() -> m_postalCodeRepository.existsById(postalCode), "PostalCodeServiceHelper.existsPostalCodeById");
    }

    public Iterable<PostalCodeInfo> findPostalCodeInfoByPostalCode(int postalCode)
    {
        return doWorkForRepository(() -> m_postalCodeInfoRepository.findByPostalCode(postalCode),
                "PostalCodeServiceHelper.findPostalCodeInfoByPostalCode");
    }

    public PostalCode savePostalCode(PostalCode postalCode)
    {
        return doWorkForRepository(() -> m_postalCodeRepository.save(postalCode), "PostalCodeServiceHelper.savePostalCode");
    }

    public PostalCodeInfo savePostalCodeInfo(PostalCodeInfo postalCodeInfo)
    {
        return doWorkForRepository(() -> m_postalCodeInfoRepository.save(postalCodeInfo), "PostalCodeServiceHelper.savePostalCodeInfo");
    }
}
