package com.article.util;

import java.util.Date;

public class GeneratorId {

    public static long GuidToInt64()
    {
        return new Date().getTime();
    }
}
