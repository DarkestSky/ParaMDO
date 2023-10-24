package org.buaa.pomes.camunda.caller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class InitProcessCaller implements JavaDelegate {
    private static final Logger LOGGER = LoggerFactory.getLogger(InitProcessCaller.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        LOGGER.info("Setting Global Variables...");
        LOGGER.info("Process Start at: " + System.currentTimeMillis());

        String WORKSPACE = (String) delegateExecution.getVariable("WORKSPACE");
        LOGGER.info("WORKSPACE: " + WORKSPACE);
        delegateExecution.getProcessInstance().setVariable("WORKSPACE", WORKSPACE);
    }
}
