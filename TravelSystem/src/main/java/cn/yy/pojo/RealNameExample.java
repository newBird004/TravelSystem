package cn.yy.pojo;

import java.util.ArrayList;
import java.util.List;

public class RealNameExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RealNameExample() {
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

        public Criteria andRealNameIdIsNull() {
            addCriterion("realNameId is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIdIsNotNull() {
            addCriterion("realNameId is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameIdEqualTo(Integer value) {
            addCriterion("realNameId =", value, "realNameId");
            return (Criteria) this;
        }

        public Criteria andRealNameIdNotEqualTo(Integer value) {
            addCriterion("realNameId <>", value, "realNameId");
            return (Criteria) this;
        }

        public Criteria andRealNameIdGreaterThan(Integer value) {
            addCriterion("realNameId >", value, "realNameId");
            return (Criteria) this;
        }

        public Criteria andRealNameIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("realNameId >=", value, "realNameId");
            return (Criteria) this;
        }

        public Criteria andRealNameIdLessThan(Integer value) {
            addCriterion("realNameId <", value, "realNameId");
            return (Criteria) this;
        }

        public Criteria andRealNameIdLessThanOrEqualTo(Integer value) {
            addCriterion("realNameId <=", value, "realNameId");
            return (Criteria) this;
        }

        public Criteria andRealNameIdIn(List<Integer> values) {
            addCriterion("realNameId in", values, "realNameId");
            return (Criteria) this;
        }

        public Criteria andRealNameIdNotIn(List<Integer> values) {
            addCriterion("realNameId not in", values, "realNameId");
            return (Criteria) this;
        }

        public Criteria andRealNameIdBetween(Integer value1, Integer value2) {
            addCriterion("realNameId between", value1, value2, "realNameId");
            return (Criteria) this;
        }

        public Criteria andRealNameIdNotBetween(Integer value1, Integer value2) {
            addCriterion("realNameId not between", value1, value2, "realNameId");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameIsNull() {
            addCriterion("travelUserId_FK_RealName is null");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameIsNotNull() {
            addCriterion("travelUserId_FK_RealName is not null");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameEqualTo(Integer value) {
            addCriterion("travelUserId_FK_RealName =", value, "travelUserId_FK_RealName");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameNotEqualTo(Integer value) {
            addCriterion("travelUserId_FK_RealName <>", value, "travelUserId_FK_RealName");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameGreaterThan(Integer value) {
            addCriterion("travelUserId_FK_RealName >", value, "travelUserId_FK_RealName");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameGreaterThanOrEqualTo(Integer value) {
            addCriterion("travelUserId_FK_RealName >=", value, "travelUserId_FK_RealName");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameLessThan(Integer value) {
            addCriterion("travelUserId_FK_RealName <", value, "travelUserId_FK_RealName");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameLessThanOrEqualTo(Integer value) {
            addCriterion("travelUserId_FK_RealName <=", value, "travelUserId_FK_RealName");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameIn(List<Integer> values) {
            addCriterion("travelUserId_FK_RealName in", values, "travelUserId_FK_RealName");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameNotIn(List<Integer> values) {
            addCriterion("travelUserId_FK_RealName not in", values, "travelUserId_FK_RealName");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameBetween(Integer value1, Integer value2) {
            addCriterion("travelUserId_FK_RealName between", value1, value2, "travelUserId_FK_RealName");
            return (Criteria) this;
        }

        public Criteria andTravelUserId_FK_RealNameNotBetween(Integer value1, Integer value2) {
            addCriterion("travelUserId_FK_RealName not between", value1, value2, "travelUserId_FK_RealName");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("idCard is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("idCard is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("idCard =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("idCard <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("idCard >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("idCard >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("idCard <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("idCard <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("idCard like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("idCard not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("idCard in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("idCard not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("idCard between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("idCard not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("realName is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("realName is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("realName =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("realName <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("realName >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("realName >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("realName <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("realName <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("realName like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("realName not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("realName in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("realName not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("realName between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("realName not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andRealNameExistIsNull() {
            addCriterion("realNameExist is null");
            return (Criteria) this;
        }

        public Criteria andRealNameExistIsNotNull() {
            addCriterion("realNameExist is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameExistEqualTo(Integer value) {
            addCriterion("realNameExist =", value, "realNameExist");
            return (Criteria) this;
        }

        public Criteria andRealNameExistNotEqualTo(Integer value) {
            addCriterion("realNameExist <>", value, "realNameExist");
            return (Criteria) this;
        }

        public Criteria andRealNameExistGreaterThan(Integer value) {
            addCriterion("realNameExist >", value, "realNameExist");
            return (Criteria) this;
        }

        public Criteria andRealNameExistGreaterThanOrEqualTo(Integer value) {
            addCriterion("realNameExist >=", value, "realNameExist");
            return (Criteria) this;
        }

        public Criteria andRealNameExistLessThan(Integer value) {
            addCriterion("realNameExist <", value, "realNameExist");
            return (Criteria) this;
        }

        public Criteria andRealNameExistLessThanOrEqualTo(Integer value) {
            addCriterion("realNameExist <=", value, "realNameExist");
            return (Criteria) this;
        }

        public Criteria andRealNameExistIn(List<Integer> values) {
            addCriterion("realNameExist in", values, "realNameExist");
            return (Criteria) this;
        }

        public Criteria andRealNameExistNotIn(List<Integer> values) {
            addCriterion("realNameExist not in", values, "realNameExist");
            return (Criteria) this;
        }

        public Criteria andRealNameExistBetween(Integer value1, Integer value2) {
            addCriterion("realNameExist between", value1, value2, "realNameExist");
            return (Criteria) this;
        }

        public Criteria andRealNameExistNotBetween(Integer value1, Integer value2) {
            addCriterion("realNameExist not between", value1, value2, "realNameExist");
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