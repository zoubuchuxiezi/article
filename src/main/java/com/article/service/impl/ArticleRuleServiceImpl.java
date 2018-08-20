package com.article.service.impl;

import com.article.dao.ArticleRuleMapper;
import com.article.pojo.ArticleRule;
import com.article.pojo.ArticleRuleExample;
import com.article.service.ArticleRuleService;
import com.article.util.GeneratorId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service(value = "articleRuleService")
public class ArticleRuleServiceImpl implements ArticleRuleService {

    @Override
    public List<ArticleRule> getAllArticleRule() {
        try{
            return articleRuleMapper.selectByExample(null);
        }catch (Exception ex){
            System.out.printf("查询出错！");
        }
        return null;
    }

    @Autowired
    private ArticleRuleMapper articleRuleMapper;

    @Override
    public ArticleRule getArtcleRuleByKey(String key) {
        ArticleRuleExample example = new ArticleRuleExample();
        example.createCriteria().andRkeyEqualTo(key);
        ArticleRule articleRule = null;
        try {
            articleRule = articleRuleMapper.selectByExample(example).get(0);
        }catch (Exception e){
            System.out.printf("查询出错");
        }
        return articleRule;
    }

    @Override
    public boolean addorUpdateArticleRule(ArticleRule articleRule) {
        Boolean rs = false;
        try{
            if(articleRule.getId() != null){
                articleRule.setUpdateTime(new Date());
                articleRuleMapper.updateByPrimaryKey(articleRule);
            }else{
                articleRule.setId(GeneratorId.GuidToInt64());
                articleRule.setUpdateTime(new Date());
                articleRule.setCreateTime(new Date());
                articleRuleMapper.insert(articleRule);
            }
            rs = true;
        }catch (Exception ex){
            System.out.printf(ex.getMessage());
            System.out.printf("保存出错");
        }
        return rs;
    }


}
