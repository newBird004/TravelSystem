package cn.yy.pojo;

import java.util.ArrayList;
import java.util.List;

public class TaoCanItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaoCanItemExample() {
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

        public Criteria andTaoCanItemIdIsNull() {
            addCriterion("taoCanItemId is null");
            return (Criteria) this;
        }

        public Criteria andTaoCanItemIdIsNotNull() {
            addCriterion("taoCanItemId is not null");
            return (Criteria) this;
        }

        public Criteria andTaoCanItemIdEqualTo(Integer value) {
            addCriterion("taoCanItemId =", value, "taoCanItemId");
            return (Criteria) this;
        }

        public Criteria andTaoCanItemIdNotEqualTo(Integer value) {
            addCriterion("taoCanItemId <>", value, "taoCanItemId");
            return (Criteria) this;
        }

        public Criteria andTaoCanItemIdGreaterThan(Integer value) {
            addCriterion("taoCanItemId >", value, "taoCanItemId");
            return (Criteria) this;
        }

        public Criteria andTaoCanItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("taoCanItemId >=", value, "taoCanItemId");
            return (Criteria) this;
        }

        public Criteria andTaoCanItemIdLessThan(Integer value) {
            addCriterion("taoCanItemId <", value, "taoCanItemId");
            return (Criteria) this;
        }

        public Criteria andTaoCanItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("taoCanItemId <=", value, "taoCanItemId");
            return (Criteria) this;
        }

        public Criteria andTaoCanItemIdIn(List<Integer> values) {
            addCriterion("taoCanItemId in", values, "taoCanItemId");
            return (Criteria) this;
        }

        public Criteria andTaoCanItemIdNotIn(List<Integer> values) {
            addCriterion("taoCanItemId not in", values, "taoCanItemId");
            return (Criteria) this;
        }

        public Criteria andTaoCanItemIdBetween(Integer value1, Integer value2) {
            addCriterion("taoCanItemId between", value1, value2, "taoCanItemId");
            return (Criteria) this;
        }

        public Criteria andTaoCanItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("taoCanItemId not between", value1, value2, "taoCanItemId");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemIsNull() {
            addCriterion("taoCanId_FK_TaoCanItem is null");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemIsNotNull() {
            addCriterion("taoCanId_FK_TaoCanItem is not null");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemEqualTo(Integer value) {
            addCriterion("taoCanId_FK_TaoCanItem =", value, "taoCanId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemNotEqualTo(Integer value) {
            addCriterion("taoCanId_FK_TaoCanItem <>", value, "taoCanId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemGreaterThan(Integer value) {
            addCriterion("taoCanId_FK_TaoCanItem >", value, "taoCanId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("taoCanId_FK_TaoCanItem >=", value, "taoCanId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemLessThan(Integer value) {
            addCriterion("taoCanId_FK_TaoCanItem <", value, "taoCanId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemLessThanOrEqualTo(Integer value) {
            addCriterion("taoCanId_FK_TaoCanItem <=", value, "taoCanId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemIn(List<Integer> values) {
            addCriterion("taoCanId_FK_TaoCanItem in", values, "taoCanId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemNotIn(List<Integer> values) {
            addCriterion("taoCanId_FK_TaoCanItem not in", values, "taoCanId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemBetween(Integer value1, Integer value2) {
            addCriterion("taoCanId_FK_TaoCanItem between", value1, value2, "taoCanId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andTaoCanId_FK_TaoCanItemNotBetween(Integer value1, Integer value2) {
            addCriterion("taoCanId_FK_TaoCanItem not between", value1, value2, "taoCanId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemIsNull() {
            addCriterion("scenicId_FK_TaoCanItem is null");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemIsNotNull() {
            addCriterion("scenicId_FK_TaoCanItem is not null");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemEqualTo(Integer value) {
            addCriterion("scenicId_FK_TaoCanItem =", value, "scenicId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemNotEqualTo(Integer value) {
            addCriterion("scenicId_FK_TaoCanItem <>", value, "scenicId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemGreaterThan(Integer value) {
            addCriterion("scenicId_FK_TaoCanItem >", value, "scenicId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("scenicId_FK_TaoCanItem >=", value, "scenicId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemLessThan(Integer value) {
            addCriterion("scenicId_FK_TaoCanItem <", value, "scenicId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemLessThanOrEqualTo(Integer value) {
            addCriterion("scenicId_FK_TaoCanItem <=", value, "scenicId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemIn(List<Integer> values) {
            addCriterion("scenicId_FK_TaoCanItem in", values, "scenicId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemNotIn(List<Integer> values) {
            addCriterion("scenicId_FK_TaoCanItem not in", values, "scenicId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemBetween(Integer value1, Integer value2) {
            addCriterion("scenicId_FK_TaoCanItem between", value1, value2, "scenicId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_TaoCanItemNotBetween(Integer value1, Integer value2) {
            addCriterion("scenicId_FK_TaoCanItem not between", value1, value2, "scenicId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemIsNull() {
            addCriterion("hotelId_FK_TaoCanItem is null");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemIsNotNull() {
            addCriterion("hotelId_FK_TaoCanItem is not null");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemEqualTo(Integer value) {
            addCriterion("hotelId_FK_TaoCanItem =", value, "hotelId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemNotEqualTo(Integer value) {
            addCriterion("hotelId_FK_TaoCanItem <>", value, "hotelId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemGreaterThan(Integer value) {
            addCriterion("hotelId_FK_TaoCanItem >", value, "hotelId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotelId_FK_TaoCanItem >=", value, "hotelId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemLessThan(Integer value) {
            addCriterion("hotelId_FK_TaoCanItem <", value, "hotelId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemLessThanOrEqualTo(Integer value) {
            addCriterion("hotelId_FK_TaoCanItem <=", value, "hotelId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemIn(List<Integer> values) {
            addCriterion("hotelId_FK_TaoCanItem in", values, "hotelId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemNotIn(List<Integer> values) {
            addCriterion("hotelId_FK_TaoCanItem not in", values, "hotelId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemBetween(Integer value1, Integer value2) {
            addCriterion("hotelId_FK_TaoCanItem between", value1, value2, "hotelId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_TaoCanItemNotBetween(Integer value1, Integer value2) {
            addCriterion("hotelId_FK_TaoCanItem not between", value1, value2, "hotelId_FK_TaoCanItem");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNull() {
            addCriterion("roomType is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNotNull() {
            addCriterion("roomType is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeEqualTo(String value) {
            addCriterion("roomType =", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotEqualTo(String value) {
            addCriterion("roomType <>", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThan(String value) {
            addCriterion("roomType >", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("roomType >=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThan(String value) {
            addCriterion("roomType <", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThanOrEqualTo(String value) {
            addCriterion("roomType <=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLike(String value) {
            addCriterion("roomType like", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotLike(String value) {
            addCriterion("roomType not like", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIn(List<String> values) {
            addCriterion("roomType in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotIn(List<String> values) {
            addCriterion("roomType not in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeBetween(String value1, String value2) {
            addCriterion("roomType between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotBetween(String value1, String value2) {
            addCriterion("roomType not between", value1, value2, "roomType");
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