CREATE TABLE category(

	id IDENTITY,
	name  VARCHAR(50),
	description VARCHAR(500),
	imageURL VARCHAR(80),
	isActive BOOLEAN

	CONSTRAINT pk_category_id PRIMARY KEY(id)
	
	);