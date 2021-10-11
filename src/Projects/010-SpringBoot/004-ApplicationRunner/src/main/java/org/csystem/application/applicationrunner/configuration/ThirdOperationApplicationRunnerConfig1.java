package org.csystem.application.applicationrunner.configuration;

import org.csystem.application.applicationrunner.component.ThirdOperation;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdOperationApplicationRunnerConfig1 {
    private final ThirdOperation m_thirdOperation;

    public ThirdOperationApplicationRunnerConfig1(ThirdOperation thirdOperation)
    {
        m_thirdOperation = thirdOperation;
    }

    @Bean("config1")
    public ApplicationRunner runThirdOperation()
    {
        return args -> m_thirdOperation.doOperation();
    }
}
