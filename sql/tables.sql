CREATE TABLE entree(
    id SERIAL PRIMARY KEY,
    name VARCHAR(16),
    score INTEGER,
    date_entree DATE
);

--debug values
INSERT INTO entree(name, score, date_entree)
    VALUES('David',10, '2025-12-06'),
    ('Sabrina',20, '2026-01-14');