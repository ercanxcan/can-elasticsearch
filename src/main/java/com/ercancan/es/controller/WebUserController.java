package com.ercancan.es.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.ercancan.es.model.WebUser;
import com.ercancan.es.repository.elasticsearch.WebUserElasticRepository;
import com.ercancan.es.repository.jpa.WebUserRepository;

import java.util.List;


/**
 * WebUserController
 *
 * @author Ercan Can
 * @version 1.0.0,  28.7.2017
 */
@RestController
@RequestMapping(value = "/wsusers")
public class WebUserController {

    Logger log = LoggerFactory.getLogger(WebUserController.class);

    @Autowired
    WebUserRepository websiteUserRepository;

    @Autowired
    WebUserElasticRepository webUserElasticRepository;

    @RequestMapping(value = "/jpa/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public WebUser getEmployeeFromH2(@PathVariable Long employeeId) {
        WebUser one = websiteUserRepository.findOne(employeeId);
        return one;
    }

    @RequestMapping(value = "/es/{employeeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public WebUser getEmployeeFromEs(@PathVariable Long employeeId) {
        WebUser one = webUserElasticRepository.findOne(employeeId);
        return one;
    }

    @RequestMapping(value = "/es/full/{search}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<WebUser> getFullTextSearch(@PathVariable String search) {
        List<WebUser> list = webUserElasticRepository.findByQuery(search);
        return list;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public WebUser createWebsiteUser(@RequestBody WebUser webUser) {
        WebUser createdUser = websiteUserRepository.save(webUser);
        webUserElasticRepository.save(webUser);
        return createdUser;
    }

}
