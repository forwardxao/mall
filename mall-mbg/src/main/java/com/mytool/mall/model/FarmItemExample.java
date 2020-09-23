package com.mytool.mall.model;

import java.util.ArrayList;
import java.util.List;

public class FarmItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FarmItemExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFarmNameIsNull() {
            addCriterion("farm_name is null");
            return (Criteria) this;
        }

        public Criteria andFarmNameIsNotNull() {
            addCriterion("farm_name is not null");
            return (Criteria) this;
        }

        public Criteria andFarmNameEqualTo(String value) {
            addCriterion("farm_name =", value, "farmName");
            return (Criteria) this;
        }

        public Criteria andFarmNameNotEqualTo(String value) {
            addCriterion("farm_name <>", value, "farmName");
            return (Criteria) this;
        }

        public Criteria andFarmNameGreaterThan(String value) {
            addCriterion("farm_name >", value, "farmName");
            return (Criteria) this;
        }

        public Criteria andFarmNameGreaterThanOrEqualTo(String value) {
            addCriterion("farm_name >=", value, "farmName");
            return (Criteria) this;
        }

        public Criteria andFarmNameLessThan(String value) {
            addCriterion("farm_name <", value, "farmName");
            return (Criteria) this;
        }

        public Criteria andFarmNameLessThanOrEqualTo(String value) {
            addCriterion("farm_name <=", value, "farmName");
            return (Criteria) this;
        }

        public Criteria andFarmNameLike(String value) {
            addCriterion("farm_name like", value, "farmName");
            return (Criteria) this;
        }

        public Criteria andFarmNameNotLike(String value) {
            addCriterion("farm_name not like", value, "farmName");
            return (Criteria) this;
        }

        public Criteria andFarmNameIn(List<String> values) {
            addCriterion("farm_name in", values, "farmName");
            return (Criteria) this;
        }

        public Criteria andFarmNameNotIn(List<String> values) {
            addCriterion("farm_name not in", values, "farmName");
            return (Criteria) this;
        }

        public Criteria andFarmNameBetween(String value1, String value2) {
            addCriterion("farm_name between", value1, value2, "farmName");
            return (Criteria) this;
        }

        public Criteria andFarmNameNotBetween(String value1, String value2) {
            addCriterion("farm_name not between", value1, value2, "farmName");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageTitleIsNull() {
            addCriterion("image_title is null");
            return (Criteria) this;
        }

        public Criteria andImageTitleIsNotNull() {
            addCriterion("image_title is not null");
            return (Criteria) this;
        }

        public Criteria andImageTitleEqualTo(String value) {
            addCriterion("image_title =", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleNotEqualTo(String value) {
            addCriterion("image_title <>", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleGreaterThan(String value) {
            addCriterion("image_title >", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleGreaterThanOrEqualTo(String value) {
            addCriterion("image_title >=", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleLessThan(String value) {
            addCriterion("image_title <", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleLessThanOrEqualTo(String value) {
            addCriterion("image_title <=", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleLike(String value) {
            addCriterion("image_title like", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleNotLike(String value) {
            addCriterion("image_title not like", value, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleIn(List<String> values) {
            addCriterion("image_title in", values, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleNotIn(List<String> values) {
            addCriterion("image_title not in", values, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleBetween(String value1, String value2) {
            addCriterion("image_title between", value1, value2, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImageTitleNotBetween(String value1, String value2) {
            addCriterion("image_title not between", value1, value2, "imageTitle");
            return (Criteria) this;
        }

        public Criteria andImage2IsNull() {
            addCriterion("image2 is null");
            return (Criteria) this;
        }

        public Criteria andImage2IsNotNull() {
            addCriterion("image2 is not null");
            return (Criteria) this;
        }

        public Criteria andImage2EqualTo(String value) {
            addCriterion("image2 =", value, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2NotEqualTo(String value) {
            addCriterion("image2 <>", value, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2GreaterThan(String value) {
            addCriterion("image2 >", value, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2GreaterThanOrEqualTo(String value) {
            addCriterion("image2 >=", value, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2LessThan(String value) {
            addCriterion("image2 <", value, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2LessThanOrEqualTo(String value) {
            addCriterion("image2 <=", value, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2Like(String value) {
            addCriterion("image2 like", value, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2NotLike(String value) {
            addCriterion("image2 not like", value, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2In(List<String> values) {
            addCriterion("image2 in", values, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2NotIn(List<String> values) {
            addCriterion("image2 not in", values, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2Between(String value1, String value2) {
            addCriterion("image2 between", value1, value2, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2NotBetween(String value1, String value2) {
            addCriterion("image2 not between", value1, value2, "image2");
            return (Criteria) this;
        }

        public Criteria andImage2TitleIsNull() {
            addCriterion("image2_title is null");
            return (Criteria) this;
        }

        public Criteria andImage2TitleIsNotNull() {
            addCriterion("image2_title is not null");
            return (Criteria) this;
        }

        public Criteria andImage2TitleEqualTo(String value) {
            addCriterion("image2_title =", value, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage2TitleNotEqualTo(String value) {
            addCriterion("image2_title <>", value, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage2TitleGreaterThan(String value) {
            addCriterion("image2_title >", value, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage2TitleGreaterThanOrEqualTo(String value) {
            addCriterion("image2_title >=", value, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage2TitleLessThan(String value) {
            addCriterion("image2_title <", value, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage2TitleLessThanOrEqualTo(String value) {
            addCriterion("image2_title <=", value, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage2TitleLike(String value) {
            addCriterion("image2_title like", value, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage2TitleNotLike(String value) {
            addCriterion("image2_title not like", value, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage2TitleIn(List<String> values) {
            addCriterion("image2_title in", values, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage2TitleNotIn(List<String> values) {
            addCriterion("image2_title not in", values, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage2TitleBetween(String value1, String value2) {
            addCriterion("image2_title between", value1, value2, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage2TitleNotBetween(String value1, String value2) {
            addCriterion("image2_title not between", value1, value2, "image2Title");
            return (Criteria) this;
        }

        public Criteria andImage3IsNull() {
            addCriterion("image3 is null");
            return (Criteria) this;
        }

        public Criteria andImage3IsNotNull() {
            addCriterion("image3 is not null");
            return (Criteria) this;
        }

        public Criteria andImage3EqualTo(String value) {
            addCriterion("image3 =", value, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3NotEqualTo(String value) {
            addCriterion("image3 <>", value, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3GreaterThan(String value) {
            addCriterion("image3 >", value, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3GreaterThanOrEqualTo(String value) {
            addCriterion("image3 >=", value, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3LessThan(String value) {
            addCriterion("image3 <", value, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3LessThanOrEqualTo(String value) {
            addCriterion("image3 <=", value, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3Like(String value) {
            addCriterion("image3 like", value, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3NotLike(String value) {
            addCriterion("image3 not like", value, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3In(List<String> values) {
            addCriterion("image3 in", values, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3NotIn(List<String> values) {
            addCriterion("image3 not in", values, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3Between(String value1, String value2) {
            addCriterion("image3 between", value1, value2, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3NotBetween(String value1, String value2) {
            addCriterion("image3 not between", value1, value2, "image3");
            return (Criteria) this;
        }

        public Criteria andImage3TitleIsNull() {
            addCriterion("image3_title is null");
            return (Criteria) this;
        }

        public Criteria andImage3TitleIsNotNull() {
            addCriterion("image3_title is not null");
            return (Criteria) this;
        }

        public Criteria andImage3TitleEqualTo(String value) {
            addCriterion("image3_title =", value, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage3TitleNotEqualTo(String value) {
            addCriterion("image3_title <>", value, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage3TitleGreaterThan(String value) {
            addCriterion("image3_title >", value, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage3TitleGreaterThanOrEqualTo(String value) {
            addCriterion("image3_title >=", value, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage3TitleLessThan(String value) {
            addCriterion("image3_title <", value, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage3TitleLessThanOrEqualTo(String value) {
            addCriterion("image3_title <=", value, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage3TitleLike(String value) {
            addCriterion("image3_title like", value, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage3TitleNotLike(String value) {
            addCriterion("image3_title not like", value, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage3TitleIn(List<String> values) {
            addCriterion("image3_title in", values, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage3TitleNotIn(List<String> values) {
            addCriterion("image3_title not in", values, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage3TitleBetween(String value1, String value2) {
            addCriterion("image3_title between", value1, value2, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage3TitleNotBetween(String value1, String value2) {
            addCriterion("image3_title not between", value1, value2, "image3Title");
            return (Criteria) this;
        }

        public Criteria andImage4IsNull() {
            addCriterion("image4 is null");
            return (Criteria) this;
        }

        public Criteria andImage4IsNotNull() {
            addCriterion("image4 is not null");
            return (Criteria) this;
        }

        public Criteria andImage4EqualTo(String value) {
            addCriterion("image4 =", value, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4NotEqualTo(String value) {
            addCriterion("image4 <>", value, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4GreaterThan(String value) {
            addCriterion("image4 >", value, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4GreaterThanOrEqualTo(String value) {
            addCriterion("image4 >=", value, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4LessThan(String value) {
            addCriterion("image4 <", value, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4LessThanOrEqualTo(String value) {
            addCriterion("image4 <=", value, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4Like(String value) {
            addCriterion("image4 like", value, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4NotLike(String value) {
            addCriterion("image4 not like", value, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4In(List<String> values) {
            addCriterion("image4 in", values, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4NotIn(List<String> values) {
            addCriterion("image4 not in", values, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4Between(String value1, String value2) {
            addCriterion("image4 between", value1, value2, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4NotBetween(String value1, String value2) {
            addCriterion("image4 not between", value1, value2, "image4");
            return (Criteria) this;
        }

        public Criteria andImage4TitleIsNull() {
            addCriterion("image4_title is null");
            return (Criteria) this;
        }

        public Criteria andImage4TitleIsNotNull() {
            addCriterion("image4_title is not null");
            return (Criteria) this;
        }

        public Criteria andImage4TitleEqualTo(String value) {
            addCriterion("image4_title =", value, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage4TitleNotEqualTo(String value) {
            addCriterion("image4_title <>", value, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage4TitleGreaterThan(String value) {
            addCriterion("image4_title >", value, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage4TitleGreaterThanOrEqualTo(String value) {
            addCriterion("image4_title >=", value, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage4TitleLessThan(String value) {
            addCriterion("image4_title <", value, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage4TitleLessThanOrEqualTo(String value) {
            addCriterion("image4_title <=", value, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage4TitleLike(String value) {
            addCriterion("image4_title like", value, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage4TitleNotLike(String value) {
            addCriterion("image4_title not like", value, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage4TitleIn(List<String> values) {
            addCriterion("image4_title in", values, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage4TitleNotIn(List<String> values) {
            addCriterion("image4_title not in", values, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage4TitleBetween(String value1, String value2) {
            addCriterion("image4_title between", value1, value2, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage4TitleNotBetween(String value1, String value2) {
            addCriterion("image4_title not between", value1, value2, "image4Title");
            return (Criteria) this;
        }

        public Criteria andImage5IsNull() {
            addCriterion("image5 is null");
            return (Criteria) this;
        }

        public Criteria andImage5IsNotNull() {
            addCriterion("image5 is not null");
            return (Criteria) this;
        }

        public Criteria andImage5EqualTo(String value) {
            addCriterion("image5 =", value, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5NotEqualTo(String value) {
            addCriterion("image5 <>", value, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5GreaterThan(String value) {
            addCriterion("image5 >", value, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5GreaterThanOrEqualTo(String value) {
            addCriterion("image5 >=", value, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5LessThan(String value) {
            addCriterion("image5 <", value, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5LessThanOrEqualTo(String value) {
            addCriterion("image5 <=", value, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5Like(String value) {
            addCriterion("image5 like", value, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5NotLike(String value) {
            addCriterion("image5 not like", value, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5In(List<String> values) {
            addCriterion("image5 in", values, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5NotIn(List<String> values) {
            addCriterion("image5 not in", values, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5Between(String value1, String value2) {
            addCriterion("image5 between", value1, value2, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5NotBetween(String value1, String value2) {
            addCriterion("image5 not between", value1, value2, "image5");
            return (Criteria) this;
        }

        public Criteria andImage5TitleIsNull() {
            addCriterion("image5_title is null");
            return (Criteria) this;
        }

        public Criteria andImage5TitleIsNotNull() {
            addCriterion("image5_title is not null");
            return (Criteria) this;
        }

        public Criteria andImage5TitleEqualTo(String value) {
            addCriterion("image5_title =", value, "image5Title");
            return (Criteria) this;
        }

        public Criteria andImage5TitleNotEqualTo(String value) {
            addCriterion("image5_title <>", value, "image5Title");
            return (Criteria) this;
        }

        public Criteria andImage5TitleGreaterThan(String value) {
            addCriterion("image5_title >", value, "image5Title");
            return (Criteria) this;
        }

        public Criteria andImage5TitleGreaterThanOrEqualTo(String value) {
            addCriterion("image5_title >=", value, "image5Title");
            return (Criteria) this;
        }

        public Criteria andImage5TitleLessThan(String value) {
            addCriterion("image5_title <", value, "image5Title");
            return (Criteria) this;
        }

        public Criteria andImage5TitleLessThanOrEqualTo(String value) {
            addCriterion("image5_title <=", value, "image5Title");
            return (Criteria) this;
        }

        public Criteria andImage5TitleLike(String value) {
            addCriterion("image5_title like", value, "image5Title");
            return (Criteria) this;
        }

        public Criteria andImage5TitleNotLike(String value) {
            addCriterion("image5_title not like", value, "image5Title");
            return (Criteria) this;
        }

        public Criteria andImage5TitleIn(List<String> values) {
            addCriterion("image5_title in", values, "image5Title");
            return (Criteria) this;
        }

        public Criteria andImage5TitleNotIn(List<String> values) {
            addCriterion("image5_title not in", values, "image5Title");
            return (Criteria) this;
        }

        public Criteria andImage5TitleBetween(String value1, String value2) {
            addCriterion("image5_title between", value1, value2, "image5Title");
            return (Criteria) this;
        }

        public Criteria andImage5TitleNotBetween(String value1, String value2) {
            addCriterion("image5_title not between", value1, value2, "image5Title");
            return (Criteria) this;
        }

        public Criteria andVideoIsNull() {
            addCriterion("video is null");
            return (Criteria) this;
        }

        public Criteria andVideoIsNotNull() {
            addCriterion("video is not null");
            return (Criteria) this;
        }

        public Criteria andVideoEqualTo(String value) {
            addCriterion("video =", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotEqualTo(String value) {
            addCriterion("video <>", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoGreaterThan(String value) {
            addCriterion("video >", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoGreaterThanOrEqualTo(String value) {
            addCriterion("video >=", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoLessThan(String value) {
            addCriterion("video <", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoLessThanOrEqualTo(String value) {
            addCriterion("video <=", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoLike(String value) {
            addCriterion("video like", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotLike(String value) {
            addCriterion("video not like", value, "video");
            return (Criteria) this;
        }

        public Criteria andVideoIn(List<String> values) {
            addCriterion("video in", values, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotIn(List<String> values) {
            addCriterion("video not in", values, "video");
            return (Criteria) this;
        }

        public Criteria andVideoBetween(String value1, String value2) {
            addCriterion("video between", value1, value2, "video");
            return (Criteria) this;
        }

        public Criteria andVideoNotBetween(String value1, String value2) {
            addCriterion("video not between", value1, value2, "video");
            return (Criteria) this;
        }

        public Criteria andVideoTitleIsNull() {
            addCriterion("video_title is null");
            return (Criteria) this;
        }

        public Criteria andVideoTitleIsNotNull() {
            addCriterion("video_title is not null");
            return (Criteria) this;
        }

        public Criteria andVideoTitleEqualTo(String value) {
            addCriterion("video_title =", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotEqualTo(String value) {
            addCriterion("video_title <>", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleGreaterThan(String value) {
            addCriterion("video_title >", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("video_title >=", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleLessThan(String value) {
            addCriterion("video_title <", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleLessThanOrEqualTo(String value) {
            addCriterion("video_title <=", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleLike(String value) {
            addCriterion("video_title like", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotLike(String value) {
            addCriterion("video_title not like", value, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleIn(List<String> values) {
            addCriterion("video_title in", values, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotIn(List<String> values) {
            addCriterion("video_title not in", values, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleBetween(String value1, String value2) {
            addCriterion("video_title between", value1, value2, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideoTitleNotBetween(String value1, String value2) {
            addCriterion("video_title not between", value1, value2, "videoTitle");
            return (Criteria) this;
        }

        public Criteria andVideo2IsNull() {
            addCriterion("video2 is null");
            return (Criteria) this;
        }

        public Criteria andVideo2IsNotNull() {
            addCriterion("video2 is not null");
            return (Criteria) this;
        }

        public Criteria andVideo2EqualTo(String value) {
            addCriterion("video2 =", value, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2NotEqualTo(String value) {
            addCriterion("video2 <>", value, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2GreaterThan(String value) {
            addCriterion("video2 >", value, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2GreaterThanOrEqualTo(String value) {
            addCriterion("video2 >=", value, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2LessThan(String value) {
            addCriterion("video2 <", value, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2LessThanOrEqualTo(String value) {
            addCriterion("video2 <=", value, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2Like(String value) {
            addCriterion("video2 like", value, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2NotLike(String value) {
            addCriterion("video2 not like", value, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2In(List<String> values) {
            addCriterion("video2 in", values, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2NotIn(List<String> values) {
            addCriterion("video2 not in", values, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2Between(String value1, String value2) {
            addCriterion("video2 between", value1, value2, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2NotBetween(String value1, String value2) {
            addCriterion("video2 not between", value1, value2, "video2");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleIsNull() {
            addCriterion("video2_title is null");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleIsNotNull() {
            addCriterion("video2_title is not null");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleEqualTo(String value) {
            addCriterion("video2_title =", value, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleNotEqualTo(String value) {
            addCriterion("video2_title <>", value, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleGreaterThan(String value) {
            addCriterion("video2_title >", value, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleGreaterThanOrEqualTo(String value) {
            addCriterion("video2_title >=", value, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleLessThan(String value) {
            addCriterion("video2_title <", value, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleLessThanOrEqualTo(String value) {
            addCriterion("video2_title <=", value, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleLike(String value) {
            addCriterion("video2_title like", value, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleNotLike(String value) {
            addCriterion("video2_title not like", value, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleIn(List<String> values) {
            addCriterion("video2_title in", values, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleNotIn(List<String> values) {
            addCriterion("video2_title not in", values, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleBetween(String value1, String value2) {
            addCriterion("video2_title between", value1, value2, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo2TitleNotBetween(String value1, String value2) {
            addCriterion("video2_title not between", value1, value2, "video2Title");
            return (Criteria) this;
        }

        public Criteria andVideo3IsNull() {
            addCriterion("video3 is null");
            return (Criteria) this;
        }

        public Criteria andVideo3IsNotNull() {
            addCriterion("video3 is not null");
            return (Criteria) this;
        }

        public Criteria andVideo3EqualTo(String value) {
            addCriterion("video3 =", value, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3NotEqualTo(String value) {
            addCriterion("video3 <>", value, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3GreaterThan(String value) {
            addCriterion("video3 >", value, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3GreaterThanOrEqualTo(String value) {
            addCriterion("video3 >=", value, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3LessThan(String value) {
            addCriterion("video3 <", value, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3LessThanOrEqualTo(String value) {
            addCriterion("video3 <=", value, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3Like(String value) {
            addCriterion("video3 like", value, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3NotLike(String value) {
            addCriterion("video3 not like", value, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3In(List<String> values) {
            addCriterion("video3 in", values, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3NotIn(List<String> values) {
            addCriterion("video3 not in", values, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3Between(String value1, String value2) {
            addCriterion("video3 between", value1, value2, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3NotBetween(String value1, String value2) {
            addCriterion("video3 not between", value1, value2, "video3");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleIsNull() {
            addCriterion("video3_title is null");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleIsNotNull() {
            addCriterion("video3_title is not null");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleEqualTo(String value) {
            addCriterion("video3_title =", value, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleNotEqualTo(String value) {
            addCriterion("video3_title <>", value, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleGreaterThan(String value) {
            addCriterion("video3_title >", value, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleGreaterThanOrEqualTo(String value) {
            addCriterion("video3_title >=", value, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleLessThan(String value) {
            addCriterion("video3_title <", value, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleLessThanOrEqualTo(String value) {
            addCriterion("video3_title <=", value, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleLike(String value) {
            addCriterion("video3_title like", value, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleNotLike(String value) {
            addCriterion("video3_title not like", value, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleIn(List<String> values) {
            addCriterion("video3_title in", values, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleNotIn(List<String> values) {
            addCriterion("video3_title not in", values, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleBetween(String value1, String value2) {
            addCriterion("video3_title between", value1, value2, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo3TitleNotBetween(String value1, String value2) {
            addCriterion("video3_title not between", value1, value2, "video3Title");
            return (Criteria) this;
        }

        public Criteria andVideo4IsNull() {
            addCriterion("video4 is null");
            return (Criteria) this;
        }

        public Criteria andVideo4IsNotNull() {
            addCriterion("video4 is not null");
            return (Criteria) this;
        }

        public Criteria andVideo4EqualTo(String value) {
            addCriterion("video4 =", value, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4NotEqualTo(String value) {
            addCriterion("video4 <>", value, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4GreaterThan(String value) {
            addCriterion("video4 >", value, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4GreaterThanOrEqualTo(String value) {
            addCriterion("video4 >=", value, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4LessThan(String value) {
            addCriterion("video4 <", value, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4LessThanOrEqualTo(String value) {
            addCriterion("video4 <=", value, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4Like(String value) {
            addCriterion("video4 like", value, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4NotLike(String value) {
            addCriterion("video4 not like", value, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4In(List<String> values) {
            addCriterion("video4 in", values, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4NotIn(List<String> values) {
            addCriterion("video4 not in", values, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4Between(String value1, String value2) {
            addCriterion("video4 between", value1, value2, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4NotBetween(String value1, String value2) {
            addCriterion("video4 not between", value1, value2, "video4");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleIsNull() {
            addCriterion("video4_title is null");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleIsNotNull() {
            addCriterion("video4_title is not null");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleEqualTo(String value) {
            addCriterion("video4_title =", value, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleNotEqualTo(String value) {
            addCriterion("video4_title <>", value, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleGreaterThan(String value) {
            addCriterion("video4_title >", value, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleGreaterThanOrEqualTo(String value) {
            addCriterion("video4_title >=", value, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleLessThan(String value) {
            addCriterion("video4_title <", value, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleLessThanOrEqualTo(String value) {
            addCriterion("video4_title <=", value, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleLike(String value) {
            addCriterion("video4_title like", value, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleNotLike(String value) {
            addCriterion("video4_title not like", value, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleIn(List<String> values) {
            addCriterion("video4_title in", values, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleNotIn(List<String> values) {
            addCriterion("video4_title not in", values, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleBetween(String value1, String value2) {
            addCriterion("video4_title between", value1, value2, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo4TitleNotBetween(String value1, String value2) {
            addCriterion("video4_title not between", value1, value2, "video4Title");
            return (Criteria) this;
        }

        public Criteria andVideo5IsNull() {
            addCriterion("video5 is null");
            return (Criteria) this;
        }

        public Criteria andVideo5IsNotNull() {
            addCriterion("video5 is not null");
            return (Criteria) this;
        }

        public Criteria andVideo5EqualTo(String value) {
            addCriterion("video5 =", value, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5NotEqualTo(String value) {
            addCriterion("video5 <>", value, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5GreaterThan(String value) {
            addCriterion("video5 >", value, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5GreaterThanOrEqualTo(String value) {
            addCriterion("video5 >=", value, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5LessThan(String value) {
            addCriterion("video5 <", value, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5LessThanOrEqualTo(String value) {
            addCriterion("video5 <=", value, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5Like(String value) {
            addCriterion("video5 like", value, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5NotLike(String value) {
            addCriterion("video5 not like", value, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5In(List<String> values) {
            addCriterion("video5 in", values, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5NotIn(List<String> values) {
            addCriterion("video5 not in", values, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5Between(String value1, String value2) {
            addCriterion("video5 between", value1, value2, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5NotBetween(String value1, String value2) {
            addCriterion("video5 not between", value1, value2, "video5");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleIsNull() {
            addCriterion("video5_title is null");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleIsNotNull() {
            addCriterion("video5_title is not null");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleEqualTo(String value) {
            addCriterion("video5_title =", value, "video5Title");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleNotEqualTo(String value) {
            addCriterion("video5_title <>", value, "video5Title");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleGreaterThan(String value) {
            addCriterion("video5_title >", value, "video5Title");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleGreaterThanOrEqualTo(String value) {
            addCriterion("video5_title >=", value, "video5Title");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleLessThan(String value) {
            addCriterion("video5_title <", value, "video5Title");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleLessThanOrEqualTo(String value) {
            addCriterion("video5_title <=", value, "video5Title");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleLike(String value) {
            addCriterion("video5_title like", value, "video5Title");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleNotLike(String value) {
            addCriterion("video5_title not like", value, "video5Title");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleIn(List<String> values) {
            addCriterion("video5_title in", values, "video5Title");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleNotIn(List<String> values) {
            addCriterion("video5_title not in", values, "video5Title");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleBetween(String value1, String value2) {
            addCriterion("video5_title between", value1, value2, "video5Title");
            return (Criteria) this;
        }

        public Criteria andVideo5TitleNotBetween(String value1, String value2) {
            addCriterion("video5_title not between", value1, value2, "video5Title");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
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