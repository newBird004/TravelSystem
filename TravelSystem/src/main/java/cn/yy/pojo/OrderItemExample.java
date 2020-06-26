package cn.yy.pojo;

import java.util.ArrayList;
import java.util.List;

public class OrderItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderItemExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderItemIdIsNull() {
            addCriterion("orderItemId is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIsNotNull() {
            addCriterion("orderItemId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdEqualTo(Integer value) {
            addCriterion("orderItemId =", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotEqualTo(Integer value) {
            addCriterion("orderItemId <>", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdGreaterThan(Integer value) {
            addCriterion("orderItemId >", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderItemId >=", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLessThan(Integer value) {
            addCriterion("orderItemId <", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("orderItemId <=", value, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdIn(List<Integer> values) {
            addCriterion("orderItemId in", values, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotIn(List<Integer> values) {
            addCriterion("orderItemId not in", values, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdBetween(Integer value1, Integer value2) {
            addCriterion("orderItemId between", value1, value2, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("orderItemId not between", value1, value2, "orderItemId");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemIsNull() {
            addCriterion("orderId_FK_OrderItem is null");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemIsNotNull() {
            addCriterion("orderId_FK_OrderItem is not null");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemEqualTo(Integer value) {
            addCriterion("orderId_FK_OrderItem =", value, "orderId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemNotEqualTo(Integer value) {
            addCriterion("orderId_FK_OrderItem <>", value, "orderId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemGreaterThan(Integer value) {
            addCriterion("orderId_FK_OrderItem >", value, "orderId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderId_FK_OrderItem >=", value, "orderId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemLessThan(Integer value) {
            addCriterion("orderId_FK_OrderItem <", value, "orderId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemLessThanOrEqualTo(Integer value) {
            addCriterion("orderId_FK_OrderItem <=", value, "orderId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemIn(List<Integer> values) {
            addCriterion("orderId_FK_OrderItem in", values, "orderId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemNotIn(List<Integer> values) {
            addCriterion("orderId_FK_OrderItem not in", values, "orderId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemBetween(Integer value1, Integer value2) {
            addCriterion("orderId_FK_OrderItem between", value1, value2, "orderId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andOrderId_FK_OrderItemNotBetween(Integer value1, Integer value2) {
            addCriterion("orderId_FK_OrderItem not between", value1, value2, "orderId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemIsNull() {
            addCriterion("realNameId_FK_OrderItem is null");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemIsNotNull() {
            addCriterion("realNameId_FK_OrderItem is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemEqualTo(Integer value) {
            addCriterion("realNameId_FK_OrderItem =", value, "realNameId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemNotEqualTo(Integer value) {
            addCriterion("realNameId_FK_OrderItem <>", value, "realNameId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemGreaterThan(Integer value) {
            addCriterion("realNameId_FK_OrderItem >", value, "realNameId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("realNameId_FK_OrderItem >=", value, "realNameId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemLessThan(Integer value) {
            addCriterion("realNameId_FK_OrderItem <", value, "realNameId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemLessThanOrEqualTo(Integer value) {
            addCriterion("realNameId_FK_OrderItem <=", value, "realNameId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemIn(List<Integer> values) {
            addCriterion("realNameId_FK_OrderItem in", values, "realNameId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemNotIn(List<Integer> values) {
            addCriterion("realNameId_FK_OrderItem not in", values, "realNameId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemBetween(Integer value1, Integer value2) {
            addCriterion("realNameId_FK_OrderItem between", value1, value2, "realNameId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_OrderItemNotBetween(Integer value1, Integer value2) {
            addCriterion("realNameId_FK_OrderItem not between", value1, value2, "realNameId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemIsNull() {
            addCriterion("scenicId_FK_OrderItem is null");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemIsNotNull() {
            addCriterion("scenicId_FK_OrderItem is not null");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemEqualTo(Integer value) {
            addCriterion("scenicId_FK_OrderItem =", value, "scenicId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemNotEqualTo(Integer value) {
            addCriterion("scenicId_FK_OrderItem <>", value, "scenicId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemGreaterThan(Integer value) {
            addCriterion("scenicId_FK_OrderItem >", value, "scenicId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("scenicId_FK_OrderItem >=", value, "scenicId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemLessThan(Integer value) {
            addCriterion("scenicId_FK_OrderItem <", value, "scenicId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemLessThanOrEqualTo(Integer value) {
            addCriterion("scenicId_FK_OrderItem <=", value, "scenicId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemIn(List<Integer> values) {
            addCriterion("scenicId_FK_OrderItem in", values, "scenicId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemNotIn(List<Integer> values) {
            addCriterion("scenicId_FK_OrderItem not in", values, "scenicId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemBetween(Integer value1, Integer value2) {
            addCriterion("scenicId_FK_OrderItem between", value1, value2, "scenicId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_OrderItemNotBetween(Integer value1, Integer value2) {
            addCriterion("scenicId_FK_OrderItem not between", value1, value2, "scenicId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemIsNull() {
            addCriterion("roomId_FK_OrderItem is null");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemIsNotNull() {
            addCriterion("roomId_FK_OrderItem is not null");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemEqualTo(Integer value) {
            addCriterion("roomId_FK_OrderItem =", value, "roomId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemNotEqualTo(Integer value) {
            addCriterion("roomId_FK_OrderItem <>", value, "roomId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemGreaterThan(Integer value) {
            addCriterion("roomId_FK_OrderItem >", value, "roomId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomId_FK_OrderItem >=", value, "roomId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemLessThan(Integer value) {
            addCriterion("roomId_FK_OrderItem <", value, "roomId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemLessThanOrEqualTo(Integer value) {
            addCriterion("roomId_FK_OrderItem <=", value, "roomId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemIn(List<Integer> values) {
            addCriterion("roomId_FK_OrderItem in", values, "roomId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemNotIn(List<Integer> values) {
            addCriterion("roomId_FK_OrderItem not in", values, "roomId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemBetween(Integer value1, Integer value2) {
            addCriterion("roomId_FK_OrderItem between", value1, value2, "roomId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_OrderItemNotBetween(Integer value1, Integer value2) {
            addCriterion("roomId_FK_OrderItem not between", value1, value2, "roomId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemIsNull() {
            addCriterion("taoCanId_FK_OrderItem is null");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemIsNotNull() {
            addCriterion("taoCanId_FK_OrderItem is not null");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemEqualTo(Integer value) {
            addCriterion("taoCanId_FK_OrderItem =", value, "taoCanId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemNotEqualTo(Integer value) {
            addCriterion("taoCanId_FK_OrderItem <>", value, "taoCanId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemGreaterThan(Integer value) {
            addCriterion("taoCanId_FK_OrderItem >", value, "taoCanId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("taoCanId_FK_OrderItem >=", value, "taoCanId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemLessThan(Integer value) {
            addCriterion("taoCanId_FK_OrderItem <", value, "taoCanId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemLessThanOrEqualTo(Integer value) {
            addCriterion("taoCanId_FK_OrderItem <=", value, "taoCanId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemIn(List<Integer> values) {
            addCriterion("taoCanId_FK_OrderItem in", values, "taoCanId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemNotIn(List<Integer> values) {
            addCriterion("taoCanId_FK_OrderItem not in", values, "taoCanId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemBetween(Integer value1, Integer value2) {
            addCriterion("taoCanId_FK_OrderItem between", value1, value2, "taoCanId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_OrderItemNotBetween(Integer value1, Integer value2) {
            addCriterion("taoCanId_FK_OrderItem not between", value1, value2, "taoCanId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemIsNull() {
            addCriterion("commentId_FK_OrderItem is null");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemIsNotNull() {
            addCriterion("commentId_FK_OrderItem is not null");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemEqualTo(Integer value) {
            addCriterion("commentId_FK_OrderItem =", value, "commentId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemNotEqualTo(Integer value) {
            addCriterion("commentId_FK_OrderItem <>", value, "commentId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemGreaterThan(Integer value) {
            addCriterion("commentId_FK_OrderItem >", value, "commentId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentId_FK_OrderItem >=", value, "commentId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemLessThan(Integer value) {
            addCriterion("commentId_FK_OrderItem <", value, "commentId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemLessThanOrEqualTo(Integer value) {
            addCriterion("commentId_FK_OrderItem <=", value, "commentId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemIn(List<Integer> values) {
            addCriterion("commentId_FK_OrderItem in", values, "commentId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemNotIn(List<Integer> values) {
            addCriterion("commentId_FK_OrderItem not in", values, "commentId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemBetween(Integer value1, Integer value2) {
            addCriterion("commentId_FK_OrderItem between", value1, value2, "commentId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andCommentId_FK_OrderItemNotBetween(Integer value1, Integer value2) {
            addCriterion("commentId_FK_OrderItem not between", value1, value2, "commentId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceIsNull() {
            addCriterion("orderItemPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceIsNotNull() {
            addCriterion("orderItemPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceEqualTo(Integer value) {
            addCriterion("orderItemPrice =", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceNotEqualTo(Integer value) {
            addCriterion("orderItemPrice <>", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceGreaterThan(Integer value) {
            addCriterion("orderItemPrice >", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderItemPrice >=", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceLessThan(Integer value) {
            addCriterion("orderItemPrice <", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceLessThanOrEqualTo(Integer value) {
            addCriterion("orderItemPrice <=", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceIn(List<Integer> values) {
            addCriterion("orderItemPrice in", values, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceNotIn(List<Integer> values) {
            addCriterion("orderItemPrice not in", values, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceBetween(Integer value1, Integer value2) {
            addCriterion("orderItemPrice between", value1, value2, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("orderItemPrice not between", value1, value2, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateIsNull() {
            addCriterion("orderItemStartDate is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateIsNotNull() {
            addCriterion("orderItemStartDate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateEqualTo(String value) {
            addCriterion("orderItemStartDate =", value, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateNotEqualTo(String value) {
            addCriterion("orderItemStartDate <>", value, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateGreaterThan(String value) {
            addCriterion("orderItemStartDate >", value, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("orderItemStartDate >=", value, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateLessThan(String value) {
            addCriterion("orderItemStartDate <", value, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateLessThanOrEqualTo(String value) {
            addCriterion("orderItemStartDate <=", value, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateLike(String value) {
            addCriterion("orderItemStartDate like", value, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateNotLike(String value) {
            addCriterion("orderItemStartDate not like", value, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateIn(List<String> values) {
            addCriterion("orderItemStartDate in", values, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateNotIn(List<String> values) {
            addCriterion("orderItemStartDate not in", values, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateBetween(String value1, String value2) {
            addCriterion("orderItemStartDate between", value1, value2, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemStartDateNotBetween(String value1, String value2) {
            addCriterion("orderItemStartDate not between", value1, value2, "orderItemStartDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateIsNull() {
            addCriterion("orderItemEndDate is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateIsNotNull() {
            addCriterion("orderItemEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateEqualTo(String value) {
            addCriterion("orderItemEndDate =", value, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateNotEqualTo(String value) {
            addCriterion("orderItemEndDate <>", value, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateGreaterThan(String value) {
            addCriterion("orderItemEndDate >", value, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("orderItemEndDate >=", value, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateLessThan(String value) {
            addCriterion("orderItemEndDate <", value, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateLessThanOrEqualTo(String value) {
            addCriterion("orderItemEndDate <=", value, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateLike(String value) {
            addCriterion("orderItemEndDate like", value, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateNotLike(String value) {
            addCriterion("orderItemEndDate not like", value, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateIn(List<String> values) {
            addCriterion("orderItemEndDate in", values, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateNotIn(List<String> values) {
            addCriterion("orderItemEndDate not in", values, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateBetween(String value1, String value2) {
            addCriterion("orderItemEndDate between", value1, value2, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemEndDateNotBetween(String value1, String value2) {
            addCriterion("orderItemEndDate not between", value1, value2, "orderItemEndDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusIsNull() {
            addCriterion("orderItemPayStatus is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusIsNotNull() {
            addCriterion("orderItemPayStatus is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusEqualTo(Integer value) {
            addCriterion("orderItemPayStatus =", value, "orderItemPayStatus");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusNotEqualTo(Integer value) {
            addCriterion("orderItemPayStatus <>", value, "orderItemPayStatus");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusGreaterThan(Integer value) {
            addCriterion("orderItemPayStatus >", value, "orderItemPayStatus");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("orderItemPayStatus >=", value, "orderItemPayStatus");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusLessThan(Integer value) {
            addCriterion("orderItemPayStatus <", value, "orderItemPayStatus");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("orderItemPayStatus <=", value, "orderItemPayStatus");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusIn(List<Integer> values) {
            addCriterion("orderItemPayStatus in", values, "orderItemPayStatus");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusNotIn(List<Integer> values) {
            addCriterion("orderItemPayStatus not in", values, "orderItemPayStatus");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("orderItemPayStatus between", value1, value2, "orderItemPayStatus");
            return (Criteria) this;
        }

        public Criteria andOrderItemPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("orderItemPayStatus not between", value1, value2, "orderItemPayStatus");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateIsNull() {
            addCriterion("orderItemCreateDate is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateIsNotNull() {
            addCriterion("orderItemCreateDate is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateEqualTo(String value) {
            addCriterion("orderItemCreateDate =", value, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateNotEqualTo(String value) {
            addCriterion("orderItemCreateDate <>", value, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateGreaterThan(String value) {
            addCriterion("orderItemCreateDate >", value, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("orderItemCreateDate >=", value, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateLessThan(String value) {
            addCriterion("orderItemCreateDate <", value, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateLessThanOrEqualTo(String value) {
            addCriterion("orderItemCreateDate <=", value, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateLike(String value) {
            addCriterion("orderItemCreateDate like", value, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateNotLike(String value) {
            addCriterion("orderItemCreateDate not like", value, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateIn(List<String> values) {
            addCriterion("orderItemCreateDate in", values, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateNotIn(List<String> values) {
            addCriterion("orderItemCreateDate not in", values, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateBetween(String value1, String value2) {
            addCriterion("orderItemCreateDate between", value1, value2, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andOrderItemCreateDateNotBetween(String value1, String value2) {
            addCriterion("orderItemCreateDate not between", value1, value2, "orderItemCreateDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemIsNull() {
            addCriterion("roomTimeId_FK_OrderItem is null");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemIsNotNull() {
            addCriterion("roomTimeId_FK_OrderItem is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemEqualTo(Integer value) {
            addCriterion("roomTimeId_FK_OrderItem =", value, "roomTimeId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemNotEqualTo(Integer value) {
            addCriterion("roomTimeId_FK_OrderItem <>", value, "roomTimeId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemGreaterThan(Integer value) {
            addCriterion("roomTimeId_FK_OrderItem >", value, "roomTimeId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomTimeId_FK_OrderItem >=", value, "roomTimeId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemLessThan(Integer value) {
            addCriterion("roomTimeId_FK_OrderItem <", value, "roomTimeId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemLessThanOrEqualTo(Integer value) {
            addCriterion("roomTimeId_FK_OrderItem <=", value, "roomTimeId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemIn(List<Integer> values) {
            addCriterion("roomTimeId_FK_OrderItem in", values, "roomTimeId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemNotIn(List<Integer> values) {
            addCriterion("roomTimeId_FK_OrderItem not in", values, "roomTimeId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemBetween(Integer value1, Integer value2) {
            addCriterion("roomTimeId_FK_OrderItem between", value1, value2, "roomTimeId_FK_OrderItem");
            return (Criteria) this;
        }

        public Criteria andRoomTimeId_FK_OrderItemNotBetween(Integer value1, Integer value2) {
            addCriterion("roomTimeId_FK_OrderItem not between", value1, value2, "roomTimeId_FK_OrderItem");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}