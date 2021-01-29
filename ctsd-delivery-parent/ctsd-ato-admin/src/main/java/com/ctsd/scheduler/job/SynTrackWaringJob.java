package com.ctsd.scheduler.job;

import com.ctsd.frame.util.okhttp.OkhttpUtil;
import com.ctsd.scheduler.base.BaseJob;
import com.ctsd.scheduler.base.ScheduleAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称：  ctsd-delivery-parent
 * 类名称：  WaringJob
 * 描述：告警
 * @author wangzheng
 * 创建时间：  2021/1/26 19:36
 * 修改人： wangzheng  修改日期： 2021/1/26 19:36
 * 修改备注：
 */
@Slf4j
@ScheduleAnnotation(jobId = "SynTrackWaringJob",jobName = "运单同步失败告警")
public class SynTrackWaringJob extends BaseJob {

    @Value("${ctsd.agg.delivery.url}")
    private String deliveryDomain;
    /**
     * 1、告警内容：快递同步失败，[06:30-08:30]一共发生 xx 个同步错误
     * （低于15个给具体运单及原因: 快递同步失败，运单号：失败原因；运单号：失败原因...）
     *
     * 2、调度1小时一次。时间区间取：
     * 2.1、第一次为6小时内
     * 2.2、后面依次为：（上一次处理时间，当前处理时间）
     *
     * 3、预警人发：coa_wechat_users，表 pk_user_id
     * @param jobExecutionContext
     * @return
     * @author wangzheng
     * @date 2020/8/21
     **/
    @Override
    public void exec(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("SynTrackWaringJob 开始执行.....");
        String url = deliveryDomain + "/delivery/supplier/synDispatchWarning";
        Map<String, String> params = new HashMap<>(4);
        OkhttpUtil.doGet(url, params);
        log.info("SynTrackWaringJob 执行结束，请求地址：{}", url);
    }
}