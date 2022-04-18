package com.sosam.hiking.model;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class MountainSpecification {
	public static Specification<Mountain> likeMntnname(String keyword) {
        return new Specification<Mountain>() {
            @Override
            public Predicate toPredicate(Root<Mountain> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 2) like
                return criteriaBuilder.like(root.get("mntnname"), "%" + keyword + "%");
            }
        };
    }

	public static Specification<Mountain> likeMntnaddr(String mntnaddr) {
        return new Specification<Mountain>() {
            @Override
            public Predicate toPredicate(Root<Mountain> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 2) like
                return criteriaBuilder.like(root.get("mntnaddr"), "%" + mntnaddr + "%");
            }
        };
    }
	
    public static Specification<Mountain> betweenMntnhighs(int mntnhigh1, int mntnhigh2) {
        return new Specification<Mountain>() {
            @Override
            public Predicate toPredicate(Root<Mountain> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 3) between
                return criteriaBuilder.between(root.get("mntnhigh"), mntnhigh1, mntnhigh2);
            }
        };
    }

    public static Specification<Mountain> greaterThanRoutes(int route1) {
        return new Specification<Mountain>() {
            @Override
            public Predicate toPredicate(Root<Mountain> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 3) between
                return criteriaBuilder.greaterThanOrEqualTo(root.get("routes"), route1);
            }
        };
    }
    
    public static Specification<Mountain> betweenRoutes(int route1, int route2) {
        return new Specification<Mountain>() {
            @Override
            public Predicate toPredicate(Root<Mountain> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                // 3) between
                return criteriaBuilder.between(root.get("routes"), route1, route2);
            }
        };
    }
}
