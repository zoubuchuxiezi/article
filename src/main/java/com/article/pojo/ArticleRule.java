package com.article.pojo;

import java.util.Date;

public class ArticleRule {
    private Long id;

    private String rkey;

    private String rule;

    private String example;

    private String exampleRel;

    private Date createTime;

    private Date updateTime;

    public ArticleRule(Long id, String rkey, String rule, String example, String exampleRel, Date createTime, Date updateTime) {
        this.id = id;
        this.rkey = rkey;
        this.rule = rule;
        this.example = example;
        this.exampleRel = exampleRel;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ArticleRule() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRkey() {
        return rkey;
    }

    public void setRkey(String rkey) {
        this.rkey = rkey == null ? null : rkey.trim();
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule == null ? null : rule.trim();
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example == null ? null : example.trim();
    }

    public String getExampleRel() {
        return exampleRel;
    }

    public void setExampleRel(String exampleRel) {
        this.exampleRel = exampleRel == null ? null : exampleRel.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}