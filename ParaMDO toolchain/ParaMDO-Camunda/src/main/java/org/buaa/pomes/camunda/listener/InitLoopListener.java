package org.buaa.pomes.camunda.listener;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 绑定为循环子流程的开始事件监听器
 * <p>
 * 在执行循环子流程内部的具体活动流程前, 设置好本循环的循环计数变量
 */
public class InitLoopListener implements ExecutionListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(InitLoopListener.class);

    @Override
    public void notify(DelegateExecution delegateExecution) throws Exception {
        String id = delegateExecution.getCurrentActivityId();
        String name = delegateExecution.getCurrentActivityName();
        LOGGER.info("Init Loop at: " + name + "[" + id + "]");

        long loopCount = (long) delegateExecution.getVariable("loopCount");
        long loopBegin = (long) delegateExecution.getVariable("loopBegin");
        LOGGER.info("Given Loop Count is: " + loopCount);
        LOGGER.info("Given Loop Begin is: " + loopBegin);
        LOGGER.info("Set Loop Count to Loop Begin");
    }
}
