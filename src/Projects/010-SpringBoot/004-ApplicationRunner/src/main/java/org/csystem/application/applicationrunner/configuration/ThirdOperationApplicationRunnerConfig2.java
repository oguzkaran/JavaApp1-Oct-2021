package org.csystem.application.applicationrunner.configuration;

import org.csystem.application.applicationrunner.component.ThirdOperation;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThirdOperationApplicationRunnerConfig2 {
    private final ThirdOperation m_thirdOperation;

    public ThirdOperationApplicationRunnerConfig2(ThirdOperation thirdOperation)
    {
        m_thirdOperation = thirdOperation;
    }

    @Bean("config2")
    public ApplicationRunner runThirdOperation()
    {
        return args -> m_thirdOperation.doOperation();
    }
}
