package com.java.code.controller;


import com.java.code.entity.CommonVo;
import com.java.code.entity.PopuBase;
import com.java.code.entity.PopuBaseService;
import com.java.code.queue.DelayQueueTest1;
import com.java.code.queue.DelayTaskItem;
import com.java.code.service.PopulationService;
import com.java.code.util.JsonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 * created by yuxiaodong01 on 2020/04/02.
 */
@RestController
@RequestMapping(value = "/test")
public class PopulationController {

    @Autowired
    DelayQueueTest1 delayService;

    private final Logger logger = LoggerFactory.getLogger(PopulationController.class);
    @Autowired
    PopuBaseService popuBaseService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private PopulationService populationService;

    @RequestMapping(value = "/listByPage/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUserByPage(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        return populationService.getPopulationListByPage(pageNum, pageSize);
    }

    @RequestMapping(value = "/list", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser() {
        return populationService.getPopulationList();
    }


    @RequestMapping(value = "/tags/{id}", produces = {"application/json;charset=UTF-8"})
    public Object getTagsById(@PathVariable("id") String id) {
        //return populationService.getTagsById();
        return null;
    }

    @RequestMapping(value = "/addPopuBase", method = RequestMethod.POST)
    public Object addPopuBase(@RequestBody  PopuBase pojo) {
        //执行sql异常处理
        int num = 0;
        try{
            num = popuBaseService.insert(pojo);
        }catch (Exception e){
            logger.error("insert failed :" + e.getMessage());
        }
        return num;
    }

    @RequestMapping(value = "/deletePopuBase", method = RequestMethod.POST)
    public Object deletePopuBase(@RequestBody Map<String,List<Long>> pojo) {
        logger.info("input ids : {}", JsonMapper.toJsonString(pojo));
        //List<Long> ids = pojo.get("ids");
        return null;
    }

    @RequestMapping(value = "/getSimpleParam", method = RequestMethod.POST)
    public Object getSimpleParam(@RequestBody String biNo) {
        logger.info("input num : {}", JsonMapper.toJsonString(biNo));
        //List<Long> ids = pojo.get("ids");
        return null;
    }

    @RequestMapping(value = "/downloadFile", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<byte[]> downloadFile(@RequestParam(value = "biNo") String biNo ,
                                               @RequestParam(required = false) String startTime,
                                               @RequestParam(required = false) String endTime) {

        logger.info("biNo : {} , startTime : {} ,endTime :{}", biNo, startTime, endTime);

        File file = new File("/home/worker/test1.txt");
        byte[] body = null;
        HttpHeaders headers = new HttpHeaders();
        try {
            InputStream is = new FileInputStream(file);

            headers.add("Content-Disposition", "attchement;filename=" + file.getName());

            headers.add("Content-Type", "text/plain;charset=utf-8");

            body = new byte[is.available()];
            is.read(body);
        } catch (Exception e) {
            logger.error("error messge :" +  e.getMessage());
        }

        logger.info("remote download file ,file size is :" + body.length);

        ResponseEntity<byte[]> entity = new ResponseEntity<>(body, headers, HttpStatus.OK);
        /*byte[] body1 = entity.getBody();
        String s = new String(body1);
        JsonMapper.toJsonString(s);*/

        return entity;
    }


    @RequestMapping(value = "/operateCache", method = RequestMethod.GET)
    public void operateCache() {

        redisTemplate.opsForValue().set("testkey1", "testValue1");

       /* redisTemplate.opsForValue().get
                Object testkey1 = redisTemplate.opsForValue().get("testkey1");*/
        logger.info("set redis value ");
    }


    @RequestMapping(value = "/testHttpStatus", method = RequestMethod.GET)
    public CommonVo testHttpStatus() {
        CommonVo vo = new CommonVo();

        vo.setCode("300");
        vo.setMessage("success");
        vo.setData("---------");

        return vo;
    }

    @RequestMapping(value = "/asyncReq", method = RequestMethod.GET)
    public CommonVo testHttpStatus2() {
        CommonVo vo = new CommonVo();

        vo.setCode("300");
        vo.setMessage("success");
        vo.setData("---------");

        return vo;
    }

    @RequestMapping(value = "/future", method = RequestMethod.GET)
    public CommonVo testAsyncFuture() {
        CommonVo vo = new CommonVo();

        vo.setCode("900");
        vo.setMessage("future success");
        vo.setData("---------");

        CompletableFuture future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000 * 20);
                //异步执行的，即使给了前端响应，任务提交到线程池当中
                System.out.println("async execute task : " + LocalDateTime.now().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        ZoneId zone = ZoneId.of("Asia/Shanghai");
        return vo;
    }


    @RequestMapping(value = "/delayTask", method = RequestMethod.GET)
    public CommonVo delayTask() {

        LocalDateTime now = LocalDateTime.now();
        logger.info("--------current time mill :{} ", now.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        long epochMill1 = now.plusMinutes(1).toInstant(ZoneOffset.of("+8")).toEpochMilli();

        DelayTaskItem item = new DelayTaskItem("task-target", epochMill1);


        logger.info("tasks in queue is : {}" , DelayQueueTest1.delayTaskQueue.size() );
        delayService.addDelayTask(item);

        CommonVo vo = new CommonVo();
        vo.setCode("2020");
        vo.setMessage("future success");
        vo.setData("---------");

        return vo;
    }
}

