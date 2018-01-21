package lyons.common.model.goods;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GOrderExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    public GOrderExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andGOrderIdIsNull() {
            addCriterion("G_ORDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andGOrderIdIsNotNull() {
            addCriterion("G_ORDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGOrderIdEqualTo(Integer value) {
            addCriterion("G_ORDER_ID =", value, "gOrderId");
            return (Criteria) this;
        }

        public Criteria andGOrderIdNotEqualTo(Integer value) {
            addCriterion("G_ORDER_ID <>", value, "gOrderId");
            return (Criteria) this;
        }

        public Criteria andGOrderIdGreaterThan(Integer value) {
            addCriterion("G_ORDER_ID >", value, "gOrderId");
            return (Criteria) this;
        }

        public Criteria andGOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("G_ORDER_ID >=", value, "gOrderId");
            return (Criteria) this;
        }

        public Criteria andGOrderIdLessThan(Integer value) {
            addCriterion("G_ORDER_ID <", value, "gOrderId");
            return (Criteria) this;
        }

        public Criteria andGOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("G_ORDER_ID <=", value, "gOrderId");
            return (Criteria) this;
        }

        public Criteria andGOrderIdIn(List<Integer> values) {
            addCriterion("G_ORDER_ID in", values, "gOrderId");
            return (Criteria) this;
        }

        public Criteria andGOrderIdNotIn(List<Integer> values) {
            addCriterion("G_ORDER_ID not in", values, "gOrderId");
            return (Criteria) this;
        }

        public Criteria andGOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("G_ORDER_ID between", value1, value2, "gOrderId");
            return (Criteria) this;
        }

        public Criteria andGOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("G_ORDER_ID not between", value1, value2, "gOrderId");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameIsNull() {
            addCriterion("G_ORDER_U_NAME is null");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameIsNotNull() {
            addCriterion("G_ORDER_U_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameEqualTo(String value) {
            addCriterion("G_ORDER_U_NAME =", value, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameNotEqualTo(String value) {
            addCriterion("G_ORDER_U_NAME <>", value, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameGreaterThan(String value) {
            addCriterion("G_ORDER_U_NAME >", value, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameGreaterThanOrEqualTo(String value) {
            addCriterion("G_ORDER_U_NAME >=", value, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameLessThan(String value) {
            addCriterion("G_ORDER_U_NAME <", value, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameLessThanOrEqualTo(String value) {
            addCriterion("G_ORDER_U_NAME <=", value, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameLike(String value) {
            addCriterion("G_ORDER_U_NAME like", value, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameNotLike(String value) {
            addCriterion("G_ORDER_U_NAME not like", value, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameIn(List<String> values) {
            addCriterion("G_ORDER_U_NAME in", values, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameNotIn(List<String> values) {
            addCriterion("G_ORDER_U_NAME not in", values, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameBetween(String value1, String value2) {
            addCriterion("G_ORDER_U_NAME between", value1, value2, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderUNameNotBetween(String value1, String value2) {
            addCriterion("G_ORDER_U_NAME not between", value1, value2, "gOrderUName");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdIsNull() {
            addCriterion("G_ORDER_G_ID is null");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdIsNotNull() {
            addCriterion("G_ORDER_G_ID is not null");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdEqualTo(Integer value) {
            addCriterion("G_ORDER_G_ID =", value, "gOrderGId");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdNotEqualTo(Integer value) {
            addCriterion("G_ORDER_G_ID <>", value, "gOrderGId");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdGreaterThan(Integer value) {
            addCriterion("G_ORDER_G_ID >", value, "gOrderGId");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("G_ORDER_G_ID >=", value, "gOrderGId");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdLessThan(Integer value) {
            addCriterion("G_ORDER_G_ID <", value, "gOrderGId");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdLessThanOrEqualTo(Integer value) {
            addCriterion("G_ORDER_G_ID <=", value, "gOrderGId");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdIn(List<Integer> values) {
            addCriterion("G_ORDER_G_ID in", values, "gOrderGId");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdNotIn(List<Integer> values) {
            addCriterion("G_ORDER_G_ID not in", values, "gOrderGId");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdBetween(Integer value1, Integer value2) {
            addCriterion("G_ORDER_G_ID between", value1, value2, "gOrderGId");
            return (Criteria) this;
        }

        public Criteria andGOrderGIdNotBetween(Integer value1, Integer value2) {
            addCriterion("G_ORDER_G_ID not between", value1, value2, "gOrderGId");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceIsNull() {
            addCriterion("G_ORDER_PRICE is null");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceIsNotNull() {
            addCriterion("G_ORDER_PRICE is not null");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceEqualTo(BigDecimal value) {
            addCriterion("G_ORDER_PRICE =", value, "gOrderPrice");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceNotEqualTo(BigDecimal value) {
            addCriterion("G_ORDER_PRICE <>", value, "gOrderPrice");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceGreaterThan(BigDecimal value) {
            addCriterion("G_ORDER_PRICE >", value, "gOrderPrice");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("G_ORDER_PRICE >=", value, "gOrderPrice");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceLessThan(BigDecimal value) {
            addCriterion("G_ORDER_PRICE <", value, "gOrderPrice");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("G_ORDER_PRICE <=", value, "gOrderPrice");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceIn(List<BigDecimal> values) {
            addCriterion("G_ORDER_PRICE in", values, "gOrderPrice");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceNotIn(List<BigDecimal> values) {
            addCriterion("G_ORDER_PRICE not in", values, "gOrderPrice");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("G_ORDER_PRICE between", value1, value2, "gOrderPrice");
            return (Criteria) this;
        }

        public Criteria andGOrderPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("G_ORDER_PRICE not between", value1, value2, "gOrderPrice");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberIsNull() {
            addCriterion("G_ORDER_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberIsNotNull() {
            addCriterion("G_ORDER_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberEqualTo(Integer value) {
            addCriterion("G_ORDER_NUMBER =", value, "gOrderNumber");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberNotEqualTo(Integer value) {
            addCriterion("G_ORDER_NUMBER <>", value, "gOrderNumber");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberGreaterThan(Integer value) {
            addCriterion("G_ORDER_NUMBER >", value, "gOrderNumber");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("G_ORDER_NUMBER >=", value, "gOrderNumber");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberLessThan(Integer value) {
            addCriterion("G_ORDER_NUMBER <", value, "gOrderNumber");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberLessThanOrEqualTo(Integer value) {
            addCriterion("G_ORDER_NUMBER <=", value, "gOrderNumber");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberIn(List<Integer> values) {
            addCriterion("G_ORDER_NUMBER in", values, "gOrderNumber");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberNotIn(List<Integer> values) {
            addCriterion("G_ORDER_NUMBER not in", values, "gOrderNumber");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberBetween(Integer value1, Integer value2) {
            addCriterion("G_ORDER_NUMBER between", value1, value2, "gOrderNumber");
            return (Criteria) this;
        }

        public Criteria andGOrderNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("G_ORDER_NUMBER not between", value1, value2, "gOrderNumber");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateIsNull() {
            addCriterion("G_ORDER_CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateIsNotNull() {
            addCriterion("G_ORDER_CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateEqualTo(Date value) {
            addCriterion("G_ORDER_CREATE_DATE =", value, "gOrderCreateDate");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateNotEqualTo(Date value) {
            addCriterion("G_ORDER_CREATE_DATE <>", value, "gOrderCreateDate");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateGreaterThan(Date value) {
            addCriterion("G_ORDER_CREATE_DATE >", value, "gOrderCreateDate");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("G_ORDER_CREATE_DATE >=", value, "gOrderCreateDate");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateLessThan(Date value) {
            addCriterion("G_ORDER_CREATE_DATE <", value, "gOrderCreateDate");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("G_ORDER_CREATE_DATE <=", value, "gOrderCreateDate");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateIn(List<Date> values) {
            addCriterion("G_ORDER_CREATE_DATE in", values, "gOrderCreateDate");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateNotIn(List<Date> values) {
            addCriterion("G_ORDER_CREATE_DATE not in", values, "gOrderCreateDate");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateBetween(Date value1, Date value2) {
            addCriterion("G_ORDER_CREATE_DATE between", value1, value2, "gOrderCreateDate");
            return (Criteria) this;
        }

        public Criteria andGOrderCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("G_ORDER_CREATE_DATE not between", value1, value2, "gOrderCreateDate");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneIsNull() {
            addCriterion("G_ORDER_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneIsNotNull() {
            addCriterion("G_ORDER_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneEqualTo(String value) {
            addCriterion("G_ORDER_PHONE =", value, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneNotEqualTo(String value) {
            addCriterion("G_ORDER_PHONE <>", value, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneGreaterThan(String value) {
            addCriterion("G_ORDER_PHONE >", value, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("G_ORDER_PHONE >=", value, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneLessThan(String value) {
            addCriterion("G_ORDER_PHONE <", value, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneLessThanOrEqualTo(String value) {
            addCriterion("G_ORDER_PHONE <=", value, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneLike(String value) {
            addCriterion("G_ORDER_PHONE like", value, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneNotLike(String value) {
            addCriterion("G_ORDER_PHONE not like", value, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneIn(List<String> values) {
            addCriterion("G_ORDER_PHONE in", values, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneNotIn(List<String> values) {
            addCriterion("G_ORDER_PHONE not in", values, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneBetween(String value1, String value2) {
            addCriterion("G_ORDER_PHONE between", value1, value2, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderPhoneNotBetween(String value1, String value2) {
            addCriterion("G_ORDER_PHONE not between", value1, value2, "gOrderPhone");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressIsNull() {
            addCriterion("G_ORDER_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressIsNotNull() {
            addCriterion("G_ORDER_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressEqualTo(String value) {
            addCriterion("G_ORDER_ADDRESS =", value, "gOrderAddress");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressNotEqualTo(String value) {
            addCriterion("G_ORDER_ADDRESS <>", value, "gOrderAddress");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressGreaterThan(String value) {
            addCriterion("G_ORDER_ADDRESS >", value, "gOrderAddress");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressGreaterThanOrEqualTo(String value) {
            addCriterion("G_ORDER_ADDRESS >=", value, "gOrderAddress");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressLessThan(String value) {
            addCriterion("G_ORDER_ADDRESS <", value, "gOrderAddress");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressLessThanOrEqualTo(String value) {
            addCriterion("G_ORDER_ADDRESS <=", value, "gOrderAddress");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressLike(String value) {
            addCriterion("G_ORDER_ADDRESS like", value, "gOrderAddress");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressNotLike(String value) {
            addCriterion("G_ORDER_ADDRESS not like", value, "gOrderAddress");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressIn(List<String> values) {
            addCriterion("G_ORDER_ADDRESS in", values, "gOrderAddress");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressNotIn(List<String> values) {
            addCriterion("G_ORDER_ADDRESS not in", values, "gOrderAddress");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressBetween(String value1, String value2) {
            addCriterion("G_ORDER_ADDRESS between", value1, value2, "gOrderAddress");
            return (Criteria) this;
        }

        public Criteria andGOrderAddressNotBetween(String value1, String value2) {
            addCriterion("G_ORDER_ADDRESS not between", value1, value2, "gOrderAddress");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table G_ORDER
     *
     * @mbg.generated do_not_delete_during_merge Sun Feb 12 16:52:20 CST 2017
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table G_ORDER
     *
     * @mbg.generated Sun Feb 12 16:52:20 CST 2017
     */
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
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
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