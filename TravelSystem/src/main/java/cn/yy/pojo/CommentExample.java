package cn.yy.pojo;

import java.util.ArrayList;
import java.util.List;

public class CommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentExample() {
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

        public Criteria andCommentIdIsNull() {
            addCriterion("commentId is null");
            return (Criteria) this;
        }

        public Criteria andCommentIdIsNotNull() {
            addCriterion("commentId is not null");
            return (Criteria) this;
        }

        public Criteria andCommentIdEqualTo(Integer value) {
            addCriterion("commentId =", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotEqualTo(Integer value) {
            addCriterion("commentId <>", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThan(Integer value) {
            addCriterion("commentId >", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentId >=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThan(Integer value) {
            addCriterion("commentId <", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdLessThanOrEqualTo(Integer value) {
            addCriterion("commentId <=", value, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdIn(List<Integer> values) {
            addCriterion("commentId in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotIn(List<Integer> values) {
            addCriterion("commentId not in", values, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdBetween(Integer value1, Integer value2) {
            addCriterion("commentId between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andCommentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("commentId not between", value1, value2, "commentId");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentIsNull() {
            addCriterion("scenicId_FK_Comment is null");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentIsNotNull() {
            addCriterion("scenicId_FK_Comment is not null");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentEqualTo(Integer value) {
            addCriterion("scenicId_FK_Comment =", value, "scenicId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentNotEqualTo(Integer value) {
            addCriterion("scenicId_FK_Comment <>", value, "scenicId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentGreaterThan(Integer value) {
            addCriterion("scenicId_FK_Comment >", value, "scenicId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("scenicId_FK_Comment >=", value, "scenicId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentLessThan(Integer value) {
            addCriterion("scenicId_FK_Comment <", value, "scenicId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentLessThanOrEqualTo(Integer value) {
            addCriterion("scenicId_FK_Comment <=", value, "scenicId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentIn(List<Integer> values) {
            addCriterion("scenicId_FK_Comment in", values, "scenicId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentNotIn(List<Integer> values) {
            addCriterion("scenicId_FK_Comment not in", values, "scenicId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentBetween(Integer value1, Integer value2) {
            addCriterion("scenicId_FK_Comment between", value1, value2, "scenicId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andScenicId_FK_CommentNotBetween(Integer value1, Integer value2) {
            addCriterion("scenicId_FK_Comment not between", value1, value2, "scenicId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentIsNull() {
            addCriterion("hotelId_FK_Comment is null");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentIsNotNull() {
            addCriterion("hotelId_FK_Comment is not null");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentEqualTo(Integer value) {
            addCriterion("hotelId_FK_Comment =", value, "hotelId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentNotEqualTo(Integer value) {
            addCriterion("hotelId_FK_Comment <>", value, "hotelId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentGreaterThan(Integer value) {
            addCriterion("hotelId_FK_Comment >", value, "hotelId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotelId_FK_Comment >=", value, "hotelId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentLessThan(Integer value) {
            addCriterion("hotelId_FK_Comment <", value, "hotelId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentLessThanOrEqualTo(Integer value) {
            addCriterion("hotelId_FK_Comment <=", value, "hotelId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentIn(List<Integer> values) {
            addCriterion("hotelId_FK_Comment in", values, "hotelId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentNotIn(List<Integer> values) {
            addCriterion("hotelId_FK_Comment not in", values, "hotelId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentBetween(Integer value1, Integer value2) {
            addCriterion("hotelId_FK_Comment between", value1, value2, "hotelId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andHotelId_FK_CommentNotBetween(Integer value1, Integer value2) {
            addCriterion("hotelId_FK_Comment not between", value1, value2, "hotelId_FK_Comment");
            return (Criteria) this;
        }

        public Criteria andCommentDateIsNull() {
            addCriterion("commentDate is null");
            return (Criteria) this;
        }

        public Criteria andCommentDateIsNotNull() {
            addCriterion("commentDate is not null");
            return (Criteria) this;
        }

        public Criteria andCommentDateEqualTo(String value) {
            addCriterion("commentDate =", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotEqualTo(String value) {
            addCriterion("commentDate <>", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateGreaterThan(String value) {
            addCriterion("commentDate >", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateGreaterThanOrEqualTo(String value) {
            addCriterion("commentDate >=", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateLessThan(String value) {
            addCriterion("commentDate <", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateLessThanOrEqualTo(String value) {
            addCriterion("commentDate <=", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateLike(String value) {
            addCriterion("commentDate like", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotLike(String value) {
            addCriterion("commentDate not like", value, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateIn(List<String> values) {
            addCriterion("commentDate in", values, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotIn(List<String> values) {
            addCriterion("commentDate not in", values, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateBetween(String value1, String value2) {
            addCriterion("commentDate between", value1, value2, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentDateNotBetween(String value1, String value2) {
            addCriterion("commentDate not between", value1, value2, "commentDate");
            return (Criteria) this;
        }

        public Criteria andCommentTextIsNull() {
            addCriterion("commentText is null");
            return (Criteria) this;
        }

        public Criteria andCommentTextIsNotNull() {
            addCriterion("commentText is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTextEqualTo(String value) {
            addCriterion("commentText =", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextNotEqualTo(String value) {
            addCriterion("commentText <>", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextGreaterThan(String value) {
            addCriterion("commentText >", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextGreaterThanOrEqualTo(String value) {
            addCriterion("commentText >=", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextLessThan(String value) {
            addCriterion("commentText <", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextLessThanOrEqualTo(String value) {
            addCriterion("commentText <=", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextLike(String value) {
            addCriterion("commentText like", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextNotLike(String value) {
            addCriterion("commentText not like", value, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextIn(List<String> values) {
            addCriterion("commentText in", values, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextNotIn(List<String> values) {
            addCriterion("commentText not in", values, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextBetween(String value1, String value2) {
            addCriterion("commentText between", value1, value2, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentTextNotBetween(String value1, String value2) {
            addCriterion("commentText not between", value1, value2, "commentText");
            return (Criteria) this;
        }

        public Criteria andCommentStarIsNull() {
            addCriterion("commentStar is null");
            return (Criteria) this;
        }

        public Criteria andCommentStarIsNotNull() {
            addCriterion("commentStar is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStarEqualTo(Integer value) {
            addCriterion("commentStar =", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarNotEqualTo(Integer value) {
            addCriterion("commentStar <>", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarGreaterThan(Integer value) {
            addCriterion("commentStar >", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentStar >=", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarLessThan(Integer value) {
            addCriterion("commentStar <", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarLessThanOrEqualTo(Integer value) {
            addCriterion("commentStar <=", value, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarIn(List<Integer> values) {
            addCriterion("commentStar in", values, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarNotIn(List<Integer> values) {
            addCriterion("commentStar not in", values, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarBetween(Integer value1, Integer value2) {
            addCriterion("commentStar between", value1, value2, "commentStar");
            return (Criteria) this;
        }

        public Criteria andCommentStarNotBetween(Integer value1, Integer value2) {
            addCriterion("commentStar not between", value1, value2, "commentStar");
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