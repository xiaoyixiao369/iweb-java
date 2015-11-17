package io.github.igordonxiao.bean;

import java.util.List;

import org.hibernate.criterion.MatchMode;

import com.alibaba.fastjson.annotation.JSONField;

public class Page<T> {

    public enum OrderType {
        asc, desc
    }

    private static final Integer MAX_PAGE_SIZE = 500;//分页允许最大数

    private List<T> list;//分页数据

    private Integer pageSize = 10;//分页大小

    private Integer nowPage = 1;//分页页码

    @JSONField(serialize = false)
    private String orderBy;//排序字段

    @JSONField(serialize = false)
    private OrderType orderType = OrderType.asc;//排序方式

    private Integer totalCount = 0;//总条数

    private Integer maxPage = 0;//总页数

    @JSONField(serialize = false)
    private String property;//关键字检索字段名称

    @JSONField(serialize = false)
    private String keyWords;//关键字检索关键字

    @JSONField(serialize = false)
    private MatchMode matchMode = MatchMode.ANYWHERE;//关键字检索的匹配模式

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize < 1 ? 1 : pageSize > MAX_PAGE_SIZE ? MAX_PAGE_SIZE : pageSize;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public void setNowPage(Integer nowPage) {
        this.nowPage = nowPage;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public boolean hasNext() {
        return totalCount > pageSize * nowPage ? true : false;
    }

    public Integer getMaxPage() {
        this.maxPage = this.totalCount / this.pageSize;
        return this.totalCount % this.pageSize > 0 ? ++this.maxPage : this.maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public MatchMode getMatchMode() {
        return matchMode;
    }

    public void setMatchMode(MatchMode matchMode) {
        this.matchMode = matchMode;
    }

}
