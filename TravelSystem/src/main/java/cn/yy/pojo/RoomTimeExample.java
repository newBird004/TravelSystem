package cn.yy.pojo;

import java.util.ArrayList;
import java.util.List;

public class RoomTimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomTimeExample() {
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

        public Criteria andRoomTimeIdIsNull() {
            addCriterion("roomTimeId is null");
            return (Criteria) this;
        }

        public Criteria andRoomTimeIdIsNotNull() {
            addCriterion("roomTimeId is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTimeIdEqualTo(Integer value) {
            addCriterion("roomTimeId =", value, "roomTimeId");
            return (Criteria) this;
        }

        public Criteria andRoomTimeIdNotEqualTo(Integer value) {
            addCriterion("roomTimeId <>", value, "roomTimeId");
            return (Criteria) this;
        }

        public Criteria andRoomTimeIdGreaterThan(Integer value) {
            addCriterion("roomTimeId >", value, "roomTimeId");
            return (Criteria) this;
        }

        public Criteria andRoomTimeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomTimeId >=", value, "roomTimeId");
            return (Criteria) this;
        }

        public Criteria andRoomTimeIdLessThan(Integer value) {
            addCriterion("roomTimeId <", value, "roomTimeId");
            return (Criteria) this;
        }

        public Criteria andRoomTimeIdLessThanOrEqualTo(Integer value) {
            addCriterion("roomTimeId <=", value, "roomTimeId");
            return (Criteria) this;
        }

        public Criteria andRoomTimeIdIn(List<Integer> values) {
            addCriterion("roomTimeId in", values, "roomTimeId");
            return (Criteria) this;
        }

        public Criteria andRoomTimeIdNotIn(List<Integer> values) {
            addCriterion("roomTimeId not in", values, "roomTimeId");
            return (Criteria) this;
        }

        public Criteria andRoomTimeIdBetween(Integer value1, Integer value2) {
            addCriterion("roomTimeId between", value1, value2, "roomTimeId");
            return (Criteria) this;
        }

        public Criteria andRoomTimeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("roomTimeId not between", value1, value2, "roomTimeId");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeIsNull() {
            addCriterion("roomId_FK_RoomTime is null");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeIsNotNull() {
            addCriterion("roomId_FK_RoomTime is not null");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeEqualTo(Integer value) {
            addCriterion("roomId_FK_RoomTime =", value, "roomId_FK_RoomTime");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeNotEqualTo(Integer value) {
            addCriterion("roomId_FK_RoomTime <>", value, "roomId_FK_RoomTime");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeGreaterThan(Integer value) {
            addCriterion("roomId_FK_RoomTime >", value, "roomId_FK_RoomTime");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("roomId_FK_RoomTime >=", value, "roomId_FK_RoomTime");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeLessThan(Integer value) {
            addCriterion("roomId_FK_RoomTime <", value, "roomId_FK_RoomTime");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeLessThanOrEqualTo(Integer value) {
            addCriterion("roomId_FK_RoomTime <=", value, "roomId_FK_RoomTime");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeIn(List<Integer> values) {
            addCriterion("roomId_FK_RoomTime in", values, "roomId_FK_RoomTime");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeNotIn(List<Integer> values) {
            addCriterion("roomId_FK_RoomTime not in", values, "roomId_FK_RoomTime");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeBetween(Integer value1, Integer value2) {
            addCriterion("roomId_FK_RoomTime between", value1, value2, "roomId_FK_RoomTime");
            return (Criteria) this;
        }

        public Criteria andRoomId_FK_RoomTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("roomId_FK_RoomTime not between", value1, value2, "roomId_FK_RoomTime");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateIsNull() {
            addCriterion("roomTimeStartDate is null");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateIsNotNull() {
            addCriterion("roomTimeStartDate is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateEqualTo(String value) {
            addCriterion("roomTimeStartDate =", value, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateNotEqualTo(String value) {
            addCriterion("roomTimeStartDate <>", value, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateGreaterThan(String value) {
            addCriterion("roomTimeStartDate >", value, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateGreaterThanOrEqualTo(String value) {
            addCriterion("roomTimeStartDate >=", value, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateLessThan(String value) {
            addCriterion("roomTimeStartDate <", value, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateLessThanOrEqualTo(String value) {
            addCriterion("roomTimeStartDate <=", value, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateLike(String value) {
            addCriterion("roomTimeStartDate like", value, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateNotLike(String value) {
            addCriterion("roomTimeStartDate not like", value, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateIn(List<String> values) {
            addCriterion("roomTimeStartDate in", values, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateNotIn(List<String> values) {
            addCriterion("roomTimeStartDate not in", values, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateBetween(String value1, String value2) {
            addCriterion("roomTimeStartDate between", value1, value2, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeStartDateNotBetween(String value1, String value2) {
            addCriterion("roomTimeStartDate not between", value1, value2, "roomTimeStartDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateIsNull() {
            addCriterion("roomTimeEndDate is null");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateIsNotNull() {
            addCriterion("roomTimeEndDate is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateEqualTo(String value) {
            addCriterion("roomTimeEndDate =", value, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateNotEqualTo(String value) {
            addCriterion("roomTimeEndDate <>", value, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateGreaterThan(String value) {
            addCriterion("roomTimeEndDate >", value, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateGreaterThanOrEqualTo(String value) {
            addCriterion("roomTimeEndDate >=", value, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateLessThan(String value) {
            addCriterion("roomTimeEndDate <", value, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateLessThanOrEqualTo(String value) {
            addCriterion("roomTimeEndDate <=", value, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateLike(String value) {
            addCriterion("roomTimeEndDate like", value, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateNotLike(String value) {
            addCriterion("roomTimeEndDate not like", value, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateIn(List<String> values) {
            addCriterion("roomTimeEndDate in", values, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateNotIn(List<String> values) {
            addCriterion("roomTimeEndDate not in", values, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateBetween(String value1, String value2) {
            addCriterion("roomTimeEndDate between", value1, value2, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andRoomTimeEndDateNotBetween(String value1, String value2) {
            addCriterion("roomTimeEndDate not between", value1, value2, "roomTimeEndDate");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNull() {
            addCriterion("payStatus is null");
            return (Criteria) this;
        }

        public Criteria andPayStatusIsNotNull() {
            addCriterion("payStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPayStatusEqualTo(Integer value) {
            addCriterion("payStatus =", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotEqualTo(Integer value) {
            addCriterion("payStatus <>", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThan(Integer value) {
            addCriterion("payStatus >", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("payStatus >=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThan(Integer value) {
            addCriterion("payStatus <", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("payStatus <=", value, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusIn(List<Integer> values) {
            addCriterion("payStatus in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotIn(List<Integer> values) {
            addCriterion("payStatus not in", values, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("payStatus between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("payStatus not between", value1, value2, "payStatus");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(String value) {
            addCriterion("createDate =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(String value) {
            addCriterion("createDate <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(String value) {
            addCriterion("createDate >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("createDate >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(String value) {
            addCriterion("createDate <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(String value) {
            addCriterion("createDate <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLike(String value) {
            addCriterion("createDate like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotLike(String value) {
            addCriterion("createDate not like", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<String> values) {
            addCriterion("createDate in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<String> values) {
            addCriterion("createDate not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(String value1, String value2) {
            addCriterion("createDate between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(String value1, String value2) {
            addCriterion("createDate not between", value1, value2, "createDate");
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