INSERT INTO producers(id, name)
VALUES
('d9638ab0-7f96-11ed-a1eb-0242ac120002', 'TERRA'),
('d9638d26-7f96-11ed-a1eb-0242ac120002', 'VERES'),
('d9638e5c-7f96-11ed-a1eb-0242ac120002', 'KYIV MLYN'),
('d963929e-7f96-11ed-a1eb-0242ac120002', 'VIKTOR i K');

INSERT INTO products(id,name,price,producer_id)
VALUES
('fd35919a-7f96-11ed-a1eb-0242ac120002', 'Oat flakes', '33.00', 'd9638ab0-7f96-11ed-a1eb-0242ac120002'),
('fd3595be-7f96-11ed-a1eb-0242ac120002', 'Cereals', '13.00', 'd9638ab0-7f96-11ed-a1eb-0242ac120002'),
('fd359708-7f96-11ed-a1eb-0242ac120002', 'Tomatoes marinated', '13.00', 'd9638d26-7f96-11ed-a1eb-0242ac120002'),
('fd359834-7f96-11ed-a1eb-0242ac120002', 'Cucumbers marinated', '50.00', 'd9638d26-7f96-11ed-a1eb-0242ac120002'),
('fd359c58-7f96-11ed-a1eb-0242ac120002', 'Wheat flour 1kg', '45.00', 'd9638e5c-7f96-11ed-a1eb-0242ac120002'),
('8d122472-7f97-11ed-a1eb-0242ac120002', 'Sunflower oil 1L', '40.00', 'd963929e-7f96-11ed-a1eb-0242ac120002'),
('8d12274c-7f97-11ed-a1eb-0242ac120002', 'Ketchup', '30.00', 'd963929e-7f96-11ed-a1eb-0242ac120002');

INSERT INTO users(id,email, first_name, last_name, password)
VALUES
('8d122d00-7f97-11ed-a1eb-0242ac120002','user@mail.com', 'Ivan', 'Moroz', '$2a$12$R/xSZpBncMdLuh3mn5dYrueKdo6ChRu2V9vQGNbuxet0.GL.NQQba'),
('8d122e4a-7f97-11ed-a1eb-0242ac120002','admin@mail.com', 'Roman', 'Kushnir', '$2a$12$DmY.1e7z/TvsLBWMv3Mj7Om8KEEJsW2FtaJeRZdd5MYWxg7qm61lu');

INSERT INTO user_dao_roles(user_dao_id, roles)
VALUES
('8d122d00-7f97-11ed-a1eb-0242ac120002', 'ROLE_USER'),
('8d122e4a-7f97-11ed-a1eb-0242ac120002', 'ROLE_ADMIN');