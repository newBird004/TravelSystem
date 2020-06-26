package cn.yy.pojo;

import java.util.ArrayList;
import java.util.List;

public class CartExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CartExample() {
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

        public Criteria andCartIdIsNull() {
            addCriterion("cartId is null");
            return (Criteria) this;
        }

        public Criteria andCartIdIsNotNull() {
            addCriterion("cartId is not null");
            return (Criteria) this;
        }

        public Criteria andCartIdEqualTo(Integer value) {
            addCriterion("cartId =", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotEqualTo(Integer value) {
            addCriterion("cartId <>", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThan(Integer value) {
            addCriterion("cartId >", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cartId >=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThan(Integer value) {
            addCriterion("cartId <", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdLessThanOrEqualTo(Integer value) {
            addCriterion("cartId <=", value, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdIn(List<Integer> values) {
            addCriterion("cartId in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotIn(List<Integer> values) {
            addCriterion("cartId not in", values, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdBetween(Integer value1, Integer value2) {
            addCriterion("cartId between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andCartIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cartId not between", value1, value2, "cartId");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartIsNull() {
            addCriterion("travelUserId_FK_Cart is null");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartIsNotNull() {
            addCriterion("travelUserId_FK_Cart is not null");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartEqualTo(Integer value) {
            addCriterion("travelUserId_FK_Cart =", value, "travelUserId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartNotEqualTo(Integer value) {
            addCriterion("travelUserId_FK_Cart <>", value, "travelUserId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartGreaterThan(Integer value) {
            addCriterion("travelUserId_FK_Cart >", value, "travelUserId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartGreaterThanOrEqualTo(Integer value) {
            addCriterion("travelUserId_FK_Cart >=", value, "travelUserId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartLessThan(Integer value) {
            addCriterion("travelUserId_FK_Cart <", value, "travelUserId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartLessThanOrEqualTo(Integer value) {
            addCriterion("travelUserId_FK_Cart <=", value, "travelUserId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartIn(List<Integer> values) {
            addCriterion("travelUserId_FK_Cart in", values, "travelUserId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartNotIn(List<Integer> values) {
            addCriterion("travelUserId_FK_Cart not in", values, "travelUserId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartBetween(Integer value1, Integer value2) {
            addCriterion("travelUserId_FK_Cart between", value1, value2, "travelUserId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_CartNotBetween(Integer value1, Integer value2) {
            addCriterion("travelUserId_FK_Cart not between", value1, value2, "travelUserId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartIsNull() {
            addCriterion("realNameId_FK_Cart is null");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartIsNotNull() {
            addCriterion("realNameId_FK_Cart is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartEqualTo(Integer value) {
            addCriterion("realNameId_FK_Cart =", value, "realNameId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartNotEqualTo(Integer value) {
            addCriterion("realNameId_FK_Cart <>", value, "realNameId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartGreaterThan(Integer value) {
            addCriterion("realNameId_FK_Cart >", value, "realNameId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartGreaterThanOrEqualTo(Integer value) {
            addCriterion("realNameId_FK_Cart >=", value, "realNameId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartLessThan(Integer value) {
            addCriterion("realNameId_FK_Cart <", value, "realNameId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartLessThanOrEqualTo(Integer value) {
            addCriterion("realNameId_FK_Cart <=", value, "realNameId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartIn(List<Integer> values) {
            addCriterion("realNameId_FK_Cart in", values, "realNameId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartNotIn(List<Integer> values) {
            addCriterion("realNameId_FK_Cart not in", values, "realNameId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartBetween(Integer value1, Integer value2) {
            addCriterion("realNameId_FK_Cart between", value1, value2, "realNameId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andRealNameId_FK_CartNotBetween(Integer value1, Integer value2) {
            addCriterion("realNameId_FK_Cart not between", value1, value2, "realNameId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartIsNull() {
            addCriterion("scenicId_FK_Cart is null");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartIsNotNull() {
            addCriterion("scenicId_FK_Cart is not null");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartEqualTo(Integer value) {
            addCriterion("scenicId_FK_Cart =", value, "scenicId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartNotEqualTo(Integer value) {
            addCriterion("scenicId_FK_Cart <>", value, "scenicId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartGreaterThan(Integer value) {
            addCriterion("scenicId_FK_Cart >", value, "scenicId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartGreaterThanOrEqualTo(Integer value) {
            addCriterion("scenicId_FK_Cart >=", value, "scenicId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartLessThan(Integer value) {
            addCriterion("scenicId_FK_Cart <", value, "scenicId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartLessThanOrEqualTo(Integer value) {
            addCriterion("scenicId_FK_Cart <=", value, "scenicId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartIn(List<Integer> values) {
            addCriterion("scenicId_FK_Cart in", values, "scenicId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartNotIn(List<Integer> values) {
            addCriterion("scenicId_FK_Cart not in", values, "scenicId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartBetween(Integer value1, Integer value2) {
            addCriterion("scenicId_FK_Cart between", value1, value2, "scenicId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CartNotBetween(Integer value1, Integer value2) {
            addCriterion("scenicId_FK_Cart not between", value1, value2, "scenicId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartIsNull() {
            addCriterion("hotelId_FK_Cart is null");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartIsNotNull() {
            addCriterion("hotelId_FK_Cart is not null");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartEqualTo(Integer value) {
            addCriterion("hotelId_FK_Cart =", value, "hotelId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartNotEqualTo(Integer value) {
            addCriterion("hotelId_FK_Cart <>", value, "hotelId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartGreaterThan(Integer value) {
            addCriterion("hotelId_FK_Cart >", value, "hotelId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotelId_FK_Cart >=", value, "hotelId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartLessThan(Integer value) {
            addCriterion("hotelId_FK_Cart <", value, "hotelId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartLessThanOrEqualTo(Integer value) {
            addCriterion("hotelId_FK_Cart <=", value, "hotelId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartIn(List<Integer> values) {
            addCriterion("hotelId_FK_Cart in", values, "hotelId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartNotIn(List<Integer> values) {
            addCriterion("hotelId_FK_Cart not in", values, "hotelId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartBetween(Integer value1, Integer value2) {
            addCriterion("hotelId_FK_Cart between", value1, value2, "hotelId_FK_Cart");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CartNotBetween(Integer value1, Integer value2) {
            addCriterion("hotelId_FK_Cart not between", value1, value2, "hotelId_FK_Cart");
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

        public Criteria andCartStartDateIsNull() {
            addCriterion("cartStartDate is null");
            return (Criteria) this;
        }

        public Criteria andCartStartDateIsNotNull() {
            addCriterion("cartStartDate is not null");
            return (Criteria) this;
        }

        public Criteria andCartStartDateEqualTo(String value) {
            addCriterion("cartStartDate =", value, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartStartDateNotEqualTo(String value) {
            addCriterion("cartStartDate <>", value, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartStartDateGreaterThan(String value) {
            addCriterion("cartStartDate >", value, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("cartStartDate >=", value, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartStartDateLessThan(String value) {
            addCriterion("cartStartDate <", value, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartStartDateLessThanOrEqualTo(String value) {
            addCriterion("cartStartDate <=", value, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartStartDateLike(String value) {
            addCriterion("cartStartDate like", value, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartStartDateNotLike(String value) {
            addCriterion("cartStartDate not like", value, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartStartDateIn(List<String> values) {
            addCriterion("cartStartDate in", values, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartStartDateNotIn(List<String> values) {
            addCriterion("cartStartDate not in", values, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartStartDateBetween(String value1, String value2) {
            addCriterion("cartStartDate between", value1, value2, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartStartDateNotBetween(String value1, String value2) {
            addCriterion("cartStartDate not between", value1, value2, "cartStartDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateIsNull() {
            addCriterion("cartEndDate is null");
            return (Criteria) this;
        }

        public Criteria andCartEndDateIsNotNull() {
            addCriterion("cartEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andCartEndDateEqualTo(String value) {
            addCriterion("cartEndDate =", value, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateNotEqualTo(String value) {
            addCriterion("cartEndDate <>", value, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateGreaterThan(String value) {
            addCriterion("cartEndDate >", value, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("cartEndDate >=", value, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateLessThan(String value) {
            addCriterion("cartEndDate <", value, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateLessThanOrEqualTo(String value) {
            addCriterion("cartEndDate <=", value, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateLike(String value) {
            addCriterion("cartEndDate like", value, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateNotLike(String value) {
            addCriterion("cartEndDate not like", value, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateIn(List<String> values) {
            addCriterion("cartEndDate in", values, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateNotIn(List<String> values) {
            addCriterion("cartEndDate not in", values, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateBetween(String value1, String value2) {
            addCriterion("cartEndDate between", value1, value2, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartEndDateNotBetween(String value1, String value2) {
            addCriterion("cartEndDate not between", value1, value2, "cartEndDate");
            return (Criteria) this;
        }

        public Criteria andCartPriceIsNull() {
            addCriterion("cartPrice is null");
            return (Criteria) this;
        }

        public Criteria andCartPriceIsNotNull() {
            addCriterion("cartPrice is not null");
            return (Criteria) this;
        }

        public Criteria andCartPriceEqualTo(Integer value) {
            addCriterion("cartPrice =", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceNotEqualTo(Integer value) {
            addCriterion("cartPrice <>", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceGreaterThan(Integer value) {
            addCriterion("cartPrice >", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("cartPrice >=", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceLessThan(Integer value) {
            addCriterion("cartPrice <", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceLessThanOrEqualTo(Integer value) {
            addCriterion("cartPrice <=", value, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceIn(List<Integer> values) {
            addCriterion("cartPrice in", values, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceNotIn(List<Integer> values) {
            addCriterion("cartPrice not in", values, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceBetween(Integer value1, Integer value2) {
            addCriterion("cartPrice between", value1, value2, "cartPrice");
            return (Criteria) this;
        }

        public Criteria andCartPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("cartPrice not between", value1, value2, "cartPrice");
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