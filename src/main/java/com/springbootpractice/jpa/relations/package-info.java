/**
 * This package contains implementation of JPA relationship.
 * <b>Hibernate supports four main types of relationships:</b>
 * <p>
 *     <b>1. One-to-One (@OneToOne)</b> <p>Used when an entity is associated with exactly one instance of another entity.</p>
 *     <b>2. One-to-Many (@OneToMany)</b> <p>Used when an entity is associated with exactly one instance of another entity.</p>
 *     <b>3. Many-to-One (@ManyToOne)</b> <p>Many entities are associated with one entity (inverse of One-to-Many)</p>
 *     <b>4. Many-to-Many (@ManyToMany)</b> <p>Entities have multiple associations on both sides.</p>
 * </p>
 *
 */
package com.springbootpractice.jpa.relations;

/*
-- One-to-One (@OneToOne)
Used when an entity is associated with exactly one instance of another entity.
Example: A User has one PANDetails or UserAccount.

--One-to-Many (@OneToMany)
One entity is related to multiple entities.
Example: A Department has multiple Employees.

--Many-to-One (@ManyToOne)
Many entities are associated with one entity (inverse of One-to-Many).
Example: Many Employees belong to one Department.

--Many-to-Many (@ManyToMany)
Entities have multiple associations on both sides.
Example: A Student can enroll in multiple Courses, and a Course can have multiple Students.
 */