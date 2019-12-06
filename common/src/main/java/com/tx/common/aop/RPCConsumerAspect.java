package com.tx.common.aop;

import com.tx.common.exception.ErrorCode;
import com.tx.common.exception.RpcException;
import com.tx.common.utils.JsonUtil;
import com.tx.common.utils.UUIDUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *@Description: 调用外部接口切面
 *@Author: T.X
 *@CreateTime: 2018/9/6 下午1:40
*/
public class RPCConsumerAspect extends AbstractAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(RPCConsumerAspect.class);
    private List<String> ignoreLog;

    @Override
    public Object around(final ProceedingJoinPoint jp) throws Throwable {
        Object proceed = null;
        final String className = getClassName(jp);
        final String methodName = getMethodName(jp);
        boolean hasReset = UUIDUtils.resetAndGetUUID();
        // 创建监控
        String monitorKey = className + "." + methodName;
//        MethodInfo methodInfo = Monitor.methodStart(monitorKey);
        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            proceed = jp.proceed();
            stopWatch.stop();
            // 不需要忽略的才打日志
            if(ignoreLog == null || !ignoreLog.contains(methodName)) {
                if (LOGGER.isInfoEnabled()) {
                    LOGGER.info("{}#{},cost:{}ms 入参:{} 出参:{}", className, methodName, stopWatch.getTime(), JsonUtil.toJSONString(jp.getArgs()), JsonUtil.toJSONString(proceed));
                }
            }
        }catch (Exception e){
//            Monitor.methodFail(methodInfo);
            LOGGER.error(className+"#"+methodName+",入参:"+ JsonUtil.toJSONString(jp.getArgs())+"调用异常",e);
            if (e instanceof Exception){
                UUIDUtils.clearUuid(hasReset);
                throw new RpcException(ErrorCode.RPC_ERROR, e.getMessage()) {
                    @Override
                    public String getServiceName() {
                        return className;
                    }

                    @Override
                    public String getMethod() {
                        return methodName;
                    }

                    @Override
                    public boolean isTimeout() {
                        return false;
                    }
                };
            }
            UUIDUtils.clearUuid(hasReset);
            throw e;
        }finally {
//            Monitor.methodFinish(methodInfo);
        }
        UUIDUtils.clearUuid(hasReset);
        return proceed;
    }

    public List<String> getIgnoreLog() {
        return ignoreLog;
    }

    public void setIgnoreLog(List<String> ignoreLog) {
        this.ignoreLog = ignoreLog;
    }
}
