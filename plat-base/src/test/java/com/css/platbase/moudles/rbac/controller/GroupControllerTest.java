package com.css.platbase.moudles.rbac.controller;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : lin
 * @date : 17:17 2021/9/7
 */
class GroupControllerTest {

    @Test
    void treeSearch() {
        String a="/a/b/c";
        List b= Arrays.asList(a.split("/"));

        System.out.println(b);
    }
}
