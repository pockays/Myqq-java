package com.linq.cool.qqbot.myqq.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.regex.Pattern;

/**
 * @author liuris
 * @create 2024-04-18-18:02
 */
@AllArgsConstructor
@Getter
public enum MyQQCommandEnum {
    /**
     * 全部指令
     */
    ALL_COMMAND(Pattern.compile("(^dd\\(.*\\)$)|(^dd\\(.*\\)\\[@[1-9][0-9]{4,14}]$)|(\\[@[1-9][0-9]{4,14}])")),
    /**
     * [@2719190494]
     */
    GROUP_AT_MEMBER_COMMAND(Pattern.compile("\\[@[1-9][0-9]{4,14}]"));
    private final Pattern pattern;
}
