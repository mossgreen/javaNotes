package com.mongojpa;

import com.mongodb.client.result.UpdateResult;
import com.mongojpa.converter.MoneyReadConverter;
import com.mongojpa.model.Coffee;
import com.mongojpa.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@SpringBootApplication
@Slf4j
@EnableMongoRepositories
public class MongoDemoApp implements CommandLineRunner {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongoDemoApp.class, args);
    }

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(new MoneyReadConverter()));
    }

    @Override
    public void run(String... args) throws Exception {

        Coffee espresso = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        Coffee latte = Coffee.builder()
                .name("lattee")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        coffeeRepository.insert(Arrays.asList(espresso, latte));

        coffeeRepository.findAll(Sort.by("name"))
                .forEach(c -> log.info("saved Coffee {}", c));

        Thread.sleep(3000);

        latte.setPrice(Money.of(CurrencyUnit.of("CNY"), 35.0));
        latte.setUpdateTime(LocalDateTime.now());
        coffeeRepository.save(latte);
        coffeeRepository.findByName("latte").forEach(c -> log.info("coffee {}", c));

        coffeeRepository.deleteAll();
        // use mogoTemplate

        Coffee saved = mongoTemplate.save(espresso);
        log.info("Coffee {}", saved);

        List<Coffee> list = mongoTemplate.find(query(where("name").is("espresso")), Coffee.class);
        log.info("Find {} Coffee", list.size());
        list.forEach(c -> log.info("Coffee {]", c));

        Thread.sleep(1000);
        UpdateResult result = mongoTemplate
                .updateFirst(query(where("name").is("espresso")),
                        new Update().set("price", Money.ofMajor(CurrencyUnit.of("CNY"), 30))
                                .currentDate("updateTime"), Coffee.class);
        log.info("Update Result: {]", result.getModifiedCount());

        Coffee udpateOne = mongoTemplate.findById(saved.getId(), Coffee.class);
        log.info("Update result: {} ", udpateOne);

        mongoTemplate.remove(udpateOne);
    }
}
