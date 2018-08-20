package com.article.service;

import com.article.pojo.ArticleRule;

import java.util.List;


public interface ArticleRuleService {
    public ArticleRule getArtcleRuleByKey(String key);
    public boolean addorUpdateArticleRule(ArticleRule articleRule);
    public List<ArticleRule> getAllArticleRule();
}
