package com.linq.cool.qqbot.myqq.utils.regex;


import com.mzlion.core.lang.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: yqlin
 * @date: 2021/6/21 15:09
 * @description:
 */
public class RegexUtils {
    private static final Logger log = LoggerFactory.getLogger(RegexUtils.class);

    /**
     * 解析字符串
     */
    public static String parse(String str, RegexRule... args) {
        if (args.length >= 1) {
            return parse(new ArrayList<>(Arrays.asList(args)), str);
        }
        return null;
    }

    private static String parse(List<RegexRule> rules, String url) {
        String itemId = null;
        if (CollectionUtils.isNotEmpty(rules)) { //!StringUtils.containsWhitespace(url)括号中该条件注释掉了，因为会导致消息中出现空格就无法识别的问题
            Pattern fragmentPattern;
            for (RegexRule rule : rules) {
                fragmentPattern = Pattern.compile(rule.getFragmentRegex());
                Matcher fragmentMatcher = fragmentPattern.matcher(url);
                if (fragmentMatcher.find()) {
                    String fragmentStr = fragmentMatcher.group();
                    switch (rule.getPlatRegexRuleEnum()) {
                        case BEGIN_INDEX_AND_END_INDEX:
                            itemId = parseBeginIndexAndEndIndex(rule, fragmentStr);
                            break;
                        case BEGIN_INDEX_AND_END_REGEX:
                            itemId = parseBeginIndexAndEndRegex(rule, fragmentStr);
                            break;
                        case BEGIN_REGEX_AND_END_REGEX:
                            itemId = parseBeginRegexAndEndRegex(rule, fragmentStr);
                            break;
                        default:
                            break;
                    }
                }

            }
        }
        return itemId;
    }

    private static String parseBeginIndexAndEndRegex(RegexRule rule, String fragmentStr) {
        Pattern endPattern = Pattern.compile(rule.getEndRegex());
        Matcher endMatcher = endPattern.matcher(fragmentStr);
        if (endMatcher.find()) {
            String endGroup = endMatcher.group();
            int endIndex = fragmentStr.lastIndexOf(endGroup);
            return fragmentStr.substring(rule.getBeginIndex(), endIndex);
        }
        return null;
    }

    //截取2个正则表达式中间的部分
    private static String parseBeginRegexAndEndRegex(RegexRule rule, String fragmentStr) {
        Pattern beginPattern = Pattern.compile(rule.getBeginRegex());
        Matcher beginMatcher = beginPattern.matcher(fragmentStr);
        if (beginMatcher.find()) {
            String beginGroup = beginMatcher.group();
            int beginIndex = beginGroup.length();
            Pattern endPattern = Pattern.compile(rule.getEndRegex());
            Matcher endMatcher = endPattern.matcher(fragmentStr);
            if (endMatcher.find()) {
                String endGroup = endMatcher.group();
                int endIndex = fragmentStr.lastIndexOf(endGroup);
                return fragmentStr.substring(beginIndex, endIndex + 1);
            }
        }
        return null;
    }

    //截取符合正则表达式的部分
    private static String parseBeginIndexAndEndIndex(RegexRule rule, String fragmentStr) {
        return fragmentStr.substring(rule.getBeginIndex(), rule.getEndIndex());
    }

}
