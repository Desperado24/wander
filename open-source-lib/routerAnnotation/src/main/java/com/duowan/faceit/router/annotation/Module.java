package com.duowan.faceit.router.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by CaoDongping on 30/10/2016.
 */
@Retention(RetentionPolicy.CLASS)
public @interface Module {
    String value();
}
