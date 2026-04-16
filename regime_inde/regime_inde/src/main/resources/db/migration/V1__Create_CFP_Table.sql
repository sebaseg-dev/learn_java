CREATE TABLE cfp_reference (
                            id INTEGER PRIMARY KEY AUTOINCREMENT,
                            startDate DATE NOT NULL
);

CREATE TABLE cfp_rate (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        cfp_reference_id INTEGER NOT NULL,
                        activity VARCHAR(100) NOT NULL,
                        rate REAL NOT NULL,
                        FOREIGN KEY (cfp_reference_id) REFERENCES cfp_reference(id)
);