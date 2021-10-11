package org.csystem.application.rest.todo.runner;

import org.csystem.application.rest.todo.data.repository.ITodoRepository;
import org.csystem.util.Console;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class ApplicationInfoReportRunner implements ApplicationRunner {
    private final ApplicationContext m_applicationContext;

    public ApplicationInfoReportRunner(ApplicationContext applicationContext)
    {
        m_applicationContext = applicationContext;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        Console.writeLine("-----------------------------------------------------------------------");
        Console.writeLine("Todos:");
        var todoRepository = m_applicationContext.getBean(ITodoRepository.class);

        todoRepository.findAll().forEach(td -> Console.writeLine(td.title));

        Console.writeLine("Application Info:");
        Console.writeLine("Application Name:%s", m_applicationContext.getApplicationName());
        Console.writeLine("Application Id:%s", m_applicationContext.getId());

        Console.writeLine("Bean/Component info:");
        Console.writeLine("Bean definition count:%d", m_applicationContext.getBeanDefinitionCount());
        Console.writeLine("Beans:");
        Stream.of(m_applicationContext.getBeanDefinitionNames()).forEach(Console::writeLine);
        Console.writeLine("-----------------------------------------------------------------------");
    }
}
