package jphaugla.redisom.com.romsdocuments.controllers;

import java.util.Optional;
import java.util.Set;

import com.redis.om.spring.annotations.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.domain.geo.Metrics;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

import jphaugla.redisom.com.romsdocuments.domain.Company;
import jphaugla.redisom.com.romsdocuments.repositories.CompanyRepository;

@RestController
@RequestMapping("/api/companies")
@Slf4j
public class CompanyController {
  @Autowired
  CompanyRepository repository;

  @GetMapping("name/{name}")
  Optional<Company> byName(@PathVariable("name") String name) {
    return repository.findOneByName(name);
  }
  @GetMapping("near")
  Iterable<Company> byLocationNear(//
                                   @RequestParam("lat") double lat, //
                                   @RequestParam("lon") double lon, //
                                   @RequestParam("d") double distance) {
    log.info("in near getMapping with lat " + String.valueOf(lat) + String.valueOf(lon) + String.valueOf(distance));
    return repository.findByLocationNear(new Point(lon, lat), new Distance(distance, Metrics.MILES));
    // find by tag field, using JRediSearch "native" annotation

  }
  @GetMapping("tags")
  Iterable<Company> byTags(//
  @RequestParam("tags") Set<String> tags) {
    return repository.findByTags(tags);
  }

}
