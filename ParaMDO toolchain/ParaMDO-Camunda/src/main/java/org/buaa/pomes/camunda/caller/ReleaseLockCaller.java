package org.buaa.pomes.camunda.caller;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.redisson.api.RLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReleaseLockCaller implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoActivityCaller.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String mutexId = (String) execution.getVariable("MUTEXID");
        RLock lock = (RLock) execution.getVariable("mutex");
        lock.unlock();
        String parentId = execution.getParentActivityInstanceId();
        LOGGER.info("Released Lock: " + mutexId + " at Parent: " + parentId);
    }
}
