package org.example;

import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class SomeTest extends AbstractJavaSamplerClient {
    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        // 表示一个测试结果
        SampleResult result = new SampleResult();

        try {
            result.sampleStart(); // 标记测试开始，记录开始时间
            doSomeTest();
            result.setSuccessful(true); // 标记测试成功，记录结束时间，本次测试的运行时间，为结束时间-开始时间
        } catch (Exception e) {
            result.setSuccessful(false); // 标记测试失败
        }

        result.sampleEnd(); // 标记测试结束
        return result;
    }

    private void doSomeTest() {
        // 随机 sleep 一小段时间，模拟执行测试
        try {
            Thread.sleep((long) (Math.random() * 100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // 随机抛出异常，模拟测试失败
        if (Math.random() < 0.1) {
            throw new RuntimeException("测试失败");
        }
    }
}
