package org.csystem.application.runner.configuration;

import org.csystem.application.runner.component.IOperation;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModulusOperationConfig {
    private final IOperation m_operation;

    private void runnerCallback()
    {
        Console.writeLine("------------------------------------------");
        Console.writeLine("ModulusOperationRunner:");
        m_operation.doOperation();
        Console.writeLine("------------------------------------------");
    }

    public ModulusOperationConfig(@Qualifier("modulusOperation") IOperation operation)
    {
        m_operation = operation;
    }

    @Bean
    public ApplicationRunner runModulus()
    {
        return args -> runnerCallback();
    }
}
