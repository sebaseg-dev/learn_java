INSERT INTO cfp_reference (start_date)
VALUES ('2025-01-01');

INSERT INTO cfp_rate (cfp_reference_id, activity, rate)
VALUES (
            (SELECT id FROM cfp_reference WHERE start_date = '2025-01-01'),
            'Activité commerciale',
            0.001
       ),
       (
            (SELECT id FROM cfp_reference WHERE start_date = '2025-01-01'),
            'Activité artisanale',
            0.003
       ),
       (
            (SELECT id FROM cfp_reference WHERE start_date = '2025-01-01'),
            'Activité libérale',
            0.002
       );