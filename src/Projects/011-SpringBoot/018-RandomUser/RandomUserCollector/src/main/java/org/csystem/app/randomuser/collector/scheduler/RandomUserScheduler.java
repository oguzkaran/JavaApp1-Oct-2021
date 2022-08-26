package org.csystem.app.randomuser.collector.scheduler;

import com.google.gson.Gson;
import org.csystem.app.randomuser.collector.data.entity.RandomUserInfo;
import org.csystem.app.randomuser.collector.data.repository.IRandomUserInfoRepository;
import org.csystem.app.randomuser.collector.dto.UserInfoDTO;
import org.csystem.app.randomuser.collector.mapper.IUserInfoMapper;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@EnableScheduling
public class RandomUserScheduler {
    private final Gson m_gson;
    private final RestTemplate m_restTemplate;

    private final IRandomUserInfoRepository m_randomUserInfoRepository;

    private final IUserInfoMapper m_userInfoMapper;


    @Value("${randomuser.me.url}")
    private String m_url;

    public RandomUserScheduler(Gson gson, RestTemplate restTemplate, IRandomUserInfoRepository randomUserInfoRepository, IUserInfoMapper userInfoMapper)
    {
        m_gson = gson;
        m_restTemplate = restTemplate;
        m_randomUserInfoRepository = randomUserInfoRepository;
        m_userInfoMapper = userInfoMapper;
    }

    @Scheduled(fixedRate = 100)
    public void schedule()
    {
        Console.writeLine("----------------------------------");
        var user = m_restTemplate.getForObject(m_url, UserInfoDTO.class);
        var json = m_gson.toJson(user);
        Console.writeLine(json);
        var rui = new RandomUserInfo();

        rui.first = user.results.get(0).name.first;
        rui.last = user.results.get(0).name.last;
        rui.userInfo = m_userInfoMapper.toUserInfo(user);

        m_randomUserInfoRepository.save(rui);
        Console.writeLine("----------------------------------");
    }
}

