module books.impl {
	requires books.api;

	requires java.naming;
	requires spring.tx;
	requires javax.inject;
	requires hibernate.core;
	requires hibernate.jpa;
	
	opens books.impl.entities;
	opens books.impl.service;
}