package cn.yy.pojo;

import java.util.ArrayList;
import java.util.List;

public class HotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelExample() {
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

        public Criteria andHotelIdIsNull() {
            addCriterion("hotelId is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotelId is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Integer value) {
            addCriterion("hotelId =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Integer value) {
            addCriterion("hotelId <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Integer value) {
            addCriterion("hotelId >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotelId >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Integer value) {
            addCriterion("hotelId <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Integer value) {
            addCriterion("hotelId <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Integer> values) {
            addCriterion("hotelId in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Integer> values) {
            addCriterion("hotelId not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Integer value1, Integer value2) {
            addCriterion("hotelId between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hotelId not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNull() {
            addCriterion("hotelName is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNotNull() {
            addCriterion("hotelName is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEqualTo(String value) {
            addCriterion("hotelName =", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotEqualTo(String value) {
            addCriterion("hotelName <>", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThan(String value) {
            addCriterion("hotelName >", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotelName >=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThan(String value) {
            addCriterion("hotelName <", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThanOrEqualTo(String value) {
            addCriterion("hotelName <=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLike(String value) {
            addCriterion("hotelName like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotLike(String value) {
            addCriterion("hotelName not like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameIn(List<String> values) {
            addCriterion("hotelName in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotIn(List<String> values) {
            addCriterion("hotelName not in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameBetween(String value1, String value2) {
            addCriterion("hotelName between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotBetween(String value1, String value2) {
            addCriterion("hotelName not between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceIsNull() {
            addCriterion("hotelIntroduce is null");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceIsNotNull() {
            addCriterion("hotelIntroduce is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceEqualTo(String value) {
            addCriterion("hotelIntroduce =", value, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceNotEqualTo(String value) {
            addCriterion("hotelIntroduce <>", value, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceGreaterThan(String value) {
            addCriterion("hotelIntroduce >", value, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("hotelIntroduce >=", value, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceLessThan(String value) {
            addCriterion("hotelIntroduce <", value, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceLessThanOrEqualTo(String value) {
            addCriterion("hotelIntroduce <=", value, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceLike(String value) {
            addCriterion("hotelIntroduce like", value, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceNotLike(String value) {
            addCriterion("hotelIntroduce not like", value, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceIn(List<String> values) {
            addCriterion("hotelIntroduce in", values, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceNotIn(List<String> values) {
            addCriterion("hotelIntroduce not in", values, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceBetween(String value1, String value2) {
            addCriterion("hotelIntroduce between", value1, value2, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelIntroduceNotBetween(String value1, String value2) {
            addCriterion("hotelIntroduce not between", value1, value2, "hotelIntroduce");
            return (Criteria) this;
        }

        public Criteria andHotelImageIsNull() {
            addCriterion("hotelImage is null");
            return (Criteria) this;
        }

        public Criteria andHotelImageIsNotNull() {
            addCriterion("hotelImage is not null");
            return (Criteria) this;
        }

        public Criteria andHotelImageEqualTo(String value) {
            addCriterion("hotelImage =", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageNotEqualTo(String value) {
            addCriterion("hotelImage <>", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageGreaterThan(String value) {
            addCriterion("hotelImage >", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageGreaterThanOrEqualTo(String value) {
            addCriterion("hotelImage >=", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageLessThan(String value) {
            addCriterion("hotelImage <", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageLessThanOrEqualTo(String value) {
            addCriterion("hotelImage <=", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageLike(String value) {
            addCriterion("hotelImage like", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageNotLike(String value) {
            addCriterion("hotelImage not like", value, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageIn(List<String> values) {
            addCriterion("hotelImage in", values, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageNotIn(List<String> values) {
            addCriterion("hotelImage not in", values, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageBetween(String value1, String value2) {
            addCriterion("hotelImage between", value1, value2, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelImageNotBetween(String value1, String value2) {
            addCriterion("hotelImage not between", value1, value2, "hotelImage");
            return (Criteria) this;
        }

        public Criteria andHotelExistIsNull() {
            addCriterion("hotelExist is null");
            return (Criteria) this;
        }

        public Criteria andHotelExistIsNotNull() {
            addCriterion("hotelExist is not null");
            return (Criteria) this;
        }

        public Criteria andHotelExistEqualTo(Integer value) {
            addCriterion("hotelExist =", value, "hotelExist");
            return (Criteria) this;
        }

        public Criteria andHotelExistNotEqualTo(Integer value) {
            addCriterion("hotelExist <>", value, "hotelExist");
            return (Criteria) this;
        }

        public Criteria andHotelExistGreaterThan(Integer value) {
            addCriterion("hotelExist >", value, "hotelExist");
            return (Criteria) this;
        }

        public Criteria andHotelExistGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotelExist >=", value, "hotelExist");
            return (Criteria) this;
        }

        public Criteria andHotelExistLessThan(Integer value) {
            addCriterion("hotelExist <", value, "hotelExist");
            return (Criteria) this;
        }

        public Criteria andHotelExistLessThanOrEqualTo(Integer value) {
            addCriterion("hotelExist <=", value, "hotelExist");
            return (Criteria) this;
        }

        public Criteria andHotelExistIn(List<Integer> values) {
            addCriterion("hotelExist in", values, "hotelExist");
            return (Criteria) this;
        }

        public Criteria andHotelExistNotIn(List<Integer> values) {
            addCriterion("hotelExist not in", values, "hotelExist");
            return (Criteria) this;
        }

        public Criteria andHotelExistBetween(Integer value1, Integer value2) {
            addCriterion("hotelExist between", value1, value2, "hotelExist");
            return (Criteria) this;
        }

        public Criteria andHotelExistNotBetween(Integer value1, Integer value2) {
            addCriterion("hotelExist not between", value1, value2, "hotelExist");
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