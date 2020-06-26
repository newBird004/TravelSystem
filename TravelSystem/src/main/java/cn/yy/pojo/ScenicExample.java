package cn.yy.pojo;

import java.util.ArrayList;
import java.util.List;

public class ScenicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ScenicExample() {
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

        public Criteria andScenicIdIsNull() {
            addCriterion("scenicId is null");
            return (Criteria) this;
        }

        public Criteria andScenicIdIsNotNull() {
            addCriterion("scenicId is not null");
            return (Criteria) this;
        }

        public Criteria andScenicIdEqualTo(Integer value) {
            addCriterion("scenicId =", value, "scenicId");
            return (Criteria) this;
        }

        public Criteria andScenicIdNotEqualTo(Integer value) {
            addCriterion("scenicId <>", value, "scenicId");
            return (Criteria) this;
        }

        public Criteria andScenicIdGreaterThan(Integer value) {
            addCriterion("scenicId >", value, "scenicId");
            return (Criteria) this;
        }

        public Criteria andScenicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("scenicId >=", value, "scenicId");
            return (Criteria) this;
        }

        public Criteria andScenicIdLessThan(Integer value) {
            addCriterion("scenicId <", value, "scenicId");
            return (Criteria) this;
        }

        public Criteria andScenicIdLessThanOrEqualTo(Integer value) {
            addCriterion("scenicId <=", value, "scenicId");
            return (Criteria) this;
        }

        public Criteria andScenicIdIn(List<Integer> values) {
            addCriterion("scenicId in", values, "scenicId");
            return (Criteria) this;
        }

        public Criteria andScenicIdNotIn(List<Integer> values) {
            addCriterion("scenicId not in", values, "scenicId");
            return (Criteria) this;
        }

        public Criteria andScenicIdBetween(Integer value1, Integer value2) {
            addCriterion("scenicId between", value1, value2, "scenicId");
            return (Criteria) this;
        }

        public Criteria andScenicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("scenicId not between", value1, value2, "scenicId");
            return (Criteria) this;
        }

        public Criteria andScenicNameIsNull() {
            addCriterion("scenicName is null");
            return (Criteria) this;
        }

        public Criteria andScenicNameIsNotNull() {
            addCriterion("scenicName is not null");
            return (Criteria) this;
        }

        public Criteria andScenicNameEqualTo(String value) {
            addCriterion("scenicName =", value, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicNameNotEqualTo(String value) {
            addCriterion("scenicName <>", value, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicNameGreaterThan(String value) {
            addCriterion("scenicName >", value, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicNameGreaterThanOrEqualTo(String value) {
            addCriterion("scenicName >=", value, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicNameLessThan(String value) {
            addCriterion("scenicName <", value, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicNameLessThanOrEqualTo(String value) {
            addCriterion("scenicName <=", value, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicNameLike(String value) {
            addCriterion("scenicName like", value, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicNameNotLike(String value) {
            addCriterion("scenicName not like", value, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicNameIn(List<String> values) {
            addCriterion("scenicName in", values, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicNameNotIn(List<String> values) {
            addCriterion("scenicName not in", values, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicNameBetween(String value1, String value2) {
            addCriterion("scenicName between", value1, value2, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicNameNotBetween(String value1, String value2) {
            addCriterion("scenicName not between", value1, value2, "scenicName");
            return (Criteria) this;
        }

        public Criteria andScenicPriceIsNull() {
            addCriterion("scenicPrice is null");
            return (Criteria) this;
        }

        public Criteria andScenicPriceIsNotNull() {
            addCriterion("scenicPrice is not null");
            return (Criteria) this;
        }

        public Criteria andScenicPriceEqualTo(Integer value) {
            addCriterion("scenicPrice =", value, "scenicPrice");
            return (Criteria) this;
        }

        public Criteria andScenicPriceNotEqualTo(Integer value) {
            addCriterion("scenicPrice <>", value, "scenicPrice");
            return (Criteria) this;
        }

        public Criteria andScenicPriceGreaterThan(Integer value) {
            addCriterion("scenicPrice >", value, "scenicPrice");
            return (Criteria) this;
        }

        public Criteria andScenicPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("scenicPrice >=", value, "scenicPrice");
            return (Criteria) this;
        }

        public Criteria andScenicPriceLessThan(Integer value) {
            addCriterion("scenicPrice <", value, "scenicPrice");
            return (Criteria) this;
        }

        public Criteria andScenicPriceLessThanOrEqualTo(Integer value) {
            addCriterion("scenicPrice <=", value, "scenicPrice");
            return (Criteria) this;
        }

        public Criteria andScenicPriceIn(List<Integer> values) {
            addCriterion("scenicPrice in", values, "scenicPrice");
            return (Criteria) this;
        }

        public Criteria andScenicPriceNotIn(List<Integer> values) {
            addCriterion("scenicPrice not in", values, "scenicPrice");
            return (Criteria) this;
        }

        public Criteria andScenicPriceBetween(Integer value1, Integer value2) {
            addCriterion("scenicPrice between", value1, value2, "scenicPrice");
            return (Criteria) this;
        }

        public Criteria andScenicPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("scenicPrice not between", value1, value2, "scenicPrice");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceIsNull() {
            addCriterion("scenicIntroduce is null");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceIsNotNull() {
            addCriterion("scenicIntroduce is not null");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceEqualTo(String value) {
            addCriterion("scenicIntroduce =", value, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceNotEqualTo(String value) {
            addCriterion("scenicIntroduce <>", value, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceGreaterThan(String value) {
            addCriterion("scenicIntroduce >", value, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("scenicIntroduce >=", value, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceLessThan(String value) {
            addCriterion("scenicIntroduce <", value, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceLessThanOrEqualTo(String value) {
            addCriterion("scenicIntroduce <=", value, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceLike(String value) {
            addCriterion("scenicIntroduce like", value, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceNotLike(String value) {
            addCriterion("scenicIntroduce not like", value, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceIn(List<String> values) {
            addCriterion("scenicIntroduce in", values, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceNotIn(List<String> values) {
            addCriterion("scenicIntroduce not in", values, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceBetween(String value1, String value2) {
            addCriterion("scenicIntroduce between", value1, value2, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicIntroduceNotBetween(String value1, String value2) {
            addCriterion("scenicIntroduce not between", value1, value2, "scenicIntroduce");
            return (Criteria) this;
        }

        public Criteria andScenicImageIsNull() {
            addCriterion("scenicImage is null");
            return (Criteria) this;
        }

        public Criteria andScenicImageIsNotNull() {
            addCriterion("scenicImage is not null");
            return (Criteria) this;
        }

        public Criteria andScenicImageEqualTo(String value) {
            addCriterion("scenicImage =", value, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicImageNotEqualTo(String value) {
            addCriterion("scenicImage <>", value, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicImageGreaterThan(String value) {
            addCriterion("scenicImage >", value, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicImageGreaterThanOrEqualTo(String value) {
            addCriterion("scenicImage >=", value, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicImageLessThan(String value) {
            addCriterion("scenicImage <", value, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicImageLessThanOrEqualTo(String value) {
            addCriterion("scenicImage <=", value, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicImageLike(String value) {
            addCriterion("scenicImage like", value, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicImageNotLike(String value) {
            addCriterion("scenicImage not like", value, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicImageIn(List<String> values) {
            addCriterion("scenicImage in", values, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicImageNotIn(List<String> values) {
            addCriterion("scenicImage not in", values, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicImageBetween(String value1, String value2) {
            addCriterion("scenicImage between", value1, value2, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicImageNotBetween(String value1, String value2) {
            addCriterion("scenicImage not between", value1, value2, "scenicImage");
            return (Criteria) this;
        }

        public Criteria andScenicExistIsNull() {
            addCriterion("scenicExist is null");
            return (Criteria) this;
        }

        public Criteria andScenicExistIsNotNull() {
            addCriterion("scenicExist is not null");
            return (Criteria) this;
        }

        public Criteria andScenicExistEqualTo(Integer value) {
            addCriterion("scenicExist =", value, "scenicExist");
            return (Criteria) this;
        }

        public Criteria andScenicExistNotEqualTo(Integer value) {
            addCriterion("scenicExist <>", value, "scenicExist");
            return (Criteria) this;
        }

        public Criteria andScenicExistGreaterThan(Integer value) {
            addCriterion("scenicExist >", value, "scenicExist");
            return (Criteria) this;
        }

        public Criteria andScenicExistGreaterThanOrEqualTo(Integer value) {
            addCriterion("scenicExist >=", value, "scenicExist");
            return (Criteria) this;
        }

        public Criteria andScenicExistLessThan(Integer value) {
            addCriterion("scenicExist <", value, "scenicExist");
            return (Criteria) this;
        }

        public Criteria andScenicExistLessThanOrEqualTo(Integer value) {
            addCriterion("scenicExist <=", value, "scenicExist");
            return (Criteria) this;
        }

        public Criteria andScenicExistIn(List<Integer> values) {
            addCriterion("scenicExist in", values, "scenicExist");
            return (Criteria) this;
        }

        public Criteria andScenicExistNotIn(List<Integer> values) {
            addCriterion("scenicExist not in", values, "scenicExist");
            return (Criteria) this;
        }

        public Criteria andScenicExistBetween(Integer value1, Integer value2) {
            addCriterion("scenicExist between", value1, value2, "scenicExist");
            return (Criteria) this;
        }

        public Criteria andScenicExistNotBetween(Integer value1, Integer value2) {
            addCriterion("scenicExist not between", value1, value2, "scenicExist");
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