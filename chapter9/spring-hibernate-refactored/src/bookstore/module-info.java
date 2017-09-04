module bookstore {
	requires books.api;

	requires spring.context;

	exports bookstore.api.service;
	opens bookstore.impl.service;
}