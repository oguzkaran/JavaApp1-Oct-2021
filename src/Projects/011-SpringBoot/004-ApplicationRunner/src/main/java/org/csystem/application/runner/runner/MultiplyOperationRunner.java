package org.csystem.application.runner.runner;

import org.csystem.application.runner.component.IOperation;
import org.csystem.util.console.Console;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class MultiplyOperationRunner implements ApplicationRunner {
    private final IOperation m_operation;

    public MultiplyOperationRunner(@Qualifier("multiplyOperation") IOperation operation)
    {
        m_operation = operation;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        Console.writeLine("------------------------------------------");
        Console.writeLine("MultiplyOperationRunner:");
        m_operation.doOperation();
        Console.writeLine("------------------------------------------");
    }
}
