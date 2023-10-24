package org.buaa.pomes.camunda.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 绑定在循环子流程最后的互斥网关, 作为开始前的监听器
 * <p>
 * 执行循环计数变量 +1 的操作
 */
public class LoopFinishListener implements ExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoopFinishListener.class);

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        String id = delegateExecution.getCurrentActivityId();
        String name = delegateExecution.getCurrentActivityName();
        LOGGER.info("Loop Finish Listener: " + name + "[" + id + "]");

        long loopCount = (long) delegateExecution.getVariable("loopCount");
        long loopEnd = (long) delegateExecution.getVariable("loopEnd");
        long newLoopCount = loopCount + 1;

        LOGGER.info("Loop Count Change:" + loopCount + " -> " + newLoopCount);
        LOGGER.info("Loop End:" + loopEnd);
        delegateExecution.setVariable("loopCount", newLoopCount);
    }
}
