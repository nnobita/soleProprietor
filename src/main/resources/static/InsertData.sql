INSERT INTO owners (name, status, updated_by) 
VALUES ('Konrad Schumann', 0, 'Administrator01'),
('Maria Franco', 1, 'Administrator01'),
('Hanako Yamada', 0, 'Administrator02');

INSERT INTO notices (owner_id, content, updated_by) 
VALUES (1, 'Please.', 'Administrator01'),
(1, 'Fuck!', 'Administrator01'),
(2, 'Until Sep. 20', 'Administrator02');

