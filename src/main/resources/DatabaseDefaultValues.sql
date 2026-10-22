-- Inserimento di 3 Conti Correnti realistici
INSERT INTO current_account (active, creation_date, name, update_date) VALUES
(b'1', NOW(6), 'Conto Principale Intesa', NOW(6)),
(b'1', NOW(6), 'Carta Prepagata Buddybank', NOW(6)),
(b'1', NOW(6), 'Fondo Risparmio Spese Casa', NOW(6));

-- Inserimento di Movimenti associati ai conti sopra (ca_id 1, 2 e 3)
INSERT INTO movement (amount, causal, creation_date, date, type, update_date, ca_id) VALUES
-- Movimenti sul Conto Principale (ca_id = 1)
(1500.00, 'Accredito Stipendio Mensile', NOW(6), '2026-10-01', 'INCOMING', NOW(6), 1),
(54.30, 'Spesa Settimanale Esselunga', NOW(6), '2026-10-02', 'OUTGOING', NOW(6), 1),
(12.50, 'Rifornimento Carburante Eni', NOW(6), '2026-10-03', 'OUTGOING', NOW(6), 1),

-- Movimenti sulla Carta Prepagata (ca_id = 2)
(50.00, 'Ricarica conto da principale', NOW(6), '2026-10-02', 'INCOMING', NOW(6), 2),
(8.99, 'Abbonamento Mensile Netflix', NOW(6), '2026-10-03', 'OUTGOING', NOW(6), 2),
(15.50, 'Aperitivo con amici', NOW(6), '2026-10-04', 'OUTGOING', NOW(6), 2),

-- Movimenti sul Fondo Casa (ca_id = 3)
(200.00, 'Versamento mensile risparmi', NOW(6), '2026-10-01', 'INCOMING', NOW(6), 3),
(110.00, 'Pagamento Bolletta Luce Enel', NOW(6), '2026-10-03', 'OUTGOING', NOW(6), 3);
