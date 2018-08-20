package com.article.dao;

import com.article.pojo.ArticleRule;
import com.article.pojo.ArticleRuleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleRuleMapper {
    int countByExample(ArticleRuleExample example);

    int deleteByExample(ArticleRuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ArticleRule record);

    int insertSelective(ArticleRule record);

    List<ArticleRule> selectByExample(ArticleRuleExample example);

    ArticleRule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ArticleRule record, @Param("example") ArticleRuleExample example);

    int updateByExample(@Param("record") ArticleRule record, @Param("example") ArticleRuleExample example);

    int updateByPrimaryKeySelective(ArticleRule record);

    int updateByPrimaryKey(ArticleRule record);
}