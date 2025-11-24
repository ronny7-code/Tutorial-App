-- Insert Admin
INSERT INTO admin (
    name,
    username,
    password,
    email,
    phone_number,
    address,
    gender
) VALUES (
    'Main Admin',
    'admin',
    '$2a$10$8Vr0J1QxQtiwfYx4YdK7qO1TQW4HIkqFzLwkJ9swQySxQ0whjURlC',
    'admin@example.com',
    '7777777777',
    'Kathmandu',
    'MALE'
);

-- Insert Role linked to admin
INSERT INTO admin_role (role, admin_id)
VALUES (
    'ADMIN',
    (SELECT id FROM admin WHERE username = 'admin')
);