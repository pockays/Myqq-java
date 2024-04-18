package com.linq.cool.qqbot.myqq.utils.regex;

/**
 * @author yqlin
 * @date: 2021/6/21 15:09
 * @description: 设置正则规则
 */
public class RegexRule {
    private final PlatRegexRuleEnum platRegexRuleEnum;
    private final String fragmentRegex;
    private final Integer beginIndex;
    private final Integer endIndex;
    private final String beginRegex;
    private final String endRegex;

    private RegexRule(Builder builder) {
        this.fragmentRegex = builder.fragmentRegex;
        this.beginIndex = builder.beginIndex;
        this.endIndex = builder.endIndex;
        this.beginRegex = builder.beginRegex;
        this.endRegex = builder.endRegex;
        this.platRegexRuleEnum = builder.platRegexRuleEnum;
    }

    public enum PlatRegexRuleEnum {
        /**
         * 必须 fragmentRegex: 正则
         * 配对: beginIndex,endIndex
         * 配对: beginIndex,endRegex
         * 配对: beginRegex,endRegex
         */
        BEGIN_INDEX_AND_END_INDEX,
        BEGIN_INDEX_AND_END_REGEX,
        BEGIN_REGEX_AND_END_REGEX,
        ;

        PlatRegexRuleEnum() {
        }

    }

    /**
     * 正则规则构建器
     */
    public static class Builder {
        /**
         * 必须 fragmentRegex: 正则
         * 配对: beginIndex,endIndex
         * 配对: beginIndex,endRegex
         * 配对: beginRegex,endRegex
         */
        private final PlatRegexRuleEnum platRegexRuleEnum;
        private final String fragmentRegex;
        private Integer beginIndex;
        private Integer endIndex;
        private String beginRegex;
        private String endRegex;


        public Builder(String fragmentRegex, Integer beginIndex, Integer endIndex) {
            this.fragmentRegex = fragmentRegex;
            this.beginIndex = beginIndex;
            this.endIndex = endIndex;
            this.platRegexRuleEnum = PlatRegexRuleEnum.BEGIN_INDEX_AND_END_INDEX;
        }

        public Builder(String fragmentRegex, Integer beginIndex, String endRegex) {
            this.fragmentRegex = fragmentRegex;
            this.beginIndex = beginIndex;
            this.endRegex = endRegex;
            this.platRegexRuleEnum = PlatRegexRuleEnum.BEGIN_INDEX_AND_END_REGEX;
        }

        public Builder(String fragmentRegex, String beginRegex, String endRegex) {
            this.fragmentRegex = fragmentRegex;
            this.beginRegex = beginRegex;
            this.endRegex = endRegex;
            this.platRegexRuleEnum = PlatRegexRuleEnum.BEGIN_REGEX_AND_END_REGEX;
        }

        public RegexRule build() {
            return new RegexRule(this);
        }
    }

    public String getFragmentRegex() {
        return fragmentRegex;
    }

    public Integer getBeginIndex() {
        return beginIndex;
    }

    public Integer getEndIndex() {
        return endIndex;
    }

    public String getBeginRegex() {
        return beginRegex;
    }

    public String getEndRegex() {
        return endRegex;
    }

    public PlatRegexRuleEnum getPlatRegexRuleEnum() {
        return platRegexRuleEnum;
    }
}