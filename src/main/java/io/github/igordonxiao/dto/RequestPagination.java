package io.github.igordonxiao.dto;

import java.io.Serializable;

/**
 * bootstrap table 前台请求分页对象
 * Created by gordon on 15/10/29.
 */
public class RequestPagination implements Serializable{
    private static final long serialVersionUID = 695994468169044L;
    public enum Order {
        asc("asc"),
        desc("desc"),
        ;

        private final String rule;

        Order(String rule) {
            this.rule = rule;
        }

        public String getRule() {
            return this.rule;
        }
    }
    private Integer limit;
    private Integer offset;
    private String orderField;
    private Order order;

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
