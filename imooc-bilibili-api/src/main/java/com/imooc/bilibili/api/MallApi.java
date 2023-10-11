package com.imooc.bilibili.api;

import com.imooc.bilibili.domain.JsonResponse;
import com.imooc.bilibili.domain.Video;
import com.imooc.bilibili.service.ElasticSearchService;
import com.imooc.bilibili.service.MallService;
//import com.imooc.bilibili.service.feign.MsDeclareService;
import com.imooc.bilibili.service.util.FastDFSUtil;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
//import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
public class MallApi {

    @Autowired
    public MallService mallService;
    @Autowired
    private FastDFSUtil fastDFSUtil;

    @Autowired
    private ElasticSearchService elasticSearchService;

    //todo 启动微服务
//    @Autowired
//    private MsDeclareService msDeclareService;

    @GetMapping("/query")
    public Map<String, Object> query(Long id) {
        return mallService.query(id);
    }

    @GetMapping("/slices")
    public void slices(MultipartFile file) throws IOException {
        fastDFSUtil.convertFileToSlices(file);
    }

    @GetMapping("/es-videos")
    public JsonResponse<Video> getEsVideos(@RequestParam String keyword) {
        Video video = elasticSearchService.getVideos(keyword);
        return new JsonResponse<>(video);
    }

//    @GetMapping("/demos")
//    public Long msget(@RequestParam Long id) {
//        return msDeclareService.msget(id);
//    }
//    @PostMapping("/demos")
//    public Map<String, Object> mspost(@RequestBody Map<String, Object> params){
//        return msDeclareService.mspost(params);
//    }
//
//    @HystrixCommand(fallbackMethod = "error",
//            commandProperties = {
//                    @HystrixProperty(
//                            name = "execution.isolation.thread.timeoutInMilliseconds",
//                            value = "2000"
//                    )
//            }
//    )
//    @GetMapping("/timeout")
//    public String circuitBreakerWithHystrix(@RequestParam Long time){
//        return msDeclareService.timeout(time);
//    }
//
//    public String error(Long time){
//        return "超时出错！";
//    }
}
