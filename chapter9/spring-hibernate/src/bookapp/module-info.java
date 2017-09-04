module bookapp {
	requires spring.context;
	requires spring.tx;

	requires javax.inject;

	requires hibernate.core;
	requires hibernate.jpa;

	exports books.api.entities;
	exports books.api.service;
	opens books.impl.entities;
	opens books.impl.service;

	exports bookstore.api.service;
	opens bookstore.impl.service;
}