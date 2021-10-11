package org.csystem.application.applicationrunner.runner;

import org.csystem.application.applicationrunner.component.SecondOperation;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SecondOperationRunner implements ApplicationRunner  {
    private final SecondOperation m_secondOperation;

    public SecondOperationRunner(SecondOperation secondOperation)
    {
        m_secondOperation = secondOperation;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        m_secondOperation.doOperation();
    }
}
