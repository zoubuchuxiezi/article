package com.article.util;

import com.article.pojo.ArticleRule;
import com.article.service.ArticleRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RuleMap implements CommandLineRunner {
    public static Map<String,String> ruleMap = new HashMap<>();
    @Autowired
    private ArticleRuleService articleRuleService;

    @Override
    public void run(String... args) throws Exception {
        List<ArticleRule> list = articleRuleService.getAllArticleRule();
        if(null != list && list.size() >0){
            for(ArticleRule articleRule:list){
                ruleMap.put(articleRule.getRkey(),articleRule.getRule());
            }
        }
    }
}
