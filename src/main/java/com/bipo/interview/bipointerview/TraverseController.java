package com.bipo.interview.bipointerview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TraverseController {

    @Autowired
    Traverse traverse;

    @RequestMapping(value = "/traverse")
    public String Traverse(@RequestParam String str) {

        return traverse.NumberSearch(str);
    }
}
