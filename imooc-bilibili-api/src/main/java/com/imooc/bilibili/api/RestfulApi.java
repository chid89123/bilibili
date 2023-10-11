package com.imooc.bilibili.api;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestfulApi {
    private final Map<Integer, Map<String, Object>> datamap;

    public RestfulApi() {
        datamap = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", i);
            data.put("name", "name" + i);
            datamap.put(i, data);
        }
    }

    @GetMapping("/objects/{id}")
    public Map<String, Object> getdata(@PathVariable Integer id) {
        return datamap.get(id);
    }

    @DeleteMapping("/object/{id}")
    public String delete(@PathVariable Integer id) {
        datamap.remove(id);
        return "delete success";
    }

    @PostMapping("/object")
    public String post(@RequestBody Map<String, Object> data) {
        Integer[] array = datamap.keySet().toArray(new Integer[0]);
        Arrays.sort(array);
        int nextId = array[array.length - 1] + 1;
        datamap.put(nextId, data);
        return "post success";
    }

    @PutMapping("/object")
    public String put(@RequestBody Map<String, Object> data) {
        Integer integer = Integer.valueOf(String.valueOf(data.get("id")));
        Map<String, Object> map = datamap.get(integer);
        if (map == null) {
            Integer[] array = datamap.keySet().toArray(new Integer[0]);
            Arrays.sort(array);
            int nextId = array[array.length - 1] + 1;
            datamap.put(nextId, data);
        } else {
            datamap.put(integer, data);
        }
        return "put success";
    }
}