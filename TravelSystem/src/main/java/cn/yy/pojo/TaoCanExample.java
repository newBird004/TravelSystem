package cn.yy.pojo;

import java.util.ArrayList;
import java.util.List;

public class TaoCanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaoCanExample() {
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

        public Criteria andTaoCanIdIsNull() {
            addCriterion("taoCanId is null");
            return (Criteria) this;
        }

        public Criteria andTaoCanIdIsNotNull() {
            addCriterion("taoCanId is not null");
            return (Criteria) this;
        }

        public Criteria andTaoCanIdEqualTo(Integer value) {
            addCriterion("taoCanId =", value, "taoCanId");
            return (Criteria) this;
        }

        public Criteria andTaoCanIdNotEqualTo(Integer value) {
            addCriterion("taoCanId <>", value, "taoCanId");
            return (Criteria) this;
        }

        public Criteria andTaoCanIdGreaterThan(Integer value) {
            addCriterion("taoCanId >", value, "taoCanId");
            return (Criteria) this;
        }

        public Criteria andTaoCanIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("taoCanId >=", value, "taoCanId");
            return (Criteria) this;
        }

        public Criteria andTaoCanIdLessThan(Integer value) {
            addCriterion("taoCanId <", value, "taoCanId");
            return (Criteria) this;
        }

        public Criteria andTaoCanIdLessThanOrEqualTo(Integer value) {
            addCriterion("taoCanId <=", value, "taoCanId");
            return (Criteria) this;
        }

        public Criteria andTaoCanIdIn(List<Integer> values) {
            addCriterion("taoCanId in", values, "taoCanId");
            return (Criteria) this;
        }

        public Criteria andTaoCanIdNotIn(List<Integer> values) {
            addCriterion("taoCanId not in", values, "taoCanId");
            return (Criteria) this;
        }

        public Criteria andTaoCanIdBetween(Integer value1, Integer value2) {
            addCriterion("taoCanId between", value1, value2, "taoCanId");
            return (Criteria) this;
        }

        public Criteria andTaoCanIdNotBetween(Integer value1, Integer value2) {
            addCriterion("taoCanId not between", value1, value2, "taoCanId");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameIsNull() {
            addCriterion("taoCanName is null");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameIsNotNull() {
            addCriterion("taoCanName is not null");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameEqualTo(String value) {
            addCriterion("taoCanName =", value, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameNotEqualTo(String value) {
            addCriterion("taoCanName <>", value, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameGreaterThan(String value) {
            addCriterion("taoCanName >", value, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameGreaterThanOrEqualTo(String value) {
            addCriterion("taoCanName >=", value, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameLessThan(String value) {
            addCriterion("taoCanName <", value, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameLessThanOrEqualTo(String value) {
            addCriterion("taoCanName <=", value, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameLike(String value) {
            addCriterion("taoCanName like", value, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameNotLike(String value) {
            addCriterion("taoCanName not like", value, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameIn(List<String> values) {
            addCriterion("taoCanName in", values, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameNotIn(List<String> values) {
            addCriterion("taoCanName not in", values, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameBetween(String value1, String value2) {
            addCriterion("taoCanName between", value1, value2, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanNameNotBetween(String value1, String value2) {
            addCriterion("taoCanName not between", value1, value2, "taoCanName");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceIsNull() {
            addCriterion("taoCanIntroduce is null");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceIsNotNull() {
            addCriterion("taoCanIntroduce is not null");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceEqualTo(String value) {
            addCriterion("taoCanIntroduce =", value, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceNotEqualTo(String value) {
            addCriterion("taoCanIntroduce <>", value, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceGreaterThan(String value) {
            addCriterion("taoCanIntroduce >", value, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceGreaterThanOrEqualTo(String value) {
            addCriterion("taoCanIntroduce >=", value, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceLessThan(String value) {
            addCriterion("taoCanIntroduce <", value, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceLessThanOrEqualTo(String value) {
            addCriterion("taoCanIntroduce <=", value, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceLike(String value) {
            addCriterion("taoCanIntroduce like", value, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceNotLike(String value) {
            addCriterion("taoCanIntroduce not like", value, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceIn(List<String> values) {
            addCriterion("taoCanIntroduce in", values, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceNotIn(List<String> values) {
            addCriterion("taoCanIntroduce not in", values, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceBetween(String value1, String value2) {
            addCriterion("taoCanIntroduce between", value1, value2, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanIntroduceNotBetween(String value1, String value2) {
            addCriterion("taoCanIntroduce not between", value1, value2, "taoCanIntroduce");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageIsNull() {
            addCriterion("taoCanImage is null");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageIsNotNull() {
            addCriterion("taoCanImage is not null");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageEqualTo(String value) {
            addCriterion("taoCanImage =", value, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageNotEqualTo(String value) {
            addCriterion("taoCanImage <>", value, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageGreaterThan(String value) {
            addCriterion("taoCanImage >", value, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageGreaterThanOrEqualTo(String value) {
            addCriterion("taoCanImage >=", value, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageLessThan(String value) {
            addCriterion("taoCanImage <", value, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageLessThanOrEqualTo(String value) {
            addCriterion("taoCanImage <=", value, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageLike(String value) {
            addCriterion("taoCanImage like", value, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageNotLike(String value) {
            addCriterion("taoCanImage not like", value, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageIn(List<String> values) {
            addCriterion("taoCanImage in", values, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageNotIn(List<String> values) {
            addCriterion("taoCanImage not in", values, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageBetween(String value1, String value2) {
            addCriterion("taoCanImage between", value1, value2, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanImageNotBetween(String value1, String value2) {
            addCriterion("taoCanImage not between", value1, value2, "taoCanImage");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistIsNull() {
            addCriterion("taoCanExist is null");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistIsNotNull() {
            addCriterion("taoCanExist is not null");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistEqualTo(Integer value) {
            addCriterion("taoCanExist =", value, "taoCanExist");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistNotEqualTo(Integer value) {
            addCriterion("taoCanExist <>", value, "taoCanExist");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistGreaterThan(Integer value) {
            addCriterion("taoCanExist >", value, "taoCanExist");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistGreaterThanOrEqualTo(Integer value) {
            addCriterion("taoCanExist >=", value, "taoCanExist");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistLessThan(Integer value) {
            addCriterion("taoCanExist <", value, "taoCanExist");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistLessThanOrEqualTo(Integer value) {
            addCriterion("taoCanExist <=", value, "taoCanExist");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistIn(List<Integer> values) {
            addCriterion("taoCanExist in", values, "taoCanExist");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistNotIn(List<Integer> values) {
            addCriterion("taoCanExist not in", values, "taoCanExist");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistBetween(Integer value1, Integer value2) {
            addCriterion("taoCanExist between", value1, value2, "taoCanExist");
            return (Criteria) this;
        }

        public Criteria andTaoCanExistNotBetween(Integer value1, Integer value2) {
            addCriterion("taoCanExist not between", value1, value2, "taoCanExist");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceIsNull() {
            addCriterion("taoCanPrice is null");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceIsNotNull() {
            addCriterion("taoCanPrice is not null");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceEqualTo(Integer value) {
            addCriterion("taoCanPrice =", value, "taoCanPrice");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceNotEqualTo(Integer value) {
            addCriterion("taoCanPrice <>", value, "taoCanPrice");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceGreaterThan(Integer value) {
            addCriterion("taoCanPrice >", value, "taoCanPrice");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("taoCanPrice >=", value, "taoCanPrice");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceLessThan(Integer value) {
            addCriterion("taoCanPrice <", value, "taoCanPrice");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceLessThanOrEqualTo(Integer value) {
            addCriterion("taoCanPrice <=", value, "taoCanPrice");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceIn(List<Integer> values) {
            addCriterion("taoCanPrice in", values, "taoCanPrice");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceNotIn(List<Integer> values) {
            addCriterion("taoCanPrice not in", values, "taoCanPrice");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceBetween(Integer value1, Integer value2) {
            addCriterion("taoCanPrice between", value1, value2, "taoCanPrice");
            return (Criteria) this;
        }

        public Criteria andTaoCanPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("taoCanPrice not between", value1, value2, "taoCanPrice");
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