package com.article.controller;

import com.article.pojo.ArticleRule;
import com.article.service.ArticleRuleService;
import com.article.util.ResultDto;
import com.article.util.RuleMap;
import com.article.util.SentenceHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/article")
public class ArticleRuleController {
    @Autowired
    private ArticleRuleService articleRuleService;

    @RequestMapping("/get")
    public Object getRuledSentence(String s){
        ResultDto resultDto = new ResultDto();
        String rule =  RuleMap.ruleMap.get(SentenceHandler.getKey(s));
        if(rule != null){
            resultDto.setData(SentenceHandler.changeSentence(s,rule));
        }else{
            resultDto.setData("没有对应该句型的规则");
        }
        return resultDto;
    }
    @RequestMapping("/add")
    public Object addRuledSentence(String s,String ex,String rule){
        ResultDto resultDto = new ResultDto();
        String key = SentenceHandler.getKey(s);
        if(RuleMap.ruleMap.get(key) != null) {
            resultDto.setData("已经有了该规则");
        }else{
            String s_ex = SentenceHandler.changeSentence(s,rule);
            if(ex.equals(s_ex)){
                ArticleRule articleRule = new ArticleRule();
                articleRule.setRkey(key);
                articleRule.setRule(rule);
                articleRule.setExample(s);
                articleRule.setExampleRel(ex);
                articleRuleService.addorUpdateArticleRule(articleRule);
                RuleMap.ruleMap.put(key,rule);
                resultDto.setData(key);
            }
        }
        return resultDto;
    }


}
