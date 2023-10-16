package com.gugu.base;

import io.swagger.models.auth.In;
import lombok.ToString;

@ToString
public class PageInfo<T> {
    private T data;
    private Integer count;
    private Integer pageSize;
    private Integer pageNum;

    /**
     * 后端返回
     * @param data
     * @param count
     */
    public PageInfo(T data, Integer count) {
        this.data = data;
        this.count = count;
    }

    /**
     * 前端查询
     * @param pageSize
     * @param pageNum
     */
    public PageInfo(Integer pageSize, Integer pageNum) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }
}
