package org.buaa.pomes.camunda.caller;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AcquireLockCaller implements JavaDelegate {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoActivityCaller.class);

    RedissonClient redissonClient;

    @Autowired
    public void setRedissonClient(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String mutexId = (String) execution.getVariable("MUTEXID");
        LOGGER.info("Acquiring Lock: " + mutexId + " at Parent: " + execution.getParentActivityInstanceId());
        RLock lock = redissonClient.getLock(mutexId);
        lock.lock();
        execution.setVariable("mutex", lock);
        LOGGER.info("Got Lock: " + mutexId + " at Parent: " + execution.getParentActivityInstanceId());
    }
}
