package org.buaa.pomes.camunda.caller;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.concurrent.TimeUnit;

/**
 * 用于初始化流程变量的活动
 */
public class AutoActivityCaller implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoActivityCaller.class);

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String id = delegateExecution.getCurrentActivityId();
        String name = delegateExecution.getCurrentActivityName();
        LOGGER.info("Start Executing Activity: " + name + "[" + id + "]" + " at: " + System.currentTimeMillis());

        String WORKSPACE = (String) delegateExecution.getVariable("WORKSPACE");
        String exec_path = (String) delegateExecution.getVariable("exec_path");
        LOGGER.info("exec_path: " + WORKSPACE + "/" + exec_path);

        Resource execResource = new ClassPathResource(WORKSPACE + "/" + exec_path);
        exec_path = execResource.getFile().getAbsolutePath();
        if (!execResource.exists()) {
            return ;
        }
        else {
            Process process = Runtime.getRuntime().exec(exec_path);
            process.waitFor();
        }
        LOGGER.info("Finish Executing Activity: " + name + "[" + id + "]" + " at: " + System.currentTimeMillis());
    }
}